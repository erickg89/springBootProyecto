package com.vidrieriasilice.proyecto.repository;


import com.vidrieriasilice.proyecto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
    boolean existsByEmailAndIdNot(String email, Integer idNot);

    Optional<User> findByEmail(String email);
}
