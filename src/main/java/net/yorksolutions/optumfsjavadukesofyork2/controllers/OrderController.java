package net.yorksolutions.optumfsjavadukesofyork2.controllers;

import net.yorksolutions.optumfsjavadukesofyork2.models.CustomerOrder;
import net.yorksolutions.optumfsjavadukesofyork2.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrderController {
    private final OrderService service;
    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<CustomerOrder> getOrderInfo(@RequestParam (required = false) Long id) {
        return service.getOrderInfo();

    }

    @PostMapping
    public ResponseEntity<Void> addNewOrder(@RequestBody CustomerOrder customerOrder) throws Exception {
        service.addNewOrder(customerOrder);
        service.getOrderInfo();
        return null;
    }

}