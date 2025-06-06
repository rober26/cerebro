Enunciado:[[05 - Insti/AD/UD4_5-NoSQL/R1-UD4-5/Enunciado|Enunciado]]

## EJ1:
Seguir [Tutorial](https://spring.io/guides/gs/accessing-data-mongodb) de Spring Boot.

Instalo MongoDb en mi equipo

- Me descargo un proyecto pre iniciado de[ spring initializr](https://start.spring.io/#!type=maven-project&groupId=com.example&artifactId=accessing-data-mongodb&name=accessing-data-mongodb&description=Demo%20project%20for%20Spring%20Boot&packageName=com.example.accessing-data-mongodb&dependencies=data-mongodb).
![[Pasted image 20250605143215.png]]
- inicio mongodb
![[Pasted image 20250605145508.png]]
![[Pasted image 20250605145508.png]]
- Creo una clase clientes
![[Pasted image 20250605150002.png]]
- Creo el repositorio  para el cliente.
![[Pasted image 20250605150652.png]]
- Creo la clase principal para insertar y consultar datos.
![[Pasted image 20250605150946.png]]
- inicio la aplicación, y recibo la respuesta esperada.
![[Pasted image 20250605151100.png]]

## EJ2:
Elige una de las bases de datos NoSQL mencionadas en clase (como Cassandra, Redis, Neo4j...) y haz un documento **resumen de 2 páginas** con:
- Características principales de esa base de datos.
- Diferencias respecto a las bases de datos SQL tradicionales.
[[Redis]]
## EJ3:
Haz una prueba de acceso a otra base de datos NoSQL distinta de MongoDB desde Java o Spring Boot. Puedes usar:
- **Redis (clave-valor en memoria):**
    - [Tutorial Redis 1](https://spring.io/guides/gs/spring-data-reactive-redis)
    - [Tutorial Redis 2 (Baeldung)](https://www.baeldung.com/spring-data-redis-tutorial)
