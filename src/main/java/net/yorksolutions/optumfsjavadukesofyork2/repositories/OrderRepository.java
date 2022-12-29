package net.yorksolutions.optumfsjavadukesofyork2.repositories;
import net.yorksolutions.optumfsjavadukesofyork2.models.CustomerOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<CustomerOrder, Long> {

}
