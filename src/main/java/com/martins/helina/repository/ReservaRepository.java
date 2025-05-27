package com.martins.helina.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.martins.helina.domain.Reserva;

import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbIndex;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;

@Repository
@RequiredArgsConstructor
public class ReservaRepository {

    private final DynamoDbEnhancedClient enhancedClient;

    private DynamoDbTable<Reserva> getTable() {
        return enhancedClient.table("he-reserva", TableSchema.fromBean(Reserva.class));
    }

    public void save(Reserva reserva) {
        getTable().putItem(reserva);
    }

    public Optional<Reserva> findById(String idReserva) {
        return Optional.ofNullable(getTable().getItem(Key.builder()
                .partitionValue(idReserva)
                .build()));
    }

    public List<Reserva> findByIdUsuario(String idUsuario) {
        DynamoDbIndex<Reserva> index = getTable().index("gsi_usuario");

        List<Reserva> reservas = new ArrayList<>();

        index.query(r -> r.queryConditional(QueryConditional.keyEqualTo(k -> k.partitionValue(idUsuario))))
                .stream()
                .forEach(page -> reservas.addAll(page.items()));

        return reservas;
    }

    public List<Reserva> findByIdEstabelecimento(String idEstabelecimento) {
        DynamoDbIndex<Reserva> index = getTable().index("gsi_estabelecimento");

        List<Reserva> reservas = new ArrayList<>();

        index.query(r -> r.queryConditional(QueryConditional.keyEqualTo(k -> k.partitionValue(idEstabelecimento))))
                .stream()
                .forEach(page -> reservas.addAll(page.items()));

        return reservas;
    }

    public void deleteById(String id) {
        getTable().deleteItem(Key.builder().partitionValue(id).build());
    }

    public List<Reserva> findAll() {
        return getTable().scan().items().stream().toList();
    }
}
