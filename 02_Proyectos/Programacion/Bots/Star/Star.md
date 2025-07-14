## Descripción General

**Star** es el asistente personal del ecosistema **Torn**, diseñado para ser el núcleo inteligente de interacción por voz, control domótico, automatización, respuestas contextuales y conexión entre dispositivos Torn. Se ejecuta en un servidor central y se comunica con otros módulos y dispositivos a través de HTTP, MQTT y WebSocket.

---

## 🧱 Arquitectura del Sistema

+------------------------+ +--------------------------+
| TornStation / TornWear | <------> | Star Assistant |
| (dispositivo físico) | HTTP | (FastAPI en Docker) |
+------------------------+ +--------------------------+
↑ ↑
| MQTT / API REST |
↓ ↓
+------------------+ +------------------------+
| Domótica (HA) | | Servidor Torn central |
| MQTT / HomeKit | | Base de datos |
+------------------+ +------------------------+

---

## 🐳 Docker Setup

### Estructura del Proyecto

star/
├── Dockerfile
├── docker-compose.yml
├── requirements.txt
└── app/
├── main.py
├── skills/
│ ├── init.py
│ ├── lights.py
│ ├── weather.py
│ └── system.py
└── utils/
└── nlu.py

---

### Dockerfile

```
FROM python:3.11-slim

ENV PYTHONDONTWRITEBYTECODE 1
ENV PYTHONUNBUFFERED 1

RUN apt-get update && apt-get install -y \
    ffmpeg \
    libsndfile1 \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /usr/src/app
COPY requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt
COPY ./app ./app

CMD ["uvicorn", "app.main:app", "--host", "0.0.0.0", "--port", "8000"]
```

requirements.txt
```
fastapi
uvicorn
requests
pydantic
python-multipart
vosk
soundfile
```

docker-compose.yml
```
version: '3.8'

services:
  star:
    build: .
    container_name: star_assistant
    ports:
      - "8000:8000"
    volumes:
      - ./app:/usr/src/app/app
    restart: unless-stopped
```

🧠 Star Core – main.py
```
from fastapi import FastAPI, Request
from app.skills import lights, weather, system

app = FastAPI()

@app.post("/query")
async def query_endpoint(request: Request):
    data = await request.json()
    text = data.get("text", "")
    for skill in [lights, weather, system]:
        result = skill.handle(text)
        if result:
            return {"response": result}
    return {"response": "No entendí el comando."}
```

### Skills (Habilidades)

lights.py
```
def handle(text):
    if "enciende" in text and "luz" in text:
        return "Luz encendida"
    if "apaga" in text and "luz" in text:
        return "Luz apagada"
    return None
```

weather.py (ejemplo)
```
import requests

def handle(text):
    if "clima" in text or "tiempo" in text:
        # Placeholder para API real
        return "El clima es soleado con 25°C."
    return None
```
### API de Comunicación
Endpoint principal
```
POST /query
Content-Type: application/json

{
  "text": "enciende la luz del salón"
}

→ Respuesta:
{
  "response": "Luz encendida"
}
```

Dispositivos Torn pueden enviar texto procesado por voz o peticiones directamente a este endpoint.

## Procesamiento de Voz
En versiones futuras (o con configuración adicional), Star podrá:

Recibir audio y convertirlo a texto (STT) con VOSK

Enviar texto a audio (TTS) usando gTTS, pyttsx3 o servicios externos

🌐 Integración con el Ecosistema Torn
Dispositivos Clientes (Ej: TornStation, TornWear)
Se conectan a Star vía HTTP (/query)

También pueden publicar sus datos a Star vía MQTT

Star podrá responder o accionar sobre otros sistemas (ej: luces, sensores)

Domótica
Se conecta vía:

MQTT (broker local o Mosquitto)

Home Assistant API

Node-RED (si se desea flujo visual)

🛠️ Extensiones Futuras
Interfaz web local de control

Reconocimiento facial (Jetson Nano / Raspberry Pi)

GPT / IA avanzada para comprensión natural

Procesamiento local offline

Soporte multilingüe

🧠 Ideas de Skills Futuras
Control de luces, enchufes, sensores

Módulo de calendario y alarmas

Notificaciones (por Telegram, Email)

Consultas: clima, noticias, tráfico, temperatura

Tareas automatizadas: rutinas diarias, control de energía

Acceso remoto a TornStation