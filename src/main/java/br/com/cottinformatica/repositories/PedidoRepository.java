package br.com.cottinformatica.repositories;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.cottinformatica.entities.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, UUID>
{
}
