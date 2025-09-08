package com.springboot.project.weatherApplication.service;

import com.springboot.project.weatherApplication.model.LoginUser;
import com.springboot.project.weatherApplication.repository.LoginUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginUserServiceImpl implements ILoginUserService{

    @Autowired
    LoginUserRepository loginUserRepository;

    public LoginUser save(LoginUser loginUser) {
        return loginUserRepository.save(loginUser);
    }

    @Override
    public void fetchByUsername() {

    }

    @Override
    public boolean validateUserExists(String uname, String pass) {
        LoginUser user = loginUserRepository.findByUsername(uname);
        if (user!=null && user.getUsername().equals(uname) && user.getPassword().equals(pass))
            return true;
        return false;
    }
}
