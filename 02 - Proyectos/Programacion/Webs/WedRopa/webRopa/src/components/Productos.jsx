import { useEffect, useState } from "react";
import Producto from "./ProductoBox";
import productos from '../productos.json';
function Productos(){


    


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
                        <Producto key ={producto.id} nombre={producto.nombre} img={producto.img} precio={producto.precio} />
                    ))}
                </div>
            </section>
        </div>
    </main>
    )
}
export default Productos;
