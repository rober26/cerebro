MySQL es un **sistema de gestión de bases de datos relacional (RDBMS)** de código abierto basado en SQL (Structured Query Language). Es ampliamente utilizado en aplicaciones web y empresariales debido a su rapidez, fiabilidad y facilidad de uso.
## **Instalación de MySQL**

Para instalar MySQL en diferentes sistemas operativos:

- **Windows**: Descargar desde [MySQL Official Site](https://dev.mysql.com/downloads/installer/)
- **Linux (Debian/Ubuntu)**:
    `sudo apt update sudo apt install mysql-server`

- **macOS** (usando Homebrew):
    `brew install mysql`

Para verificar la instalación:
`mysql --version`

Para iniciar MySQL en Linux/Mac:
`sudo systemctl start mysql`

Para ingresar a la consola de MySQL:
`mysql -u root -p`

---

## **3. Comandos Básicos de MySQL**

### **3.1 Conectar a MySQL**

bash

CopiarEditar

`mysql -u usuario -p`

O si estás usando `root`:

bash

CopiarEditar

`mysql -u root -p`

---

### **3.2 Gestión de Bases de Datos**

|Comando|Descripción|
|---|---|
|`SHOW DATABASES;`|Lista todas las bases de datos disponibles.|
|`CREATE DATABASE nombre_bd;`|Crea una nueva base de datos.|
|`DROP DATABASE nombre_bd;`|Elimina una base de datos.|
|`USE nombre_bd;`|Selecciona una base de datos para trabajar.|

---

### **3.3 Gestión de Tablas**

| Comando                                                            | Descripción                                        |
| ------------------------------------------------------------------ | -------------------------------------------------- |
| `SHOW TABLES;`                                                     | Lista todas las tablas en la base de datos actual. |
| `DESCRIBE nombre_tabla;`                                           | Muestra la estructura de una tabla.                |
| `CREATE TABLE nombre_tabla ( columna1 tipo, columna2 tipo, ... );` | Crea una tabla con las columnas especificadas.     |
| `DROP TABLE nombre_tabla;`                                         | Elimina una tabla.                                 |
| `ALTER TABLE nombre_tabla ADD columna tipo;`                       | Agrega una nueva columna a una tabla existente.    |
| `ALTER TABLE nombre_tabla DROP COLUMN columna;`                    | Elimina una columna de la tabla.                   |

---

### **3.4 Tipos de Datos Comunes en MySQL**

|Tipo|Descripción|
|---|---|
|`INT`|Números enteros.|
|`VARCHAR(n)`|Cadenas de texto de hasta `n` caracteres.|
|`TEXT`|Cadenas de texto largas.|
|`DATE`|Fechas en formato `YYYY-MM-DD`.|
|`DATETIME`|Fecha y hora en `YYYY-MM-DD HH:MM:SS`.|
|`FLOAT`|Números decimales de punto flotante.|
|`BOOLEAN`|Valores `TRUE` o `FALSE`.|

---

## **4. Manipulación de Datos**

### **4.1 Insertar Datos**
`INSERT INTO nombre_tabla (columna1, columna2) VALUES ('valor1', 'valor2');`

Para insertar múltiples filas:

`INSERT INTO nombre_tabla (columna1, columna2) VALUES  ('valor1', 'valor2'), ('valor3', 'valor4');`

---

### **4.2 Consultar Datos**

sql

CopiarEditar

`SELECT * FROM nombre_tabla;`

Filtrar resultados con `WHERE`:

sql

CopiarEditar

`SELECT * FROM nombre_tabla WHERE columna1 = 'valor';`

Ordenar resultados:

sql

CopiarEditar

`SELECT * FROM nombre_tabla ORDER BY columna1 ASC;  -- Orden ascendente SELECT * FROM nombre_tabla ORDER BY columna1 DESC; -- Orden descendente`

Limitar el número de resultados:

sql

CopiarEditar

`SELECT * FROM nombre_tabla LIMIT 5;`

---

### **4.3 Actualizar Datos**

sql

CopiarEditar

`UPDATE nombre_tabla SET columna1 = 'nuevo_valor' WHERE columna2 = 'valor_especifico';`

---

### **4.4 Eliminar Datos**

sql

CopiarEditar

`DELETE FROM nombre_tabla WHERE columna1 = 'valor';`

Eliminar todos los datos de una tabla:

sql

CopiarEditar

`DELETE FROM nombre_tabla;`

---

## **5. Relaciones entre Tablas**

### **5.1 Tipos de Relaciones**

- **Uno a Uno (`1:1`)**: Cada registro en una tabla tiene **un único** registro en otra.
- **Uno a Muchos (`1:N`)**: Un registro en una tabla está relacionado con **muchos** registros en otra.
- **Muchos a Muchos (`M:N`)**: Se usa una tabla intermedia para relacionar múltiples registros entre ambas tablas.

### **5.2 Crear Relaciones con Claves Foráneas**

sql

CopiarEditar

`CREATE TABLE usuarios (     id INT PRIMARY KEY AUTO_INCREMENT,     nombre VARCHAR(50) );  CREATE TABLE pedidos (     id INT PRIMARY KEY AUTO_INCREMENT,     usuario_id INT,     fecha DATE,     FOREIGN KEY (usuario_id) REFERENCES usuarios(id) );`

---

## **6. Consultas Avanzadas**

### **6.1 Joins (Unir Tablas)**

#### **INNER JOIN** (Solo registros coincidentes en ambas tablas)

sql

CopiarEditar

`SELECT usuarios.nombre, pedidos.fecha  FROM usuarios INNER JOIN pedidos ON usuarios.id = pedidos.usuario_id;`

#### **LEFT JOIN** (Todos los registros de la tabla izquierda, y los coincidentes de la derecha)

sql

CopiarEditar

`SELECT usuarios.nombre, pedidos.fecha  FROM usuarios LEFT JOIN pedidos ON usuarios.id = pedidos.usuario_id;`

#### **RIGHT JOIN** (Todos los registros de la tabla derecha, y los coincidentes de la izquierda)

sql

CopiarEditar

`SELECT usuarios.nombre, pedidos.fecha  FROM usuarios RIGHT JOIN pedidos ON usuarios.id = pedidos.usuario_id;`

---

### **6.2 Subconsultas**

Obtener usuarios que han hecho pedidos:

sql

CopiarEditar

`SELECT * FROM usuarios WHERE id IN (SELECT usuario_id FROM pedidos);`

---

### **6.3 Agrupar Datos con `GROUP BY`**

Contar cuántos pedidos ha hecho cada usuario:

sql

CopiarEditar

`SELECT usuario_id, COUNT(*) AS total_pedidos  FROM pedidos GROUP BY usuario_id;`

---

## **7. Seguridad en MySQL**

### **7.1 Crear Usuarios**

sql

CopiarEditar

`CREATE USER 'nuevo_usuario'@'localhost' IDENTIFIED BY 'contraseña_segura';`

### **7.2 Asignar Permisos**

Otorgar todos los permisos sobre una base de datos:

sql

CopiarEditar

`GRANT ALL PRIVILEGES ON nombre_bd.* TO 'nuevo_usuario'@'localhost';`

Actualizar privilegios:

sql

CopiarEditar

`FLUSH PRIVILEGES;`

### **7.3 Ver Permisos de un Usuario**

sql

CopiarEditar

`SHOW GRANTS FOR 'nuevo_usuario'@'localhost';`

### **7.4 Eliminar Usuario**

sql

CopiarEditar

`DROP USER 'usuario'@'localhost';`

---

## **8. Copia de Seguridad y Restauración**

Para hacer un backup de una base de datos:

bash

CopiarEditar

`mysqldump -u usuario -p nombre_bd > backup.sql`

Para restaurar una base de datos desde un backup:

bash

CopiarEditar

`mysql -u usuario -p nombre_bd < backup.sql`