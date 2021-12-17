package com.Zikri.backEndProject.security;

import com.Zikri.backEndProject.models.auth.UserAuth;
import com.Zikri.backEndProject.repositorys.UserAuthRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserAuthRepository userAuthRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        UserAuth userAuth = userAuthRepository.getUserByUsername(username);

        if (userAuth == null) {
            throw new UsernameNotFoundException("User not find");
        }

        return new MyUserDetails(userAuth);
    }

}
