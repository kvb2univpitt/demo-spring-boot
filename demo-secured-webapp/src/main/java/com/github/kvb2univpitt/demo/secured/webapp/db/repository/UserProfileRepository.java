package com.github.kvb2univpitt.demo.secured.webapp.db.repository;

import com.github.kvb2univpitt.demo.secured.webapp.db.entity.AppUser;
import com.github.kvb2univpitt.demo.secured.webapp.db.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * Dec 28, 2020 11:20:50 PM
 *
 * @author Kevin V. Bui (kvb2univpitt@gmail.com)
 */
@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    public UserProfile findByAppUser(AppUser appUser);

}
