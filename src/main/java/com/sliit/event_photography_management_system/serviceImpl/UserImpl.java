package com.sliit.event_photography_management_system.serviceImpl;



import com.sliit.event_photography_management_system.entity.User;
import com.sliit.event_photography_management_system.repository.UserRepository;
import com.sliit.event_photography_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save (user);
    }


    public User getUser(Long uid){
        Optional<User> user =userRepository.findById(uid);
        if (user.isPresent()) {
            return user.get();
        }
        else {
            throw new RuntimeException("User not found id "+uid);
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long uid, User user) {
        User existingUser = getUser(uid);
        existingUser.setUemail(user.getUemail());
        existingUser.setUname(user.getUname());
        existingUser.setUphone(user.getUphone());
        existingUser.setUpassword(user.getUpassword());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long uid) {
        User user = getUser(uid);
        userRepository.delete(user);
    }
    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        return userRepository.findByUemailAndUpassword(email, password);
    }



}
