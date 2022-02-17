package com.Project.MealBoxOnlineOrderingApp.Service;


import com.Project.MealBoxOnlineOrderingApp.Entity.User;
import com.Project.MealBoxOnlineOrderingApp.Security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    public UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{

        User user=userService.findById(username);
        System.out.println(user.getUsername());
        return new MyUserDetails(user);
    }
}
