package com.springboot.project.weatherApplication.controllers;

import com.springboot.project.weatherApplication.model.LoginObject;
import com.springboot.project.weatherApplication.model.LoginUser;
import com.springboot.project.weatherApplication.service.ILoginUserService;
import org.apache.catalina.session.StandardSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @Autowired
    ILoginUserService loginUserService;

    @RequestMapping("/login")
    public String login(HttpSession session) {
        session.setAttribute("errorMessage", "");
        return "login.jsp";
    }

    @RequestMapping("/loginNotRegistered")
    public String loginNotRegistered(HttpSession session) {
        return "login.jsp";
    }


    @RequestMapping(value = "/welcome", method = RequestMethod.POST)
    public String showWelcomePage1(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String uname = req.getParameter("username");
        String pass = req.getParameter("password");
        boolean result = loginUserService.validateUserExists(uname, pass);
        if (result==true){
            session.setAttribute("uname", uname);
            return "welcome.jsp";
        }
        session.setAttribute("errorMessage", "You are not registered. Please Register yourself");
        return "redirect:/loginNotRegistered";
    }

    @RequestMapping("/registration")
    public String registration(){
        return "registration.jsp";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(ModelMap model, LoginUser loginUser) {
        model.addAttribute("uname", loginUser.getUsername());
        loginUserService.save(loginUser);
        return "redirect:/login";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "logout";
    }



    // accepting data from JSP
    /*
    1. HTTPRequest
    2. Object
     */

    /*
    @RequestMapping(value = "/welcome2", method = RequestMethod.POST)
    public String showWelcomePage2(@RequestParam("username") String name, @RequestParam("password") String pass, HttpSession session) {
        session.setAttribute("uname", name);
        return "welcome.jsp";
    }

    @RequestMapping(value = "/welcome3", method = RequestMethod.POST)
    public ModelAndView showWelcomePage3(@RequestParam("username") String name, @RequestParam("password") String pass) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("uname", name);
        mv.setViewName("welcome.jsp");
        return mv;
    }

    //@RequestBody maps web request's body to method parameter LoginObject
    @RequestMapping(value = "/welcome4", method = RequestMethod.POST)
    public ModelAndView showWelcomePage4(@RequestBody LoginObject login) {
        String username = login.getUsername();
        String password = login.getPassword();

        ModelAndView mv = new ModelAndView();
        mv.addObject("uname", username);
        mv.setViewName("welcome.jsp");
        return mv;
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.POST)
    public String showWelcomePage4(ModelMap model, LoginObject object) {
        model.addAttribute("uname", object.getUsername());
        return "welcome.jsp";
    }*/
}
