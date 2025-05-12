import './App.css'
import Contacto from './components/Contacto'
import Footer from './components/Footer'
import Header from './components/Header'
import Producto from './components/Producto'
import Productos from './components/Productos'
import { BrowserRouter,Routes,Route } from 'react-router-dom'

function App() {

  return (
    <>
      <BrowserRouter>
      <Header/>
      
      <Routes>
        <Route path='/' element={<Productos/>}/>
        <Route path='Producto' element={<Producto/>}/>
        <Route path='Contacto' element={<Contacto/>}/>
      </Routes>

      <Footer/>
      </BrowserRouter>
    </>
  )
}

export default App
