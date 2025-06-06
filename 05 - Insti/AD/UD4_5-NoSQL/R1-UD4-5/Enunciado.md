R1-UD4_5
### 💻 **Tarea sobre Bases de Datos NoSQL (Tema 4 y 5)**

Debéis hacer **individualmente o en parejas** los siguientes apartados. Sirven para trabajar con MongoDB y otras bases de datos NoSQL, y entender sus diferencias con las bases de datos SQL.

---

### **Apartado 1: Trabajar con MongoDB y Spring Boot**

**Requisitos previos:** Asegúrate con el profesor de que tienes MongoDB instalado y funcionando correctamente en tu ordenador.

Luego elige **uno** de estos dos tutoriales de Spring Boot (si trabajas en pareja, podéis hacer los dos si queréis):

- 🔹 **Tutorial 1:**  
    [Acceder a MongoDB con Spring Boot](https://spring.io/guides/gs/accessing-data-mongodb)  
    Inserta dos documentos al arrancar la aplicación y haz algunas consultas. Solo es una prueba de concepto.
    
- 🔹 **Tutorial 2:**  
    [API REST con MongoDB y Spring Boot](https://spring.io/guides/gs/accessing-mongodb-data-rest)  
    Aquí se usa `RestRepository` para exponer automáticamente un API REST sobre MongoDB.
    

📌 **Importante:** Cambia los nombres de las clases y atributos del inglés al castellano (por ejemplo, en lugar de `Customer`, usa `Cliente`).

Además, con ayuda del PDF **"Curso_MongoDB.pdf"** (de OpenWebinars), crea un objeto desde la consola de MongoDB (`mongosh`) y comprueba que lo puedes recuperar desde tu programa Java.

---
- [x] 
### 📄 **Apartado 2: Comparar bases de datos NoSQL**

Elige una de las bases de datos NoSQL mencionadas en clase (como Cassandra, Redis, Neo4j...) y haz un documento **resumen de 2 páginas** con:

- Características principales de esa base de datos.
- Diferencias respecto a las bases de datos SQL tradicionales.

📅 **Presentación oral:** El trabajo se presenta en clase el **25 de febrero de 2025**. Duración: **10 minutos por grupo**.
- [x] 
---

### 🧪 **Apartado 3: Prueba de otra base de datos NoSQL desde Java**

Haz una prueba de acceso a otra base de datos NoSQL distinta de MongoDB desde Java o Spring Boot. Puedes usar:

- **Neo4J (grafos):**  
    [Tutorial Neo4J](https://spring.io/guides/gs/accessing-data-neo4j)
- **Cassandra (clave-valor distribuido):**  
    [Tutorial Cassandra](https://spring.io/guides/gs/accessing-data-cassandra)
- **Redis (clave-valor en memoria):**
    - [Tutorial Redis 1](https://spring.io/guides/gs/spring-data-reactive-redis)
    - [Tutorial Redis 2 (Baeldung)](https://www.baeldung.com/spring-data-redis-tutorial)

💡 Puedes usar contenedores Docker para instalar Cassandra o Redis fácilmente (no necesitas instalarlo en tu máquina directamente).
- [ ] 
---

### 🎯 **Criterios de evaluación**

- **Suficiente:** has hecho el apartado 1 **o** el 2.
- **Bien:** has hecho **los apartados 1 y 2**.
- **Excelente:** has hecho **los tres apartados**, y has documentado bien el tercero (prueba de otra base de datos).