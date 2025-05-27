# TornStation 🛰️

TornStation es una estación doméstica inteligente y modular, basada en ESP32, que actúa como interfaz de usuario para un servidor personal. Su función principal es ser el nodo físico de un ecosistema inteligente: actúa como panel de control, asistente personal, interfaz de comunicación LoRa/WiFi/Bluetooth, y punto de interacción con sistemas domóticos.

## 🎯 Objetivos del Proyecto

- Crear un dispositivo compacto, modular y siempre encendido.
- Proveer interfaz de entrada y salida de información (pantalla, voz, sensores).
- Comunicación con servidor propio para peticiones, control domótico y funciones de asistente.
- Soporte de múltiples apps internas, estilo mini sistema operativo.
- Interfaz natural mediante voz, pantalla, botones y red.

## 🧩 Componentes Principales

- **Microcontrolador**: ESP32-WROOM / ESP32-S3
- **Pantalla**: TFT 1.8" SPI (ST7735/ST7789) o 2.4" táctil si hay espacio
- **Audio**: micrófono I2S (INMP441) + amplificador MAX98357A + altavoz
- **LEDs**: WS2812B para retroalimentación visual
- **Control físico**: rotary encoder + joystick + botones
- **Conectividad**:
  - WiFi + Bluetooth (integrados)
  - LoRa (SX1278)
  - UART para GPS (opcional)
  - I2C para sensores o módulos adicionales
- **Almacenamiento**: microSD SPI (opcional para logs/audio)

---

## 🧠 Asistente Personal + Servidor

TornStation funciona como interfaz de voz o táctil, conectada a un servidor personal (Raspberry Pi, PC o VPS). Este servidor ejecuta el motor del asistente:

### 🔗 Flujo del asistente:

1. Usuario dice: "Enciende la luz del salón"
2. TornStation captura el audio (I2S)
3. Envío del audio al servidor por WiFi (HTTP o WebSocket)
4. El servidor transcribe, interpreta y ejecuta la orden
5. Si es domótica: usa MQTT/HTTP/etc.
6. Envía respuesta ("Luz encendida") a TornStation
7. TornStation lo reproduce por voz o pantalla

---

## 🏠 Control Domótico

El servidor ejecuta el módulo de domótica, compatible con:

- **MQTT**: para bombillas, interruptores, sensores
- **HTTP APIs**: dispositivos WiFi y plataformas externas
- **Home Assistant**: integración completa
- **Node-RED**: lógica visual de control

### 🔌 Dispositivos compatibles:

| Tipo              | Ejemplo                    | Control vía         |
|-------------------|----------------------------|---------------------|
| Bombillas         | Tasmota, Shelly, Tuya hack | MQTT / HTTP         |
| Enchufes          | Sonoff, ESP8266+Relé       | MQTT / GPIO local   |
| Motores / Persianas | DIY con relé doble         | MQTT                |
| Sensores          | Movimiento, temperatura     | MQTT                |

### 🧾 Ejemplo de comando

plaintext
Usuario: "Asistente, apaga las luces del dormitorio"
→ TornStation → Servidor
→ Interpreta texto
→ MQTT → topic: home/lights/dormitorio → payload: OFF
→ Confirmación devuelta: "Luces apagadas"

📲 Sistema de Apps (modo modular)
TornStation soporta múltiples "apps" como mini programas. Ejemplos:

🎵 Reproductor MP3 local

📡 Monitor LoRa/GPS

📻 Radio FM o Web

🧭 Dashboard sensores

💬 Terminal de chat

🧠 Módulo asistente personal

La navegación entre apps se hace con rotary encoder o menú táctil.

🔧 Pines ESP32 Sugeridos

| Función            | Componente       | Pin ESP32       |
|--------------------|------------------|-----------------|
| Pantalla TFT (SPI) | ST7789/GC9A01    | 18 (SCK), 23 (MOSI), 5 (CS), 2 (DC), 4 (RST) |
| Micrófono I2S      | INMP441          | 14 (WS), 27 (SD), 12 (SCK) |
| Altavoz I2S        | MAX98357A        | 25 (LRC), 26 (BCLK), 22 (DIN) |
| LoRa SX1278        | SPI              | 18, 23, 19, 5, 4 (DIO0) |
| Encoder Rotativo   | KY-040           | 32 (CLK), 33 (DT), 25 (SW) |
| Joystick           | PS2              | 34 (X), 35 (Y), 26 (SW) |
| LEDs WS2812B       | LED              | 21               |
| I2C (expansión)    | RDA5807M, sensores| 13 (SDA), 15 (SCL) |
🔮 Ideas futuras
Interfaz táctil completa

Reconocimiento facial o QR

Sincronización NTP + RTC hardware

Módulo celular (SIM800L / LTE)

Reconocimiento de voz offline con Vosk o Picovoice