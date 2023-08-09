package com.LoadBalancer.service;

import com.LoadBalancer.model.User;
import com.LoadBalancer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;
    public List<User> getAllUsers()
    {
        List<User>users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return  users;
    }
    public  User createUser(User user)
    {
        return userRepository.save(user);
    }

    public Optional<User> findUserById(Long id)
    {
        return  userRepository.findById(id);
    }

    public String  deleteById(Long id)
    {
         userRepository.deleteById(id);
         Optional<User> user = userRepository.findById(id);
         if(user!=null)
             return "User does not get deleted";
         else
             return "User get deleted sucessfully";

    }
    public Optional<User> updateUser(User user,Long id)
    {
        Optional<User> user1 = userRepository.findById(id);
        //user1.get().setId(user.getId());
        user1.get().setUserName(user.getUserName());
        user1.get().setName(user.getName());
        user1.get().setEmail(user.getEmail());
        userRepository.save(user1.get());
        return  user1;
    }
}
