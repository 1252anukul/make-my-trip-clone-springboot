package com.makemytrip.makemytrip.services;
import com.makemytrip.makemytrip.models.Users;
import com.makemytrip.makemytrip.repositories .UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;


    public Users login(String email, String password) {
        System.out.println("Email from login: " + email);
        System.out.println("Password from login: " + password);

        Optional<Users> userOptional = Optional.ofNullable(userRepository.findByEmail(email));

        if (userOptional.isPresent()) {
            Users user = userOptional.get();

            if (user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    }

    public Users signup(Users user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email is already registered");
        }
       user.setPassword(user.getPassword()); ;
        if (user .getRole()== null) {
            user.setRole("USER");
        }
        return userRepository.save(user);
    }
    public Users editprofile(String id,Users updatedUser){
        Users user=userRepository.findById(id).orElse(null);
        if(user != null){
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setPhoneNumber(updatedUser.getPhoneNumber());
            return userRepository.save(user);
        }
        return null;
    }
}