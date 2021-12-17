package com.Zikri.backEndProject.controllers;

import java.util.List;

import com.Zikri.backEndProject.models.User;
import com.Zikri.backEndProject.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String HomePage(Model model) {
        List<User> listuser = userService.listAll();
        model.addAttribute("listUser", listuser);
        return "index";
    }

    @RequestMapping("/newUser")
    public String NewUserPage(Model model) {
        User users = new User();
        model.addAttribute(users);
        return "new_user";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String SaveUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/";
    }

    @RequestMapping("/edit/{uid}")
    public ModelAndView EditUser(@PathVariable(name = "uid") long uid) {
        ModelAndView mView = new ModelAndView("edit_user");
        User user = userService.get(uid);
        mView.addObject("user", user);
        return mView;
    }

    @RequestMapping("/delete/{uid}")
    public String DeleteUser(@PathVariable(name = "uid") long uid) {
        userService.delete(uid);
        return "redirect:/";
    }
}
