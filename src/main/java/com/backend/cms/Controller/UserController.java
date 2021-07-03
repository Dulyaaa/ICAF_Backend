package com.backend.cms.Controller;

import com.backend.cms.Model.User;
import com.backend.cms.Repository.UserRepository;
import com.backend.cms.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    public UserService userService;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("opUsers/{id}")
    public Optional<User> findUserDetails(@PathVariable String id){
        return (Optional<User>) userRepository.findById(id);
    }

    @PutMapping("/updateUser/{id}")
    public User updateUser(@PathVariable(value = "id") String id, @RequestBody User userDetails)  {
        Optional<User> userData =  userRepository.findById(id);
            User user = userData.get();

         user.setFirstname(userDetails.getFirstname());
         user.setLastname(userDetails.getLastname());
         user.setEmail(userDetails.getEmail());
         user.setUsername(userDetails.getUsername());
         user.setRole(userDetails.getRole());
         return  userRepository.save(user);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
        try {
            userRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
