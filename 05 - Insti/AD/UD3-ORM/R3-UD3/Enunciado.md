**Objetivo**: Conocer las características y uso de las bases de datos embebidas y el concepto de transacción Superar los criterios de evaluación del Resultado de Aprendizaje 2 del módulo. _**“2. Desarrolla aplicaciones que gestionan información almacenada en bases de datos relacionales identificando y utilizando mecanismos de conexión.”**_

j) Se han gestionado las transacciones.

k) Se han ejecutado procedimientos almacenados en la base de datos.

**Introducción**: os propongo realizar pruebas sobre el código adjunto cambiando ciertos parámetros de ejecución para analizar sus resultados. Por otro lado realizar una prueba de concepto de llamada a procedimiento almacenado.  

**Desarrollo**: en grupos de dos alumnos/as se trata de realizar estos pasos

1. **Transacciones**: análisis de ejecución del simulador de banco adjunto contra mysql cambiando las constantes RETIRA_EN_DOS_PASOS y TRANSACCIÓN de la clase HiloTransferencias en cada ejecución para tomar las cuatro combinaciones posibles. Para el caso de las dos variables a true prueba también con REORDENA_QUERIES tanto a true como a false. Observad en qué condiciones se producen las siguientes situaciones y tratad de explicar el por qué:
    1. Descuadres temporales en el balance.
    2. Descubiertos en las cuentas.
    3. Interbloqueos en la base de datos.
        Nota: si no se produjeran dichos problemas en ningún caso, prueba aumentando el número de hilos. Si solo se producen con algunas combinaciones, anotad las combinaciones que no generan ninguna de las situaciones.

2. **Procedimiento almacenado**: sustituye en el código adjunto en el método Transfiere de la clase Banco por una sola llamada a un procedimiento almacenado en la base de datos que realice la misma funcionalidad. Analiza los resultados respecto a los del apartado anterior.

3. **Otras bases de datos**: (una de las siguientes opciones)
    
    1. Investiga sobre la declaración de procedimientos almacenados en alguna otra base de datos y realiza la prueba de concepto.
    2. Haz el apartado 1 con bases de datos embebidas.

4. **Explicación** **del código**: realiza una documentación del código adjunto a la luz de la información obtenida en el apartado 1. Incluye comentarios pertinentes en el código.

5. **Contadores**: ejecuta el código de los contadores del reto anterior contra Mysql y analiza las diferencias en sus comportamientos.

**Herramientas:** IDE de Java y gestores de bases de datos relacionales.

**Entrega:** un documento del grupo R3-UD2.pdf con la documentación y el análisis de las pruebas realizadas.  

**Evaluación:** se tendrá en cuenta la claridad de las explicaciones, la documentación de las pruebas realizadas y el análisis de sus resultados.

**Calificación:**
- Suficiente: apartados 1 y 2 bien documentados.
- Bien: lo anterior más el apartado 3 o 4 bien documentado.
- Excelente: cuatro apartados bien documentados.

**Nota**: los casos posibles a testear serían:

| DOS_PASOS | TRANSACCIÓN | REORDENA | RESULTADO |
| --------- | ----------- | -------- | --------- |
| false     | false       | *        |           |
| false     | true        | *        |           |
| true      | false       | *        |           |
| true      | true        | false    |           |
| true      | true        | true     |           |
