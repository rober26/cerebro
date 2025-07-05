CSS Grid Layout es un sistema de diseño **bidimensional** que permite organizar contenido en **filas y columnas**, ofreciendo una forma muy flexible y potente para construir layouts complejos como galerías, dashboards, secciones de una web, etc.

---
## 🧩 **Terminología Básica**

| Término            | Definición                                                                      |
| ------------------ | ------------------------------------------------------------------------------- |
| **Grid Container** | Elemento que contiene los elementos a organizar. Se activa con `display: grid`. |
| **Grid Items**     | Hijos directos del contenedor que se distribuyen dentro de la cuadrícula.       |
| **Grid Lines**     | Líneas horizontales y verticales que dividen la cuadrícula.                     |
| **Grid Tracks**    | Filas o columnas (espacios entre líneas).                                       |
| **Grid Cells**     | Celdas individuales formadas por la intersección entre filas y columnas.        |
| **Grid Areas**     | Áreas nombradas dentro del grid que pueden ser ocupadas por los elementos.      |

---

## 🧰 **Propiedades del Contenedor Grid**

### 1. `display: grid;`

Convierte un contenedor en una cuadrícula.

`.container {   display: grid; }`

### 2. `grid-template-columns` / `grid-template-rows`

Define el número y tamaño de columnas/filas. Puede usarse con unidades (`px`, `fr`, `%`, `auto`), funciones como `repeat()` o nombres de líneas entre corchetes (`[]`).
````
.container {   
	grid-template-columns:     
	[col-start]1fr[col-1-end col-2-start]2fr[col-2-end col-3-start]1fr[col-3-end]; 
	
	grid-template-rows:     
	[fil-start]1fr[fil-1-end fil-2-start]2fr[fil-2-end fil-3-start]1fr[fil-3-end]; }
````
💡 **`fr`** = fracción del espacio restante (ej: `1fr 2fr 1fr` reparte en 25%-50%-25%).

### 3. `grid-template-areas`

Define áreas usando nombres personalizados:
````
.container {   
	grid-template-areas:     
		"header header header"  "sidebar main main"  "footer footer footer"; 
}
````
### 4. `gap` (anteriormente `grid-gap`)

Espacio entre filas y columnas:

`.container {   gap: 20px; }`

---

## 📦 **Propiedades de los Elementos Grid**

### 1. `grid-column` / `grid-row`

Controlan la posición de los elementos dentro del grid:
````
.item {   
	grid-column: 1 / 3;  /* de columna línea 1 a 3 */   
	grid-row: 2 / 4;     /* de fila línea 2 a 4 */ 
}
````
### 2. `grid-column-start` / `grid-column-end`

Más detallado:
````
.item {   
	grid-column-start: col-start;   
	grid-column-end: col-2-end; 
}
````
### 3. `grid-row-start` / `grid-row-end`
````
.item {   
	grid-row-start: fil-start;   
	grid-row-end: fil-2-end; 
}
````
---

## 🧠 **Funciones Avanzadas**

### 1. `fr` (fracción)

Distribuye el espacio restante proporcionalmente.

`grid-template-columns: 1fr 2fr;`

### 2. `auto-fit` / `auto-fill`

Autoajusta el número de columnas:

```
grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
```

---

## 🎯 **Ubicación por líneas nombradas (Ejemplo específico)**
````
.img1 {   
	grid-column: col-start;   
	grid-row: fil-start; 
}  
.img4 {   
	grid-column: col-2;   
	grid-row: fil-2; 
}
````
🔸 Los **nombres de línea** (`col-start`, `fil-2`, etc.) se definen entre `[]` en `grid-template-columns` y `grid-template-rows`. Permiten ubicar con precisión cada elemento.

---

## 🔀 **Uso combinado con Flexbox**

Puedes usar **Flexbox dentro de Grid**, por ejemplo para alinear el contenido de una celda:
````
.galeria__titulo {   
	display: flex;   
	justify-content: center;   
	align-items: center;   
	gap: 10px;   
	grid-column: col-2; 
}
````
---

## 🖼️ **object-fit en imágenes Grid**

`.galeria__img {   object-fit: fill; }`

🔸 `fill`: Estira la imagen para que ocupe todo el espacio, **aunque se deforme**.

---

## ✅ **Resumen Visual del Grid (Ejemplo)**

|Línea|Columna|Tamaño|
|---|---|---|
|col-start|1.ª columna|1fr|
|col-2|2.ª columna|2fr|
|col-3|3.ª columna|1fr|

|Línea|Fila|Tamaño|
|---|---|---|
|fil-start|1.ª fila|1fr|
|fil-2|2.ª fila|2fr|
|fil-3|3.ª fila|1fr|