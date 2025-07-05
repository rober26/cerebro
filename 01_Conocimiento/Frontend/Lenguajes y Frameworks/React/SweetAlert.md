## 📌 1. ¿Qué es SweetAlert?

- **SweetAlert** y **SweetAlert2** son librerías para reemplazar los `alert()`, `confirm()` y `prompt()` del navegador con diálogos más atractivos y personalizables.
    

---

## 📦 2. Instalación

### ✅ SweetAlert2 (recomendado):

```
npm install sweetalert2
```

> También puedes usarlo con `CDN`:

```
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
```

---

## 🛠️ 3. Uso básico
```
import Swal from 'sweetalert2';  
Swal.fire('¡Hola!', 'Esto es una alerta.', 'success');

```


---

## 🔄 4. Tipos de íconos

```
Swal.fire('Título', 'Mensaje', 'success');  // success, error, warning, info, question
```
---

## 🔘 5. Botones personalizados

```
Swal.fire({   
	title: '¿Estás seguro?',   
	text: "No podrás revertir esto.",   
	icon: 'warning',   
	showCancelButton: true,   
	confirmButtonText: 'Sí, eliminar',   
	cancelButtonText: 'Cancelar' 
});

```
---

## 🧠 6. Promesas y manejo de respuestas

```
Swal.fire({   
	title: '¿Eliminar?',   
	showCancelButton: true,   
	confirmButtonText: 'Sí', 
})
.then((result) => {   
	if (result.isConfirmed) {     
		Swal.fire('Eliminado', '', 'success');   
	} 
});
```

---

## 🧩 7. Input (campo de texto)
```
Swal.fire({   
	title: 'Ingresa tu nombre',   
	input: 'text',   
	inputPlaceholder: 'Nombre aquí', 
})
.then(result => {   
	if (result.isConfirmed) {     console.log('Nombre ingresado:', result.value);   } });

```

---

## 🎨 8. Personalización (estilos, colores, clases)
```
Swal.fire({   
	title: 'Custom',   
	html: '<b>Mensaje con HTML</b>',   
	background: '#f0f0f0',   
	confirmButtonColor: '#3085d6',   
	cancelButtonColor: '#d33', 
});

```

---

## 📦 En React

Si lo usas en un botón en React:
```

function App() {  
	const showAlert = () => {     
		Swal.fire('Hola desde React', 'Usando SweetAlert2', 'info');   
	};    
return <button onClick={showAlert}>Mostrar Alerta</button>;
}
```

