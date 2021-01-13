package com.sametakbal.api.service;

import com.sametakbal.api.dao.interfaces.IUserDao;
import com.sametakbal.api.entity.User;
import com.sametakbal.api.entity.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    private final IUserDao userDao;

    @Autowired
    public UserService(IUserDao userDao) {
        this.userDao = userDao;
    }

    public boolean addUser(User user){
        if (!userDao.isEmailExist(user.getEmail())){
            return false;
        }
        user.setRole(Role.USER);
        return userDao.save(user);
    }
}
