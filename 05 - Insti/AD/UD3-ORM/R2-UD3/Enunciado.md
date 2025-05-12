**Objetivo**: usar la implementación de JPA Hibernate para realizar mapeos objeto-relacional y consultas sobre los datos. Superar los criterios de evaluación del Resultado de Aprendizaje 3 del módulo. _**“Gestiona la persistencia de los datos identificando herramientas de mapeo objeto relacional (ORM) y desarrollando aplicaciones que las utilizan.”**_

a) Se ha instalado la herramienta ORM.

b) Se ha configurado la herramienta ORM.

c) Se han definido configuraciones de mapeo.

d) Se han aplicado mecanismos de persistencia a los objetos.

e) Se han desarrollado aplicaciones que modifican y recuperan objetos persistentes.

f) **Se han desarrollado aplicaciones que realizan consultas usando el lenguaje SQL.**

_g) Se han gestionado las transacciones._

  
  

**Introducción**: te propongo implementar el CRUD sobre una base de datos relacional mysql/mariadb o similar desde una aplicación Java haciendo uso de mapeo ORM con JPA mediante la implementación más popular que es Hibernate. La parte operativa podéis hacerla con una interfaz de texto o reutilizar una interfaz de los proyectos del tema anterior.

  
  

**Desarrollo**: en grupos de dos alumnos se trata de implementar las siguientes propuestas:

1. Sustituye en el proyecto del reto anterior las dependencias de EclipseLink por las de Hibernate. Documenta si funciona y en caso concreto si hay cambios con los que consigas hacerlo funcionar. Deberás cambiar en persistence.xml el valor de provider a org.hibernate.jpa.HibernatePersistenceProvider (ojo con int, float, etc. te obligará a tipos wrapped: Integer, Float …)
    
2. Como alternativa al punto anterior podéis empezar el proyecto desde cero para hacer igualmente un CRUD sobre la misma base datos del proyecto anterior.
    
3. Os voy a pedir confecciona consultas diversas y además usando dos sistemas distintos: JPQL y API Criteria. Para ambos casos más abajo tenéis referencias. Se os piden realizar consultas para al menos los siguientes casos:
    
    1. Listado de todas las entidades de una tabla seleccionando solo algunos campos.
        
    2. Listado filtrado por algún criterio (WHERE)
        
    3. Listados ordenados por algún criterio.
        
    4. Búsqueda de elementos por criterios exactos y aproximados.
        
    5. Listado de elementos que cumplen que un determinado campo numérico esté en un rango determinado.
        
    6. Obtención de sumas, medias, número de registros que cumplen un criterio
        
    7. Algún join.
        
    8. Podéis buscar inspiración en los ejercicios del aula virtual:
        
4. Opcional pendiente de más explicaciones en clase pero podéis ir investigando: implementar un patrón DAO o Repository. Prueba de concepto de los apartados anteriores mediante un Repository.
    
5. Opcional, algo laborioso: haced la prueba de generar automáticamente el código de las clases por ingeniería inversa a partir de una base de datos. Una forma es seguir el tutorial de José María “Configuración de Hibernate en Eclipse 2023.pdf” para la prueba de concepto de que a partir de una base de datos Hibernate te infiera y genere las entidades Java. Verás que utiliza los xml para los mappings en vez de anotaciones. Ojo con algunos pasos:
    
    1. La versión actual de JBoss que te localizará es la 4.29.1, deja marcadas las opciones por defecto, acepta la licencia, Trust para la descarga (luego toca hacer un Trust a un sitio unknown :-) Pide reiniciar Eclipse y tarda mucho en hacerlo, ten paciencia, con un ps puedes ver que aunque se haya cerrado sigue en ejecución.
        
    2. El proyecto con arquetipo org.apache.maven.archetypes → maven-archetype-quickstart no crea un src/main/resources visibles y tampoco deja crearlo, a mi me ha funcionado crearlo sin terminar en s y luego refactor-rename. OJO, la creación de proyecto Maven se queda al 33% esperando a responder una pregunta Y por consola !!!
        
    3. Puedes usar el driver de MariaDb pero tocará actualizarlo en los xml, si usas el de Maven ([https://mvnrepository.com/artifact/org.mariadb.jdbc/mariadb-java-client/3.5.1](https://mvnrepository.com/artifact/org.mariadb.jdbc/mariadb-java-client/3.5.1)) luego el driver_class es org.mariadb.jdbc.Driver y la conexión jdbc:mariadb://localhost/… , el hibernate dialect sigue siendo el de MySql por defecto.
        
    4. Añade la dependencia Hibernate del respositorio Maven (la tiene más abajo) [https://mvnrepository.com/artifact/org.hibernate.orm/hibernate-core/](https://mvnrepository.com/artifact/org.hibernate.orm/hibernate-core/6.6.5.Final)[6.6.5.Final](https://mvnrepository.com/artifact/org.hibernate.orm/hibernate-core/6.6.5.Final)
        
    5. Al generar código, asegúrate que se ven todas las tablas, no vale con el Import solo de la base de datos / *
        
    6. El hibernate.cfg.xml que genera lo deja en src/main/java y no lo reconoce, a mi me ha funcionado moverlo a src/main/resources machacando el que había creado con el primer asistente y que no tenía los mappings de clases. O seguramente añadiendo los mappings a ese también irá bien.
        
    7. ¿Podemos crear código JPA con EntityManager en vez de Session, etc.? sí, pero hay que migrar el proyecto. Eclipse J2EE Edition tiene utilidades para hacerlo, si no siempre podemos crear a mano el persistence.xml , en realidad basta con poner los elementos class con referencia al archivo .hbm.xml y su paquete, ej: <class>database.Alumno.hbm.xml</class>
        
    
    6.- (Alternativa al punto anterior) Buscar alternativas más sencillas al punto anterior, entre ellas:
    
    8. 1. Netbeans parece que lo hace más fácil.
            
        2. JPA-Buddy para IntelliJ ¿y para otros IDES? [https://jpa-buddy.com/documentation/reverse-engineering/](https://jpa-buddy.com/documentation/reverse-engineering/)
            
        3. ¿ [https://jeddict.github.io/](https://jeddict.github.io/) ?
            
        4. [https://www.baeldung.com/jpa-tools-overview](https://www.baeldung.com/jpa-tools-overview) Dali Tools Plugin
            
            ¿lo mismo viene integrado en la versión Web Development de Eclipse? https://eclipse.dev/webtools/dali/docs/3.2/user_guide/tasks006.htm ,  
            
              
            
        5. ...  
            

**Herramientas:** IDE de Java, librerías de Hibernate (vía Maven) y motor de base de datos relacional.  
  

**Entrega:** un documento del grupo R2-UD3.pdf que incluya enlace al código e información sobre cómo probarlo y un texto de conclusiones por cada miembro del grupo.

**Evaluación:** se tendrá en cuenta la claridad de las explicaciones y del código, la documentación de las pruebas realizadas y su análisis, la facilidad de desplegar la aplicación a partir de la documentación entregada y las conclusiones sobre lo aprendido durante su realización.

**Calificación:**

- en función del número y complejidad de las consultas implementadas y la realización de las partes opcionales.