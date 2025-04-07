El **DOM (Document Object Model)** es una interfaz de programación para documentos HTML y XML. Es un modelo de objetos que representa la estructura de un documento en un árbol jerárquico donde cada nodo es un objeto que representa una parte del documento. En el contexto de JavaScript, el DOM permite acceder y modificar dinámicamente el contenido, la estructura y los estilos de una página web.

---

### **1. ¿Qué es el DOM?**

- El DOM es una representación estructurada de un documento HTML o XML.
    
- El documento se modela como un conjunto de nodos organizados jerárquicamente, donde cada nodo es un objeto.
    
- Cada etiqueta HTML, atributo, y el contenido de texto en una página se representan como nodos dentro del DOM.
    

Por ejemplo, el siguiente fragmento de HTML:

`<!DOCTYPE html> <html>   <head>     <title>Mi Página</title>   </head>   <body>     <h1>Hola Mundo</h1>     <p>Bienvenidos a mi página web.</p>   </body> </html>`

Será representado en el DOM de forma jerárquica como:

`Document  ├── html  │   ├── head  │   │   └── title  │   └── body  │       ├── h1  │       └── p`

---

### **2. Acceso al DOM desde JavaScript**

JavaScript proporciona varios métodos para acceder y manipular el DOM de la página web:

#### **2.1. Selección de Elementos**

- `document.getElementById(id)` - Selecciona un elemento por su ID.

    `let element = document.getElementById("miElemento");`
    
- `document.getElementsByClassName(className)` - Selecciona todos los elementos con una clase específica.

    `let items = document.getElementsByClassName("miClase");`
    
- `document.getElementsByTagName(tagName)` - Selecciona todos los elementos con una etiqueta específica.
    
    `let paragraphs = document.getElementsByTagName("p");`
    
- `document.querySelector(selector)` - Selecciona el primer elemento que coincide con un selector CSS.
    
    `let firstButton = document.querySelector("button");`
    
- `document.querySelectorAll(selector)` - Selecciona todos los elementos que coinciden con un selector CSS.
    
    `let allButtons = document.querySelectorAll("button");`
    

#### **2.2. Acceder a Atributos**

- `element.getAttribute(attribute)` - Obtiene el valor de un atributo de un elemento.
	
    `let hrefValue = document.getElementById("link").getAttribute("href");`
    
- `element.setAttribute(attribute, value)` - Establece un nuevo valor para un atributo.
    
    `document.getElementById("link").setAttribute("href", "https://www.nuevoenlace.com");`
    

#### **2.3. Modificar el Contenido**

- `element.innerHTML` - Permite obtener o modificar el contenido HTML de un elemento.
    
    `let content = document.getElementById("miElemento").innerHTML; document.getElementById("miElemento").innerHTML = "<p>Nuevo contenido HTML</p>";`
    
- `element.textContent` - Permite obtener o modificar el contenido de texto de un elemento.
    
    `let text = document.getElementById("miElemento").textContent; document.getElementById("miElemento").textContent = "Nuevo texto";`
    

#### **2.4. Modificar Estilos**

- `element.style.property` - Modifica el estilo en línea de un elemento (propiedades CSS).
    
    `document.getElementById("miElemento").style.color = "blue";`
    

---

### **3. Crear y Eliminar Elementos**

#### **3.1. Crear Elementos**

- `document.createElement(tagName)` - Crea un nuevo elemento HTML de tipo `tagName`.
    
    `let newDiv = document.createElement("div"); newDiv.textContent = "Hola, soy un nuevo div!"; document.body.appendChild(newDiv); // Añade el div al final del body`
    

#### **3.2. Eliminar Elementos**

- `element.remove()` - Elimina un elemento del DOM.
    
    `let elementToRemove = document.getElementById("miElemento"); elementToRemove.remove();`
    
- `element.parentNode.removeChild(element)` - Elimina un elemento usando su nodo padre.
    
    `let elementToRemove = document.getElementById("miElemento"); elementToRemove.parentNode.removeChild(elementToRemove);`
    

---

### **4. Manipulación de Eventos en el DOM**

El DOM permite agregar **eventos** a los elementos, lo que hace posible que la página interactúe con el usuario.

#### **4.1. Agregar Eventos**

- `element.addEventListener(event, function)` - Asocia un evento con un elemento. Permite que varios eventos sean escuchados de manera eficiente.
    
    `document.getElementById("boton").addEventListener("click", function() {   alert("¡Botón clickeado!"); });`
    

#### **4.2. Eliminar Eventos**

- `element.removeEventListener(event, function)` - Elimina un evento previamente asociado.
    
    `function handleClick() {   alert("¡Botón clickeado!"); }  document.getElementById("boton").addEventListener("click", handleClick); document.getElementById("boton").removeEventListener("click", handleClick);`
    

#### **4.3. Tipos de Eventos Comunes**

- `click` - Ocurre cuando se hace clic en un elemento.
    
- `mouseover` - Ocurre cuando el puntero del mouse pasa por encima de un elemento.
    
- `mouseout` - Ocurre cuando el puntero del mouse deja un elemento.
    
- `keydown` / `keyup` - Ocurren cuando se presiona o se suelta una tecla.
    
- `submit` - Ocurre cuando se envía un formulario.
    
- `load` - Ocurre cuando una página web se ha cargado completamente.
    

---

### **5. Traversing del DOM**

El **traversing** o "recorrido" del DOM es el proceso de navegar entre los nodos del DOM para acceder a los elementos relacionados.

#### **5.1. Propiedades para Recorrer el DOM**

- `element.parentNode` - Accede al nodo padre del elemento.
    
    `let parentElement = document.getElementById("miElemento").parentNode;`
    
- `element.children` - Obtiene todos los nodos hijos de un elemento.
    
    `let childElements = document.getElementById("miElemento").children;`
    
- `element.firstChild` / `element.lastChild` - Accede al primer o último nodo hijo de un elemento.
    
    `let firstChild = document.getElementById("miElemento").firstChild; let lastChild = document.getElementById("miElemento").lastChild;`
    
- `element.previousSibling` / `element.nextSibling` - Accede al nodo anterior o siguiente de un nodo en el mismo nivel.
    
    `let previousNode = document.getElementById("miElemento").previousSibling;`
    

---

### **6. El DOM y el Modelo de Estilos (CSSOM)**

El **CSSOM** (CSS Object Model) es similar al DOM, pero representa los estilos de una página. JavaScript puede interactuar tanto con el DOM como con el CSSOM para cambiar dinámicamente los estilos de los elementos en la página.

#### **6.1. Manipulación de Clases CSS**

- `element.classList.add(className)` - Añade una clase a un elemento.
    
    `document.getElementById("miElemento").classList.add("nuevaClase");`
    
- `element.classList.remove(className)` - Elimina una clase de un elemento.
    `document.getElementById("miElemento").classList.remove("nuevaClase");`
    
- `element.classList.toggle(className)` - Añade la clase si no está presente, o la elimina si ya está.
`document.getElementById("miElemento").classList.toggle("nuevaClase");`