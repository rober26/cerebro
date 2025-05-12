Implementar una carrera por relevos:

- Tenemos 4 Atletas dispuestos a correr
- Tenemos una clase principal Carrera

Realiza una primera implementación con `join()`.

- El metodo `main()` ira lanzando los hilos con `join()`, de tal forma que vayan realizando la carrea secuencialmente.

Una segunda implementación con turnos y _synchronize_.

- Tenemos un objeto testigo
- Todos los atletas empiezan parados, uno comienza a correr (tarda entre 9 y 11s) y al terminar su carrera pasa el testigo a otro que comienza a correr, y así sucesivamente.