Implementar una carrera de 100m lisos:

- Tenemos 8 Atletas dispuestos a correr
    - Cada uno tiene un atributo dorsal
- Tenemos una clase principal Carrera
    - Indica el pistoletazo de salida y el resultado de la carrera
- Todos los Atletas comienzan pero se quedan parados esperando el pistoletazo de salida
    
    - Luego comienzan a correr (tardan entre 9 y 11s)
    
    - Al llegar a meta notifican a la carrera su dorsal y terminan
- La Carrera escribe “preparados” y espera 1s, luego escribe “listos” y espera 1s, finalmente escribe “ya!” y notifica a los hilos de los Atletas
    - Cada vez que un atleta le notifica su dorsal, escribe por pantalla: dorsal+” tarda “+System.currentTimeMillis()