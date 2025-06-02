package ar.com.nextfix.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.com.nextfix.service.CustomUserDetailsService;
import ar.com.nextfix.service.DirectorService;

@Controller
@AllArgsConstructor
public class DirectorViewController {
	private final DirectorService directorService;
	private final CustomUserDetailsService customUserDetailsService;

	@GetMapping("/directores")
	public String listarDirectores(Model model) {
		model.addAttribute("directores", directorService.listarDirectores());
		model.addAttribute("userService", customUserDetailsService);

		return "listaDirectores";
	}
}
