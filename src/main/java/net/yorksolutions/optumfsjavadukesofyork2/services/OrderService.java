package net.yorksolutions.optumfsjavadukesofyork2.services;

import net.yorksolutions.optumfsjavadukesofyork2.models.CustomerOrder;
import net.yorksolutions.optumfsjavadukesofyork2.models.Product;
import net.yorksolutions.optumfsjavadukesofyork2.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository orderRepository) {
        this.repository = orderRepository;
    }


    public void addNewOrder(CustomerOrder customerOrder) {
    //    final var newProduct = new Product();
        repository.save(customerOrder);
    }

    public Iterable<CustomerOrder> getOrders() {
        return repository.findAll();
    }


    public Optional<CustomerOrder> getOrderInfoById(Long id) {
        return repository.findById(id);
    }


    public Optional<CustomerOrder> getOrderInfoByEmail(String email) {
        return repository.getOrderInfoByEmail(email);
    }




    public void deleteOrder(Long id) throws Exception {
        repository.deleteById(id);

    }






}
