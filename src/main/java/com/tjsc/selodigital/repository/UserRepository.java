package com.tjsc.selodigital.repository;

import com.tjsc.selodigital.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
