# 🗃️ **Conceptos Clave de JPA**

---

## 1. 📌 Anotaciones Básicas

| Anotación                       | Descripción                                                                           |
| ------------------------------- | ------------------------------------------------------------------------------------- |
| `@Entity`                       | Marca la clase como entidad persistente (tabla en la BD).                             |
| `@Table(name = "nombre_tabla")` | Opcional. Especifica el nombre de la tabla en la base de datos.                       |
| `@Id`                           | Indica la clave primaria. Obligatorio en cada entidad.                                |
| `@GeneratedValue`               | Estrategia de generación automática de la clave primaria.                             |
| `@Column`                       | Personaliza el mapeo entre atributo y columna (nombre, longitud, nullabilidad, etc.). |

### 🧱 Ejemplo básico:
````
@Entity 
@Table(name = "clientes") 
public class Cliente {     
	
	@Id     
	@GeneratedValue(strategy = GenerationType.IDENTITY)     
	private Long id;      
	
	@Column(name = "nombre_completo", length = 100, nullable = false)     
	private String nombre; 

}
````
---

## 2. 🔗 Tipos de Relaciones

### 🔸 Uno a Uno (`@OneToOne`)
````
@Entity 
public class Usuario {     
	@OneToOne(mappedBy = "usuario")     
	private Perfil perfil; 
}  

@Entity 
public class Perfil {     @OneToOne     @JoinColumn(name = "usuario_id")     private Usuario usuario; }
````
### 🔸 Uno a Muchos / Muchos a Uno (`@OneToMany` / `@ManyToOne`)
````
@Entity 
public class Departamento {     
	@OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)     
	private List<Empleado> empleados = new ArrayList<>(); 
}  

@Entity 
public class Empleado {     
	@ManyToOne(fetch = FetchType.LAZY)     
	@JoinColumn(name = "departamento_id")     
	private Departamento departamento; 
}
````
### 🔸 Muchos a Muchos (`@ManyToMany`)
````
@Entity 
public class Estudiante {     
	@ManyToMany     
	@JoinTable( 
		name = "estudiantes_cursos",         
		joinColumns = @JoinColumn(name = "estudiante_id"),         
		inverseJoinColumns = @JoinColumn(name = "curso_id")     
	)     
	private List<Curso> cursos; 
}  

@Entity 
public class Curso {     
	@ManyToMany(mappedBy = "cursos")     
	private List<Estudiante> estudiantes; 
}
````
---

## 3. ⚙️ Opciones Avanzadas en Relaciones

|Opción|Descripción|
|---|---|
|`mappedBy`|Indica el lado no dueño de la relación en asociaciones bidireccionales.|
|`cascade`|Propaga operaciones (`PERSIST`, `MERGE`, `REMOVE`, etc.) a la entidad relacionada.|
|`fetch`|Controla la estrategia de carga: `LAZY` (por defecto) o `EAGER`.|

### Ejemplo de uso:
````
@OneToMany(mappedBy = "autor", 
	cascade = CascadeType.ALL, 
	fetch = FetchType.LAZY
) 
private List<Libro> libros;
````
---

## 4. ✅ Buenas Prácticas

- **Claves primarias:** Usar tipos envoltorio (`Long`, `Integer`) en vez de primitivos (`long`, `int`).
- **Relaciones bidireccionales:** Sincronizar ambos lados manualmente.
````
public void agregarEmpleado(Empleado emp) {     
	empleados.add(emp);     
	emp.setDepartamento(this); 
}
````
- **Carga LAZY por defecto:** Evita cargar relaciones innecesarias hasta que se accedan explícitamente.
- **Evita ciclos infinitos en serialización:** Usa `@JsonIgnore` o DTOs en APIs REST.
- **Estados del ciclo de vida de una entidad:**
    - **Transient:** No gestionada aún por el EntityManager.
    - **Managed:** Persistida y gestionada.
    - **Detached:** Ya no está gestionada.
    - **Removed:** Marcada para ser eliminada.

---

## 5. 🔍 Consultas JPQL (Java Persistence Query Language)

### Consulta simple

java

CopiarEditar

`TypedQuery<Cliente> query = em.createQuery(     "SELECT c FROM Cliente c WHERE c.edad > :edad", Cliente.class); query.setParameter("edad", 18); List<Cliente> clientes = query.getResultList();`

### Consulta con JOIN

java

CopiarEditar

`TypedQuery<Pedido> query = em.createQuery(     "SELECT p FROM Pedido p JOIN p.cliente c WHERE c.nombre = :nombre", Pedido.class); query.setParameter("nombre", "Carlos"); List<Pedido> pedidos = query.getResultList();`

### Otros operadores útiles:

- `LIKE`, `BETWEEN`, `IN`, `IS NULL`, `ORDER BY`, `GROUP BY`
- Funciones agregadas: `COUNT()`, `MAX()`, `MIN()`, `AVG()`, `SUM()`

---

## 6. 🔐 Transacciones

Las operaciones JPA deben ejecutarse dentro de una transacción para ser efectivas:
````
EntityTransaction tx = em.getTransaction(); 
try {     
	tx.begin();     
	// operaciones JPA     
	tx.commit(); 
} catch (Exception e) {     
	if (tx.isActive()) tx.rollback();     
	throw e; 
}
````
> En frameworks como Spring, se gestiona automáticamente con `@Transactional`.

---

## 7. 🧰 Utilidades adicionales

### Flush y Clear
````
em.flush(); // Fuerza sincronización con la base de datos 
em.clear(); // Limpia el contexto de persistencia
````
### Eliminación en cascada
````
@OneToMany(mappedBy = "usuario", 
	cascade = CascadeType.ALL, 
	orphanRemoval = true
) 
private List<Direccion> direcciones;
```