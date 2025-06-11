La clase `RandomAccessFile` de Java permite leer y escribir archivos de manera **aleatoria**, es decir, sin necesidad de recorrer el archivo secuencialmente. Esto es útil cuando necesitas modificar partes específicas de un archivo sin reescribirlo completamente.

**Ubicación en Java:** `java.io.RandomAccessFile`

---

## **1. Abrir un Archivo con RandomAccessFile**

El constructor de `RandomAccessFile` requiere:

`RandomAccessFile archivo = new RandomAccessFile("archivo.txt", "modo");`

**Modos de Apertura:**

- `"r"` → Solo lectura
- `"rw"` → Lectura y escritura
- `"rws"` → Guarda cambios en disco inmediatamente
- `"rwd"` → Guarda cambios en disco sin actualizar metadatos

Ejemplo de apertura:

```
import java.io.RandomAccessFile; 
import java.io.IOException;  

public class EjemploApertura {     
	public static void main(String[] args) {         
		try (RandomAccessFile archivo = new RandomAccessFile("datos.txt", "rw")) {             System.out.println("Archivo abierto correctamente.");         
		} catch (IOException e) {             
			System.out.println("Error al abrir el archivo.");             e.printStackTrace();         
		}     
	} 
}
```

---

##  **2. Escribir en un Archivo**

Podemos escribir datos en una posición específica con métodos como `writeUTF()`, `writeInt()`, `writeDouble()`, etc.
```
import java.io.RandomAccessFile; 
import java.io.IOException;  

public class EscribirArchivo {     
	public static void main(String[] args) {         
		try (RandomAccessFile archivo = new RandomAccessFile("datos.txt", "rw")) {
			archivo.writeUTF("Hola Mundo"); // Escribe una cadena             
			archivo.writeInt(2024); // Escribe un número entero             
			archivo.writeDouble(3.1416); // Escribe un número decimal             
			System.out.println("Datos escritos correctamente.");         
		} catch (IOException e) {             
		System.out.println("Error al escribir en el archivo.");        
		}     
	} 
}
```

---

##  **3. Leer desde un Archivo**

Podemos leer datos desde posiciones específicas con `readUTF()`, `readInt()`, `readDouble()`, etc.
```
import java.io.RandomAccessFile; 
import java.io.IOException;  

public class LeerArchivo {     
	public static void main(String[] args) {         
		try (RandomAccessFile archivo = new RandomAccessFile("datos.txt", "r")) {             
			String mensaje = archivo.readUTF(); // Lee una cadena             
			int anio = archivo.readInt(); // Lee un número entero             
			double numero = archivo.readDouble(); // Lee un decimal              
			System.out.println("Mensaje: " + mensaje);             
			System.out.println("Año: " + anio);             
			System.out.println("Número: " + numero);         
		} catch (IOException e) {             
		System.out.println("Error al leer el archivo."); 
		}     
	} 
}
```

---

## **4. Posicionamiento en el Archivo**

Usamos `seek(posición)` para movernos a una posición específica y modificar solo una parte del archivo.

```
import java.io.RandomAccessFile; 
import java.io.IOException;  
public class ModificarArchivo {    
	public static void main(String[] args) {         
		try (RandomAccessFile archivo = new RandomAccessFile("datos.txt", "rw")) {
			archivo.seek(2); // Mueve el cursor a la posición 2             
			archivo.writeInt(9999); // Sobrescribe un entero en esa posición 
			System.out.println("Archivo modificado.");         
		} catch (IOException e) {             
		System.out.println("Error al modificar el archivo.");  
		}     
	} 
}
```
---

## **5. Obtener Información del Archivo**

Podemos obtener información del archivo con estos métodos:

- `length()` → Tamaño total del archivo
- `getFilePointer()` → Posición actual del puntero

Ejemplo:

```
import java.io.RandomAccessFile; 
import java.io.IOException;  

public class InfoArchivo {     
	public static void main(String[] args) {         
		try (RandomAccessFile archivo = new RandomAccessFile("datos.txt", "r")) {
			System.out.println("Tamaño del archivo: " + archivo.length() + " bytes");             System.out.println("Posición actual: " + archivo.getFilePointer());         
		} catch (IOException e) {             
		System.out.println("Error al obtener información del archivo."); 
		}     
	} 
}
```