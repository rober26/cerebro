import Producto from "./Producto";

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
                    
                    <Producto/>

                </div>
            </section>
        </div>
    </main>
    )
}
export default Productos;
