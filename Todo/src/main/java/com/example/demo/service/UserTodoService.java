// UserService.java
package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.demo.model.UserTodo;
@Component
public interface UserTodoService {
    List<UserTodo> getAllUsersTodo();
    Optional<UserTodo> getUserTodoById(Long id);
    UserTodo createUserTodo(UserTodo user);
    UserTodo updateUserTodo(Long id, UserTodo user);
    void deleteUserTodo(Long id);
}
