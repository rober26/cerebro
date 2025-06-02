### ✅ 1. Instalar `json-server`

`npm install -g json-server`

O si prefieres en tu proyecto local:

`npm install --save-dev json-server`

---

### 🗃️ 2. Crear archivo `db.json`

Este archivo simula tu base de datos.

```
{   
"usuarios": [    
	{ "id": 1, "nombre": "Ana", "edad": 25 },     
	{ "id": 2, "nombre": "Luis", "edad": 30 }   
],   
"posts": [     
	{ "id": 1, "titulo": "Hola mundo", "contenido": "Primer post" }   
] 
}
```

Guárdalo como `db.json`.

---

### ▶️ 3. Iniciar el servidor

`json-server --watch db.json --port 3000`

Esto crea un servidor RESTful en `http://localhost:3000`.

---

### 🌐 4. Endpoints disponibles

Con el archivo anterior, puedes hacer peticiones a:

- `GET /usuarios`
- `GET /usuarios/1`
- `POST /usuarios`
- `PUT /usuarios/1`
- `PATCH /usuarios/1`
- `DELETE /usuarios/1`

---

### 📡 5. Consumir con Axios

#### Ejemplo con `GET`

`axios.get('http://localhost:3000/usuarios')   .then(response => console.log(response.data))   .catch(error => console.error(error));`

#### Ejemplo con `POST`

`axios.post('http://localhost:3000/usuarios', {   nombre: 'Carlos',   edad: 28 }) .then(res => console.log(res.data));`