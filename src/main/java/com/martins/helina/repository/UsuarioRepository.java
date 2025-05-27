package com.martins.helina.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Repository;

import com.martins.helina.domain.Usuario;

import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;

@Repository
@RequiredArgsConstructor
public class UsuarioRepository {

    private final DynamoDbEnhancedClient enhancedClient;

    private DynamoDbTable<Usuario> getTable() {
        return enhancedClient.table("he-usuario", TableSchema.fromBean(Usuario.class));
    }

    public Optional<Usuario> findByEmail(String email) {
        return StreamSupport.stream(
                getTable()
                    .index("gsi_email")
                    .query(r -> r.queryConditional(QueryConditional.keyEqualTo(k -> k.partitionValue(email))))
                    .spliterator(),
                false)
            .flatMap(page -> page.items().stream())
            .findFirst();
    }

    public void save(Usuario usuario) {
        getTable().putItem(usuario);
    }

    public Usuario findById(String id) {
        return getTable().getItem(Key.builder().partitionValue(id).build());
    }

    public void deleteById(String id) {
        getTable().deleteItem(Key.builder().partitionValue(id).build());
    }

    public List<Usuario> findAll() {
        return getTable().scan().items().stream().toList();
    }
}
