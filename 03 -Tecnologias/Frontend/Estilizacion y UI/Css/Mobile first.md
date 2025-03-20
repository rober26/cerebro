El enfoque **Mobile First** prioriza el diseño para dispositivos móviles y luego lo adapta a pantallas más grandes utilizando media queries.

---
### **1. Media Queries en Mobile First**

Las **media queries** permiten aplicar estilos específicos según el tamaño de pantalla.

#### **Sintaxis general**
`@media (min-width: tamaño) {     /* Estilos para pantallas más grandes */ }`

`min-width`: Se aplican los estilos cuando el ancho mínimo de la pantalla es el especificado o mayor.
Se recomienda definir primero los estilos para móviles y luego usar `min-width` para adaptarlos a pantallas más grandes.

### **2. Tipos de Media Queries**

#### **Por ancho de pantalla**

`@media (min-width: 768px) {}` → Estilos para tablets.
`@media (min-width: 1024px) {}` → Estilos para escritorio.
`@media (min-width: 1440px) {}` → Estilos para pantallas grandes.

#### **Por orientación**

`@media (orientation: portrait) {}` → Estilos cuando la pantalla está en vertical.
`@media (orientation: landscape) {}` → Estilos cuando la pantalla está en horizontal.

#### **Por resolución**

`@media (min-resolution: 2dppx) {}` → Para pantallas retina o de alta densidad.

### **3. Buenas Prácticas en Mobile First**

- Usar unidades relativas (`em`, `rem`, `%`) en lugar de píxeles fijos.
- Optimizar imágenes para reducir tiempos de carga.
- Minimizar el uso de efectos y animaciones pesadas en móviles.
- Priorizar la velocidad y rendimiento con carga diferida de recursos.
- Diseñar con una estructura simple y adaptable.