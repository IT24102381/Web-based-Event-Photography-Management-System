package com.sliit.event_photography_management_system.service;
import com.sliit.event_photography_management_system.entity.User;
import java.util.List;

public interface UserService {

    User createUser(User user);
    User getUser(Long uid);
    List<User> getAllUsers();
    User updateUser(Long uid, User user);
    void deleteUser(Long uid);
    User getUserByEmailAndPassword(String email, String password);
}
