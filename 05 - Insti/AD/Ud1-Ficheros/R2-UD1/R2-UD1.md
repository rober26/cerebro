### **Apartado 1: Trabajar con XStream (XML)**

1. **Serialización y deserialización de objetos**:
    
    - Crea una clase `Libro` con atributos y métodos getter/setter.
    
    - Usa **XStream** para convertir un objeto `Libro` en XML y luego vuelve a convertirlo en objeto.
    
    - Guarda el XML en un archivo y lee el archivo para recuperar el objeto.
    
2. **Usar aliases**:
    
    - Repite lo anterior pero usa **aliases** para las clases y atributos. Esto hará que el XML generado tenga nombres más legibles y fáciles de personalizar.
    
3. **Reflexión**:
    
    - Compara la comodidad de usar XStream con otros métodos que se mencionan en el tutorial.
    
4. **Ejercicios adicionales**:
    
    - Realiza ejercicios de personalización del XML, como usar atributos en las etiquetas o manejar colecciones de objetos.
    

---

### **Apartado 2: Conversión entre XML y JSON**

1. **Convertir a JSON**:
    
    - Toma el código **PruebaXStreamJSON.java** y modifica la clase utilizada para convertirla a JSON.
    
    - Guarda el JSON en un archivo y luego lee ese archivo para recuperar el objeto.
    
2. **Pruebas con diferentes librerías**:
    
    - Usa **XStream**, **GSON**, o **Sterarly** para convertir entre XML y JSON y compara cuál es más fácil de usar.
    

---

### **Apartado 3: Manipulación de XML con DOM**

1. **Leer y escribir XML con DOM**:
    
    - Usa **DOM** para leer los XML generados en el Apartado 1.
    
    - Usa **DOM** también para crear nuevos XML que puedan ser leídos correctamente.
    
2. **Reflexión sobre DOM**:
    
    - Compara las ventajas y desventajas de usar **DOM** para manejar XML en comparación con **XStream**.
    

---

### **Apartado 4: Trabajar con grandes volúmenes de datos**

1. **Generar datos con Mockaroo**:
    
    - Usa **Mockaroo** para generar grandes conjuntos de datos en formato **XML** o **JSON**.
    
    - Realiza conversiones entre XML y JSON con esos grandes conjuntos de datos y comparte los archivos con tus compañeros.
    
2. **Uso de arrays y objetos anidados**:
    
    - Asegúrate de que los datos generados contengan **arrays** y **objetos anidados** (con `{}` y `[]`).
    
    - Realiza las pruebas de conversión entre XML y JSON con estos datos.