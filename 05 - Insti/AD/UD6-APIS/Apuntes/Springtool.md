## 🧩 ¿Qué es Spring Tool Suite?

Spring Tool Suite (STS) es un **IDE especializado** para el desarrollo de aplicaciones Spring. Está basado en **Eclipse** y ofrece herramientas integradas para facilitar el desarrollo con el **Spring Framework**.

---

## 🛠️ Instalación de STS

1. **Requisitos previos:**
    
    - Java JDK (versión 8 o superior)
        
    - Maven o Gradle (opcional, pero recomendado)
        
2. **Descarga:**
    
    - Desde [https://spring.io/tools](https://spring.io/tools)
        
3. **Instalación:**
    
    - Extraer el archivo ZIP y ejecutar el archivo `STS.exe` (Windows) o el equivalente en otros sistemas operativos.
        

---

## 🧱 Características Principales

- Basado en Eclipse.
    
- Integración con Spring Boot.
    
- Soporte para Maven y Gradle.
    
- Generación de proyectos desde Spring Initializr.
    
- Autocompletado, navegación entre clases, y sugerencias contextuales.
    
- Consola de logs integrada.
    
- Soporte para pruebas JUnit.
    

---

## ⚙️ Crear un proyecto Spring Boot en STS

### Opción 1: Spring Initializr (GUI)

1. File > New > Spring Starter Project.
    
2. Configura:
    
    - Nombre del proyecto
        
    - Group ID y Artifact ID
        
    - Tipo de empaquetado (`jar` o `war`)
        
    - Versión de Java
        
3. Elige dependencias (Spring Web, JPA, Security, etc.)
    
4. Termina y el proyecto se generará automáticamente.
    

### Opción 2: Importar proyecto existente

1. File > Import > Existing Maven/Gradle Project.
    
2. Navega al directorio y sigue los pasos del asistente.
    

---

## 📦 Estructura típica de un proyecto Spring Boot

bash

CopiarEditar

`src/ ├── main/ │   ├── java/ │   │   └── com/ejemplo/demo/ │   │       ├── DemoApplication.java │   │       └── controller/ │   │       └── service/ │   │       └── repository/ │   └── resources/ │       ├── application.properties │       └── static/ │       └── templates/ ├── test/`

---

## ✍️ Archivos importantes

### `application.properties` o `application.yml`

Configuración del proyecto (puerto, base de datos, logging, etc.)

Ejemplo:

properties

CopiarEditar

`server.port=8081 spring.datasource.url=jdbc:mysql://localhost:3306/mi_bd spring.datasource.username=root spring.datasource.password=1234`

---

## 📚 Funcionalidades clave de STS

|Función|Descripción|
|---|---|
|Spring Boot Dashboard|Ejecutar, depurar y gestionar múltiples apps Spring Boot.|
|Live Hover|Mostrar información de anotaciones (como `@Autowired`, `@Controller`).|
|Spring Starter Wizard|GUI para crear proyectos con dependencias desde Initializr.|
|Spring Navigation|Saltar entre beans, controladores, servicios, repositorios.|
|Test Runner|Ejecutar pruebas unitarias y de integración.|
|Spring Boot Devtools|Hot reload para desarrollo rápido.|

---

## 🧪 Pruebas en STS

Puedes crear tests con JUnit fácilmente:

java

CopiarEditar

`@SpringBootTest public class MiServicioTest {      @Autowired     private MiServicio servicio;      @Test     public void testSuma() {         assertEquals(5, servicio.sumar(2, 3));     } }`

---

## 🧠 Consejos útiles

- Usa `Ctrl + Shift + R` para abrir cualquier archivo rápidamente.
    
- Usa `@ComponentScan` para detectar beans fuera del paquete raíz.
    
- Usa `application-dev.properties` y perfiles para distintos entornos (`dev`, `prod`, etc.)
    
- Integra con Git desde STS o usa terminal integrada.
    
- Puedes usar **Lombok** para reducir código boilerplate (`@Getter`, `@Setter`, etc.)
    

---

## 🧩 Integración con tecnologías comunes

|Tecnología|Uso en Spring|
|---|---|
|Spring Data JPA|ORM y acceso a base de datos|
|Spring Security|Autenticación y autorización|
|Spring MVC|Controladores y vistas REST|
|Thymeleaf|Motor de plantillas HTML|
|REST APIs|Creación de endpoints con `@RestController`|
|Swagger/OpenAPI|Documentación de APIs|

---

## 🔧 Ejemplo de aplicación simple (controlador)

java

CopiarEditar

`@RestController @RequestMapping("/api/saludo") public class SaludoController {      @GetMapping     public String saludar(@RequestParam(defaultValue = "mundo") String nombre) {         return "Hola, " + nombre + "!";     } }`

---

## 🚀 Ejecutar el proyecto

1. Botón derecho sobre la clase con `@SpringBootApplication`
    
2. Run As > Spring Boot App
    

---

## 🧹 Limpieza y solución de errores

- `Project > Clean`
    
- `Maven > Update Project`
    
- Revisa consola para errores de dependencias
    

---