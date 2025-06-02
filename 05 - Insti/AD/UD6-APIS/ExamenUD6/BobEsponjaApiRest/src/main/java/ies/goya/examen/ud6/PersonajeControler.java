package ies.goya.examen.ud6;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonajeControler {
	@Autowired
	RepositoryPersonaje repositrioPersanajes;
	
	@GetMapping("/personajes")
	public List<Personaje> dameTodos(){
		return (List<Personaje>) repositrioPersanajes.findAll();
	}
	
	@GetMapping("/personajes/{id}")
	public ResponseEntity<?> dameUno(@PathVariable(name="id") Long id){
		repositrioPersanajes.findById(id).orElse(null);
		if (res.isPresent()) return new ResponseEntity<Personaje>(res.get().)
		return new ResponseEntity(null.H);
	}
	
	@PostMapping("/personajes")
	public Personaje crearPersonaje(@RequestBody Personaje personaje) {
		return repositrioPersanajes.save(personaje);
	}
	@PutMapping("/personajes/{id}")
	public Personaje putPersonaje(@PathVariable(name="id") Long id,@RequestBody Personaje personaje) {
		if(repositrioPersanajes.existsById(id)) {
			Personaje personajeA = repositrioPersanajes.findById(id).orElse(null);
			personajeA.setNombre(personaje.getNombre());
			personajeA.setDescripción(personaje.getDescripción());
			return repositrioPersanajes.save(personajeA);
		}else {
		System.out.print("No funciona");
		}
		return null;
	}
	
	@DeleteMapping("/personajes/{id}")
	public void deletePersonaje(@PathVariable(name="id") Long id) {
		repositrioPersanajes.deleteById(id);
	}
	
}
