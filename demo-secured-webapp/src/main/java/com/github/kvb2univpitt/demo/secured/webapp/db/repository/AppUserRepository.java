package com.github.kvb2univpitt.demo.secured.webapp.db.repository;

import com.github.kvb2univpitt.demo.secured.webapp.db.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * Dec 28, 2020 11:19:38 PM
 *
 * @author Kevin V. Bui (kvb2univpitt@gmail.com)
 */
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    public AppUser findByUsername(String username);

    public boolean existsByUsername(String username);

}
