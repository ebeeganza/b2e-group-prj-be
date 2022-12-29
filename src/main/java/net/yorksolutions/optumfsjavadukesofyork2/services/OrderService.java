package net.yorksolutions.optumfsjavadukesofyork2.services;

import net.yorksolutions.optumfsjavadukesofyork2.models.CustomerOrder;
import net.yorksolutions.optumfsjavadukesofyork2.repositories.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository orderRepository) {
        this.repository = orderRepository;
    }


    public Iterable<CustomerOrder> getOrderInfo() {
        return repository.findAll();
    }


    public void addNewOrder(CustomerOrder customerOrder) {
        repository.save(customerOrder);
    }

}
