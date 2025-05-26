package com.martins.helina.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import com.martins.helina.domain.Estabelecimento;

import software.amazon.awssdk.enhanced.dynamodb.*;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EstabelecimentoRepository {

    private final DynamoDbEnhancedClient enhancedClient;

    private DynamoDbTable<Estabelecimento> getTable() {
        return enhancedClient.table("Estabelecimento", TableSchema.fromBean(Estabelecimento.class));
    }

    public void save(Estabelecimento estabelecimento) {
        getTable().putItem(estabelecimento);
    }

    public Estabelecimento findById(String id) {
        return getTable().getItem(Key.builder().partitionValue(id).build());
    }

    public void deleteById(String id) {
        getTable().deleteItem(Key.builder().partitionValue(id).build());
    }

    public List<Estabelecimento> findAll() {
        return getTable().scan().items().stream().toList();
    }
}
