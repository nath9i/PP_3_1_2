package org.nath9i.pp3_1_2.service;


import org.nath9i.pp3_1_2.dao.UserRepository;
import org.nath9i.pp3_1_2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private UserRepository userRepository;

   @Override
   public List<User> getAllUsers() {
      return userRepository.findAll();
   }

   @Override
   public void createOrUpdateUser(User user) {
      userRepository.save(user);
   }

   @Override
   public void deleteUser(int id) {
      userRepository.deleteById(id);
   }

   @Override
   public User getUserById(int id) {
      return userRepository.findById(id).orElse(null);
   }
}
