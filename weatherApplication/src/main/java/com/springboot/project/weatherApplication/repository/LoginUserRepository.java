package com.springboot.project.weatherApplication.repository;

import com.springboot.project.weatherApplication.model.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginUserRepository extends JpaRepository<LoginUser, Long> {

    public LoginUser findByUsername(String uname);
}