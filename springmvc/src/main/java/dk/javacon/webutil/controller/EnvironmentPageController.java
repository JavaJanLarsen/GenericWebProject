package dk.javacon.webutil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dk.javacon.util.web.EnvironmentFacade;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class EnvironmentPageController {
	@RequestMapping("/environment.html")
	public String environment(Model model) {
		log.debug("EnvironmentPageController.environment");
		EnvironmentFacade env = new EnvironmentFacade();
		
		model.addAttribute("props", env.getSortedProperties());
		model.addAttribute("dependencies", env.getDependencies(EnvironmentPageController.class));
		return "environment";
	}

}
