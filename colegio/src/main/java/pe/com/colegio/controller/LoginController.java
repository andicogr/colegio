package pe.com.colegio.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.com.colegio.domain.Usuario;
import pe.com.colegio.service.UsuarioService;


@Controller
public class LoginController {

	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping("/login")
	public String login(Model model,  String message) {
		log.info("[LoginController] - [login]");
		//model.addAttribute("message", message);
		return "acceso/login";
	}
	
	@RequestMapping("/login2")
	public String login2(Model model, String message) {
		log.info("[LoginController] - [login2]");
		//model.addAttribute("message", message);
		return "acceso/login2";
	}
	
	@RequestMapping(value = "/denied")
 	public String denied() {
		return "acceso/denied";
	}
	
	@RequestMapping(value = "/login/failure")
 	public String loginFailure(Model model) {
		log.info("[LoginController] - [loginFailure]");
		String message = "Nombre de Usuario o Clave Incorrectos!";
		//model.addAttribute("message", message);
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/logout/success")
 	public String logoutSuccess(Model model) {
		log.info("[LoginController] - [logoutSuccess]");
		String message = "Sesion cerrada correctamente!";
		//model.addAttribute("message", message);
		return "redirect:/login";
	}

}