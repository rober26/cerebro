Flexbox (Flexible Box Layout) es un modelo de diseño en [[CSS]] que permite organizar y distribuir elementos en un contenedor de forma eficiente, incluso cuando sus tamaños son dinámicos o desconocidos. Su principal ventaja es la facilidad para alinear y distribuir elementos en diferentes direcciones y tamaños, sin necesidad de usar float o position.

## 1. Conceptos Básicos de Flexbox
Flexbox se basa en un contenedor flexible (flex container) y sus elementos flexibles (flex items). Para activar Flexbox en un contenedor, se usa:

`display: flex;`
Esto convierte los hijos directos en elementos flexibles.

### Ejes en Flexbox
Flexbox trabaja con dos ejes:
- Eje principal (Main Axis): Depende de flex-direction. Puede ser horizontal (row) o vertical ([column]()).
- Eje secundario (Cross Axis): Perpendicular al eje principal.

Ejemplo con `flex-direction: row;`
Main Axis →  (izquierda a derecha)
Cross Axis ↓  (de arriba a abajo)

Ejemplo con `flex-direction: column;`
Main Axis ↓  (de arriba a abajo)
Cross Axis →  (de izquierda a derecha)

## 2. Propiedades del Contenedor Flex
Estas propiedades afectan a los elementos dentro del contenedor.

### 2.1 `flex-direction`
Define la dirección de los elementos dentro del contenedor:

`flex-direction: row;`  Predeterminado: de izquierda a derecha 
`flex-direction: row-reverse;`  De derecha a izquierda 
`flex-direction: column;`  De arriba hacia abajo 
`flex-direction: column-reverse;`  De abajo hacia arriba 

### 2.2 `justify-content` (Alineación en el Eje Principal)
Controla cómo se distribuyen los elementos a lo largo del eje principal.

`justify-content: flex-start;` Alineados al inicio
`justify-content: flex-end;` Alineados al final 
`justify-content: center;`  Centrados 
`justify-content: space-between;`  Espacio uniforme entre elementos 
`justify-content: space-around;`  Espacio igual alrededor de cada elemento 
`justify-content: space-evenly;` Espaciado uniforme entre y alrededor de los elementos 

### 2.3 `align-items` (Alineación en el Eje Secundario)
Controla cómo se alinean los elementos en el eje secundario.

`align-items: flex-start;`  Arriba 
`align-items: flex-end;`  Abajo 
`align-items: center;`  Centrado 
`align-items: stretch;`  Se estiran para ocupar todo el alto 
`align-items: baseline;`  Alineados según la línea base del texto 

### 2.4 `align-content` (Solo para Múltiples Líneas)
Alinea grupos de elementos cuando hay múltiples líneas (si `flex-wrap: wrap;`).

`align-content: flex-start;`
`align-content: flex-end;`
`align-content: center;`
`align-content: space-between;`
`align-content: space-around;`
`align-content: space-evenly;`

### 2.5 `flex-wrap` (Control de Desbordamiento)
Por defecto, los elementos intentan ajustarse en una sola línea. flex-wrap permite definir el comportamiento cuando no caben en el contenedor.

`flex-wrap: nowrap;` Predeterminado: todo en una línea 
`flex-wrap: wrap;` Permite múltiples líneas si es necesario 
`flex-wrap: wrap-reverse;` Igual que wrap, pero en orden inverso 

### 2.6 `gap` (Espaciado Entre Elementos)
Define el espacio entre los elementos flexibles sin afectar los bordes del contenedor.

`gap: 10px;` Espacio de 10px entre los elementos 
`row-gap: 10px;`  Espacio entre filas 
`column-gap: 20px;`  Espacio entre columnas

## 3. Propiedades de los Elementos Flexibles
Estas propiedades afectan individualmente a cada elemento dentro de un contenedor flex.

### 3.1 flex-grow (Crecimiento)
Define cuánto puede crecer un elemento en relación con los demás.

`flex-grow: 1;`  El elemento ocupa todo el espacio disponible 
`flex-grow: 0;`  No crece más allá de su tamaño inicial (predeterminado) 
Ejemplo:

`.item1 { flex-grow: 1; }`
`.item2 { flex-grow: 2; }`  Ocupará el doble de espacio que item1 
### 3.2 flex-shrink (Encogimiento)
Define cuánto puede reducirse un elemento si no hay suficiente espacio.

`flex-shrink: 1;`  Predeterminado: se encoge si es necesario 
`flex-shrink: 0;`  No se encoge 
### 3.3 flex-basis (Tamaño Inicial)
Define el tamaño inicial de un elemento antes de aplicar flex-grow o flex-shrink.

`flex-basis: auto;`  Tamaño basado en el contenido 
`flex-basis: 100px;`  Tamaño fijo de 100px 

### 3.4 flex (Shorthand)
Agrupa flex-grow, flex-shrink y flex-basis en una sola línea.

`flex: 1 1 auto;  grow: 1, shrink: 1, basis: auto` 
`flex: 2 0 100px;  grow: 2, shrink: 0, basis: 100px` 

### 3.5 align-self (Alineación Individual)
Permite cambiar la alineación de un elemento sin afectar a los demás.

`align-self: flex-start;`
`align-self: flex-end;`
`align-self: center;`
`align-self: stretch;`

### 3.6 order (Orden de los Elementos)

Define el orden de aparición de los elementos en un contenedor flex, sin necesidad de modificar el HTML.

- `order: 0;`  Valor predeterminado
- `order: 1;`  Aparece después de elementos con `order: 0`
- `order: -1;`  Aparece antes de los elementos con `order: 0`

## 4. Ejemplo Práctico

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Flexbox Ejemplo</title>
    <style>
        .container {
            display: flex;
            flex-direction: row;
            justify-content: space-around;
            align-items: center;
            height: 200px;
            border: 2px solid black;
        }
        .item {
            width: 100px;
            height: 100px;
            background-color: lightblue;
            text-align: center;
            line-height: 100px;
            font-weight: bold;
        }
    </style>
</head>
<body>

    <div class="container">
        <div class="item">1</div>
        <div class="item">2</div>
        <div class="item">3</div>
    </div>

</body>
</html>
Explicación:
`display: flex;` activa Flexbox en el .container.
`flex-direction: row;` alinea los elementos en fila.
`justify-content: space-around;` distribuye los elementos con espacios iguales.
`align-items: center;` centra los elementos verticalmente.
