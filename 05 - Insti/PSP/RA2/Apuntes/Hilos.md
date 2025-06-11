Los **hilos** (threads) permiten la ejecución de múltiples tareas al mismo tiempo en un programa Java, lo que mejora el rendimiento y la eficiencia en operaciones concurrentes.

---

## **1. Creación de Hilos en Java**

En Java, hay dos formas principales de crear hilos:

### **1.1 Extender la clase `Thread`**
```
class MiHilo extends Thread {     
	public void run() {         
		for (int i = 1; i <= 5; i++) {             
			System.out.println("Ejecutando hilo: " + i);             
			try {                 
				Thread.sleep(1000); // Pausa de 1 segundo             
			} catch (InterruptedException e) {                 
				e.printStackTrace();             
			}         
		}     
	}
} 
public class HilosEjemplo {     
	public static void main(String[] args) {        
		MiHilo hilo = new MiHilo();         
		hilo.start(); // Inicia el hilo     
	} 
}
```
**Explicación:**

- Se sobrescribe el método `run()`, que contiene el código a ejecutar en el hilo.
- Se usa `start()` para iniciar el hilo (¡no uses `run()` directamente!).

---

### **1.2 Implementar la interfaz `Runnable`**
```
class MiRunnable implements Runnable {     
	public void run() {         
		for (int i = 1; i <= 5; i++) {             
			System.out.println("Hilo con Runnable: " + i);             
			try {                 
				Thread.sleep(1000); // Pausa de 1 segundo             
			} catch (InterruptedException e) {                 
				e.printStackTrace();             
			}         
		}     
	} 
}  

public class HilosEjemplo {     
	public static void main(String[] args) {         
		Thread hilo = new Thread(new MiRunnable());         
		hilo.start();     
	} 
}
```

**Diferencia con `Thread`**:  
`Runnable` es más flexible, ya que permite que la clase extienda otra clase si es necesario.  
`Thread` ya extiende de `Object`, por lo que si usas `extends Thread`, pierdes la posibilidad de heredar de otra clase.

---

## **2. Métodos útiles de la clase `Thread`**

|Método|Descripción|
|---|---|
|`start()`|Inicia el hilo.|
|`run()`|Código que ejecutará el hilo. No llamarlo directamente.|
|`sleep(ms)`|Pausa el hilo por `ms` milisegundos.|
|`join()`|Espera a que el hilo termine.|
|`isAlive()`|Retorna `true` si el hilo sigue en ejecución.|
|`setName(nombre)`|Asigna un nombre al hilo.|
|`getName()`|Obtiene el nombre del hilo.|
|`setPriority(n)`|Cambia la prioridad del hilo (1 a 10).|

---

## **3. Uso de `join()` para esperar la finalización de un hilo**
```
class MiHilo extends Thread {     
	public void run() {        
		for (int i = 1; i <= 3; i++) {             
			System.out.println(getName() + " ejecutando: " + i);             
			try {                 
				Thread.sleep(1000);             
			} catch (InterruptedException e) {                 
				e.printStackTrace();             
			}         
		}     
	} 
}  
public class EjemploJoin {     
	public static void main(String[] args) {         
		MiHilo hilo1 = new MiHilo();         
		MiHilo hilo2 = new MiHilo();          
		hilo1.start();        
		try {             
			hilo1.join(); // Espera a que termine antes de continuar         
		} catch (InterruptedException e) {             
			e.printStackTrace();         
		}         
		hilo2.start();     
	} 
}
```

🔹 `join()` se usa para esperar a que un hilo termine antes de continuar con la ejecución de otros hilos.

---

## **4. Sincronización de Hilos (`synchronized`)**

Si varios hilos acceden a un mismo recurso, pueden ocurrir problemas de concurrencia. Para evitarlo, usamos `synchronized`.

```
class CuentaBancaria {     
	private int saldo = 100;      
	public synchronized void retirarDinero(int cantidad) {        
		if (saldo >= cantidad) {            
			System.out.println(Thread.currentThread().getName() + " retirando $" + cantidad);             
			saldo -= cantidad;             
			System.out.println("Saldo restante: $" + saldo);         
		} else {             
			System.out.println("No hay suficiente saldo para " + Thread.currentThread().getName());
		}     
	} 
}  

class Cliente extends Thread {     
	CuentaBancaria cuenta;      
	public Cliente(CuentaBancaria cuenta) {         
		this.cuenta = cuenta;     
	}      
	public void run() {         
		cuenta.retirarDinero(50);     
	} 
}  

public class EjemploSincronizacion {     
	public static void main(String[] args) {         
		CuentaBancaria cuenta = new CuentaBancaria();         
		Cliente c1 = new Cliente(cuenta);         
		Cliente c2 = new Cliente(cuenta);          
		c1.start();         
		c2.start();     
	} 
}
```

🔹 `synchronized` garantiza que solo un hilo acceda al método a la vez, evitando inconsistencias.

---

## **5. Uso de `ExecutorService` (Manejo Avanzado de Hilos)**

En lugar de manejar hilos manualmente, podemos usar `ExecutorService` para administrar un grupo de hilos.
```
import java.util.concurrent.ExecutorService; 
import java.util.concurrent.Executors;  
class Tarea implements Runnable {     
	private int id;      
	public Tarea(int id) {         
		this.id = id;     
	}      
	public void run() {         
		System.out.println("Ejecutando tarea " + id + " en " + Thread.currentThread().getName());     
		} 
} 
public class EjemploExecutor {     
	public static void main(String[] args) {         
		ExecutorService executor = Executors.newFixedThreadPool(3); // 3 hilos disponibles          
		for (int i = 1; i <= 5; i++) {             
			executor.execute(new Tarea(i));         
		}          
		
		executor.shutdown(); // Finaliza el ExecutorService
	}
}
```


🔹 `ExecutorService` maneja automáticamente la creación y terminación de hilos, mejorando la eficiencia.

---

## **6. Diferencia entre Hilos y Procesos**

|Característica|Hilo (`Thread`)|Proceso|
|---|---|---|
|Espacio de memoria|Comparte memoria con otros hilos del mismo proceso.|Tiene su propio espacio de memoria.|
|Velocidad|Más rápido.|Más lento.|
|Comunicación|Fácil (comparten memoria).|Difícil (requiere IPC).|
|Creación|Menos costosa.|Más costosa.|

---

## **7. Problemas Comunes en Hilos**

### **7.1 Condiciones de carrera**

Ocurre cuando dos o más hilos acceden a la misma variable al mismo tiempo y causan resultados inesperados.  
🔹 **Solución:** Usar `synchronized` o `Lock` de `java.util.concurrent.locks`.

### **7.2 Deadlocks (Bloqueo Mutuo)**

Sucede cuando dos hilos esperan indefinidamente que el otro libere un recurso.  
🔹 **Solución:** Evitar bloqueos circulares y usar `tryLock()`.

### **7.3 Starvation (Inanición)**

Ocurre cuando un hilo de baja prioridad nunca se ejecuta porque los de alta prioridad acaparan la CPU.  
🔹 **Solución:** Usar planificación justa de hilos.

---

## **8. Resumen Final**

**Usar `Thread` o `Runnable` para tareas simples.**  
 **Usar `synchronized` para evitar problemas de concurrencia.**  
 **Utilizar `ExecutorService` para manejo eficiente de hilos.**  
**Evitar `join()` y `sleep()` en exceso, ya que pueden bloquear la ejecución.**