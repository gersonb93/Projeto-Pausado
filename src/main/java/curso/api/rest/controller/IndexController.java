package curso.api.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.api.rest.model.Usuario;


@RestController
@RequestMapping(value = "/usuario")
public class IndexController {

	
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<Usuario> init() {
		
		Usuario usuario = new Usuario();
		usuario.setId(50L);
		usuario.setLogin("bgerson003@gmail.com");	
		usuario.setNome("Gerson Batista da Silva");
		usuario.setSenha("123456");
		
		return new ResponseEntity (usuario, HttpStatus.OK);
		
	}
	
}
