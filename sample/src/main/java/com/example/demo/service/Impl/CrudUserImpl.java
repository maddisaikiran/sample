package com.example.demo.service.Impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.exception.ValidationException;
import com.example.demo.model.User;
import com.example.demo.respository.UserRespository;
import com.example.demo.service.CrudUser;

@Service
public class CrudUserImpl implements CrudUser{

	@Autowired
	private UserRespository userRespository;
	
	
	@Override
	public User addUser(User user) throws ValidationException {
		// TODO Auto-generated method stub
		validateUser(user);
		return userRespository.save(user);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return userRespository.save(user);
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userRespository.deleteById(id);
	}

	

	@Override
	public User findByUserEmail(String emailId) {
		// TODO Auto-generated method stub
		User c = new User();
		c = userRespository.findByEmailId(emailId);
		return c;
	}

	@Override
	public User getUsersById(int id) {
		// TODO Auto-generated method stub
		return userRespository.findById(id).get();
	}

	@Override
	public User getUserByEmailIdAndPassword(String emailId, String password) {
		// TODO Auto-generated method stub
		return userRespository.findByEmailIdAndPassword(emailId, password);
	}
	
	private void validateUser(User user) throws ValidationException {
		if(StringUtils.isEmpty(user.getEmailId())) {
			throw new ValidationException("Email id should be mandatory");
		}
		if(StringUtils.isEmpty(user.getPassword()) || user.getPassword().trim().equals("")) {
			throw new ValidationException("Password should be mandatory");
		}
		if(StringUtils.isEmpty(user.getMobile())) {
			throw new ValidationException("Mobile should be mandatory");
		}
		if(StringUtils.isEmpty(user.getFullName())) {
			throw new ValidationException("FullName should be mandatory");
		}
	}

}
