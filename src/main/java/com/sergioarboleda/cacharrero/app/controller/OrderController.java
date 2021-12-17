package com.sergioarboleda.cacharrero.app.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.sergioarboleda.cacharrero.app.model.Order;
import com.sergioarboleda.cacharrero.app.service.OrderService;

/**
 *
 * @author Carotobarj
 */

@RestController
@RequestMapping("order")
@CrossOrigin(origins = "*")
public class OrderController {
    
    @Autowired
    private OrderService service;

    /**
     * 
     * @return 
     */
    @GetMapping("/all")
    public List<Order> getOrders(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") Integer id) {
        return service.getOrderById(id);
    }
    /**
     * 
     * @param orden
     * @return 
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order orden){
        return service.save(orden);
    }

    /**
     * 
     * @param orden
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order orden){
        return service.update(orden);
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return service.deleteById(id);
    }
    
    @GetMapping("/zona/{zone}")
    public List<Order> getOrdersByZone(@PathVariable("zone") String zone){
        return service.getOrdersByZone(zone);
    }
    
    @GetMapping("/status/{status}")
    public List<Order> getOrdersByStatus(@PathVariable("status") String status){
        return service.getOrdersByStatus(status);
    }
    
    @GetMapping("/quantity/{quantity}")
    public List<Order> getOrdersByQuantity(@PathVariable("quantity") String quantity){
        return service.getOrdersByQuantities(quantity);
    }
}
