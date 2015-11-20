package dk.javacon.springmvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HejController {
	@RequestMapping("/hej")
	public String hej(Model model) {
		model.addAttribute("navn", "Jan");
		return "hej";
	}
}
