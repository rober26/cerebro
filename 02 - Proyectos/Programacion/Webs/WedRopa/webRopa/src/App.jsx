import { useState } from 'react'
import './App.css'
import Contacto from './components/Contacto'
import Footer from './components/Footer'
import Header from './components/Header'
import Producto from './components/ProductoBox'
import Productos from './components/Productos'
import SobreNosotros from './components/SobreNosotros'
import { BrowserRouter,Routes,Route } from 'react-router-dom'

function App() {
  return (
      <BrowserRouter>
        <Header/>
        
        <Routes>
          <Route path='/' element={<Productos/>}/>
          <Route path='Producto' element={<Producto/>}/>
          <Route path='Contacto' element={<Contacto/>}/>
          <Route path='SobreNosotros' element={<SobreNosotros/>}/>
        </Routes>

        <Footer/>
      </BrowserRouter>
  )
}

export default App
