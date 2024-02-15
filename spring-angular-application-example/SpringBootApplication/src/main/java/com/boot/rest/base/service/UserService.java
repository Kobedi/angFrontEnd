package com.boot.rest.base.service;

import java.util.List;

import com.boot.rest.base.dto.SocietySearch;
import com.boot.rest.base.model.Company;
import com.boot.rest.base.model.Society;
import com.boot.rest.base.model.User;

public interface UserService {

	public List<Society> getSocieties();

	public User insert(User userVO);

	public User login(User user);

	public List<User> findAll();

	public List<Company> searchBySocietyAndChargeDate(SocietySearch societySearch);


	public void delete(int id);

	public User findById(int id);

	public User updateUser(int id, User userVO);
}
