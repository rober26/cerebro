CSS Grid Layout es un sistema de diseño bidimensional que permite crear diseños de página complejos de manera sencilla. Se basa en un modelo de filas y columnas, lo que facilita la colocación de elementos en una cuadrícula de manera flexible y controlada.

---

## **Terminología Básica:**

- **Grid Container (Contenedor de la cuadrícula):** El elemento que actúa como contenedor para los elementos que se colocarán en la cuadrícula. Se define utilizando la propiedad `display: grid`.
    
- **Grid Items (Elementos de la cuadrícula):** Los elementos hijos del contenedor que se colocarán dentro de la cuadrícula.
    
- **Grid Lines (Líneas de la cuadrícula):** Las líneas horizontales y verticales que dividen el contenedor en filas y columnas.
    
- **Grid Tracks (Rieles de la cuadrícula):** Las filas o columnas dentro de la cuadrícula. Son los espacios entre las líneas de la cuadrícula.
    
- **Grid Cells (Celdas de la cuadrícula):** Las intersecciones entre las filas y columnas, donde se colocan los elementos.
    

---

## **Propiedades del Contenedor de la Cuadrícula:**

1. **display: grid;**
    
    - Define el contenedor como una cuadrícula. Los elementos hijos de este contenedor se convertirán en elementos de la cuadrícula.
    
    `.container {     display: grid; }`
    
2. **grid-template-columns:**
    
    - Define las columnas de la cuadrícula. Puedes usar valores como `px`, `%`, `fr` (fracción) o `auto`.
    
    `.container {     grid-template-columns: 1fr 2fr 1fr; /* Tres columnas */ }`
    
3. **grid-template-rows:**
    
    - Define las filas de la cuadrícula. Similar a `grid-template-columns`, puedes usar valores específicos para las filas.
    
    `.container {     grid-template-rows: 100px auto 50px; }`
    
4. **grid-template-areas:**
    
    - Define el diseño de la cuadrícula usando nombres de áreas. Es útil para layouts complejos.
    
    `.container {     grid-template-areas:          "header header header"         "sidebar main main"         "footer footer footer"; }`
    
5. **grid-gap (o gap):**
    
    - Define el espacio entre las filas y columnas de la cuadrícula.
    
    `.container {     gap: 20px; }`
    

---

## **Propiedades de los Elementos de la Cuadrícula:**

1. **grid-column:**
    
    - Controla en qué columnas se ubica un elemento. Puedes usar números de línea de la cuadrícula para indicar las posiciones.
    
    `.item {     grid-column: 1 / 3; /* El elemento abarca desde la columna 1 hasta la columna 3 */ }`
    
2. **grid-row:**
    
    - Controla en qué filas se ubica un elemento.
    
    `.item {     grid-row: 2 / 4; /* El elemento abarca desde la fila 2 hasta la fila 4 */ }`
    
3. **grid-column-start / grid-column-end:**
    
    - Define el inicio y fin en las columnas de la cuadrícula.
    
    `.item {     grid-column-start: 1;     grid-column-end: 4; }`
    
4. **grid-row-start / grid-row-end:**
    
    - Define el inicio y fin en las filas de la cuadrícula.
    
    
    `.item {     grid-row-start: 1;     grid-row-end: 3; }`
    

---

## **Funciones Avanzadas:**

1. **fr (fracción):**
    
    - Es una unidad relativa que se usa para distribuir el espacio disponible entre las columnas o filas. Por ejemplo, `1fr` y `2fr` dividirían el espacio en proporciones 1:2.
    
    `.container {     grid-template-columns: 1fr 2fr; /* La segunda columna tiene el doble de espacio que la primera */ }`
    
2. **auto-fit / auto-fill:**
    
    - Estas funciones permiten que las columnas o filas se ajusten automáticamente a los elementos contenidos dentro de ellas.
    
    `.container {     grid-template-columns: repeat(auto-fill, minmax(200px, 1fr)); }`