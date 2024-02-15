package com.boot.rest.base.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.boot.rest.base.dto.SocietySearch;
import com.boot.rest.base.model.Company;
import com.boot.rest.base.model.Society;
import com.boot.rest.base.service.UserService;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.rest.base.model.User;
import com.boot.rest.base.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;

  @Override
  public List<Society> getSocieties() {
    return new ArrayList<>();
  }

  @Override
  public User insert(User userVO) {
    return this.userRepository.save(userVO);
  }

  @Override
  public User login(User loginuser) {

    List<User> lst = findAll();
    if(lst!=null && lst.size() > 0)
    {
      for(User user: lst)
      {
        if(user.getUsername().equalsIgnoreCase(loginuser.getUsername()))
        {
          return user;
        }
      }
    }
    return new User();
  }

  @Override
  public List<User> findAll() {

    return this.userRepository.findAll();
  }

  @Override
  public List<Company> searchBySocietyAndChargeDate(SocietySearch societySearch) {

    return new ArrayList<>();
  }

  @Override
  public void delete(int id) {
    this.userRepository.deleteById(id);
  }

  @Override
  public User findById(int id) {
    return this.userRepository.findById(id).get();
  }

  @Override
  public User updateUser(int id, User userVO) {
    userVO.setId(id);
    return this.userRepository.save(userVO);
  }

}
