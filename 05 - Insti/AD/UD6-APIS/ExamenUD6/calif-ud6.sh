#!/bin/bash
reset
# Códigos de respuesta por apartados
#CODIGOS=(200 200 200 200 201 204 204 204 404 404 404 404 400 409 409 409 400 409)
echo "***************************************************************"
echo "POST + código 201 + cuerpo json "
echo "***************************************************************"
RES=`curl -w"|%{http_code}" -X POST -H "Content-Type:application/json" -d '{"nombre" : "Patricio" , "descripción" : "amigo de Calamardo" }' http://localhost:8080/personajes 2>/dev/null`
COD=${RES##*\|}
ID=`echo ${RES%%,*} | sed -e 's/.*://'`
echo
echo "1 debe aparecer Patricio al pedirlos todos:"
BODY=`curl http://localhost:8080/personajes 2>/dev/null`
if [[ $BODY == *'"nombre":"Patricio","descripción":"amigo de Calamardo"'* ]]
then CAL1=25
else CAL1=0
fi
echo "1 debe aparecer Patricio al pedir $ID obtenido del POST inicial"
BODY=`curl http://localhost:8080/personajes/$ID 2>/dev/null`
if [[ $BODY == *'"nombre":"Patricio","descripción":"amigo de Calamardo"'* ]]
then CAL2=25
else CAL2=0
fi
CALIF[1]=`echo "scale=2; ($CAL1+$CAL2)/100" | bc | tr '.' ',' | sed -e 's/^,/0,/'`

if [[ $COD == "201" ]]
then CALIF[5]=0,5
else CALIF[5]=0
fi
echo POST devolvió $ID : $RES
echo GET $ID devolvió $BODY
echo COD debería ser 201, es:  $COD
echo CALIF[1] ES ${CALIF[1]}
echo CALIF[5] ES ${CALIF[5]}
read -p "Pulse ENTER para continuar"
echo
echo "***************************************************************"
echo "2 PUT"
echo "***************************************************************"
ID=2
# A muchos les falla si no ponemos id
#RES=`curl -w"|%{http_code}" -X PUT -H "Content-Type:application/json" -d '{"nombre" : "Estrellita" , "descripción" : "Estrella de mar" }' http://localhost:8080/personajes/$ID  2>/dev/null`
RES=`curl -w"|%{http_code}" -X PUT -H "Content-Type:application/json" -d "{\"id\" : $ID, \"nombre\" : \"Estrellita\" , \"descripción\" : \"Estrella de mar\" }" http://localhost:8080/personajes/$ID  2>/dev/null`
COD=${RES##*\|}
echo
echo '2: debe aparecer Estrellita con descripción "Estrella de mar"'
BODY=`curl http://localhost:8080/personajes/$ID 2>/dev/null`
if [[ $BODY == *'"nombre":"Estrellita","descripción":"Estrella de mar"'* ]]
then CALIF[2]=0,5
else CALIF[2]=0
fi
if [[ $COD == "204" ]]
then CALIF[6]=0,5
else CALIF[6]=0
fi
echo PUT $ID : $BODY
echo COD debería ser 204, es:  $COD
echo CALIF[2] ES ${CALIF[2]}
echo CALIF[6] ES ${CALIF[6]}
echo
read -p "Pulse ENTER para continuar"
echo "***************************************************************"
echo "3 PATCH"
echo "***************************************************************"
ID=1
RES=`curl -w"|%{http_code}" -X PATCH -H "Content-Type:application/json" -d '{ "descripción" : "Pantalones cuadrados" }' http://localhost:8080/personajes/$ID  2>/dev/null`
COD=${RES##*\|}
echo
echo '3: debe aparecer Bob con descripción "Pantalones cuadrados"'
#curl -w"\n%{http_code}\n" http://localhost:8080/personajes/1 2>/dev/null
BODY=`curl http://localhost:8080/personajes/$ID 2>/dev/null`
if [[ $BODY == *'"nombre":"Bob Esponja","descripción":"Pantalones cuadrados"'* ]]
then CALIF[3]=0,5
else CALIF[3]=0
fi
if [[ $COD == "204" ]]
then CALIF[7]=0,5
else CALIF[7]=0
fi
echo PATCH $ID : $BODY
echo COD debería ser 204, es:  $COD
echo CALIF[3] ES ${CALIF[3]}
echo CALIF[7] ES ${CALIF[7]}
echo
read -p "Pulse ENTER para continuar"
echo "***************************************************************"
echo "4 DELETE" 
echo "***************************************************************"
ID=2
RES=`curl -w"|%{http_code}" -X DELETE http://localhost:8080/personajes/$ID 2>/dev/null`
COD=${RES##*\|}
echo
echo "4 no debe aparecer el id $ID"
BODY=`curl http://localhost:8080/personajes 2>/dev/null`
if [[ $BODY == *'"id":"2",'* ]]
then CALIF[4]=0
else CALIF[4]=0,5
fi
if [[ $COD == "204" ]]
then CALIF[8]=0,5
else CALIF[8]=0
fi
echo DELETE $ID : $BODY
echo COD debería ser 204, es:  $COD
echo CALIF[4] ES ${CALIF[4]}
echo CALIF[8] ES ${CALIF[8]}
echo
read -p "Pulse ENTER para continuar"
echo "***************************************************************"
echo "CÓDIGO 404" 
echo "***************************************************************"
ID=10
echo "9 Debe dar error 404 el GET del elemento $ID:"
RES=`curl -w"|%{http_code}" http://localhost:8080/personajes/$ID 2>/dev/null`
COD=${RES##*\|}
if [[ $COD == "404" ]]
then CALIF[9]=0,5
else CALIF[9]=0
fi
echo BODY: $RES
echo COD $COD
echo CALIF[9] ES ${CALIF[9]}
echo
echo "10 Debe dar error 404 el PUT del elemento $ID:"
RES=`curl -w"|%{http_code}" -X PUT -H "Content-Type:application/json" -d '{"nombre" : "Estrellita" , "descripción" : "Estrella de mar" }' http://localhost:8080/personajes/$ID 2>/dev/null`
COD=${RES##*\|}
if [[ $COD == "404" ]]
then CALIF[10]=0,5
else CALIF[10]=0
fi
echo COD $COD
echo CALIF[10] ES ${CALIF[10]}
echo
echo "11 Debe dar error 404 el PATCH del elemento $ID:"
RES=`curl -w"|%{http_code}" -X PATCH -H "Content-Type:application/json" -d '{ "descripción" : "Pantalones cuadrados" }' http://localhost:8080/personajes/$ID 2>/dev/null`
COD=${RES##*\|}
if [[ $COD == "404" ]]
then CALIF[11]=0,5
else CALIF[11]=0
fi
echo BODY: $RES
echo COD $COD
echo CALIF[11] ES ${CALIF[11]}
echo
echo
echo "12 Debe dar error 404 el DELETE del elemento 10:"
RES=`curl -w"|%{http_code}" -X DELETE http://localhost:8080/personajes/$ID 2>/dev/null`
COD=${RES##*\|}
if [[ $COD == "404" ]]
then CALIF[12]=0,5
else CALIF[12]=0
fi
echo BODY: $RES
echo COD $COD
echo CALIF[12] ES ${CALIF[12]}
echo
echo
echo BODY: $RES
read -p "Pulse ENTER para continuar"
echo "***************************************************************"
echo "13 Debe dar error 400 POST con id en URL o cuerpo" 
echo "***************************************************************"
RES=`curl -w"|%{http_code}\n" -X POST -H "Content-Type:application/json" -d '{ "nombre" : "Calamardo" , "descripción" : "Toca el clarinete" }' http://localhost:8080/personajes/$ID 2>/dev/null`
COD=${RES##*\|}
RES2=`curl -w"|%{http_code}\n" -X POST -H "Content-Type:application/json" -d '{ "id": 10 , "nombre" : "Calamardo" , "descripción" : "Toca el clarinete" }' http://localhost:8080/personajes 2>/dev/null`
COD2=${RES2##*\|}

echo COD post con Id en url: $COD COD post con id en cuerpo $COD2
#"scale=2; $A.0/100"
if [[ $COD == "400" ]]
then CAL1=25
else CAL1=0
fi
if [[ $COD2 == "400" ]]
then CAL2=25
else CAL2=0
fi
CALIF[13]=`echo "scale=2; ($CAL1+$CAL2)/100" | bc | tr '.' ',' | sed -e 's/^,/0,/'`
echo CALIF13 es ${CALIF[13]}
echo
echo BODY: $RES
echo BODY2: $RES2
read -p "Pulse ENTER para continuar"
echo "***************************************************************"
echo "14 Debe dar error 409 POST con nombre ya existente:" 
echo "***************************************************************"
RES=`curl -w"|%{http_code}" -X POST -H "Content-Type:application/json" -d '{ "nombre" : "Bob Esponja" , "descripción" : "Propietario de Crusty Crub" }' http://localhost:8080/personajes 2>/dev/null`
COD=${RES##*\|}
if [[ $COD == "409" ]]
then CALIF[14]=0,5
else CALIF[14]=0
fi
echo COD $COD
echo BODY: $RES
echo CALIF[14] ES ${CALIF[14]}
echo
read -p "Pulse ENTER para continuar"
echo "***************************************************************"
echo "15 Debe dar error 409 si ya existe nombre al reemplazar" 
echo "***************************************************************"
# A muchos les falla si no viene id
#RES=`curl -w"|%{http_code}" -X PUT -H "Content-Type:application/json" -d '{"nombre" : "Bob Esponja", "descripción" : "error" }' http://localhost:8080/personajes/3 2>/dev/null`
RES=`curl -w"|%{http_code}" -X PUT -H "Content-Type:application/json" -d '{"id" : 3,"nombre" : "Bob Esponja", "descripción" : "error" }' http://localhost:8080/personajes/3 2>/dev/null`
COD=${RES##*\|}
if [[ $COD == "409" ]]
echo BODY: $RES
then CALIF[15]=0,5
else CALIF[15]=0
fi
echo COD $COD
echo BODY: $RES
echo CALIF[15] ES ${CALIF[15]}
echo
read -p "Pulse ENTER para continuar"
echo "16 Debe dar error 409 PUT con ID en cuerpo distinto de URL" 
echo "***************************************************************"
RES=`curl -w"|%{http_code}" -X PUT -H "Content-Type:application/json" -d '{ "id" : "4" , "nombre" : "Boby Esponja", "descripción" : "error" }' http://localhost:8080/personajes/3 2>/dev/null`
COD=${RES##*\|}
if [[ $COD == "409" ]]
then CALIF[16]=0,5
else CALIF[16]=0
fi
echo BODY: $RES
echo COD $COD
echo CALIF[16] ES ${CALIF[16]}
read -p "Pulse ENTER para continuar"
echo "17 Debe dar error 400 PATCH con ID en el cuerpo" 
echo "***************************************************************"
RES=`curl -w"|%{http_code}" -X PATCH -H "Content-Type:application/json" -d '{"id" : 2, "descripción" : "error" }' http://localhost:8080/personajes/1 2>/dev/null`
COD=${RES##*\|}
if [[ $COD == "400" ]]
then CALIF[17]=0,5
else CALIF[17]=0
fi
echo BODY: $RES
echo COD $COD
echo CALIF[17] ES ${CALIF[17]}
echo
read -p "Pulse ENTER para continuar"
echo "***************************************************************"
echo "18 Debe dar error 409 si ya existe nombre al parchear" 
echo "***************************************************************"
echo
echo "PATCH:"
RES=`curl -w"|%{http_code}" -X PATCH -H "Content-Type:application/json" -d '{"nombre" : "Bob Esponja", "descripción" : "error" }' http://localhost:8080/personajes/3 2>/dev/null`
COD=${RES##*\|}
if [[ $COD == "409" ]]
then CALIF[18]=0,5
else CALIF[18]=0
fi
echo BODY: $RES
echo COD $COD
echo CALIF[18] ES ${CALIF[18]}
read -p "Pulse ENTER para TERMINAR"
NOTAS=""
for i in "${CALIF[@]}"
do
 echo -n "$i;"
 NOTAS="$NOTAS+$i";
done
echo
echo -n "NOTA SIN EL PUNTO DEL 10: "
echo $NOTAS | sed -e 's/^+//' | tr ',' '.' | bc
