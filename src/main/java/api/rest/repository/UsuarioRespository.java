package api.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import api.rest.model.Usuario;



@Repository
public interface UsuarioRespository extends CrudRepository<Usuario, Long>{

	
	
	
}
