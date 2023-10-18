package com.gec.service;

import com.gec.entity.Type;

import java.util.List;

public interface TypeService {
    public List<Type> getAllType(Integer page,Integer limit);
}
