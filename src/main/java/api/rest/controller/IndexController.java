package api.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.rest.model.Usuario;
import api.rest.repository.UsuarioRespository;


/* Arquitetura Rest */
@RestController
@RequestMapping(value = "/usuario")
public class IndexController {

/* Serviços Restful */
	
    @Autowired /* se fosse CDI seria @Inject*/	
	private UsuarioRespository usuarioRespository;
	
    
    @GetMapping(value = "/{id}/codigovenda/{venda}", produces = "application/json")
	public ResponseEntity<Usuario> relatorio(@PathVariable (value = "id") Long id
                                            ,@PathVariable (value = "venda") Long venda){
		
	 Optional<Usuario> usuario = usuarioRespository.findById(id);
		
		return new ResponseEntity<Usuario> (usuario.get(), HttpStatus.OK);
		
	}
    
    
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Usuario> init(@PathVariable (value = "id") Long id) {
		
	 Optional<Usuario> usuario = usuarioRespository.findById(id);
		
		return new ResponseEntity<Usuario> (usuario.get(), HttpStatus.OK);
		
	}
	
	
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<Usuario>> usuario(){
		
		List<Usuario> list = (List<Usuario>) usuarioRespository.findAll();
		
		return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/", produces = "application/json")
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario){
		
		Usuario usuarioSalvo = usuarioRespository.save(usuario);
		
		return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/", produces = "application/json")
	public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario){
		
		Usuario usuarioSalvo = usuarioRespository.save(usuario);
		
		return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/{id}", produces = "application/text")
	public String delete (@PathVariable (value = "id") Long id) {
		
	 usuarioRespository.deleteById(id);
		
		return "OK";
		
	}
	
}
