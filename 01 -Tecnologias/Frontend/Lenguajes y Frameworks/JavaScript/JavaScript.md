**JavaScript (JS)** es un lenguaje de programación interpretado, de alto nivel y orientado a eventos, utilizado principalmente para el desarrollo web. Es uno de los tres pilares fundamentales del desarrollo web junto con **HTML (estructura)** y **CSS (estilos)**.

---

## **1.Sintaxis Básica**

### Variables:

- **`var`**: Declaración de variables (es obsoleta en la mayoría de los casos).
- **`let`**: Declaración de variables con alcance de bloque.
- **`const`**: Declara una constante cuyo valor no puede cambiar.
```
let nombre = "Juan"; 
const edad = 30;
```

### Tipos de Datos:

- **Primitivos**: `string`, `number`, `boolean`, `null`, `undefined`, `symbol` (ES6+).
- **Compuestos**: `object` (arrays, objetos, etc.).
```
let texto = "Hola"; 
let numero = 42; 
let esVerdadero = true; 
let persona = { nombre: "Ana", edad: 25 }; let numeros = [1, 2, 3];
```

### Operadores:

- **Aritméticos**: `+`, `-`, `*`, `/`, `%`.
- **Lógicos**: `&&`, `||`, `!`.
- **Comparación**: `==`, `===`, `!=`, `>`, `<`, `>=`, `<=`.

`let suma = 5 + 3;  // 8 let esIgual = (5 === 5);  // true`

### Condicionales:

- **if / else**: Para tomar decisiones basadas en condiciones.
```
let edad = 18; 
if (edad >= 18) {   
	console.log("Eres mayor de edad"); 
} else {   
	console.log("Eres menor de edad"); 
}
```

### Bucles:

- **for**: Itera sobre un bloque de código un número determinado de veces.
```
for (let i = 0; i < 5; i++) {   
	console.log(i);  // Imprime del 0 al 4 
}
```

- **while**: Ejecuta un bloque de código mientras se cumpla una condición.
```
let i = 0; 
while (i < 5) {   
	console.log(i);  // Imprime del 0 al 4   
	i++; 
}
```

- **for...of**: Itera sobre los elementos de un array o de una colección iterable.
```
let numeros = [1, 2, 3]; 
for (let num of numeros) {   
	console.log(num);  // Imprime 1, 2, 3 
}
```

---

## **2. Funciones**

### **2.1 Declaración de funciones:**
```
function saludar(nombre) {   
	return "Hola " + nombre; 
}  
console.log(saludar("Juan"));  // Imprime "Hola Juan"
```

### **2.2 Funciones de flecha (Arrow Functions):**

Una forma más concisa de escribir funciones.
```
const saludar = (nombre) => "Hola " + nombre; console.log(saludar("Ana"));
```


---

## **3. Objetos y Arrays**

### **3.1 Objetos:**

Un objeto en JavaScript es una colección de propiedades, cada una con un valor.
```
let persona = {   
	nombre: "Carlos",   
	edad: 28,   
	saludar: function() {     
		return `Hola, soy ${this.nombre}`;   
	} 
};  
console.log(persona.saludar());  // Imprime "Hola, soy Carlos"
```

### **3.2 Arrays:**

Un array es una lista ordenada de elementos.
```
let numeros = [1, 2, 3, 4]; console.log(numeros[0]);  // Imprime 1
```
Puedes acceder y manipular arrays con métodos como `push()`, `pop()`, `shift()`, `unshift()`, `map()`, `filter()`, etc.
```
numeros.push(5);  // Agrega el número 5 al final console.log(numeros);
```

---

## **4. DOM (Document Object Model)**

El **DOM** es una interfaz de programación que permite acceder a los elementos HTML de la página web y manipularlos mediante JavaScript.

### **4.1 Acceder a elementos:**

- **`getElementById()`**: Obtiene un elemento por su ID.
```
let encabezado = document.getElementById("miEncabezado");
```
- **`getElementsByClassName()`**: Obtiene una colección de elementos por su clase.
```
let elementos = document.getElementsByClassName("miClase");
```
- **`querySelector()`**: Selecciona el primer elemento que coincide con un selector CSS.
```
let boton = document.querySelector("#miBoton");
```
### **4.2 Modificar elementos:**

- **Cambiar el contenido de un elemento:**
```
document.getElementById("miEncabezado").textContent = "Nuevo texto";
```
- **Cambiar el estilo de un elemento:**
```
document.getElementById("miEncabezado").style.color = "blue";
```
- **Añadir un evento:**
```
document.getElementById("miBoton").addEventListener("click", function() {   alert("Botón presionado"); });
```
### **4.3 Crear y agregar nuevos elementos:**
```
let nuevoElemento = document.createElement("div"); 
nuevoElemento.textContent = "¡Hola, mundo!"; document.body.appendChild(nuevoElemento);
```
---
## **5. Promesas (Promises)**

Las **Promesas** en JavaScript son objetos que representan la eventual finalización o el fracaso de una operación asíncrona. Son fundamentales para trabajar con código asincrónico como las peticiones HTTP.

### **5.1 Promesa básica:**
```
let miPromesa = new Promise((resolve, reject) => {   
	let exito = true;  // Cambia a false para simular un error
	if (exito) {  
		resolve("Operación exitosa");   
	}else {     
		reject("Hubo un error");   
	}
});  
miPromesa   
	.then(result => console.log(result))   // "Operación exitosa"   
	.catch(error => console.log(error));  // "Hubo un error"

```

### **5.2 Encadenamiento de promesas:**

Puedes encadenar múltiples `then` y `catch` para manejar diferentes etapas de la promesa.
```
let promesa = new Promise((resolve, reject) => {   
	resolve("Operación completada"); 
});  
promesa   
	.then(result => {     
		console.log(result);  // "Operación completada"     
		return "Siguiente paso";   
	})   
.then(result => {     
	console.log(result);  // "Siguiente paso"   
})   
.catch(error => {     
	console.log(error);   
});
```
### **5.3 `async` y `await`:**

`async` y `await` son una forma más sencilla de trabajar con promesas, haciendo que el código asincrónico parezca más sincrónico.
```
async function ejemploAsync() {   
	let resultado = await miPromesa;   
	console.log(resultado);  // "Operación exitosa" 
}  
ejemploAsync();
```
---

## **6. Event Loop y Asincronía**

El **Event Loop** es el mecanismo que permite que JavaScript ejecute código de manera asincrónica. Las operaciones como **setTimeout**, **promesas** y **event listeners** se gestionan en el "cola de tareas" y se ejecutan después de que el "stack de ejecución" esté vacío.

### **6.1 setTimeout y setInterval:**

- **`setTimeout()`**: Ejecuta una función después de un cierto tiempo.
```
setTimeout(() => {   
	console.log("Esto se muestra después de 2 segundos"); 
}, 2000);
```
- **`setInterval()`**: Ejecuta una función repetidamente a intervalos de tiempo definidos.
```
setInterval(() => {   
	console.log("Esto se repite cada 1 segundo"); 
}, 1000);
```
---

## **7. ES6 y Funciones Avanzadas**

### **7.1 Desestructuración:**

Te permite extraer valores de arrays u objetos de manera más fácil.

- **Objetos:**
```
const persona = { nombre: "Juan", edad: 25 }; 
const { nombre, edad } = persona; 
console.log(nombre);  // "Juan"
```
- **Arrays:**
```
const numeros = [1, 2, 3]; 
const [a, b] = numeros; 
console.log(a);  // 1
```
### **7.2 Operador Rest y Spread:**

- **Rest (`...`)**: Para agrupar elementos.
```
function sumar(...numeros) {   
	return numeros.reduce((acc, num) => acc + num, 0); 
} 
console.log(sumar(1, 2, 3));  // 6
```
- **Spread (`...`)**: Para expandir elementos de un array u objeto.
```
const arr1 = [1, 2]; 
const arr2 = [...arr1, 3, 4]; 
console.log(arr2);  // [1, 2, 3, 4]
```
### **7.3 Template Literals:**

Permite interpolar expresiones dentro de cadenas de texto de manera más fácil.
```
let nombre = "Pedro"; 
let saludo = `Hola, ${nombre}`; 
console.log(saludo);  // "Hola, Pedro"
```
