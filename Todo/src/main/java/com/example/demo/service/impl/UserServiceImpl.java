// UserServiceImpl.java
package com.example.demo.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserTodo;
import com.example.demo.repo.UserTodoRepo;
import com.example.demo.service.UserTodoService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserTodoService {

    private final UserTodoRepo userRepository;

    @Autowired
    public UserServiceImpl(UserTodoRepo userRepository) {
        this.userRepository = userRepository;
    }

	@Override
	public List<UserTodo> getAllUsersTodo() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public Optional<UserTodo> getUserTodoById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public UserTodo createUserTodo(UserTodo user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public UserTodo updateUserTodo(Long id, UserTodo user) {
		Optional<UserTodo> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            UserTodo updatedUser = existingUser.get();
            updatedUser.setDescription(user.getDescription());
            updatedUser.setCompleted(false);
            return userRepository.save(updatedUser);
        }
        return null;
	}

	@Override
	public void deleteUserTodo(Long id) {
		userRepository.deleteById(id);
		
	}
}
