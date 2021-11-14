package main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import main.models.User;
import main.repository.UserRepository;
import main.services.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}

	@GetMapping("/forbidden")
	public String showForbidden() {
		return "403";
	}

	@GetMapping("/signup")
	public String showSignupForm(@ModelAttribute User user) {
		return "form-signup";
	}

	@PostMapping("/processSignUp")
	public String processSignUp(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
		boolean errors = false;
		if (!user.getPassword().equals(user.getConfirmPassword())) {
			redirectAttributes.addAttribute("differentsPassword", "Passwords Are Differents");
			errors = true;
		}
		
		if(userService.loginExists(user.getLogin())) {
			redirectAttributes.addAttribute("loginExists", "Login already exists choose another one");
			errors = true;
		}
		
		if(errors) {
			return "redirect:/signup";
		}
		
		userService.createNewAccount(user);

		return "/login";
	}

}
