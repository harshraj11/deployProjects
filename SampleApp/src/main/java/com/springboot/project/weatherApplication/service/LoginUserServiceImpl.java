package com.springboot.project.weatherApplication.service;

import com.springboot.project.weatherApplication.model.LoginUser;
import org.springframework.stereotype.Service;

@Service
public class LoginUserServiceImpl implements ILoginUserService{

    public LoginUser save(LoginUser loginUser) {
        return new LoginUser();
    }

    @Override
    public void fetchByUsername() {

    }

    @Override
    public boolean validateUserExists(String uname, String pass) {
        LoginUser user = new LoginUser();
        user.setName("harsh");
        user.setPassword("harsh");
        if (user!=null && user.getUsername().equals(uname) && user.getPassword().equals(pass))
            return true;
        return false;
    }
}
