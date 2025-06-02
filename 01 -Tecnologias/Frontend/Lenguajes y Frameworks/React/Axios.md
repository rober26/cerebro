## 📘 ¿Qué es Axios?

Axios es una biblioteca para hacer **peticiones HTTP** desde el navegador o Node.js. Es una alternativa a `fetch` con una sintaxis más amigable y opciones avanzadas.

---

## 📦 Instalación

`npm install axios # o yarn add axios`

---

## 📥 Importar Axios

`import axios from 'axios';`

---

## 📌 Uso básico

### GET

```
useEffect(() => {   
	axios.get('https://api.example.com/data')     
	.then(response => {       
		console.log(response.data);     
	})     
	.catch(error => {       
		console.error(error);     
	}); 
}, []);`
```

### POST

```
axios.post('https://api.example.com/data', {   
	name: 'Juan',   
	age: 25 }) 
	.then(response => {   
	console.log(response.data); 
	}) 
	.catch(error => {   
	console.error(error); 
	}
);
```

---

## 📦 Axios con async/await

```
const fetchData = async () => {   
	try {     
		const response = await axios.get('https://api.example.com/data');
		console.log(response.data);   
	} catch (error) {     
		console.error(error);   
	} 
};
```

---

## 🧠 En React con `useEffect` y `useState`

`import { useEffect, useState } from 'react'; import axios from 'axios';  function App() {   const [users, setUsers] = useState([]);    useEffect(() => {     const loadUsers = async () => {       try {         const res = await axios.get('https://api.example.com/users');         setUsers(res.data);       } catch (err) {         console.error(err);       }     };      loadUsers();   }, []);    return (     <ul>       {users.map(user => <li key={user.id}>{user.name}</li>)}     </ul>   ); }`

---

## ⚙️ Configuración global

`axios.defaults.baseURL = 'https://api.example.com'; axios.defaults.headers.common['Authorization'] = 'Bearer TOKEN';`

---

## 🛑 Manejo de errores

`try {   const res = await axios.get('/data'); } catch (error) {   if (error.response) {     // El servidor respondió con un estado diferente a 2xx     console.error(error.response.data);   } else if (error.request) {     // No hubo respuesta     console.error('No response received');   } else {     console.error('Error', error.message);   } }`

---

## 📁 Crear instancia personalizada de Axios

`const api = axios.create({   baseURL: 'https://api.example.com',   timeout: 1000,   headers: { 'X-Custom-Header': 'foobar' } });  api.get('/users').then(...);`