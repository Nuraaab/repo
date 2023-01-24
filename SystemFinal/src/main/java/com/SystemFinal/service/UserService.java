package com.SystemFinal.service;

import org.springframework.stereotype.Service;

import com.SystemFinal.entity.User;
@Service
public interface UserService {
	public Iterable<User> findAll();
	public User find(int id);
	public void create(User user);
	public void update(User user);
	public void delete(int id); 

}
