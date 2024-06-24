package requestsz.Controll.Service;


import  requestsz.Controll.Model.Item;
import org.springframework.stereotype.Service;
import requestsz.Controll.Model.Pedido;
import requestsz.Controll.Repository.PedidoRepository;

import java.util.*;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Pedido save(Pedido pedido) {
        double valorTotal = pedido.getItens().stream().mapToDouble(Item::getValor).sum();
        pedido.setValorTotal(valorTotal);
        return pedidoRepository.save(pedido);
    }

    public void deleteById(Long id) {
        pedidoRepository.deleteById(id);
    }
}
