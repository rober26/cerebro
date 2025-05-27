## 💻 Descripción General

Un mini ordenador de muñeca estilo Pip-Boy, diseñado para ser compacto, modular y multifuncional. Basado en el microcontrolador **ESP32-S3**, este dispositivo es capaz de ejecutar apps como GPS, mensajería LoRa, grabadora de voz, sensores ambientales y más. Además, cuenta con conectividad WiFi y Bluetooth para integrarse con servidores y otros dispositivos.

---

## ✨ Características Clave

- Microcontrolador ESP32-S3 (dual-core, WiFi, BLE, USB nativo)
- Pantalla TFT cuadrada (SPI)
- Control por rotary encoder o joystick
- Sistema de apps con menú navegable
- Conectividad: LoRa, WiFi, Bluetooth, UART, I2C, SPI
- Almacenamiento con microSD
- Audio: micrófono digital + altavoz I2S
- Módulos conectables: sensores, GPS, radio FM
- Carcasa impresa en 3D, estilo retro-futurista

---

## 🏃‍♂️ Estructura de Software: Sistema de Apps

Cada app es una función independiente en el código, activada por un menú principal:

cpp

CopiarEditar

`enum AppID { APP_MENU, APP_GPS, APP_LORA, APP_AUDIO, APP_SENSOR }; AppID currentApp = APP_MENU;  void loop() {   switch (currentApp) {     case APP_MENU:   showMenu(); break;     case APP_GPS:    runGPS(); break;     case APP_LORA:   runLoRa(); break;     case APP_AUDIO:  runAudio(); break;     case APP_SENSOR: runSensors(); break;   }   handleInput(); }`

---

## 🌍 Módulos y Funciones Planeadas

|Módulo / App|Funciones|
|---|---|
|GPS (UART)|Ubicación, seguimiento, datos de satélites|
|LoRa (SPI)|Comunicación sin Internet, mensajería local|
|Audio (I2S)|Grabación y reproducción de notas de voz|
|Sensor ambiental|Temperatura, presión, humedad (BME280, I2C)|
|Almacenamiento (SD)|Guarda logs, grabaciones, configuraciones|
|Conexión WiFi|Sincronización con servidor personal, actualización de datos|
|Radio FM (I2C)|Receptor de radio con salida por altavoz|

---

## 📊 Conexiones de Hardware (ESP32-S3)

|Componente|Conexión|Pines sugeridos ESP32-S3|
|---|---|---|
|Pantalla TFT (SPI)|SPI|SCLK=18, MOSI=23, CS=5, DC=2, RST=4|
|Rotary Encoder|Digital|CLK=32, DT=33, SW=25|
|Joystick PS2|Analog/Dig|X=34, Y=35, SW=26|
|Micrófono I2S|I2S|WS=14, SD=27, SCK=12|
|Altavoz I2S|I2S|LRC=25, BCLK=26, DIN=22|
|GPS (UART)|UART|RX=16, TX=17|
|LoRa SX1278|SPI|MISO=19, MOSI=23, SCK=18, CS=5, DIO0=4|
|Radio FM (I2C)|I2C|SDA=13, SCL=15|
|Lector microSD|SPI|MISO=19, MOSI=23, SCK=18, CS=2|

---

## 💡 Ideas Adicionales para Apps Futuras

- Control remoto por Bluetooth para PC o smartphone
    
- Juegos simples (Snake, Pong, etc.)
    
- App de estado del sistema: batería, red, almacenamiento
    
- Modo terminal retro (estilo consola DOS)
    
- Enlace con sensores externos vía I2C (por puerto de expansión)
    

---

## 🛠️ Siguientes pasos

1. Diseñar carcasa compacta y modular (3D o láser)
    
2. Implementar software base (menú, sistema de apps)
    
3. Integrar almacenamiento y configuración por microSD
    
4. Probar conectividad WiFi/LoRa con servidor personal
    
5. Optimizar consumo para uso prolongado con batería