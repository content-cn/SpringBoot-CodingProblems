package com.example.imdb_1.web;

import com.example.imdb_1.domain.ImdbUser;
import com.example.imdb_1.domain.User;
import com.example.imdb_1.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignUp {
    @Autowired
    RegistrationService registrationService;
    @RequestMapping("signup")
    public String getHomePage(Model registrationFormModel)
    {
        User user = registrationService.getNewImdbUser();
        registrationFormModel.addAttribute("user",user);
        return "signup";
    }
    @RequestMapping("/registerUser")
    public String getResponsePage(@ModelAttribute("user")ImdbUser imdbUser){
        int imdbUserId=registrationService.registerUser(imdbUser.getUserName(),imdbUser.getEmail(),imdbUser.getPassword());
        if(imdbUserId!=-1){
            ModelAndView modelAndView= new ModelAndView("redirect:success?id="+imdbUserId + "&name=" + imdbUser.getUserName());
            return modelAndView.getViewName();
        }
        return "signup";
    }
    @RequestMapping(value="/success")
    public String getsuccessPage(@RequestParam String id, @RequestParam String name){
        return "success";
    }

}
