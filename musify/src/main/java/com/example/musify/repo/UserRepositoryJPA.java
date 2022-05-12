package com.example.musify.repo;

import com.example.musify.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryJPA extends JpaRepository<User, Integer> {
    User getUserById(Integer id);

    User findByEmailAndPassword(String email, String password);

    User getUserByEmail(String email);
}
