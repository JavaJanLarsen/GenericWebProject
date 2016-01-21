package dk.javacon.webutil.controller;

import java.util.Map.Entry;

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
		EnvironmentFacade env = new EnvironmentFacade();
		for (Entry<Object, Object> entry : env.getProperties().entrySet()) {
			log.debug("Entry: "+entry);
		}
		model.addAttribute("props", env.getProperties().entrySet());
		return "environment";
	}

}
