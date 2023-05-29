package in.ineuron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import in.ineuron.model.Users;
import in.ineuron.service.UserService;

@Controller
public class Main 
{
	@Autowired
	private UserService service;
	
	@GetMapping("/")
	public ModelAndView getRegisterViewPage()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@PostMapping("/postUser")
	public ModelAndView postRegisterDetails(Users users)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		
		service.postUserDetails(users);
		return modelAndView;
	}
	
	@GetMapping("/login")
	public ModelAndView getLoginViewPage()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@PostMapping("/validate")
	public ModelAndView validateLoginUser(Users users)
	{
		ModelAndView modelAndView = new ModelAndView();
		
		String validateUser = service.validateUser(users);
		if(validateUser.equals("InvalidCredentials"))
		{
			modelAndView.setViewName("login");
			modelAndView.addObject("message", "UserName or Password Incorrect!");
			return modelAndView;
		}
		else
		{
			modelAndView.setViewName("dashboard");
			return modelAndView;
		}
	}
}
