## 🧩 **Objetivo del Proyecto**

El objetivo de este trabajo es **aprender a usar JPA (Java Persistence API)** con su implementación de referencia **EclipseLink** para desarrollar aplicaciones Java que usen bases de datos relacionales. Esto te permitirá **entender cómo funciona el mapeo objeto-relacional (ORM)** y cómo se realiza la **persistencia de datos** de forma profesional.

### ✅ Resultado de Aprendizaje 3

Para superarlo, deberás demostrar que sabes:

- Instalar y configurar una herramienta ORM (EclipseLink).
- Definir correctamente el mapeo de entidades Java a tablas de base de datos.
- Aplicar persistencia de objetos (guardar, actualizar, eliminar, consultar).
- Gestionar transacciones correctamente.
- Desarrollar una aplicación Java que use estos mecanismos.
---
## 📌 **Fases del Proyecto**

### 1. **Prueba de concepto**

- Elegid una base de datos ya usada en clase (tema 2).
- Haced un CRUD sobre una de sus entidades con EclipseLink.
- No hace falta especificar `@Table` ni `@Column`: dejad que EclipseLink cree las tablas automáticamente.

---

### 2. **Prueba completa**

- Experimentad con las opciones de EclipseLink para:
    - Crear las tablas automáticamente.
    - Solo modificarlas si hay cambios.
    - No modificar nada y usar la base de datos tal cual.
- Ahora sí, usad las anotaciones `@Table` y `@Column` para que los nombres coincidan con los reales en la base de datos.

---

### 3. **Relaciones OneToMany**

- Ampliad el CRUD para trabajar con **más de una entidad**.
- Relacionadlas con **OneToMany** (por ejemplo: un cliente tiene muchos pedidos).

---

### 4. **Relaciones ManyToMany**

- Añadid una relación **ManyToMany** (por ejemplo: alumnos y asignaturas, donde cada alumno puede estar en varias asignaturas y viceversa).

---

### 5. **Uso de herramientas gráficas**

- Investigad cómo crear automáticamente el archivo `persistence.xml` y la conexión a la base de datos desde el IDE (NetBeans, Eclipse, etc.).
- Recomendado: usad **Maven**.

Opciones:

- **NetBeans**: `Archivo → Nuevo → Unidad de persistencia`.
- **Eclipse**: instalar DTP (Database Tools Platform) o usar la versión para Web Development.
- **Otras herramientas** compatibles.

---

## 💻 Herramientas necesarias

- Un IDE para Java (NetBeans, Eclipse…)
- EclipseLink (como librería JPA)
- Un motor de base de datos como MySQL o MariaDB

---

## 📄 **Entrega**

Debéis entregar un documento **PDF** con el nombre del grupo:  
`R1-UD3.pdf`, que incluya:

- Enlace al código fuente (GitHub, GitLab, etc.).
- Explicación de cómo ejecutar/probar la aplicación.
- **Conclusiones personales** de cada miembro del grupo (qué habéis aprendido, qué dificultades tuvisteis, etc.).

---

## 📝 **Criterios de Evaluación**

|Nota|Requisitos|
|---|---|
|**Suficiente**|Apartados 1 y 2 correctamente hechos y bien explicados|
|**Bien**|Apartados 1, 2 y 3 implementados y documentados|
|**Excelente**|Todos los apartados realizados, bien explicados y con buena documentación|
