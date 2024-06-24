package requestsz.Controll.Controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import requestsz.Controll.Model.Item;
import requestsz.Controll.Model.Pedido;
import requestsz.Controll.Service.ItemService;
import requestsz.Controll.Service.PedidoService;

import java.util.*;

@Controller
@RequestMapping("/web")
public class WebController {
    private final ItemService itemService;
    private final PedidoService pedidoService;

    public WebController(ItemService itemService, PedidoService pedidoService) {
        this.itemService = itemService;
        this.pedidoService = pedidoService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Item> itens = itemService.findAll();
        List<Pedido> pedidos = pedidoService.findAll();
        model.addAttribute("itens", itens);
        model.addAttribute("pedidos", pedidos);
        return "index";
    }

    @PostMapping("/pedidos")
    public String createPedido(@RequestParam List<Long> itemIds, Model model) {
        List<Item> itens = itemService.findAllById(itemIds);
        Pedido pedido = new Pedido();
        pedido.setItens(itens);
        pedidoService.save(pedido);
        return "redirect:/web/";
    }

    @PostMapping("/itens")
    public String createItem(@RequestParam String nome, @RequestParam Double valor) {
        Item item = new Item();
        item.setNome(nome);
        item.setValor(valor);
        itemService.save(item);
        return "redirect:/web/";
    }

    @PostMapping("/pedidos/{id}/delete")
    public String deletePedido(@PathVariable Long id) {
        pedidoService.deleteById(id);
        return "redirect:/web/";
    }

    @PostMapping("/itens/{id}/delete")
    public String deleteItem(@PathVariable Long id) {
        itemService.deleteById(id);
        return "redirect:/web/";
    }
}