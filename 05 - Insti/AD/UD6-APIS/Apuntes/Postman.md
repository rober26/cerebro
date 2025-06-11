## 🧩 ¿Qué es Postman?

**Postman** es una herramienta que permite a desarrolladores crear, probar, documentar y compartir **APIs RESTful** de forma sencilla. Facilita el envío de peticiones HTTP y el análisis de las respuestas.

---

## 🖥️ Instalación y Acceso

- Disponible en: Windows, macOS, Linux, y también en versión Web.
- Descargar desde: https://www.postman.com/downloads

---

## 🚀 Interfaz Principal

- **Workspace**: Espacio de trabajo para organizar tus colecciones y peticiones.
- **Collections**: Agrupaciones de peticiones relacionadas.
- **Request Builder**: Área donde configuras y envías peticiones.
- **Response Viewer**: Muestra la respuesta del servidor (status, body, headers).
- **Console**: Registro detallado de las peticiones/respuestas (útil para debugging).

---

## 📤 Tipos de Peticiones HTTP

|Método|Uso común|
|---|---|
|`GET`|Obtener datos|
|`POST`|Enviar datos nuevos|
|`PUT`|Actualizar datos existentes (reemplazo)|
|`PATCH`|Actualización parcial|
|`DELETE`|Eliminar datos|

---

## 📌 Estructura de una Petición

1. **URL**: La dirección del recurso.
2. **Método**: GET, POST, etc.
3. **Headers**: Información adicional (Auth, Content-Type, etc.)
4. **Body**: Solo para métodos como POST, PUT, PATCH (JSON, form-data, etc.)
5. **Params**:
    - **Query Params**: `?id=123`
    - **Path Params**: `/usuarios/{id}`

---

## 🧪 Ejemplo de Petición POST

- **URL**: `https://api.ejemplo.com/login`
- **Headers**:
	
    `Content-Type: application/json`
    
- **Body (raw - JSON)**:
	
    `{   "usuario": "admin",   "clave": "1234" }`
    

---

## 🔑 Autenticación

### Tipos comunes:

- **Bearer Token**
- **Basic Auth**
- **OAuth 2.0**
- **API Key**

Puedes configurar la autenticación en la pestaña **Authorization** de cada petición.

---

## 🗃️ Colecciones

Las **colecciones** permiten:

- Agrupar peticiones relacionadas
- Añadir documentación
- Ejecutar test automáticos
- Compartir con tu equipo

---

## ⚙️ Variables

Postman permite definir variables a nivel de:

|Nivel|Uso típico|
|---|---|
|Global|Acceso en todos los entornos|
|Environment|Variables para distintos entornos (dev, prod...)|
|Collection|Compartidas dentro de una colección|
|Local|Sólo para una petición específica|

Ejemplo de uso:
`{{base_url}}/usuarios/{{user_id}}`

---

## 🌍 Entornos (Environments)

Permiten cambiar dinámicamente las variables según el contexto (dev, staging, producción).

Ejemplo:
`{   "base_url": "https://api.dev.com" }`

---

## 🧪 Tests Automáticos (pestaña **Tests**)

Puedes escribir tests en JavaScript para validar las respuestas.

### Ejemplo:
````
pm.test("Status code is 200", function () {     
	pm.response.to.have.status(200); 
});  
pm.test("Body contiene usuario", function () {     
	const jsonData = pm.response.json();     
	pm.expect(jsonData.nombre).to.eql("admin"); 
});
````
---

## 🔁 Runner (Ejecutar tests en lote)

- Ejecuta toda una colección de peticiones.
- Útil para pruebas de regresión, smoke testing, etc.
- Puedes cargar archivos `.csv` o `.json` con datos para pruebas.

---

## 📘 Documentación de APIs

- Puedes documentar tu colección directamente.
- Postman genera documentación accesible por URL pública o privada.
- Opción: “View Documentation” > “Publish”.

---

## 🔄 Monitorización

- Puedes programar la ejecución periódica de colecciones para monitorear la salud de una API.
- Funciona desde la nube de Postman (requiere cuenta).

---

## 🔌 Integraciones

Postman se puede integrar con:

- GitHub / GitLab
- Jenkins / CI/CD
- Swagger/OpenAPI
- Newman (CLI para ejecución desde terminal)

---

## 🖥️ Uso de Newman (CLI de Postman)

Instalación:

`npm install -g newman`

Ejecutar colección:

`newman run mi_coleccion.json -e entorno.json`

---

## 💡 Consejos útiles

- Usa `Pre-request Script` para preparar tokens u otros datos dinámicos.
- Usa la **Postman Console** (`View > Show Postman Console`) para debuggear errores.
- Guarda tus respuestas exitosas como ejemplos (`Save Response > Save as example`).
- Usa `pm.environment.set("token", value)` para guardar valores dinámicos.