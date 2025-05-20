import { useState } from "react";
import "../styles/contacto.css"

function Contacto(){
    const [nombre, setNombre] = useState("");
    const [correo, setCorreo] = useState("");
    const [mensaje, setMensaje] = useState("");

    const enviar = (e)=>{
        e.preventDefault();
        alert(
            `Formulario de contacto:\n` +
            `Nombre: ${nombre}\n` +
            `Correo: ${correo}\n` +
            `Mensaje: ${mensaje}`
        );
    }

    return(
        <main>
            <form className="box contac__box" onSubmit={enviar}>
                <h1>Contacto</h1>
                <input type="text" placeholder="Nombre" value={nombre} required onChange={(e) => setNombre(e.target.value)}/>
                <input type="email" placeholder="Correo" value={correo} required onChange={(e) => setCorreo(e.target.value)}/>

                <textarea value={mensaje} placeholder="Mensaje" required onChange={(e) => setMensaje(e.target.value) }/>

                <button type="submit">Enviar</button>
            </form>
        </main>
    )
}
export default Contacto;