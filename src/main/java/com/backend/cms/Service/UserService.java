package com.backend.cms.Service;

import com.backend.cms.Model.User;
import com.backend.cms.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public User saveUser( User user){
        return userRepository.save(user);
    }


}
