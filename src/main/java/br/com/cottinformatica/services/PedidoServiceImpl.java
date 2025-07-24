package br.com.cottinformatica.services;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import br.com.cottinformatica.dtos.PedidoRequest;
import br.com.cottinformatica.dtos.PedidoResponse;
import br.com.cottinformatica.interfaces.PedidoService;
@Service
public class PedidoServiceImpl implements PedidoService {
    @Override
    public PedidoResponse criar(PedidoRequest request) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public PedidoResponse alterar(UUID id, PedidoRequest request) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public PedidoResponse excluir(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public Page<PedidoResponse> consultar (int page, int size, String sortBy, String direction) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public PedidoResponse obterPorId(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }
}
