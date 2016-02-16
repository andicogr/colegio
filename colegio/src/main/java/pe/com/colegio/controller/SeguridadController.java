package pe.com.colegio.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.com.colegio.service.PerfilService;
import pe.com.colegio.service.UsuarioService;


@Controller
@RequestMapping("seguridad/")
public class SeguridadController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	private static final Logger log = LoggerFactory.getLogger(SeguridadController.class);
	
	@RequestMapping(value="usuario/usuarioForm", method = RequestMethod.GET)
	public String usuarioForm(Model model,Integer msg){
		log.info("[SeguridadController] - [usuarioForm]");
		usuarioService.listaUsuarios();
		/*Mejorar el data table para la vista y tener un standar*/
		return "seguridad/usuario/usuarioList";
	}
}