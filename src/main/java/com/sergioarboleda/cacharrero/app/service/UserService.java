package com.sergioarboleda.cacharrero.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.sergioarboleda.cacharrero.app.model.User;
import com.sergioarboleda.cacharrero.app.repository.UserRepository;

/**
 *
 * @author Carotobarj
 */


@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getAll() {
        return repository.getAll();
    }

    public User getUser(int id) {
        return repository.getUserById(id).orElse(new User());
    }

    public User save(User usuario){
        if(usuario.getName()== null || usuario.getEmail()== null || usuario.getPassword() == null){ //|| usuario.getIdentification() == null || usuario.getType() == null
            return usuario;
        }else{
            List<User> existUser = repository.getUsersByNameOrEmail(usuario.getName(), usuario.getEmail());
            if(existUser.isEmpty()){
                if(usuario.getId()==null){
                    return repository.save(usuario);
                }else{
                    Optional<User> existUser2 = repository.getUserById(usuario.getId());
                    if(existUser2.isEmpty()){
                        return repository.save(usuario);
                    }else{
                        return usuario;
                    }
                }
            }else{
                return usuario;
            }
        }
    }

    public boolean getUserByEmail(String email) {
        return repository.getUserByEmail(email).isPresent();
    }

    public User getByEmailPass(String email, String password){
        Optional<User> userExist = repository.getUserEmailAndPassword(email, password);
        if(userExist.isPresent()){
            return userExist.get();
        }else{
            return new User();
        }
    }
    
    /**
     * 
     * @param Actualizar
     * @return 
     */
    public User update(User usuario){
        if(usuario.getId()!=null){
            Optional<User> userExist = repository.getUserById(usuario.getId());
            if(userExist.isPresent()){
                if(usuario.getIdentification()!=null){
                    userExist.get().setIdentification(usuario.getIdentification());
                }
                if(usuario.getName()!=null){
                    userExist.get().setName(usuario.getName());
                }
                if(usuario.getAddress()!=null){
                    userExist.get().setAddress(usuario.getAddress());
                }
                if(usuario.getCellPhone()!=null){
                    userExist.get().setCellPhone(usuario.getCellPhone());
                }
                if(usuario.getEmail()!=null){
                    userExist.get().setEmail(usuario.getEmail());
                }
                if(usuario.getPassword()!=null){
                    userExist.get().setPassword(usuario.getPassword());
                }
                if(usuario.getZone()!=null){
                    userExist.get().setZone(usuario.getZone());
                }
                if(usuario.getType()!=null){
                    userExist.get().setType(usuario.getType());
                }
                return repository.save(userExist.get());
            }else{
                return usuario;
            }
        }else{
            return usuario;
        }
    }
    
    public boolean deleteById(Integer id){
        boolean aBoolean = repository.getUserById(id).map(user -> {
            repository.deleteById(id);
            return true;
        }).orElse(false);
        return false;
    }

}
