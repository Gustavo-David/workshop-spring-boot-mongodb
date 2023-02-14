package com.gustavodavid.workshopmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavodavid.workshopmongo.domain.User;
import com.gustavodavid.workshopmongo.repository.UserRepository;

@Service
public class UserService {
        @Autowired
        private UserRepository userRepository;

        public List<User> findAll() {
                return userRepository.findAll();
        }
}
