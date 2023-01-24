package com.SystemFinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SystemFinal.entity.User;
import com.SystemFinal.repository.UserRepository;

@Service("UserService")
public class UserServiceimpl implements UserService{
@Autowired
private UserRepository userRepository;
	@Override
	public Iterable<User> findAll() {
		
		return userRepository.findAll();
	}
	@Override
	public User find(int id) {
		return userRepository.findById(id).get();
	}
	@Override
	public void create(User user) {
		userRepository.save(user);
		
	}
	@Override
	public void update(User user) {
		userRepository.save(user);
	}
	@Override
	public void delete(int id) {
		userRepository.deleteById(id);
	}

}
