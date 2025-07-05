Las **promesas** son una característica fundamental en JavaScript, especialmente en la programación asincrónica. Permiten manejar operaciones que no se completan de inmediato, como las solicitudes a servidores, la lectura de archivos, o la manipulación de temporizadores, sin bloquear el hilo principal de ejecución.

---

### **1. ¿Qué es una Promesa?**

Una **promesa** es un objeto que representa la eventual finalización (o fracaso) de una operación asincrónica. En otras palabras, es un compromiso de devolver un valor en el futuro.

Una promesa puede estar en uno de los siguientes tres estados:

- **Pendiente**: El estado inicial de la promesa, en espera de que la operación se complete.
    
- **Cumplida (Resolved/Fulfilled)**: La operación asincrónica se completó con éxito.
    
- **Rechazada (Rejected)**: La operación asincrónica falló.
    

`let promesa = new Promise(function(resolve, reject) {   let exito = true; // Simulación de éxito o fracaso    if (exito) {     resolve("¡Operación exitosa!"); // Si la operación es exitosa, la promesa se resuelve   } else {     reject("¡Operación fallida!"); // Si la operación falla, la promesa se rechaza   } });`

---

### **2. Sintaxis de las Promesas**

La creación de una promesa sigue esta sintaxis básica:

`let promesa = new Promise(function(resolve, reject) {   // Código asincrónico   if (/* éxito */) {     resolve(valor);  // Se ejecuta si la operación tiene éxito   } else {     reject(error);  // Se ejecuta si ocurre un error   } });`

- `resolve`: Función que se llama si la operación tiene éxito, y acepta un valor que se pasará como resultado.
    
- `reject`: Función que se llama si ocurre un error, y acepta un valor (generalmente un objeto de error) que se pasará como razón del rechazo.
    

---

### **3. Consumiendo Promesas**

Una vez que una promesa se ha creado, se puede manejar su resultado utilizando los métodos `.then()`, `.catch()` y `.finally()`.

#### **3.1. `.then()`**

El método `.then()` se usa para manejar el caso en el que la promesa se cumple (resuelta). Acepta dos funciones: una para el caso exitoso (`onFulfilled`) y otra para el caso de error (`onRejected`), aunque solo se puede pasar la función exitosa si no necesitas manejar el rechazo explícitamente.

`promesa.then(function(valor) {   console.log(valor);  // Se ejecuta si la promesa se resuelve exitosamente }).catch(function(error) {   console.log(error);  // Se ejecuta si la promesa es rechazada });`

#### **3.2. `.catch()`**

El método `.catch()` se usa para manejar los errores o rechazos de una promesa. Es una forma más concisa de manejar errores que especificando un manejador en el `.then()`.

`promesa.catch(function(error) {   console.log("Error: " + error); });`

#### **3.3. `.finally()`**

El método `.finally()` se ejecuta siempre, sin importar si la promesa fue resuelta o rechazada. Se utiliza para realizar tareas de limpieza o acciones que deben ocurrir sin importar el resultado.

`promesa.finally(function() {   console.log("Operación completada, independientemente del resultado."); });`

---

### **4. Encadenando Promesas**

Las promesas pueden ser encadenadas usando varios `.then()`. Cada `.then()` devuelve una nueva promesa, lo que permite encadenar múltiples operaciones asincrónicas de manera secuencial.


`fetchData()  // Esta es una función que devuelve una promesa   .then(function(result) {     return processData(result);  // Devuelve otra promesa   })   .then(function(data) {     return saveData(data);  // Devuelve una tercera promesa   })   .then(function(finalResult) {     console.log(finalResult);  // Resultado final de todas las operaciones   })   .catch(function(error) {     console.error("Error:", error);  // Maneja cualquier error ocurrido   });`

---

### **5. Promesas Combinadas**

#### **5.1. `Promise.all()`**

`Promise.all()` recibe un array de promesas y devuelve una nueva promesa. Esta promesa se resuelve cuando todas las promesas en el array se resuelven con éxito, o se rechaza en cuanto una de ellas se rechaza.

`Promise.all([promesa1, promesa2, promesa3])   .then(function(results) {     console.log(results);  // [resultado1, resultado2, resultado3]   })   .catch(function(error) {     console.log("Error:", error);  // Se ejecuta si alguna promesa falla   });`

#### **5.2. `Promise.race()`**

`Promise.race()` recibe un array de promesas y devuelve una nueva promesa. Esta promesa se resuelve tan pronto como la primera de las promesas en el array se resuelve o se rechaza.

`Promise.race([promesa1, promesa2, promesa3])   .then(function(result) {     console.log("Primera respuesta:", result);   })   .catch(function(error) {     console.log("Error:", error);   });`

#### **5.3. `Promise.allSettled()`**

`Promise.allSettled()` se resuelve cuando todas las promesas han finalizado, ya sea con éxito o con error. Devuelve un array de objetos que contienen el estado de cada promesa (`fulfilled` o `rejected`) y su valor o razón.

`Promise.allSettled([promesa1, promesa2, promesa3])   .then(function(results) {     console.log(results);  // [{status: "fulfilled", value: ...}, {status: "rejected", reason: ...}]   });`

#### **5.4. `Promise.any()`**

`Promise.any()` devuelve la primera promesa que se resuelve con éxito. Si todas las promesas son rechazadas, devuelve una promesa rechazada con el primer error de las promesas rechazadas.

`Promise.any([promesa1, promesa2, promesa3])   .then(function(result) {     console.log("Primera promesa exitosa:", result);   })   .catch(function(error) {     console.log("Todas las promesas fallaron:", error);   });`

---

### **6. Funciones Asíncronas y `async`/`await`**

Con la llegada de las funciones **`async`** y **`await`**, trabajar con promesas es más sencillo y legible. `async` se usa para declarar una función que siempre devuelve una promesa, y dentro de ella se usa `await` para esperar la resolución de una promesa.

#### **6.1. Funciones `async`/`await`**

`async function fetchData() {   try {     let response = await fetch('url');     let data = await response.json();     console.log(data);   } catch (error) {     console.log("Error:", error);   } }`

En este ejemplo:

- **`await`** se usa para esperar que las promesas `fetch()` y `response.json()` se resuelvan antes de continuar con la ejecución.
    
- **`async`** asegura que la función siempre devuelva una promesa.