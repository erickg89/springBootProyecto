package com.vidrieriasilice.proyecto.controller;

import com.vidrieriasilice.proyecto.dto.UserFormDTO;
import com.vidrieriasilice.proyecto.model.User;
import com.vidrieriasilice.proyecto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/admin/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    Page<User> index(@PageableDefault(sort = "fullName", size = 5) Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @GetMapping("/list")
    public List<User> list() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Integer id) {
        User user = userRepository.findById(id).orElse(null);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody @Validated UserFormDTO userFormDTO) {
        boolean existsEmail = userRepository.existsByEmail(userFormDTO.getEmail());
        if (existsEmail) return ResponseEntity.badRequest().build();

        User user = new User();
        user.setFirstName(userFormDTO.getFirstName());
        user.setLastName(userFormDTO.getLastName());
        user.setFullName(userFormDTO.getFullName());
        user.setEmail(userFormDTO.getEmail());
        user.setPassword(userFormDTO.getPassword());
        user.setRole(userFormDTO.getRole());
        user.setCreatedAt(LocalDateTime.now());

        userRepository.save(user);

        return ResponseEntity.created(null).body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody @Validated UserFormDTO userFormDTO) {
        User updateUser = userRepository.findById(id).orElse(null);

        boolean existsEmail = userRepository.existsByEmailAndIdNot(userFormDTO.getEmail(), id);

        if (existsEmail) return ResponseEntity.badRequest().build();
        if (updateUser == null) return ResponseEntity.notFound().build();

        updateUser.setFirstName(userFormDTO.getFirstName());
        updateUser.setLastName(userFormDTO.getLastName());
        updateUser.setFullName(userFormDTO.getFullName());
        updateUser.setEmail(userFormDTO.getEmail());
        updateUser.setPassword(userFormDTO.getPassword());
        updateUser.setRole(userFormDTO.getRole());
        updateUser.setUpdatedAt(LocalDateTime.now());

        userRepository.save(updateUser);
        return ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        boolean existsUser = userRepository.existsById(id);

        if (!existsUser) return ResponseEntity.notFound().build();

        userRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
