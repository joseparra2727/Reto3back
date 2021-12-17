package com.sergioarboleda.cacharrero.app.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sergioarboleda.cacharrero.app.model.Order;
import com.sergioarboleda.cacharrero.app.repository.crud.OrderCrudRepository;


/**
 *
 * @author Carotobarj
 */


@Repository
public class OrderRepository {
    
    @Autowired
    private OrderCrudRepository repository;

    public List<Order> getAll() {
        return repository.findAll();
    }

    public Order save(Order orden) {
        return repository.save(orden);
    }

    public Optional<Order> getOrderById(Integer id){
        return repository.findById(id);
    }
    
    /**
     * 
     * @param id
     */
    public void deleteById (Integer id){
        repository.deleteById(id);
    }
    
    /**
     * 
     * @param zona
     * @return
     */
    public List<Order> getOrderByZone(String zona){
        return repository.findByZone(zona);
    }
    
    public List<Order> getOrderByStatus(String status){
        return repository.findByStatus(status);
    }
    
    public List<Order> getOrderByQuantities(String quantities){
        return repository.findByStatus(quantities);
    }

}
