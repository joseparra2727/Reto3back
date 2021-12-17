package com.sergioarboleda.cacharrero.app.repository.crud;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.sergioarboleda.cacharrero.app.model.Order;

/**
 *
 * @author Carotobarj
 */

public interface OrderCrudRepository extends MongoRepository<Order, Integer>{
    
    @Query("{'salesMan.zone':?0}")
    public List<Order> findByZone(String country);
    
    public List<Order> findByStatus(String status);
    
    public List<Order> findByQuantities(String quantities);
}
