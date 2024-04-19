package org.nath9i.pp3_1_2.service;



import org.nath9i.pp3_1_2.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void createOrUpdateUser(User user);
    void deleteUser(int id);
    User getUserById(int id);
}
