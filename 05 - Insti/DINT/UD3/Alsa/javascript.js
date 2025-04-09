let botonBuscar = document.getElementById("send");
let swapButton = document.getElementById("swapButton");
let soloIda = document.getElementById("soloIda");

let origen = document.getElementById("origen");
let destino = document.getElementById("destino");

let fechaIda = document.getElementById("fechaIda");
let fechaVuelta = document.getElementById("fechaVuelta");




botonBuscar.addEventListener("click", function(){
    if(soloIda.checked == true){
        fechaVuelta.setAttribute("disable")
    }
    valOrigDest(origen,destino);

});

function valOrigDest(origen, destino){
    if(origen = destino){
        alert("El origen y el destino no pueden ser iguales");
    };
};
