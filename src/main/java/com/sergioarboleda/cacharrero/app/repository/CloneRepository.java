/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sergioarboleda.cacharrero.app.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sergioarboleda.cacharrero.app.model.Clone;
import com.sergioarboleda.cacharrero.app.repository.crud.CloneCrudRepository;

/**
 *
 * @author Carotobarj
 */


@Repository
public class CloneRepository {
    
    @Autowired
    private CloneCrudRepository repository;
    
    public List<Clone> getAll() {
        return repository.findAll();
    }

    public Optional<Clone> getCloneById(Integer id){
        return repository.findById(id);
    }
    
    public Clone save(Clone clon) {
        return repository.save(clon);
    }
    
    /**
     * 
     * @param id
     */
    public void deleteById (Integer id){
        repository.deleteById(id);
    }

    
}
