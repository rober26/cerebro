**Objetivo del ejercicio:**  
Crear una aplicación Java que almacene, consulte, modifique y elimine datos en una **base de datos relacional** (como MySQL o MariaDB), en lugar de usar ficheros. El objetivo es **aprender a conectar Java con bases de datos** y realizar un **CRUD completo** (Create, Read, Update, Delete).

---

**Opciones de desarrollo (elige una):**

1. **Completar un CRUD** en la clase `ModeloAlumnosJDBC` del proyecto `gestionAlumnos`.

2. **Modificar un proyecto existente** (como `FicheroAgendaV1`) para que en vez de guardar datos en ficheros, lo haga en una base de datos.
    - Crearás una clase nueva `BD_Agenda.java` que se conecte a la base de datos y tenga métodos como:
        - `leeContactos()`
        - `escribeRegistro(Contacto contacto)`
        - `borraRegistro(Contacto contacto)`
    - No necesitas listas ni mapas en memoria, solo usarás SQL.
    - Puedes usar la misma clase de pruebas cambiando solo la instancia del fichero por la base de datos.

3. **Crear una aplicación nueva** (por consola o con interfaz gráfica) que gestione datos en una base de datos. Puede ser sobre cualquier tema que te interese (películas, tareas, productos, etc.).

4. Si quieres nota excelente:
    - Usa **más de una tabla** con relaciones (por ejemplo, alumnos y cursos).
    - Añade **campos de fecha** y **funcionalidad de búsqueda**.
    - Haz que la aplicación **cree las tablas automáticamente** la primera vez que se ejecute.
    - Importa datos desde archivos CSV.
---

**Requisitos técnicos:**

- Usa `PreparedStatement` (no `Statement`) por seguridad.
    
- Usa Java y un motor de base de datos como MySQL o MariaDB.
    
- Documenta el proyecto en un PDF con:
    
    - Enlace al código fuente.
        
    - Instrucciones claras para probarlo.
        
    - Conclusiones personales de cada integrante del grupo.