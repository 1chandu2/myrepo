package com.bizauth.dao;

import org.springframework.data.repository.CrudRepository;

import com.bizauth.model.UserVO;

public interface UserDAO extends CrudRepository<UserVO, Integer>{

	UserVO findByUsername(String username);
}
