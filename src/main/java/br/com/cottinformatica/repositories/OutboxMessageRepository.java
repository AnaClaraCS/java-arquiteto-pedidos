package br.com.cottinformatica.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.cottinformatica.entities.OutboxMessage;

@Repository
public interface OutboxMessageRepository extends JpaRepository<OutboxMessage, Integer> {
    /*
    * Método para consultar todos os pedidos
    * não transmitidos para a API de faturamentos
    */
    @Query("""
    SELECT om FROM OutboxMessage om
    WHERE om.transmitido = false
    """)
    List<OutboxMessage> findByNaoTransmitidos();
}
