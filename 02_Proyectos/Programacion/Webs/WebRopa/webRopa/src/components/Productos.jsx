import ProductoBox from "./ProductoBox";
import "../styles/productos.css"
import { useEffect, useState } from "react";
import operaciones from "../servicios /axios/operaciones";

function Productos(){
    const [productos,setProductos] = useState([])

    useEffect(() => {
        operaciones.getProductos()
        .then(response => {
            setProductos(response.data)
        })
        .catch(error =>{
            console.log(error);
        })
    }, []);

    return(
        <main >
        <img src="src/assets/Banner.svg" alt="Banner promocional" className="main__banner"></img>

        <div className="main__container">
            <aside className="categories">
                <ul className="categories__list">
                    <li className="categories__item">Camisetas</li>
                    <li className="categories__item">Pantalones</li>
                    <li className="categories__item">Sudaderas</li>
                    <li className="categories__item">Zapatos</li>
                </ul>
            </aside>

            <section className="products">
                <div className="products__grid">
                    {productos.map(producto =>(
                        <ProductoBox key ={producto.id} producto ={producto} />
                    ))}
                </div>
            </section>
        </div>
    </main>
    )
}
export default Productos;
