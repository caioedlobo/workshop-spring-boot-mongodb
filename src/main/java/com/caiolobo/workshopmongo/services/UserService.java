package com.caiolobo.workshopmongo.services;

import com.caiolobo.workshopmongo.domain.User;
import com.caiolobo.workshopmongo.dto.UserDTO;
import com.caiolobo.workshopmongo.repository.UserRepository;
import com.caiolobo.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired      // para instanciar automaticamente um objeto no Service
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        Optional<User> user = repository.findById(id);     // se não achar retorna nulo;
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj){
        return repository.insert(obj);
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }

    public User update(User obj){
        User newObj = repository.findById(obj.getId()).orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setId(obj.getId());
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

}
