package com.github.kvb2univpitt.demo.secured.webapp.db.service;

import com.github.kvb2univpitt.demo.secured.webapp.db.entity.AppUser;
import com.github.kvb2univpitt.demo.secured.webapp.db.entity.UserProfile;
import com.github.kvb2univpitt.demo.secured.webapp.db.repository.AppUserRepository;
import com.github.kvb2univpitt.demo.secured.webapp.db.repository.UserProfileRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * Dec 28, 2020 11:23:49 PM
 *
 * @author Kevin V. Bui (kvb2univpitt@gmail.com)
 */
@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;
    private final UserProfileRepository userProfileRepository;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository, UserProfileRepository userProfileRepository) {
        this.appUserRepository = appUserRepository;
        this.userProfileRepository = userProfileRepository;
    }

    public AppUser findByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    public boolean existsByUsername(String username) {
        return appUserRepository.existsByUsername(username);
    }

    public AppUser addNewUser(String username, String password, String firstName, String lastName) {
        AppUser appUser = appUserRepository.save(new AppUser(username, password, new Date()));

        userProfileRepository.save(new UserProfile(firstName, lastName, appUser));

        return appUser;
    }

}
