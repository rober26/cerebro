React es una biblioteca de [[JavaScript]] para construir interfaces de usuario interactivas y dinámicas. Fue desarrollada por Facebook y se basa en un modelo de componentes reutilizables, lo que facilita la creación de aplicaciones web eficientes y escalables.
## Conceptos principales

### 1. Componentes

- Son la unidad básica en React.
- Pueden ser **funcionales** o **de clase**.
- Cada componente puede tener su propio estado y ciclo de vida.

**Ejemplo de componente funcional:**
```
function Saludo() {   
	return(
		<h1>Hola, Mundo</h1>; 
	)
}
```
---
### 2. JSX

- JSX es una extensión de JavaScript que permite escribir HTML dentro de JavaScript.
    
- No es obligatorio usar JSX, pero es muy común.
    

**Ejemplo de JSX:**

jsx

Copiar código

`const elemento = <h1>Hola, soy JSX</h1>;`

---

### 3. Estado (State)

- El estado es un objeto que almacena datos que pueden cambiar a lo largo del tiempo.
    
- Se usa el **hook** `useState` para manejarlo en componentes funcionales.
    

**Ejemplo de `useState`:**
```
import { useState } from 'react'; 

function Contador() {   
	const [contador, setContador] = useState(0);    
	return (     
		<div>       
			<p>Contador: {contador}</p>       
			<button onClick={() => setContador(contador + 1)}>Incrementar</button>     
		</div>   
	); 
}
```


---

### 4. Props

- Las props (propiedades) son parámetros que se pasan a los componentes desde su componente padre.
    
- Son de solo lectura.
    

**Ejemplo de props:**

jsx

Copiar código

`function Saludo(props) {   return <h1>Hola, {props.nombre}</h1>; }  // Usándolo: <Saludo nombre="Carlos" />`

---

### 5. useEffect

- `useEffect` es un hook que permite ejecutar efectos secundarios en los componentes, como peticiones HTTP, cambios en el DOM, timers, etc.
    

**Ejemplo básico de `useEffect`:**

jsx

Copiar código

`import { useEffect } from 'react';  function App() {   useEffect(() => {     console.log('El componente se montó');   }, []); // El array vacío indica que se ejecuta solo una vez    return <div>Hola</div>; }`

---

### 6. Ciclo de vida

- En componentes de clase, hay métodos como `componentDidMount`, `componentDidUpdate`, y `componentWillUnmount`.
    
- En componentes funcionales, se manejan usando `useEffect`.
    

---

### 7. Manejo de eventos

- React usa camelCase para los eventos.
    
- Se pasan funciones como manejadores.
    

**Ejemplo de evento:**


`function Boton() {   const manejarClick = () => {     alert('Hiciste clic');   };    return <button onClick={manejarClick}>Clic aquí</button>; }`