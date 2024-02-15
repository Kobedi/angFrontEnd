package com.boot.rest.base.service.impl;

import com.boot.rest.base.model.Society;
import com.boot.rest.base.repository.SocietyRepository;
import com.boot.rest.base.service.SocietyService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SocietyServiceImpl implements SocietyService {

    @Autowired
    private SocietyRepository societyRepository;

    private List<Society> lst = new ArrayList<>();

    public SocietyServiceImpl()
    {
        System.out.println("Generate a quick list");
        for(int i=0; i<10; i++)
        {
            Society society = new Society();
            society.setId(i);
            society.setName("name_"+i);
            lst.add(society);

        }
    }

    @Override
    public List<Society> findAll() {
        //return this.societyRepository.findAll();
        return lst;
    }
}
