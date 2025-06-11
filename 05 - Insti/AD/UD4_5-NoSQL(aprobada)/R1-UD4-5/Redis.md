## **Redis - Base de Datos NoSQL**
**Roberto Lespe Herrera**
**Acceso a datos**

---

### **¿Qué es Redis?**

**Redis** (que viene de REmote DIctionary Server) es una base de datos NoSQL de código abierto que guarda los datos en memoria, usando un formato clave-valor. Fue creada en 2009 por Salvatore Sanfilippo y está hecha en lenguaje C.

Está pensada para ser **muy rápida**, tanto que puede hacer millones de operaciones por segundo. Por eso se usa mucho en apps donde la velocidad es clave, como para guardar sesiones de usuario, hacer sistemas de caché o manejar colas de tareas.

---

### **Características principales de Redis**
1. **Funciona en memoria**: Redis guarda todo en la RAM, no en el disco, así que es mucho más rápido que otras bases de datos más "lentas".
2. **Clave-valor**: Guarda la info como si fueran pares tipo `clave:valor`, como en un diccionario. No hace falta montar una estructura complicada antes de usarla.
3. **Tipos de datos variados**: Aunque parezca simple, Redis puede manejar varios tipos de datos:
    
    - Listas (como arrays)
    - Conjuntos (listas sin elementos repetidos)
    - Hashes (como objetos JSON)
    - Sorted sets (listas ordenadas con puntuación)
    - Streams (datos que llegan en tiempo real)
    
4. **Se puede guardar en disco**: Aunque trabaja en memoria, puedes configurarlo para que guarde los datos en el disco cada cierto tiempo, por si necesitas recuperar la info después.
5. **Rinde muchísimo**: Redis está hecho para ir rápido. En buenas condiciones, puede hacer más de un millón de operaciones por segundo.
6. **Fácil de usar**: Los comandos son súper simples. Por ejemplo: `SET`, `GET`, `INCR`, `LPUSH`... Nada del otro mundo.
7. **Escalable y replicable**: Se puede hacer que Redis funcione en varios servidores (escalado horizontal), y también tiene un sistema para replicar datos entre nodos (tipo copia de seguridad en tiempo real).
---

### **Diferencias entre Redis y bases de datos SQL tradicionales**
| **Caracteristicas**               | **Redis (NoSQL)**                                               | **Bases de datos SQL (tipo MySQL, PostgreSQL…)**                               |
| --------------------------------- | --------------------------------------------------------------- | ------------------------------------------------------------------------------ |
| **Cómo guarda los datos**         | Usa pares clave-valor                                           | Usa tablas con columnas y filas                                                |
| **Esquema o estructura**          | No necesitas definir nada antes, puedes guardar lo que quieras. | Necesitas decir cómo será la estructura (tipo nombre, edad…) antes de guardar. |
| **Consultas**                     | Son simples, rápidas, pero limitadas (no hay `JOIN`).           | Puedes hacer consultas complejas (con `JOIN`, `GROUP BY`, etc.).               |
| **Velocidad**                     | Muy rapido, porque trabaja en memoria.                          | Más lento, porque accede al disco.                                             |
| **Guardar datos permanentemente** | Opcional, lo puedes configurar.                                 | Siempre guarda los datos por defecto.                                          |
| **Escalar o crecer**              | Fácil de repartir en varios servidores (escalado horizontal).   | Más complicado de escalar, suele crecer en un solo servidor.                   |

---

### **Casos de uso reales de Redis**
Redis es utilizado ampliamente en aplicaciones modernas, especialmente en aquellas donde el rendimiento es crítico. Algunos ejemplos:

- **Caché de resultados de consultas**: Se guarda temporalmente el resultado de búsquedas para reducir la carga del servidor.
- **Gestión de sesiones de usuario**: Ideal para aplicaciones web, donde se requiere guardar sesiones de forma rápida y segura.
- **Sistemas de mensajería y colas de tareas**: Redis puede funcionar como intermediario entre servicios usando listas y Pub/Sub.
- **Contadores en tiempo real**: Por ejemplo, contar visitas a una web o clics en un botón.

Empresas como Twitter, GitHub, StackOverflow, y Spotify usan Redis en su infraestructura para mejorar la velocidad y disponibilidad de sus servicios.

---

### **Conclusión**

Redis es una base de datos NoSQL que destaca por ser muy rápida, fácil de usar y bastante versátil. Es perfecta para situaciones en las que necesitas acceder a los datos casi al instante, como en sistemas de caché, sesiones o tareas en segundo plano. No está pensada para reemplazar a las bases de datos SQL de toda la vida, pero sí es un buen complemento cuando necesitas más velocidad o flexibilidad. Por todo eso, se ha vuelto súper popular entre desarrolladores y se usa en un montón de proyectos modernos.