En nuestro proyecto de [[Docker]] deberemos crear un archivo llamado Dockerfile en este archivo definiremos parámetros para la creación de nuestro contenedor.

`FROM ruta Imagen` 

`WORKDIR /directorio` 
`COPY . .`
`RUN yarn install –produccion` 

`CMD [“node”, “/app/src/index.js”]`

