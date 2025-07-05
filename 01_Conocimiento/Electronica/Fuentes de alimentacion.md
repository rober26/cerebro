### **¿Qué es una fuente de alimentación?**

Una fuente de alimentación es un dispositivo que convierte energía eléctrica de un tipo a otro para proporcionar la tensión y corriente necesarias para que funcionen los circuitos electrónicos.

---

### **2. Tipos de fuentes de alimentación**

#### **2.1 Según la naturaleza de la salida**

- **Fuente de corriente continua (DC):** Salida estable y constante (como la de una batería o adaptador DC).
- **Fuente de corriente alterna (AC):** Salida en forma de onda senoidal, cambia de polaridad (como la que entrega el enchufe de casa).

#### **2.2 Según su construcción**

- **Lineales:**
    
    - Usan transformadores, rectificadores y reguladores.
    - Son más simples y generan poca interferencia.
    - Desventaja: Son grandes, pesadas y poco eficientes.
    
- **Conmutadas (SMPS – Switching Mode Power Supply):**
    
    - Transforman la energía usando transistores de conmutación.
    - Son más pequeñas, ligeras y eficientes.
    - Se usan en cargadores modernos, fuentes de PC, etc.

---

### **3. Partes de una fuente de alimentación lineal básica**

1. **Transformador:** Baja o sube el voltaje de entrada AC.
2. **Rectificador:** Convierte AC en pulsos positivos de DC (puente de diodos).
3. **Filtro:** Suaviza la señal con capacitores para reducir el rizado.
4. **Regulador:** Mantiene un voltaje constante de salida.

---

### **4. Reguladores de voltaje**

- **Lineales:**
    
    - **78xx:** Salida positiva fija (ej. 7805 = 5V, 7812 = 12V)
    - **79xx:** Salida negativa fija
    - **LM317:** Regulable (ajustable con resistencias)
    
- **Conmutados:**
    
    - **Buck:** Disminuye el voltaje (step-down)
    - **Boost:** Aumenta el voltaje (step-up)
    - **Buck-Boost:** Puede subir o bajar el voltaje
    

---

### **5. Características importantes**

- **Voltaje de salida (V):** Debe coincidir con lo que necesita el circuito.
- **Corriente máxima (A):** La fuente debe ser capaz de suministrar al menos la corriente que demanda el circuito.
- **Estabilidad:** Qué tanto varía el voltaje con carga.
- **Protección:** Algunas fuentes tienen protección contra sobrecarga, sobrecalentamiento, cortocircuito.

---

### **6. Ejemplos de fuentes usadas en proyectos**

|Fuente|Descripción|Uso común|
|---|---|---|
|Pilas/Baterías|Fuente portátil de CC|Proyectos móviles|
|Adaptador DC (9V, 12V)|Fuente fija de CC|Arduino, routers|
|Power bank|Fuente portátil con USB (5V)|Carga microcontroladores|
|Módulo Buck LM2596|Fuente conmutada ajustable|Convertir 12V a 5V, por ejemplo|
|Fuente de laboratorio|Voltaje y corriente regulable|Pruebas y desarrollo|

---

### **7. Consejos para elegir una fuente**

- Verifica el **voltaje necesario** del dispositivo.
- La **corriente de salida** debe ser igual o mayor a la que necesita el circuito.
- Si es conmutada, revisa que tenga **filtros adecuados** para evitar ruido eléctrico.
- No uses adaptadores baratos si conectas microcontroladores sensibles.
- Usa fusibles o diodos de protección para evitar daños.