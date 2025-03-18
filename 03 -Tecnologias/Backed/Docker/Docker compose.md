**ocker Compose** es una herramienta que permite definir y administrar múltiples contenedores [[Docker]] en una sola configuración. Se usa principalmente para aplicaciones con múltiples servicios, como una API, base de datos y frontend que necesitan ejecutarse juntas.
## **Instalar Docker Compose:**
`sudo apt-get update`
`sudo apt-get install docker-compose`
## **Conceptos Clave**
- Servicios: Definen los contenedores que componen tu aplicación.
- Volúmenes: Persisten los datos generados y utilizados por los contenedores.
- Redes: Configuran la comunicación entre los contenedores.
## **Estructura de un Archivo docker-compose.yml**
`version: '3'  # Versión del archivo de Docker Compose`

`services:  # Definición de los servicios`
  `db:  # Servicio de base de datos`
    `image: mariadb  # Imagen de Docker a usar`
    `restart: always  # Política de reinicio del contenedor`
    `volumes:`
      `- db:/var/lib/mysql  # Definición de volúmenes`
    `environment:  # Variables de entorno para configuración`
      `- MYSQL_ROOT_PASSWORD=contraseña`
      `- MYSQL_DATABASE=nextcloud`
      `- MYSQL_USER=nextcloud`
      `- MYSQL_PASSWORD=nextcloud`

  `app:  # Servicio de la aplicación Nextcloud`
    `image: nextcloud  # Imagen de Docker a usar`
    `ports:`
      `- 8080:80  # Mapeo de puertos`
    `links:`
      `- db  # Enlace al servicio de base de datos`
    `volumes:`
      `- nextcloud:/var/www/html  # Definición de volúmenes`
    `restart: always  # Política de reinicio del contenedor`

`volumes:  # Definición de volúmenes persistentes`
  `db:`
  `nextcloud:`

## **Comandos Básicos de Docker Compose**
### Iniciar servicios:  
`docker-compose up -d (en segundo plano).`
### Detener servicios:  
`docker-compose down`
### Ver estado de los servicios:  
`docker-compose ps`
### Ver logs de servicios:  
`docker-compose logs`
### Escalar servicios:  
`docker-compose up -d --scale <servicio>=<número>`