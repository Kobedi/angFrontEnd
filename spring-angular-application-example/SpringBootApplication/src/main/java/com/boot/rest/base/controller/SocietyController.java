package com.boot.rest.base.controller;

import com.boot.rest.base.model.Society;
import com.boot.rest.base.model.User;
import com.boot.rest.base.service.SocietyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "society")
@CrossOrigin(origins = "http://localhost:4200")
public class SocietyController {

    @Autowired
    private SocietyService societyService;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Society> findAllUser() {

        return this.societyService.findAll();
    }









}
