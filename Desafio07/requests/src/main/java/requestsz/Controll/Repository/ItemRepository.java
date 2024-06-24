package requestsz.Controll.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import requestsz.Controll.Model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
