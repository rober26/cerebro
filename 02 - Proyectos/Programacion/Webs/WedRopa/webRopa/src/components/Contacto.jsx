import { useEffect, useState } from "react";
import "../styles/contacto.css"
import Swal from 'sweetalert2';  
import axios from "axios";
import operaciones from "../servicios /axios/operaciones";

function Contacto(){
    const [nombre, setNombre] = useState("");
    const [correo, setCorreo] = useState("");
    const [mensaje, setMensaje] = useState("");
    const [errores, setErrores] = useState([]);
    const [mensajes, setMensajes] = useState([]);

    const enviarServer = () =>{
        operaciones.setProducto(nombre,correo,mensaje);
    }

    useEffect(() => {
        operaciones.getMensajes()
        .then(response => {
            setMensajes(response.data)
        })
        .catch(error =>{
            console.log(error);
        })
    }, []);

    const eliminar = (id) => {
        operaciones.deleteMensaje(id)
        .then(response => {
            alert("Mensaje con id "+ id+ "ha sido eliminado")
        })
        .catch(error =>{
            console.error(error)
        })
    }

    const enviar = (e)=>{
        e.preventDefault();
        if(validar()){
            Swal.fire(
                `Formulario de contacto:\n` +
                `Nombre: ${nombre}\n` +
                `Correo: ${correo}\n` +
                `Mensaje: ${mensaje}`
            );
            enviarServer();
        }else{
            Swal.fire({
                title: 'Errores en el formulario',
                html: errores.map(err => `<p>${err}</p>`).join(''),
                icon: 'error'
              });
        }
        
    }

    const validar = () =>{
        const erroresTemp = [];

        if( nombre.length < 10 || nombre.length > 100){
            erroresTemp.push("El nombre tiene que tener entre 10 y 100 caracteres.")
        }
        const regex = /^[a-zA-Z\s]*$/;
        if(!regex.test(nombre)){
            erroresTemp.push("No se permiten caracteres epeciales")
        }

        setErrores(erroresTemp);
        return erroresTemp.length === 0;
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
            <article>
                {mensajes.map(mensaje =>(
                    <div>
                        <p key ={mensaje.id}>NOMBRE: {mensaje.Nombre},CORREO: {mensaje.Correo}, MENSAJE:{mensaje.Mensaje} </p>
                        <button onClick={()=>{eliminar(mensaje.id)}} >Eliminar</button>
                    </div>
    
                ))}
            </article>
        </main>
    )
}
export default Contacto;