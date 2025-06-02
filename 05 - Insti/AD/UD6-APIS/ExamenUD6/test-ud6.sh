#!/bin/bash
reset
echo "***************************************************************"
echo "POST + código 201 + cuerpo json (8)"
echo "***************************************************************"
curl -w"\n%{http_code}\n" -i -X POST -H "Content-Type:application/json" -d '{"nombre" : "Patricio" , "descripción" : "amigo de Calamardo" }' http://localhost:8080/personajes 2>/dev/null
echo
echo "RES TODOS: debe aparecer Patricio con el último id"
curl -w"\n%{http_code}\n" http://localhost:8080/personajes 2>/dev/null | sed -e 's/{/\n{/g'
echo
read -p "Pulse ENTER para continuar"
echo "***************************************************************"
echo "PUT"
echo "***************************************************************"
curl -w"\n%{http_code}\n" -i -X PUT -H "Content-Type:application/json" -d '{"nombre" : "Estrellita" , "descripción" : "Estrella de mar" }' http://localhost:8080/personajes/2  2>/dev/null
echo
echo 'RES 2: debe aparecer Estrellita con descripción "Estrella de mar"'
curl -w"\n%{http_code}\n" http://localhost:8080/personajes/2 2>/dev/null
echo
read -p "Pulse ENTER para continuar"
echo "***************************************************************"
echo "PATCH"
echo "***************************************************************"
curl -w"\n%{http_code}\n" -i -X PATCH -H "Content-Type:application/json" -d '{ "descripción" : "Pantalones cuadrados" }' http://localhost:8080/personajes/1  2>/dev/null
echo
echo 'RES 1: debe aparecer Bob con descripción "Pantalones cuadrados"'
curl -w"\n%{http_code}\n" http://localhost:8080/personajes/1 2>/dev/null
echo
read -p "Pulse ENTER para continuar"
echo "***************************************************************"
echo "DELETE" 
echo "***************************************************************"
curl -w"\n%{http_code}\n" -i -X DELETE http://localhost:8080/personajes/2 2>/dev/null
echo
echo "RES TODOS: no debe aparecer el 2"
curl -w"\n%{http_code}\n" http://localhost:8080/personajes  2>/dev/null| sed -e 's/{/\n{/g'
echo
read -p "Pulse ENTER para continuar"
echo "***************************************************************"
echo "CÓDIGO 404" 
echo "***************************************************************"
echo "Debe dar error 404 el GET del elemento 10:"
curl -w"\n%{http_code}\n" http://localhost:8080/personajes/10 2>/dev/null
echo
echo "Debe dar error 404 el PUT del elemento 10:"
curl -w"\n%{http_code}\n" -i -X PUT -H "Content-Type:application/json" -d '{"nombre" : "Estrellita" , "descripción" : "Estrella de mar" }' http://localhost:8080/personajes/10 2>/dev/null
echo
echo "Debe dar error 404 el PATCH del elemento 10:"
curl -w"\n%{http_code}\n" -i -X PATCH -H "Content-Type:application/json" -d '{ "descripción" : "Pantalones cuadrados" }' http://localhost:8080/personajes/10 2>/dev/null
echo
echo "Debe dar error 404 el DELETE del elemento 10:"
curl -w"\n%{http_code}\n" -i -X DELETE http://localhost:8080/personajes/10 2>/dev/null
echo
echo
read -p "Pulse ENTER para continuar"
echo "***************************************************************"
echo "Debe dar error 400 POST con id en URL" 
echo "***************************************************************"
curl -w"\n%{http_code}\n" -i -X POST -H "Content-Type:application/json" -d '{"nombre" : "Calamardo" , "descripción" : "Toca el clarinete" }' http://localhost:8080/personajes/1 2>/dev/null
echo
read -p "Pulse ENTER para continuar"
echo "***************************************************************"
echo "Debe dar error 400 POST con id en el cuerpo:" 
echo "***************************************************************"
curl -w"\n%{http_code}\n" -i -X POST -H "Content-Type:application/json" -d '{"id" : 6, "nombre" : "Señor Cangrejo" , "descripción" : "Propietario de Crusty Crub" }' http://localhost:8080/personajes 2>/dev/null
echo
read -p "Pulse ENTER para continuar"
echo "***************************************************************"
echo "Debe dar error 409 PUT con ID en cuerpo distinto de URL" 
echo "***************************************************************"
curl -w"\n%{http_code}\n" -i -X PUT -H "Content-Type:application/json" -d '{"id" : 2, "descripción" : "error" }' http://localhost:8080/personajes/1  2>/dev/null
echo
read -p "Pulse ENTER para continuar"
echo "***************************************************************"
echo "Debe dar error 400 PATCH con ID en el cuerpo" 
echo "***************************************************************"
curl -w"\n%{http_code}\n" -i -X PATCH -H "Content-Type:application/json" -d '{"id" : 2, "descripción" : "error" }' http://localhost:8080/personajes/1 2>/dev/null
echo
read -p "Pulse ENTER para continuar"
echo "***************************************************************"
echo "Debe dar error 409 si ya existe al crear,reemplazar o parchear" 
echo "***************************************************************"
echo "POST:"
curl -w"\n%{http_code}\n" -i -X POST -H "Content-Type:application/json" -d '{"nombre" : "Bob Esponja" , "descripción" : "Amigo de Calamardo" }' http://localhost:8080/personajes 2>/dev/null
echo
echo "PUT:"
curl -w"\n%{http_code}\n" -i -X PUT -H "Content-Type:application/json" -d '{"nombre" : "Bob Esponja", "descripción" : "error" }' http://localhost:8080/personajes/3 2>/dev/null
echo
echo "PATCH:"
curl -w"\n%{http_code}\n" -i -X PATCH -H "Content-Type:application/json" -d '{"nombre" : "Bob Esponja", "descripción" : "error" }' http://localhost:8080/personajes/3 2>/dev/null
echo
read -p "Pulse ENTER para TERMINAR"
