package com.sergioarboleda.cacharrero.app.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sergioarboleda.cacharrero.app.model.Order;
import com.sergioarboleda.cacharrero.app.repository.OrderRepository;

/**
 *
 * @author Carotobarj
 */

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository repository;

    public List<Order> getAll() {
        return repository.getAll();
    }

    public Optional<Order> getOrderById(int id) {
        return repository.getOrderById(id);
    }
    
    public Order save(Order orden) {
        if(orden.getId()==null){
            return repository.save(orden);
        }else{
            Optional<Order> existOrder = repository.getOrderById(orden.getId());
            if(existOrder.isPresent()){
                return orden;
            }else{
                return repository.save(orden);
            }
        }
    }

    /**
     *
     * @param Actualizar
     * @return
     */
    public Order update(Order orden) {
        if (orden.getId() != null) {
            Optional<Order> orderExist = repository.getOrderById(orden.getId());
            if (orderExist.isPresent()) {
                if (orden.getRegisterDay()!= null) {
                    orderExist.get().setRegisterDay(orden.getRegisterDay());
                }
                if (orden.getStatus()!= null) {
                    orderExist.get().setStatus(orden.getStatus());
                }
                if (orden.getSalesMan()!= null) {
                    orderExist.get().setSalesMan(orden.getSalesMan());
                }
                if (orden.getProducts()!= null) {
                    orderExist.get().setProducts(orden.getProducts());
                }
                if (orden.getQuantities()!= null) {
                    orderExist.get().setQuantities(orden.getQuantities());
                }
                return repository.save(orderExist.get());
            } else {
                return orden;
            }
        } else {
            return orden;
        }
    }

    public boolean deleteById(Integer id) {
        boolean aBoolean = repository.getOrderById(id).map(order -> {
            repository.deleteById(id);
            return true;
        }).orElse(false);
        return false;
    }
    
    public List<Order> getOrdersByZone(String zone){
        return repository.getOrderByZone(zone);
    }
    
    public List<Order> getOrdersByStatus(String status){
        return repository.getOrderByZone(status);
    }
    
    public List<Order> getOrdersByQuantities(String quantities){
        return repository.getOrderByZone(quantities);
    }
    
}
