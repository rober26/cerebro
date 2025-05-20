## 1. Descripción General

Este proyecto consiste en el diseño y construcción de un dispositivo portátil, modular y multifunción, basado en el microcontrolador ESP32. Combina funcionalidades de smartwatch, comunicador, consola interactiva, radio y walkie-talkie, integrando pantalla circular, interfaz LED, entradas de sonido y control físico mediante encoder rotativo y joystick.

## 2. Características Principales

- Microcontrolador ESP32 con WiFi y Bluetooth
	- Pantalla circular TFT (1.28", SPI)
	- Tira LED RGB direccionable (WS2812B)
	- Rotary encoder + Joystick PS2 (control analógico 5D)
- Micrófono digital I2S y altavoz con amplificador
- Módulos GPS (NEO-6M), LoRa (SX1278) y receptor de radio FM
- Almacenamiento externo mediante tarjeta microSD
- Alimentación por batería LiPo + circuito de carga y booster
	- Carcasa modular impresa en 3D o cortada en láser

## 3. Componentes Principales

### Microcontrolador

- ESP32 DevKit (ESP32-WROOM-32 o ESP32-S3)

### Pantallas e interfaz visual

- Pantalla circular GC9A01 (1.28") 240x240 px, SPI
- Tira LED WS2812B (8-16 LEDs)
- Condensador 1000 µF, Resistencia 330 Ohm

### Entrada de Usuario

- Rotary encoder KY-040 (con pulsador)
- Joystick tipo PS2

### Audio

- Micrófono I2S INMP441 o SPH0645
    
- Amplificador I2S MAX98357A
    
- Altavoz 8 Ohm / 1W
    

### Comunicaciones

- GPS NEO-6M o NEO-M8N (UART)
- Módulo LoRa SX1278 (SPI)
- Receptor de radio FM (como TEA5767 o RDA5807M, I2C)

### Almacenamiento

- Módulo lector de tarjeta microSD (SPI)
- Tarjeta microSD de 4GB o superior

### Alimentación

- Batería LiPo 3.7V 2500-5000 mAh
- Cargador TP4056 con protección
- Elevador de voltaje MT3608 (5V)
- Interruptor SPST

### Conectividad y montaje

- Protoboard o placa perforada
- Cables Dupont
- Carcasa 3D / láser + tornillería M2-M3

## 4. Diagrama de Conexión (Resumen)

- LED y pantalla: alimentación 5V desde booster, datos al ESP32
- Pantalla TFT: SPI (SCLK, MOSI, CS, DC, RST)
- Rotary encoder: 2 pines digitales + pulsador
- Joystick: 2 pines analógicos + digital
- Micrófono: I2S WS, SD, SCK
- Altavoz: datos I2S al MAX98357A
- GPS: UART TX/RX
- LoRa: SPI (compartido con pantalla si se multiplexa)
- Radio FM: I2C (SDA, SCL) + salida de audio al amplificador
- microSD: SPI (SCLK, MOSI, MISO, CS)

## 5. Software y Librerías

- Arduino IDE o PlatformIO
- FastLED o Adafruit_NeoPixel
- TFT_eSPI para pantalla GC9A01
- LoRa (RadioHead o arduino-LoRa)
- I2S para micrófono y salida de audio
- TEA5767 o RDA5807M para radio FM (librerías específicas)
- SD o SdFat para lectura/escritura en tarjeta microSD

## 6. Posibles Aplicaciones

- Comunicación LoRa sin internet (mensajes, datos GPS)
- Receptor de radio FM portátil
- Grabación y reproducción de audio
- Almacenamiento de datos de sensores o GPS
- Visualizador de estados y sensores
- Mini consola interactiva
- Controlador remoto modular

## 7. Futuras Mejoras

- Carcasa hermética y ergonómica
- Baterías intercambiables o carga inalámbrica
- Conectividad celular o LTE
- Reconocimiento de voz local o remoto
