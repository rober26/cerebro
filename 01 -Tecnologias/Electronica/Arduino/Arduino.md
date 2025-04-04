## **Apuntes de Arduino**

### **1. ¿Qué es Arduino?**

Arduino es una plataforma de desarrollo de hardware libre basada en una placa con un microcontrolador y un entorno de desarrollo (IDE) que permite escribir código y cargarlo fácilmente a la placa. Se utiliza para crear proyectos interactivos que combinan sensores, actuadores y programación.

---

### **2. Componentes de una placa Arduino típica (como Arduino UNO)**

- Microcontrolador: ATmega328P
- Pines digitales (0-13): Usados para entradas y salidas digitales
- Pines analógicos (A0-A5): Usados para leer señales analógicas
- GND: Tierra (negativo)
- 5V y 3.3V: Salidas de voltaje
- Botón de reset
- Puerto USB: Para cargar el programa y alimentar la placa

---

### **3. Tipos de datos en Arduino**

- `int`: Enteros (−32,768 a 32,767)
- `float`: Números con decimales
- `char`: Un solo carácter
- `boolean`: Verdadero (true) o falso (false)
- `String`: Cadena de texto

---

### **4. Estructura básica de un programa (sketch)**

`void setup() {`   
`// Se ejecuta una vez al inicio` 
`}`  
`void loop() {`   
`// Se ejecuta repetidamente` 
`}`

---

### **5. Funciones básicas**

- `pinMode(pin, modo)`: Configura un pin como entrada o salida
- `digitalWrite(pin, valor)`: Escribe un valor HIGH o LOW en un pin digital
- `digitalRead(pin)`: Lee el valor de un pin digital
- `analogRead(pin)`: Lee el valor de un pin analógico (0 a 1023)
- `analogWrite(pin, valor)`: Escribe un valor PWM (0 a 255) en un pin con salida analógica simulada

---

### **6. Ejemplo básico: Parpadeo de un LED**

`void setup() {`   
	`pinMode(13, OUTPUT); // LED conectado al pin 13` 
`}`  
`void loop() {`   
	`digitalWrite(13, HIGH);  // Encender LED`   
	`delay(1000);             // Esperar 1 segundo`   
	`digitalWrite(13, LOW);   // Apagar LED`   
	`delay(1000);             // Esperar 1 segundo` 
`}`

---

### **7. Lectura de sensores analógicos**

Ejemplo con un potenciómetro conectado a A0:

`int valor = analogRead(A0);`

---

### **8. Salida PWM (modulación por ancho de pulso)**

Permite controlar intensidad de luces o velocidad de motores:

`analogWrite(9, 128); // Valor entre 0 (apagado) y 255 (máximo)`

---

### **9. Comunicación serial**

Usada para enviar y recibir datos desde la computadora:

`Serial.begin(9600);         // Inicializa la comunicación Serial.println("Hola");     // Envía texto 
`int dato = Serial.read();   // Lee un dato recibido`

---

### **10. Bibliotecas**

Permiten extender las funciones del Arduino para manejar módulos como pantallas LCD, sensores de temperatura, motores, etc.

Ejemplo:

`#include <Servo.h>`  
`Servo miServo;  

`void setup() {`  
`miServo.attach(9); // Conecta el servo al pin 9` 
`}` 
`void loop() {`   
`miServo.write(90); // Mueve el servo a 90 grados` 
`}`

---

### **11. Proyectos comunes para principiantes**
- LED que parpadea
- Semáforo con LEDs
- Lectura de sensor de temperatura (LM35, DHT11)
- Control de servo motor
- Sensor de luz con LDR
- Control de un motor DC con transistor y PWM

---

### **12. Consejos**

- Siempre revisar conexiones antes de alimentar la placa
- Utilizar resistencias con LEDs
- No conectar motores directamente al Arduino sin protección
- Utilizar protoboard para pruebas sin soldadura