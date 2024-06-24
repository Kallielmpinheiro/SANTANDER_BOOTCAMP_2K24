package requestsz.Controll.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import requestsz.Controll.Model.Pedido;
import requestsz.Controll.Service.PedidoService;

import java.util.*;

@RestController
@RequestMapping("/api/pedidos")
//@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public List<Pedido> getAllPedidos() {
        return pedidoService.findAll();
    }

    @PostMapping
    public Pedido createPedido(@RequestBody Pedido pedido) {
        return pedidoService.save(pedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Long id) {
        pedidoService.deleteById(id);
        return ResponseEntity.noContent().build();

 //   public void deletePedido(@PathVariable Long id) {
 //       pedidoService.deleteById(id);
    }
}
