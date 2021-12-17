package com.sergioarboleda.cacharrero.app.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sergioarboleda.cacharrero.app.model.Clone;
import com.sergioarboleda.cacharrero.app.repository.CloneRepository;

/**
 *
 * @author Carotobarj
 */

@Service
public class CloneService {

    @Autowired
    private CloneRepository repository;

    public List<Clone> getAll() {
        return repository.getAll();
    }

    public Optional<Clone> getCloneById(int id) {
        return repository.getCloneById(id);
    }
    
    public Clone save(Clone clon) {
        if(clon.getBrand() == null || clon.getProcesor() == null ||
        clon.getOs() == null || clon.getDescription() == null ||
        clon.getMemory() == null || clon.getHardDrive() == null || 
        clon.getPhotography() == null){
            return clon;
        }else{
            Optional<Clone> cloneExists = repository.getCloneById(clon.getId());
            if(cloneExists.isEmpty()){
                return repository.save(clon);
            }else{
                return clon;
            }
        }
    }

    /**
     *
     * @param Update
     * @return
     */
    public Clone update(Clone clon) {
        if (clon.getId() != null) {
            Optional<Clone> cloneExist = repository.getCloneById(clon.getId());
            if (cloneExist.isPresent()) {
                if (clon.getBrand()!= null) {
                    cloneExist.get().setBrand(clon.getBrand());
                }
                if (clon.getProcesor()!= null) {
                    cloneExist.get().setProcesor(clon.getProcesor());
                }
                if (clon.getOs()!= null) {
                    cloneExist.get().setOs(clon.getOs());
                }
                if (clon.getDescription()!= null) {
                    cloneExist.get().setDescription(clon.getDescription());
                }
                if (clon.getMemory()!= null) {
                    cloneExist.get().setMemory(clon.getMemory());
                }
                if (clon.getHardDrive()!= null) {
                    cloneExist.get().setHardDrive(clon.getHardDrive());
                }
                if (clon.getPrice()!= 0.0) {
                    cloneExist.get().setPrice(clon.getPrice());
                }
                if (clon.getQuantity()!= 0) {
                    cloneExist.get().setQuantity(clon.getQuantity());
                }
                if (clon.getPhotography()!= null) {
                    cloneExist.get().setPhotography(clon.getPhotography());
                }
                return repository.save(cloneExist.get());
            } else {
                return clon;
            }
        } else {
            return clon;
        }
    }

    public boolean deleteById(Integer id) {
        boolean aBoolean = repository.getCloneById(id).map(clone -> {
            repository.deleteById(id);
            return true;
        }).orElse(false);
        return false;
    }

}
