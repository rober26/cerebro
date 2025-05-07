import './App.css'
import { useState } from 'react';
import Mensaje from './components/Mensaje'
import Perfil from './components/Perfil'

function App() {
  const tareas = [
    "Estudiar React",
    "Hacer ejercicio",
    "Leer 10 paginas"
  ]
  const [numero,setNumero] = useState(0);
  const [texto, setTexto] = useState("");
  const [colorFondo,setColorFondo] = useState("white");
  const [fechaHora, setFechaHora] = useState(new Date().toLocaleString());
  const [logeado,setlogeado] = useState(false);
  
  const cambiarColorFondo= () => {
    setColorFondo(colorFondo ==="white" ? "black" : "white")
  }
  
  
  const saludar = () =>{
    alert("!Hola desde React¡")
  } 
  const actualizar = ()=>{
    setTexto(document.getElementById("input").value);
  }
  const actualizarFecha = () =>{
    setFechaHora(new Date().toLocaleString())
  }
  

  return (
    <>
      <Mensaje />
      <Perfil />
      <button id="botosSaludo" onClick={saludar}>Mostrar saludo</button>
      <p>
        <input type="text" id="input" value={texto} onChange={actualizar}></input>
      </p>
      <p>{texto}</p>
      <ul>
        {tareas.map((tarea,index) => (
          <li key={index} >{tarea}</li>
        ))}
      </ul>
      
      <p>{numero}</p>
      <button onClick={() => (setNumero(numero + 1) )}>+1</button>
      <button onClick={() => (setNumero(numero - 1) )}>-1</button>
      <button onClick={() => (setNumero(0))}>Reset</button>
      
      <div style={{ backgroundColor: colorFondo }}>
        <button onClick={cambiarColorFondo}>Cambiar Color de Fondo</button>
      </div>
  
      {logeado ? (<h1>Bienvenido</h1>):(<h1>Inicia sesion</h1>)}
      <button onClick={()=>setlogeado(!logeado)}>{logeado ? "Cerrar sesion": "iniciar sesion"}</button>

      <p>Fecha y hora actual:{fechaHora}</p>
      <button onClick={actualizarFecha}>Actualizar</button>
    </>
  )
}

export default App
