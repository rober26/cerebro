**Objetivo**: Conocer las características y uso de las bases de datos embebidas y el concepto de transacción Superar los criterios de evaluación del Resultado de Aprendizaje 2 del módulo. _**“2. Desarrolla aplicaciones que gestionan información almacenada en bases de datos relacionales identificando y utilizando mecanismos de conexión.”**_

b) Se han utilizado gestores de bases de datos embebidos e independientes.

j) Se han gestionado las transacciones.

  

**Introducción**: os propongo realizar pruebas cambiando en aplicaciones ya existentes el acceso a una base de datos independiente por una base de datos embebidas. Por otro lado realizar una prueba de concepto de transacciones.  
  

**Desarrollo**: en grupos de dos alumnos/as se trata de implementar algunas de las siguientes propuestas:

1. **Bases de datos embebidas**: bien sea en alguna aplicación del reto anterior, o en los pequeñas pruebas de concepto de los Contadores adjuntos, sustituir el acceso a mysql por una de las bases de datos entre SQLite, Apache Derby, H2 o HSQLDB en modo de fichero local. Hacerlo dos veces, cada una con una base de datos distintas.
    
2. **Transacciones**: ejecuta las pruebas de concepto de los Contadores adjuntos, por cada uno ejecutálo varias veces de manera simultánea (la forma más simple es dar al play varias veces seguidas) y analiza su comportamiento. Compara el código de al menos uno que cuente bien con uno que cuente mal.
    
3. **Prueba de concepto de transacciones**: sobre una tabla con 10 nombres de clientes y saldo bancario, haz un pequeño programa que ejecute 1000 transferencias de saldo aletorios entre cuentas siendo cada uno restar de una cantidad de una cuenta para sumarlo en otra. Monitoriza el balance total (la suma de todas las contidades) al menos al terminar y cada 100 transferencias. Ejecuta varias instancias del programa simultáneamente, inicialmente sin transacciones observando los saldos de cada cuenta y el total ¿se genera algún problema? ¿se puede solicionar mediante transacciones? Os dejo adjunto un esqueleto sin bbdd por si os sirve para completarlo.  
    
4. **Ampliación**: hacer una comparativa de las características y funcionalidades de al menos dos de las bases de datos embebidas, contando los modos de conexión que soportan (memoria, fichero, puerto de red …) el soporte de concurrencia (puedes probar con los contadores ejecutando varios a la vez en los distintos modos) ...
    
5. **Ampliación**: exportar cualquier de vuestros proyectos del apartado 1 en un jar y demostrar que con ese jar y el archivo de base de datos es suficiente para copiarlo a otra máquina con un JRE y ejecutarlo (java jar vuestroarchivo.jar con la base de datos en esa carpeta) Haz que la configuración de ruta del fichero la tome de un archivo de configuración .ini (PropertiesFile)  
    

**Herramientas:** IDE de Java y bases de datos SQLite, Apache Derby, H2 o HSQLDB

**Entrega:** un documento del grupo R2-UD2.pdf que incluya enlace al código e información sobre cómo probarlo y un texto de conclusiones por cada miembro del grupo.  

**Evaluación:** se tendrá en cuenta la claridad de las explicaciones y del código, la documentación de las pruebas realizadas y su análisis, la facilidad de desplegar la aplicación a partir de la documentación entregada y las conclusiones sobre lo aprendido durante su realización.

**Calificación:**

- Suficiente: apartados 1 y 2 bien documentados.
    
- Bien: lo anterior más el apartado 3 bien documentado.
    
- Excelente: lo anterior y el apartado 4 incluyendo una presentación en clase o el apartado 4 sin presentación y el 5.