package com.gustavodavid.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavodavid.workshopmongo.domain.User;
import com.gustavodavid.workshopmongo.dto.UserDTO;
import com.gustavodavid.workshopmongo.repository.UserRepository;
import com.gustavodavid.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {
        @Autowired
        private UserRepository userRepository;

        public List<User> findAll() {
                return userRepository.findAll();
        }

        public User findById(String id) {
                Optional<User> obj = userRepository.findById(id);
                return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

        }

        public User insert(User obj) {
                return userRepository.insert(obj);
        }

        public void delete(String id) {
                findById(id);
                userRepository.deleteById(id);
        }

        public User update(User obj){
                User newObj = findById(obj.getId());
                updateData(newObj, obj);
		return userRepository.save(newObj);

        }

        private void updateData(User newObj, User obj) {
                newObj.setName(obj.getName());
                newObj.setEmail(obj.getEmail());
        }

        public User fromDto(UserDTO objdto) {
                return new User(objdto.getId(), objdto.getName(), objdto.getEmail());
        }

}
