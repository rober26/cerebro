**Objetivo**: usar la implementación de referencia de JPA EclipseLink para entender cómo funciona el mapeo ORM. Superar los criterios de evaluación del Resultado de Aprendizaje 3 del módulo. _**“Gestiona la persistencia de los datos identificando herramientas de mapeo objeto relacional (ORM) y desarrollando aplicaciones que las utilizan.”**_

a) Se ha instalado la herramienta ORM.

b) Se ha configurado la herramienta ORM.

c) Se han definido configuraciones de mapeo.

d) Se han aplicado mecanismos de persistencia a los objetos.

e) Se han desarrollado aplicaciones que modifican y recuperan objetos persistentes.

_g) Se han gestionado las transacciones._

  

**Introducción**: te propongo implementar el CRUD sobre una base de datos relacional mysql/mariadb o similar desde una aplicación Java haciendo uso de mapeo ORMcon JPA mediante su implementación de referencia EclipseLink. La parte operativa podéis hacerla con una interfaz de texto o reutilizar una interfaz de los proyectos del tema anterior.

  

**Desarrollo**: en grupos de dos alumnos se trata de implementar las siguientes propuestas:

1. Prueba de concepto: elegid una base de datos del curso pasado o de las propuestas en el curso (tema 2 - [Bases de datos de ejemplos-20241021 Archivo](https://aulavirtual33.educa.madrid.org/ies.goya.madrid/mod/resource/view.php?id=63065) ) y realizar una aplicación que mediante EclipseLink realice un CRUD sobre una de las entidades de dicha base de datos haciendo el correspondiente mapeo a objetos de Java. En este caso dejad que cree las tablas el propio EclipseLink sin especificar @Tabla ni @Column.  
    
2. Prueba completa: explorad las distintas posibilidades de hacer que la aplicación cree las tablas, que solo las modifique ante cambios o que se limite a usar las tablas y datos ya existentes. Cambia mediante @Table y @Column el mapeo para que se corresponda exactamente con los nombres de la base de datos original.
    
3. Ampliad el apartado 1 para que el CRUD incluya más de una entidad relacionadas entre ellas con relaciones OneToMany.
    
4. Añadid alguna relación ManyToMany.
    
5. Investigad y **compara****d** maneras de crear el archivo persistence.xml y la conexión a bbdd automáticamente con alguna herramienta desde un entorno gráfico. En general será mejor usarlas con maven. Algunas posibilidades son:
    
    1. IDE NetBeans (new File → Persistence → PersistenceUnit …)
        
    2. IDE Eclipse en su versión “for web develpment” y uso de DTP (Data Tools Plataform) [https://javabeat.net/eclipselink-jpa-installation-configuration/](https://javabeat.net/eclipselink-jpa-installation-configuration/) o en una versión normal de Eclipse instalarlo con Help → INstall New Software → Database Development.
        
    3. Cualquier otra herramienta con Eclipse u otro IDE.
        

  

**Herramientas:** IDE de Java, librerías de EclipseLink y motor de base de datos relacional.  
  

**Entrega:** un documento del grupo R1-UD3.pdf que incluya enlace al código e información sobre cómo probarlo y un texto de conclusiones por cada miembro del grupo.

  

**Evaluación:** se tendrá en cuenta la claridad de las explicaciones y del código, la documentación de las pruebas realizadas y su análisis, la facilidad de desplegar la aplicación a partir de la documentación entregada y las conclusiones sobre lo aprendido durante su realización.  
  

**Calificación:**

- Suficiente: apartados 1 y 2 correctamente implementados y bien documentados.
    
- Bien: apartado 1, 2 y 3 correctamente implementados y bien documentados.
    
- Excelente: todos los apartados correctamente implementados y bien documentados.