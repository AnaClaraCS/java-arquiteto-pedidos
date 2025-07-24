package br.com.cottinformatica.interfaces;

import java.util.UUID;
import org.springframework.data.domain.Page;
import br.com.cottinformatica.dtos.PedidoRequest;
import br.com.cottinformatica.dtos.PedidoResponse;

public interface PedidoService {
    PedidoResponse criar(PedidoRequest request);
    PedidoResponse alterar(UUID id, PedidoRequest request);
    PedidoResponse excluir(UUID id);
    Page<PedidoResponse> consultar
    (int page, int size, String sortBy, String direction);
    PedidoResponse obterPorId(UUID id);
}
