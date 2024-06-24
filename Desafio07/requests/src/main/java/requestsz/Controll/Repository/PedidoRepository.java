package requestsz.Controll.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import requestsz.Controll.Model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
