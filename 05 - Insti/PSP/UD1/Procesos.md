En Java, un **proceso** representa un programa en ejecución que tiene su propio espacio de memoria y recursos. Para manejar procesos en Java, se utiliza la clase `ProcessBuilder` y la clase `Runtime`.

---

## **1. Creación de Procesos en Java**

### **1.1 Usando `Runtime.getRuntime().exec()`**

Este método permite ejecutar comandos del sistema operativo desde un programa Java.
```
import java.io.IOException;  
public class ProcesoConRuntime {     
	public static void main(String[] args) {         
		try {             
			Process proceso = Runtime.getRuntime().exec("notepad.exe"); // Abre el Bloc de notas
			proceso.waitFor(); // Espera a que el proceso termine         
		} catch (IOException | InterruptedException e) {             
			e.printStackTrace();         
		}     
	} 
}
```

**Desventajas de `Runtime.exec()`**
- Difícil de manejar argumentos complejos.
- No proporciona tanto control como `ProcessBuilder`.


---

### **1.2 Usando `ProcessBuilder`**

Esta es la forma recomendada para ejecutar procesos en Java, ya que permite mayor control sobre la entrada y salida del proceso.
```
import java.io.IOException; 
public class ProcesoConProcessBuilder {     
	public static void main(String[] args) {        
		try {            
			ProcessBuilder pb = new ProcessBuilder("notepad.exe");             
			Process proceso = pb.start();            
			proceso.waitFor(); // Espera a que el proceso termine        
		} catch (IOException | InterruptedException e) {            
			e.printStackTrace();         
		}     
	}
}
```

**Ventajas de `ProcessBuilder`**  
- Permite configurar el entorno del proceso.  
- Puede redirigir la entrada/salida del proceso.  
- Soporta ejecución en directorios específicos.

---

## **2. Captura de Salida y Error del Proceso**

Cuando ejecutamos un proceso externo, podemos capturar su salida y errores:
```
import java.io.*;  
public class CapturaSalida {     
	public static void main(String[] args) {         
	try {             
		ProcessBuilder pb = new ProcessBuilder("ping", "google.com");             
		Process proceso = pb.start();  // Captura la salida del proceso           
		BufferedReader reader = new BufferedReader(new
		InputStreamReader(proceso.getInputStream()));             
		String linea;  
		           
		while ((linea = reader.readLine()) != null) {
			System.out.println(linea);
		}
		
		proceso.waitFor(); // Espera a que termine
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
```

**Explicación:**

- `getInputStream()`: Captura la salida estándar del proceso.
- `getErrorStream()`: Captura los errores del proceso.

---

## **3. Finalización de un Proceso**

Para terminar un proceso manualmente, usamos `destroy()`:
```
Process proceso = new ProcessBuilder("notepad.exe").start(); 
Thread.sleep(5000); // Espera 5 segundos antes de cerrar 
proceso.destroy();
```
 **Advertencia:** `destroy()` no siempre es seguro en todos los sistemas operativos.

---

## **4. Ejecución en un Directorio Específico**

Podemos ejecutar un proceso en un directorio diferente:
```
ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "dir"); 
pb.directory(new File("C:\\Users")); // Ejecutar en C:\Users 
Process proceso = pb.start();
```

---

## **5. Paso de Argumentos a un Proceso**
```
ProcessBuilder pb = new ProcessBuilder("java", "-version"); 
Process proceso = pb.start();
```

Este código ejecuta `java -version` desde Java.

---

## **6. Redirección de Entrada y Salida**

Podemos redirigir la salida de un proceso a un archivo:
```
ProcessBuilder pb = new ProcessBuilder("java", "-version"); 
pb.redirectOutput(new File("output.txt")); // Guarda salida en output.txt 
pb.start();
```

---

### **Resumen**

|Característica|`Runtime.exec()`|`ProcessBuilder`|
|---|---|---|
|Facilidad de uso|Baja|Alta|
|Captura de salida|Difícil|Fácil|
|Configuración|Limitada|Completa|
|Redirección de I/O|No|Sí|
|Control del entorno|No|Sí|

Si necesitas **control avanzado**, usa `ProcessBuilder`. Si solo quieres ejecutar algo rápido, `Runtime.exec()` puede ser suficiente.

---

### **Ejemplo Completo**

Aquí tienes un ejemplo que ejecuta `ping google.com`, captura la salida y la guarda en un archivo:
```
import java.io.*;
public class ProcesoEjemplo {     
	public static void main(String[] args) {         
		try {             
			ProcessBuilder pb = new ProcessBuilder("ping", "google.com"); 
			pb.redirectOutput(new File("salida.txt")); // Guarda salida en archivo             
			Process proceso = pb.start();             
			proceso.waitFor(); // Espera a que termine             
			System.out.println("Proceso terminado. Revisa salida.txt");         
		} catch (IOException | InterruptedException e) {             
			e.printStackTrace();         
		}     
	} 
}
```

