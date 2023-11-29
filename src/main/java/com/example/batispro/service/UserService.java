package com.example.batispro.service;

import com.example.batispro.domain.entity.User;
import com.example.batispro.handlers.exceptionHandler.ValidationException;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Service
public interface UserService {
    public User save(@Valid User user) throws ValidationException;

    public List<User> findAll() throws ValidationException;

    public Optional<User> findById(Long id) throws ValidationException;

    public User update(@Valid User userUpdated) throws ValidationException;

    public void delete(@Valid Long id) throws ValidationException;
}
