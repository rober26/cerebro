Te propongo aprender sobre las API RESTful creando y probando tu propia API con los tres métodos que describo a continuación. Antes de nada elije una temática de tu interés. Para empezar puedes hacerlo con un solo tipo de entidad y pocos atributos.

**Apartado 1.- API REST con Json-server:**

Basándote en este tutorial [https://desarrolloweb.com/articulos/crear-api-rest-json-server.html](https://desarrolloweb.com/articulos/crear-api-rest-json-server.html) (si te diera problema de sintaxis por versión de Node.JS en el equipo de clase díselo al profesor), recomiendo la opción 3 de [https://www.digitalocean.com/community/tutorials/how-to-install-node-js-on-ubuntu-22-04](https://www.digitalocean.com/community/tutorials/how-to-install-node-js-on-ubuntu-22-04))

Prueba la API REST generada bien sea con Postman, httpie, POST, curl o cualquiera de las alternativas de las referencias. El objetivo es describir el código de retorno y los datos devueltos para cada una de las siguientes peticiones:

- GET de la lista de entidades.
- GET de una entidad existente.
- GET de una entidad que no exista (id inválido, por ejemplo)
- POST de una entidad nueva.
- POST de una entidad ya existente.
- DEL de una entidad existente.
- DEL de una entidad que no exista.
- PUT de una entidad existente.
- PUT de una entidad que no exista.
- PATCH de una entidad existente.
- PATCH de una entidad existente pero provocando incoherencia entre el id del path y el pasado en json.

Tras cada petición observa el listado de todas las entidades para asegurarte de que los cambios son coherentes.

Si decides hacer las pruebas con el comando POST (paquete lwp-request), recuerda:

POST -c "application/json" http://localhost:8080/peliculas

POST -m PUT -c "application/json" http://localhost:8080/peliculas/10

POST -m DELETE http://localhost:8080/pelicutlas/2

-U muestra cabeceras de envío

-E muestra cabeceras de repuesta

**Nota**: en los siguientes apartados, si te atrancases, vuelve al ejemplo del tutorial y continua una vez que te funcione el tutorial tal cual, sin personalizarlo (en inglés, mismas entidades, …)

  

**Apartado 2.- API con REST Repository.**

Sigue este otro tutorial [https://spring.io/guides/gs/accessing-data-rest/](https://spring.io/guides/gs/accessing-data-rest/) para implementar el mismo API del apartado anterior pero esta vez con SpringBoot. Tendrás que crear una clase para la entidad (ej: Pelicula.java) un interfaz repositorio y teniendo activas las dependencias JPA DATA y H2 automáticamente creará una base de datos en memoria. Puedes cargar la base de datos inicialmente creando un archivo import.sql en la carpeta resources con órdenes INSERT de la entidad (todo minúsculas y si en Java hay cambios a mayúscula en SQL se traducen a _₎ Ejemplo para entidad Persona con atributos firstName y lastName:

INSERT INTO person(first_name,last_name,id) VALUES('Javier','Puche',2);

INSERT INTO person(first_name,last_name,id) VALUES('Agustín','Aguilera',1);

podemos quitar los id y que los autogenere la base de datos si marcamos en Persona id como:

@GeneratedValue(strategy = GenerationType.**_IDENTITY_**)

Realiza las mismas pruebas que en el apartado anterior y las de búsqueda y filtrado del tutorial.

En los logs iniciales de arranque de SpringBoot puedes ver el acceso a la consola H2 para inspeccionar la base de datos en memoria. En el próximo tema veremos cómo activar que muestre todas las queries que realiza la aplicación para depuración.

Compara las pruebas del apartado 1 con las de este apartado ¿devuelven los mismos códigos en los mismos casos, el mismo cuerpo de mensaje?  Elabora una **tabla** comparativa de las respuestas (código y contenido) entre el apartado anterior y este. Ejemplo: (en cada columna indica código de respuestas, cuerpo de respuesta e incidencias si las hay)

|   |   |   |
|---|---|---|
||Json-server|RestRepository|
|GET OK 1 objeto|||
|GET OK todos los objetos|||
|GET de id no existente|||
|POST OK sin especificar id|||
|POST con id en path|||
|POST con id en json|||
|POST de objeto existente|||
|DEL OK|||
|DEL entidad no existente|||
|PUT OK|||
|PUT id no exista|||
|PUT con id distinto en json|||
|PATCH OK|||
|PATCH con id distinto en json|||

  

**Apartado 3. API REST con @RestController (web) pero sin RestRepository.**

Vamos a reimplementar la misma API REST del apartado anterior pero sin la dependencia REST Repository. Tendremos que crear nosotros los puntos de acceso con un @RestController (dependencia Spring Web) Empieza con los conceptos de este tutorial [https://spring.io/guides/tutorials/rest](https://spring.io/guides/tutorials/rest) pero los métodos del controlador tendrán que devolver objetos de tipo ResponseEntity para poder encapsular tanto el código HTTP de respuestas como el contenido JSON de la misma, algo que no pasaría si solo devolvemos un objeto (el JSON del mismo)

[https://www.arquitecturajava.com/responseentity-spring-y-rest/](https://www.arquitecturajava.com/responseentity-spring-y-rest/)

[https://medium.com/@sebastian.alejandro.hv/java-spring-usando-responseentity-ef327164d514](https://medium.com/@sebastian.alejandro.hv/java-spring-usando-responseentity-ef327164d514)

[https://www.baeldung.com/spring-response-entity](https://www.baeldung.com/spring-response-entity)

[https://jakarta.ee/learn/starter-guides/how-to-store-and-retrieve-data-using-jakarta-persistence/](https://jakarta.ee/learn/starter-guides/how-to-store-and-retrieve-data-using-jakarta-persistence/)

Se trata de realizar nosotros el código de capturar las peticiones y elaborar las respuestas para tener un mayor control en caso de que tuviéramos que hacer más operaciones y no solamente el simple mantenimiento del repositorio.

Vamos a aprovechar el tener un mayor control de nuestro API para verificar:

- Que no dejamos insertar elementos que ya existan (elegid los campos que marquen la identidad, convendría crear equals y hashCode de nuestra entidad) Aunque en el caso de POST puede que sí haya que permitirlo: https://restfulapi.net/rest-put-vs-post/
    
- Que no dejamos hacer PUT o PATCH sobre elementos que no existan. Ups, o sí: https://stackoverflow.com/questions/56240547/should-http-put-create-a-resource-if-it-does-not-exist
    

En un primer momento puedes obviar los códigos de respuestas, centrarte en que cada método haga su cometido y reciba o devuelva los objetos pertinentes que Spring se encargará de convertir a JSON:

- Para devolver JSON en un @RestController basta con que el método asociado al mapeo (GetMaping, PostMapping, etc.) devuelva un objeto. Spring lo transforma en JSON pues va implicita la anotación @ResponseBody a json en el @RestController.
    
- Para recibir JSON basta con la anotación @RequestBody y el parámetro de tipo objeto, lo convertirá de json a ese objeto. Ej: (@RequestBody Personaje personaje)
    

  

En un segundo momento mediante ResponseEntity<> puedes añadir el código de respuesta correcto en cada caso:

- Los métodos de los mapeos deben devolver ResponseEntity<T> donde T será la entidad de tu API Rest o ResponseEntity<?>
    
- Hay respuestas sin cuerpo de mensaje, por ejemplo ResponseEntity.badRequest().build() , ResponseEntity.notFound().build() ...
    
    o también ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR) ... o  return new  
    
- Las respuestas con código y cuerpo se pueden hacer con body() en vez de build. Ejemp,.os: ResponseEntity.accepted().body( …) ResponseEntity.created().body(…) , (en body va el objeto y lo pasa a Json)
    
- También especificando cuerpo y código, ej: ResponseEntity<Empleado>(empleado,HttpStatus.CREATED);
    

Un ejemplo:

@PostMapping

public ResponseEntity<Personaje> save(@RequestBody Personaje personaje) { ...

No dejes de dividir las clases en los paquetes model (o entity) repositories, controllers y service de tal manera que los métodos del controller invoquen a los de service y sea ahí donde se instancien los repositorios.

Si te ves perdido/a te recomiendo, además de preguntar en clase, hacer antes los tutoriales de introducción:

[https://spring.io/guides/gs/accessing-data-mysql](https://spring.io/guides/gs/accessing-data-mysql)

[https://spring.io/guides/gs/rest-service/](https://spring.io/guides/gs/rest-service/)

[https://spring.io/guides/gs/accessing-data-rest/](https://spring.io/guides/gs/accessing-data-rest/)

[https://restfulapi.net/http-methods/](https://restfulapi.net/http-methods/)

[https://www.restapitutorial.com/lessons/httpmethods.html](https://www.restapitutorial.com/lessons/httpmethods.html)

[https://spring.io/guides/gs/rest-hateoas](https://spring.io/guides/gs/rest-hateoas/)

[https://spring.io/guides/tutorials/rest/](https://spring.io/guides/tutorials/rest/)

  

**Apartado 4.-** Para el excelente debes investigar las buenas prácticas en el diseño de API RESTful y el concepto de HATEOAS. Algunas referencias (más las del aula virtual)

[https://www.oreilly.com/content/how-a-restful-api-server-reacts-to-requests/](https://www.oreilly.com/content/how-a-restful-api-server-reacts-to-requests/)

[https://stackoverflow.blog/2020/03/02/best-practices-for-rest-api-design/](https://stackoverflow.blog/2020/03/02/best-practices-for-rest-api-design/)

¿suministrar un id en el POST?  [https://stackoverflow.com/questions/33452765/what-to-do-when-rest-post-provides-an-id](https://stackoverflow.com/questions/33452765/what-to-do-when-rest-post-provides-an-id)

no, hacerlo co PUT con id:

[https://octo-woapi.github.io/cookbook/create-with-id-already-known.html](https://octo-woapi.github.io/cookbook/create-with-id-already-known.html)

  

**ENTREGA:** un documento D1-UD6.pdf con las capturas demostrativas del paso a paso del proceso y conclusiones sobre lo aprendido en la práctica. Enlace al código fuente. Demostración en clase del funcionamiento.

  

**Calificación**:

- Suficiente: apartados 1, 2 y 3 documentando solo la tabla comparativa de respuestas básicas.
    
- Bien: apartados lo anterior pero el apartado 3 sobre mysql.
    
- Excelente: lo anterior bien documentado y en el apartado 4 o dos entidades con relación 1aN.
    

