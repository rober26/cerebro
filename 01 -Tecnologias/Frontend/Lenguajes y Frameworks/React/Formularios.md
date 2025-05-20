### 1. ¿Qué es un formulario en React?

Un **formulario** en React es una forma de capturar datos del usuario (inputs) y manejar eventos asociados, como el envío del formulario.

---

### 2. Estado Controlado vs No Controlado

#### Controlado (Controlled Component)

- El valor del input está vinculado al **estado de React**.
    
- Se usa `useState` y `onChange`.
    
```
const [nombre, setNombre] = useState("");  
<input   
	type="text"   
	value={nombre}   
	onChange={(e) => setNombre(e.target.value)} 
/>
```
#### No Controlado (Uncontrolled Component)

- El valor del input lo maneja el DOM.
    
- Se usa `useRef` para acceder al valor directamente.
    
```
const inputRef = useRef();  
<input type="text" ref={inputRef} />  
<button onClick={() => console.log(inputRef.current.value)}>Enviar</button>
```
---

### 3.  Manejando el envío del formulario

Usamos el evento `onSubmit` y la función `preventDefault()` para evitar que recargue la página.
```
function Formulario() {   
	const [email, setEmail] = useState("");    
	const handleSubmit = (e) => {     
		e.preventDefault();     
		console.log(email);   
	};    
	return (     
		<form onSubmit={handleSubmit}>       
			<input         
				type="email"         
				value={email}         
				onChange={(e) => setEmail(e.target.value)}       
			/>       
			<button type="submit">Enviar</button>     
		</form>   
	); 
}
```

---

### 4.  Validaciones básicas

Puedes validar dentro del `handleSubmit` o usando `onBlur`, `pattern`, etc.

`if (email === "") {   alert("El email es obligatorio"); }`

---

### 5.  Librerías populares para formularios

- **Formik**: Simplifica el manejo de formularios y validaciones.
    
- **React Hook Form**: Muy liviana y rápida, basada en refs.
    
`npm install react-hook-form`
```
import { useForm } from "react-hook-form";  
const { register, handleSubmit } = useForm();  
<form onSubmit={handleSubmit(data => console.log(data))}>   
<input {...register("nombre")} />   
<input type="submit" /> </form>
```
