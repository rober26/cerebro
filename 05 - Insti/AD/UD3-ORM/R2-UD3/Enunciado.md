## 🧩 **Objetivo del Proyecto**

El objetivo de este reto es **usar Hibernate como implementación de JPA** para realizar mapeo objeto-relacional (ORM) y realizar consultas avanzadas a la base de datos.

Este trabajo te permite alcanzar el **Resultado de Aprendizaje 3**:
### Para superarlo, deberás:

- Instalar y configurar Hibernate como herramienta ORM.
    
- Definir correctamente el mapeo entre clases Java y tablas.
    
- Aplicar persistencia: guardar, actualizar, borrar y leer objetos.
    
- Realizar **consultas SQL usando JPQL y API Criteria**.
    
- Gestionar **transacciones**.
    

---

## 🛠️ Qué tenéis que hacer

En grupos de 2 alumnos, debéis crear una aplicación Java que acceda a una base de datos relacional (MySQL o MariaDB), usando JPA con **Hibernate**.

Podéis usar una interfaz de texto o adaptar alguna interfaz de proyectos anteriores.

---

## 📌 **Fases del Proyecto**

### 1. **Cambiar EclipseLink por Hibernate**

- Tomad el proyecto del reto anterior y **sustituid EclipseLink por Hibernate**.
    
- Cambiad el `persistence.xml`, indicando:
    
    xml
    
    Copiar código
    
    `<provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>`
    
- OJO: Hibernate es más estricto con tipos primitivos → usad `Integer` en vez de `int`, `Float` en vez de `float`, etc.
    
- Documentad si funciona directamente o qué cambios fueron necesarios.
    

---

### 2. **Opción alternativa**

- Si preferís, podéis empezar desde cero el proyecto, pero haciendo de nuevo el CRUD sobre la misma base de datos del reto anterior.
    

---

### 3. **Consultas con JPQL y Criteria API**

Implementad **consultas** usando **dos formas distintas**:  
✔️ JPQL (Java Persistence Query Language)  
✔️ Criteria API (consulta mediante objetos)

Para practicar, realizad al menos estas 7 consultas en ambos sistemas:

1. Mostrar algunas columnas de todas las filas (proyección parcial).
    
2. Filtrar por un criterio (`WHERE`).
    
3. Ordenar los resultados.
    
4. Búsqueda exacta y por coincidencia parcial (`LIKE`).
    
5. Buscar por rango de valores (`BETWEEN`).
    
6. Obtener estadísticas: suma, media, total de registros que cumplan una condición.
    
7. Hacer un `JOIN` entre entidades relacionadas.
    

💡 Podéis buscar ejemplos en los ejercicios del aula virtual.

---

### 4. **(Opcional) Patrones DAO o Repository**

- Investigad cómo aplicar un patrón **DAO o Repository**.
    
- Implementad alguno de los CRUD o consultas anteriores usando este patrón.
    

---

### 5. **(Opcional) Generar clases por ingeniería inversa**

Intentad que Hibernate **genere automáticamente las clases Java a partir de una base de datos existente**.

🔍 Usad el tutorial de José María:  
_“Configuración de Hibernate en Eclipse 2023.pdf”_

⚠️ **Consejos para evitar errores comunes**:

- Al instalar JBoss tools en Eclipse, tened paciencia (tarda bastante).
    
- El proyecto Maven puede quedarse esperando una confirmación por consola.
    
- Crear correctamente `src/main/resources` (a veces hay que renombrarlo).
    
- Si usáis MariaDB, configurad correctamente el driver y la URL JDBC.
    
- El archivo `hibernate.cfg.xml` generado puede no funcionar si está en `src/main/java`. Movedlo a `src/main/resources`.
    

🛠️ Otras herramientas útiles para esta tarea:

- **NetBeans** (más sencillo para esta tarea)
    
- **JPA-Buddy** (IntelliJ)
    
- **Jeddict**
    
- **Dali Tools Plugin** (Eclipse Web Edition)
    

---

## 🔧 Herramientas necesarias

- IDE Java (Eclipse, NetBeans, IntelliJ…)
    
- Hibernate (añadido con Maven)
    
- MySQL o MariaDB como base de datos relacional
    

---

## 📄 Entrega

Debéis entregar un documento PDF llamado `R2-UD3.pdf` con:

- Enlace al repositorio del código (GitHub, GitLab…)
    
- Instrucciones para ejecutar y probar el proyecto
    
- Conclusiones personales de cada miembro del grupo (qué habéis aprendido, dificultades, etc.)
    

---

## 📝 Evaluación

Se valorará:

- Claridad del código y explicaciones.
    
- Pruebas realizadas y documentación.
    
- Facilidad para ejecutar el proyecto con las instrucciones entregadas.
    
- Complejidad y número de consultas implementadas.
    
- Realización de las partes opcionales (DAO, ingeniería inversa...).
    

---

## 🎯 Calificación

|Nota|Requisitos principales|
|---|---|
|**Suficiente**|CRUD funcionando y consultas básicas con JPQL o Criteria|
|**Bien**|Consultas bien implementadas con ambos sistemas|
|**Excelente**|Incluye también DAO/Repository y pruebas de ingeniería inversa|
