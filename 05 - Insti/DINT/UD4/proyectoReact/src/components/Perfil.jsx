import { useState } from "react"
import { useEffect } from "react";

function Perfil(){
    const [nombre, setNombre] = useState("");
    const [edad, setEdad] = useState("");

    useEffect(() => {
        const nombrePrompt = prompt("¿Cuál es tu nombre?");
        const edadPrompt = prompt("¿Cuál es tu edad?");
        
        if (nombrePrompt) setNombre(nombrePrompt);
        if (edadPrompt) setEdad(edadPrompt);
    }, []);

    return(
        <>
        <p>Nombre:{nombre}, Edad:{edad}</p>
        </>
    )
}

export default Perfil