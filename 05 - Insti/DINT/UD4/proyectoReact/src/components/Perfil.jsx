import { useState } from "react"
import { useEffect } from "react";

function Perfil({nombre, edad}){
   
    return(
        <>
        <p>Nombre:{nombre}, Edad:{edad}</p>
        </>
    )
}

export default Perfil