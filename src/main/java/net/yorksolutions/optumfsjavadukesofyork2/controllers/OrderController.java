package net.yorksolutions.optumfsjavadukesofyork2.controllers;

import net.yorksolutions.optumfsjavadukesofyork2.models.CustomerOrder;
import net.yorksolutions.optumfsjavadukesofyork2.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrderController {
    private final OrderService service;
    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<Void> addNewOrder(@RequestBody CustomerOrder customerOrder) throws Exception {
        service.addNewOrder(customerOrder);
        service.getOrders();
        return null;
    }


    @GetMapping
    public Iterable<CustomerOrder> getOrders() {
        return service.getOrders();

    }


    @GetMapping("/{id}")
    public Optional<CustomerOrder> getOrderInfoById(@PathVariable (required = false) Long id) {
        return service.getOrderInfoById(id);

    }


/*

    @GetMapping("/{userId}")
    public Optional<CustomerOrder> getOrderInfoByCustomer(@PathVariable (required = false) Long userId) {
        return service.getOrderInfoByCustomer(userId);

    }
*/

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOrder(@PathVariable (required = false) Long id) {
        try {
            service.deleteOrder(id);
            service.getOrders();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;

    }
    }