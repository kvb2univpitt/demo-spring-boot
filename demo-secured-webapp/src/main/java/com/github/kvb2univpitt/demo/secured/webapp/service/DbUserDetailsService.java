package com.github.kvb2univpitt.demo.secured.webapp.service;

import com.github.kvb2univpitt.demo.secured.webapp.db.entity.AppUser;
import com.github.kvb2univpitt.demo.secured.webapp.db.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * Dec 28, 2020 2:02:41 PM
 *
 * @author Kevin V. Bui (kvb2univpitt@gmail.com)
 */
@Service
public class DbUserDetailsService implements UserDetailsService {

    private static final UsernameNotFoundException INVALID_USER = new UsernameNotFoundException("Invalid username/password.");

    private final AppUserService appUserService;

    @Autowired
    public DbUserDetailsService(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserService.findByUsername(username);
        if (appUser == null) {
            throw INVALID_USER;
        }

        return User
                .withUsername(appUser.getUsername())
                .password(appUser.getPassword())
                .roles("USER")
                .build();
    }

}
