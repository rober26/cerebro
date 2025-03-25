- **1. Prueba de la clase [[Properties]]:**
    
    - **Paso 1**: Crea un objeto `Properties` y agrega algunos pares de clave/valor (como si fueran datos de configuración).
    
    - **Paso 2**: Guarda estos datos en un archivo de texto usando el método `store` y en formato XML con `storeToXML`.
    
    - **Paso 3**: Verifica que los datos se guardaron correctamente.
    
    - **Paso 4**: Carga los datos guardados desde los archivos usando los métodos `load` y `loadFromXML`.
- **2. Trabajo con archivos CSV**:
    
    - **Paso 1**: Crea una colección de objetos (por ejemplo, una lista de libros, coches, etc.).
    - **Paso 2**: Guarda esta colección en un archivo CSV (archivo de texto con comas) utilizando `PrintWriter`.
    - **Paso 3**: Lee el archivo CSV con `BufferedReader` y asegúrate de que los datos se cargan correctamente.
    - **Pruebas adicionales**: Asegúrate de que los caracteres especiales (como acentos y eñes) se guardan correctamente, y prueba a guardar el archivo con diferentes codificaciones. También verifica qué pasa si usas un procesador de texto como Word para crear el archivo CSV.
- **3. Serialización**:
    
    - **Paso 1**: Guarda objetos en un archivo binario usando `ObjectOutputStream`.
    - **Paso 2**: Lee esos objetos desde el archivo usando `ObjectInputStream`.
- **4. Prueba de `RandomAccessFile`**:
    
    - **Paso 1**: Crea un array de 20 números enteros.
    - **Paso 2**: Si existe un archivo con esos números, léelos y ponlos en el array. Si no existe, crea el archivo y pon 20 ceros.
    - **Paso 3**: Abre el archivo con `RandomAccessFile` y permite que el usuario modifique cualquier número en el archivo, guardando solo ese cambio sin tocar el resto del archivo.

**Examen**
Leer `CSV` separado por ###, mackaroo
Volver a gravarlo pero separado por ,

Leer Property 
Grabar Property

