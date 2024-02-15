package com.boot.rest.base.service;

import com.boot.rest.base.model.Loyalty;
import com.boot.rest.base.model.User;

import java.util.List;

public interface LoyaltyService {

    public Loyalty saveLoyalty(Loyalty loyalty);

    public List<Loyalty> findAll();
}
