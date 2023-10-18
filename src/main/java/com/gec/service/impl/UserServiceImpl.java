package com.gec.service.impl;


import com.gec.dao.UserDao;
import com.gec.entity.User;
import com.gec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
     UserDao userDao;
    @Override
    public List<User>getAllUser(){
        return userDao.getAllUser();
    }
}
