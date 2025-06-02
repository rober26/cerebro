## 🧩 ¿Qué es un Controlador REST?

Un **controlador REST** en Spring Boot es una clase que gestiona peticiones HTTP (GET, POST, PUT, DELETE) y devuelve respuestas en formato JSON o XML.

---

## 🧱 Anotaciones clave

|Anotación|Descripción|
|---|---|
|`@RestController`|Marca la clase como controlador REST (combina `@Controller` y `@ResponseBody`)|
|`@Autowired`|Inyecta automáticamente un bean (por ejemplo, un repositorio)|
|`@GetMapping("/ruta")`|Define un endpoint GET|
|`@PostMapping("/ruta")`|Define un endpoint POST|
|`@PutMapping("/ruta")`|Define un endpoint PUT|
|`@DeleteMapping("/ruta")`|Define un endpoint DELETE|
|`@RequestBody`|Indica que el parámetro se toma del cuerpo de la petición (JSON)|
|`@PathVariable`|Extrae un valor de la URL para usarlo como argumento|

---

## 🧪 CRUD BÁSICO EN UN CONTROLADOR

### 1. 🔍 Obtener todos los elementos

```
@GetMapping("/elementos") 
public List<Elemento> getAll() {     
	return repositorio.findAll(); 
}
```

### 2. 🔍 Obtener uno por ID

```
@GetMapping("/elementos/{id}") 
public ResponseEntity<Elemento> getOne(@PathVariable Long id) {     Optional<Elemento> res = repositorio.findById(id);     
	return res.map(ResponseEntity::ok)               
	.orElseGet(() -> ResponseEntity.notFound().build()); 
}
```

> 🧠 Usa `Optional<>` para evitar `NullPointerException` y `ResponseEntity` para manejar el estado HTTP (200, 404, etc.).

### 3. ➕ Crear un nuevo elemento

```
@PostMapping("/elementos") 
public Elemento create(@RequestBody Elemento elemento) {     
	return repositorio.save(elemento); 
}
```
> 🧠 Spring convierte automáticamente el JSON recibido en un objeto Java.

### 4. 🛠️ Actualizar un elemento existente

```
@PutMapping("/elementos/{id}") 
public ResponseEntity<Elemento> update(@PathVariable Long id, @RequestBody Elemento nuevo) {     
	return repositorio.findById(id).map(actual -> {         
		actual.setCampo1(nuevo.getCampo1());         
		actual.setCampo2(nuevo.getCampo2());         
		return ResponseEntity.ok(repositorio.save(actual));     
	})
	.orElseGet(() -> ResponseEntity.notFound().build()); 
}
```

> 🧠 Es buena práctica devolver 404 si no existe el objeto.

### 5. ❌ Eliminar por ID

```
@DeleteMapping("/elementos/{id}") 
public ResponseEntity<Void> delete(@PathVariable Long id) {     
	if (repositorio.existsById(id)) {         
		repositorio.deleteById(id);         
		return ResponseEntity.noContent().build(); // 204 No Content     
	}     
	return ResponseEntity.notFound().build(); // 404 Not Found 
}
```
---

## 🧰 Buenas prácticas

- Usa `ResponseEntity<T>` para tener más control sobre el código de respuesta.
- Valida entradas usando `@Valid` y `BindingResult`.
- Usa `Optional<T>` para manejar ausencias sin errores.
- Inyecta los repositorios con `@Autowired` o constructor.
- Crea una clase `@Service` para lógica de negocio si la aplicación crece.
- Usa nombres RESTful (`/personajes`, `/personajes/{id}`).

---

## 📦 Repositorios en Spring Data JPA

```
@Repository 
public interface RepositoryPersonaje extends JpaRepository<Personaje, Long> { 
	// Puedes añadir métodos personalizados como:     
	List<Personaje> findByNombre(String nombre); 
}
```
> `JpaRepository<T, ID>` proporciona todos los métodos CRUD automáticamente.