package com.LoadBalancer.controller;

import com.LoadBalancer.model.User;
import com.LoadBalancer.repository.UserRepository;
import com.LoadBalancer.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

//@Tag(name = "User Management System API", description = "Endpoints related to user management System")

@RestController
public class userController
{
    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    @Operation(summary = "Get all users", description = "This endpoint get all users information from DB system.")
    @ApiResponse(responseCode = "200 Users Info.", description = "All User information get retrived successfully.")
    @Tag(name = "Retrieve All Users", description = "Retrieve All user information")
    public List<User> getAllUsers()
    {
        return  userService.getAllUsers();
    }

    @PostMapping("/createUser")
    @Tag(name = "Create User", description = "Create User by providing relevent details")
    public  User createUser(@RequestBody User user)
    {
        return  userService.createUser(user);
    }

    @GetMapping("/getById/{id}")
    @Tag(name = "Retrive user ", description = "Retrive User information By user_ID")
    public Optional<User> findUserById(@Parameter(description = "User ID for Search ", example = "1",required = true)@PathVariable Long id)
    {
        Optional<User> user = userService.findUserById(id);
        return user;
    }


    @DeleteMapping("/deleteUser/{id}")
    @Tag(name = "Delete user ", description = "Delete User By user_ID")
    public  String deleteUser(@PathVariable Long id)
    {
        userService.deleteById(id);
        return  "User Sucessfully get deleted";
    }

    @PutMapping("/updateUser/{id}")
    @Tag(name = "Update user ", description = "Update User Information")
    public Optional<User> updateUser(@RequestBody User user,@Parameter(description = "User ID for Search ", example = "1",required = true)@PathVariable  Long id)
    {
        Optional<User> user1 = userService.updateUser(user,id);
        return  user1;
    }

//    we can send any java class as a request body or not
//    @Parameter(in = ParameterIn.QUERY, description = "List of create data (default: [{\"name\": \"Sample\", \"quantity\": 1}])", example = "[{\"name\": \"Sample\", \"quantity\": 1}]")
    //this way i am passing dafault value of list
    //@Parameter(in = ParameterIn.QUERY, description = "List of channel IDs (default: [1, 2, 3])"
}
