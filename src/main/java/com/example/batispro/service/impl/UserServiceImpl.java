package com.example.batispro.service.impl;

import com.example.batispro.domain.entity.User;
import com.example.batispro.handlers.exceptionHandler.ValidationException;
import com.example.batispro.repository.UserRepository;
import com.example.batispro.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Validated
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(@Valid User user) throws ValidationException {
        if (user.getId() != null) {
            throw new ValidationException("User ID must be null for a new user.");
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() throws ValidationException {
        List<User> userList = userRepository.findAll();

        if (userList.isEmpty()) {
            throw new ValidationException("No users found");
        }

        return userList;
    }

    @Override
    public Optional<User> findById(Long id) throws ValidationException {
        if (id == null || id <= 0) {
            throw new ValidationException("Invalid user ID");
        }
        return userRepository.findById(id);
    }

    @Override
    public User update(@Valid User userUpdated) throws ValidationException {
        Optional<User> user = userRepository.findById(userUpdated.getId());
        if (user.isEmpty()) {
            throw new ValidationException("User not found with ID: " + userUpdated.getId());
        }
        return userRepository.save(userUpdated);
    }

    @Override
    public void delete(@Valid Long id) throws ValidationException {
        if (id == null || id <= 0) {
            throw new ValidationException("Invalid ID for deletion");
        }

        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
        } else {
            throw new ValidationException("User not found with id: " + id);
        }
    }
}
