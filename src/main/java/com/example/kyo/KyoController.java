package com.example.kyo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class KyoController {

	@RequestMapping("/")
	public String index(HttpServletRequest request, Model model) {
		String username = (String) request.getSession().getAttribute("username");

		if(StringUtils.isBlank(username)) {
			return "redirect:/login";
		}

		model.addAttribute("username", username);

		return "chat";
	}

	@GetMapping(path = "/login")
	public String showLoginPage() {
		return "login";
	}

	@PostMapping(path = "/login")
	public String doLogin(HttpServletRequest request, @RequestParam(defaultValue = "") String userName) {
		userName = userName.trim();

		if(StringUtils.isBlank(userName)) {
			return "login";
		}

		request.getSession().setAttribute("username", userName);

		return "redirect:/";
	}

	@RequestMapping(path = "/logout")
	public String logout(HttpServletRequest request) {
		request.getSession(true).invalidate();

		return "redirect:/login";
	}
}
