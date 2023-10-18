package com.gec.service.impl;


import com.github.pagehelper.PageHelper;
import com.gec.dao.TypeDao;
import com.gec.entity.Type;
import com.gec.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeDao typeDao;

    @Override
    public List<Type> getAllType(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
       return typeDao.getAllType();
    }
}
