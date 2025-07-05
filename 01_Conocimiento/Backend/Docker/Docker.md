**Docker** es una plataforma de código abierto que permite **crear, distribuir y ejecutar aplicaciones en contenedores**. Los contenedores son entornos ligeros, portátiles y aislados que incluyen todo lo necesario para que una aplicación funcione de manera consistente en cualquier sistema.

# **Conceptos clave de Docker** 

- **Imagen (Image):** Es una plantilla inmutable con el sistema operativo, dependencias y aplicación lista para ejecutarse.
- **Contenedor (Container):** Es una instancia en ejecución de una imagen.
- **Dockerfile:** Archivo donde se define cómo construir una imagen.
- **Docker Hub:** Repositorio público donde se almacenan imágenes de Docker.
- **Docker Compose:** Herramienta para definir y ejecutar múltiples contenedores con un solo comando.
- **Orquestadores:** Herramientas como Kubernetes que permiten administrar múltiples contenedores en producción.

# **Instalación en Linux:**
### **1. Actualizar el sistema**
Primero, asegúrate de que tu sistema esté actualizado:

`sudo apt-get update/sudo apt-get upgrade`
### **2. Instalar paquetes necesarios**
Instala los paquetes para permitir que apt utilice un repositorio a través de HTTPS:

`sudo apt-get install \ apt-transport-https \ ca-certificates \ curl \ gnupg-agent \ software-properties-common`
### **3. Agregar la clave GPG de Docker**
Agrega la clave GPG oficial de Docker a tu sistema:

`curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -`
### **4. Agregar el repositorio de Docker**
Agrega el repositorio de Docker a las fuentes de apt:

`sudo add-apt-repository \ "deb [arch=amd64] https://download.docker.com/linux/ubuntu \ $(lsb_release -cs) \ stable"`
### **5. Actualizar el índice de paquetes**
Después de agregar el repositorio de Docker, actualiza el índice de paquetes:
`sudo apt-get update`
### **6. Instalar Docker**
Instala Docker
`sudo apt-get install docker-ce`
### **7.Instalar docker compose**
`sudo curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose`

# **Comandos:**
### **Gestión de imágenes**
### Descargar una imagen
`docker pull <imagen >`
### Descargar e iniciar una imagen
`docker run <imagen>` 
### Listar imágenes
`docker images`
### Eliminar una imagen
`docker rmi <imagen>`
### **Gestión de Contenedores**
### Listar contenedores en ejecución
`docker ps`
### Listar todos los contenedores (en ejecución y detenidos)
`docker ps -a`
### Iniciar un contenedor específico
`docker start <id-contenedor>`
### Mostrar logs de un contenedor
`docker logs <id-contenedor>`
### Ejecutar un comando en un contenedor en ejecución
`docker exec <id-contenedor> <comando>`
### Detener un contenedor en ejecución
`docker stop <id-contenedor>`
### Eliminar un contenedor
`docker rm <id-contenedor>`
### **Volúmenes**
### Crear un volumen
`docker volume create <nombre-volumen>`
### Listar volúmenes
`docker volume ls`
### Eliminar un volumen
`docker volume rm <nombre-volumen>`
### **Redes**
### Crear una red
`docker network create <nombre-red>`
### Listar redes
`docker network ls`
### Conectar un contenedor a una red
`docker network connect <nombre-red> <id-contenedor>`
### Desconectar un contenedor de una red
`docker network disconnect <nombre-red> <id-contenedor>`
### **Información y Estadísticas**

### Ver el uso de recursos de todos los contenedores
`docker stats`
### Ver información detallada sobre un contenedor
`docker inspect <id-contenedor>`
### Ver información detallada sobre una imagen
`docker inspect <imagen>`
### **Otros Comandos Útiles**
### Renombrar un contenedor
`docker rename <id-contenedor> <nuevo-nombre>`
### Detener todos los contenedores en ejecución
`docker stop $(docker ps -q)`
### Eliminar todos los contenedores detenidos
`docker rm $(docker ps -a -q)`
### Eliminar todas las imágenes no utilizadas
`docker image prune`
### Eliminar todos los contenedores detenidos y todas las imágenes no referenciadas por ningún contenedor
`docker system prune`

Referencias:
[[Dockerfile]]
[[Docker]]