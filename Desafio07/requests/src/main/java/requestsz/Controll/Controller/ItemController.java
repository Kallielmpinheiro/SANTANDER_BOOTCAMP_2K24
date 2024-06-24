package requestsz.Controll.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import requestsz.Controll.Model.Item;
import requestsz.Controll.Service.ItemService;

import java.util.List;

@RestController
//@RequestMapping("/itens")
@RequestMapping("api/itens")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getAllItens() {
        return itemService.findAll();
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.save(item);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.deleteById(id);
        return ResponseEntity.noContent().build();

//    public void deleteItem(@PathVariable Long id) {
//        itemService.deleteById(id);*
    }
}
