### Productor - Consumidor.

Se construirá una aplicación donde una serie de productores generaran una serie de mensajes, al menos 10 mensajes por productor, y los consumidores consumirán ese mensaje y mostraran los datos por pantalla. Los mensajes deben ser aleatorios.

Se debe implementar un mensaje que contenga un identificador, un estado concreto; los posibles estados son: LOG y MOSTRAR; y una descripción.El consumidor debe leer el mensaje y mostrar la información, por consola en el caso de que el estado sea MOSTRAR y almacenar en un archivo de LOG.txt en el caso de que sea LOG con la fecha y hora en la que se registro.

El modelo de la aplicación debe basarse en la arquitectura productor consumidor. Debe poder aumentarse el numero de mensajeros y el de consumidores.

**Calificación**:

- Ejecución (2 puntos).
- Codificación (4 puntos).
    - Principio de responsabilidad única, que cada clase realice una función.
    - Inversión de dependencias, las clases deben solo conocer los interfaces de uso de aquellas clases de las que dependan.
    - Construcción del modelo productor consumidor adecuada.
- Memoria (4 puntos).
    - Funcionalidades: diagrama y descripción textual de casos de uso
    - Implementación: diagrama de secuencia y explicación de aquellas partes que son más relevantes del código.

**Entregable**: Clases necesarias para la implementación. Documento pdf describiendo el funcionamiento del programa.

**Nota**: Os paso un código de generación de códigos de error que ha adaptado Laura por si os ayuda.