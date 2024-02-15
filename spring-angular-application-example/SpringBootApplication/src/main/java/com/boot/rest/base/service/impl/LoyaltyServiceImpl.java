package com.boot.rest.base.service.impl;

import com.boot.rest.base.model.Loyalty;
import com.boot.rest.base.repository.LoyaltyRepository;
import com.boot.rest.base.service.LoyaltyService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class LoyaltyServiceImpl implements LoyaltyService {


    @Autowired
    LoyaltyRepository loyaltyRepository;
    @Override
    public Loyalty saveLoyalty(Loyalty loyalty) {
        return loyaltyRepository.save(loyalty);
    }

    @Override
    public List<Loyalty> findAll() {
        return loyaltyRepository.findAll();
    }
}
