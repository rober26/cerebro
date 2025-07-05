### 📌 ¿Qué es Axios?

- Axios es una **librería basada en Promesas** para hacer solicitudes HTTP desde el navegador y Node.js.
- Similar a `fetch`, pero con más características útiles.
- Soporta **interceptores, cancelación de peticiones**, transformación automática de datos y más.

---

### 🔧 Instalación

`npm install axios`

O con CDN para usarlo directamente en el navegador:

`<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>`

---

### 🚀 Ejemplos de uso básico

#### ✅ Hacer un GET

```
axios.get('https://api.example.com/data')   
.then(response => {     
	console.log(response.data); // datos de la respuesta   
})   
.catch(error => {     
	console.error(error); // manejo de errores   
});
```

#### ✅ Hacer un POST

```
axios.post('https://api.example.com/data', {   
	nombre: 'Juan',   edad: 30 
	}
) .then(response => console.log(response.data)) 
.catch(error => console.error(error));
````
---

### ⚙️ Configuración

#### 🔑 Config global

```
axios.defaults.baseURL = 'https://api.example.com'; axios.defaults.headers.common['Authorization'] = 'Bearer TOKEN';
```

#### 📁 Config en una sola petición

```
axios({   
	method: 'get',   
	url: '/usuarios',   
	params: { id: 1 } 
});
```

---

### 🔄 Interceptores

#### Interceptar solicitud

```
axios.interceptors.request.use(config => {   
	console.log('Enviando solicitud...', config);   
	return config; 
});
```
#### Interceptar respuesta

```
axios.interceptors.response.use(response => {   
	console.log('Respuesta recibida', response);   
	return response; 
});
```

---

### ⏱ Cancelar peticiones

```
const controller = new AbortController();  
axios.get('/datos', { signal: controller.signal })   
.catch(error => {     
	if (axios.isCancel(error)) {       
		console.log('Petición cancelada');     
	}   
});  
// Cancelar la petición controller.abort();`
```

---

### 🔄 Axios y async/await

```
async function obtenerDatos() {   
	try {     
		const response = await axios.get('/api/productos');
		console.log(response.data);   
	} catch (error) {     
		console.error(error);   
	} 
}
```

---

### 📦 Resumen de métodos HTTP en Axios

| Método      | Uso                    |
| ----------- | ---------------------- |
| `.get()`    | Obtener datos          |
| `.post()`   | Enviar datos (crear)   |
| `.put()`    | Reemplazar datos       |
| `.patch()`  | Modificar parcialmente |
| `.delete()` | Eliminar datos         |
