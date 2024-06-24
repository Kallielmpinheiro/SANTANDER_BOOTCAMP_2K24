package requestsz.Controll.Service;


import org.springframework.stereotype.Service;
import requestsz.Controll.Model.Item;
import requestsz.Controll.Repository.ItemRepository;

import java.util.*;


@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }

    public void deleteById(Long id) {
        itemRepository.deleteById(id);
    }

    public List<Item> findAllById(List<Long> ids) {
        return itemRepository.findAllById(ids);
    }

    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }
}




