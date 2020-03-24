package com.jt.dubbo.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.jt.dubbo.pojo.User;

public interface UserService {
	
	List<User> findAll();
	
	@Transactional
	void saveUser(User user);
}
