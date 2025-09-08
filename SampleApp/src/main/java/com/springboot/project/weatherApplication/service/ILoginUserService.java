package com.springboot.project.weatherApplication.service;

import com.springboot.project.weatherApplication.model.LoginUser;

public interface ILoginUserService {
    public LoginUser save(LoginUser loginUser);
    public void fetchByUsername();
    public boolean validateUserExists(String uname, String pass);
}
