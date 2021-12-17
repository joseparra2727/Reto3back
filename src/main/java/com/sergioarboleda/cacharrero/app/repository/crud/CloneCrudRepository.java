package com.sergioarboleda.cacharrero.app.repository.crud;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.sergioarboleda.cacharrero.app.model.Clone;

/**
 *
 * @author Carotobarj
 */

public interface CloneCrudRepository extends MongoRepository<Clone, Integer>{
    
}
