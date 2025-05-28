Se nos pide crear una aplicación [multiproceso](https://aulavirtual33.educa.madrid.org/ies.goya.madrid/mod/assign/view.php?id=60714 "Multiproceso") que mediante la consola simule el funcionamiento de una tienda. En concreto las funcionalidades que debemos crear son las siguientes:

- Almacén de todos los productos. Sera gestionada por un proceso teniendo un archivo o base de datos con el que se podrán hacer las siguientes acciones: (2 puntos)
    
    - Se debe poder ordenar por precio, tanto ascendente como descendente.
    
    - Se debe ordenar por tipo.
    
    - Se debe poner por fecha de inserción, este será el orden por defecto.
    
    - Se debe poner por cantidad de unidades disponibles.
    - Recuperar un producto por su UUID.
    - Reducir sus unidades en Stock.
- Carrito. Sera gestionada por un proceso teniendo un archivo o base de datos con el que se podrán hacer las siguientes acciones: (2 puntos)
    - Insertar nuevo producto.
    - Eliminar producto.
    - añadir unidad de un producto existente.
    - Calcular total.
    - Calcular precio total de cada producto en el carrito.

La construcción del producto debe incluir las siguientes propiedades:(1 punto)

- ID, numérico autoincremental.
- [UUID](https://www.baeldung.com/java-uuid).
- Nombre del producto
- Tipo del producto
- Unidades de Stock
-  Precio
- fecha de inserción.

La aplicación consistirá en un menú que nos permitirá mediante ordenes sencillas llevar a cabo las siguientes situaciones: Sera el proceso principal que se comunicara con el resto para poder realizar las acciones, siendo esta la única que se comunicará con la consola.(2 puntos)

- Mostrar la lista de todos los productos disponibles ordenándolos por el orden indicado  por el usuario.
- Añadir un producto a nuestro carrito.
- Eliminar un producto de nuestro carrito.
- Calcular el total que llevamos mostrando detalladamente el calculo de precio por producto con sus unidades.
- Mostrar el carrito con los datos del producto y las unidades pedidas.

Construcción adecuada siguiendo la programación orientada a objetos, 1 punto.  
Uso eficiente de las estructuras de almacenamiento de datos, 1 punto.  
Construcción de procesos independientes que colaboran, 1 punto.  

**ENTREGA**:

- Código usando Programación Orientada a Objetos mediante técnicas de abstracción, encapsulamiento.
- Todos los programas deben estar libres de errores tanto en la entrada como en la salida de datos.
- Se debe adjuntar capturas en una carpeta images de la ejecución y simulación de los ejercicios.
- Todos ficheros que entregues deben tener tu nombre, apellidos y correo electrónico. Si hay código sin comentar, sin tu nombre, capturas o explicación el ejercicio puede considerarse inválido.
- Ante copia parcial, total o sospecha de esta se invalidará el ejercicio hasta que se demuestre la autoría.