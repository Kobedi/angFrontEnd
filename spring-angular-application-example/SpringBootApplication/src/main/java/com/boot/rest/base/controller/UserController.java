package com.boot.rest.base.controller;

import java.util.List;

import com.boot.rest.base.dto.SocietySearch;
import com.boot.rest.base.model.Company;
import com.boot.rest.base.model.Society;
import com.boot.rest.base.service.SocietyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.boot.rest.base.model.User;
import com.boot.rest.base.service.UserService;

@RestController
@RequestMapping(value = "user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private SocietyService societyService;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public User registerUser(@RequestBody User userVO) {

		return this.userService.insert(userVO);
	}

	@PostMapping("/login")
	@ResponseStatus(value = HttpStatus.OK)
	public User login(@RequestBody User user) {

		return this.userService.login(user);
	}

	@GetMapping("/society-lst")
	@ResponseStatus(value = HttpStatus.OK)
	public List<Society> getSocieties() {

		return this.userService.getSocieties();
	}


	@GetMapping("/society")
	@ResponseStatus(value = HttpStatus.OK)
	public List<Society> findAllSocieties() {
		return this.societyService.findAll();
	}

	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public List<User> findAllUser() {

		return this.userService.findAll();
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public User findById(@PathVariable int id) {
		return this.userService.findById(id);
	}

	@PutMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public User updateUser(@PathVariable int id, @RequestBody User userVO) {

		return this.userService.updateUser(id, userVO);
	}

	@GetMapping(value = "/search")
	@ResponseStatus(value = HttpStatus.OK)
	public List<Company> searchSocietyByIdNChargeDate(@RequestBody SocietySearch societySearch) {

		return this.userService.searchBySocietyAndChargeDate(societySearch);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable int id) {

		this.userService.delete(id);
	}


}
