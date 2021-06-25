package com.estudo.hroauth.services;

import com.estudo.hroauth.entities.User;
import com.estudo.hroauth.feignClients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private static Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email){
       User user = userFeignClient.findbyEmail(email).getBody();
       if(user == null){
           log.error("Email NOT Found: "+ email);
           throw new IllegalArgumentException("Email NOT Found !");
       }
       log.info("Email Found: "+ email);
       return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userFeignClient.findbyEmail(username).getBody();
        if(user == null){
            log.error("Email NOT Found: "+ username);
            throw new UsernameNotFoundException("Email NOT Found !");
        }
        log.info("Email Found: "+ username);
        return user;
    }
}
