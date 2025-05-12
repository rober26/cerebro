import { Link } from "react-router-dom";

function Producto (){
    return (
        <Link className="product" to="Producto">
            <img src="src/assets/placeholder.jpg" alt="Producto" className="product__img"></img>
            <div className="product__info">
                <p className="product__price">99.99€</p>
                <img src="src/assets/plus.svg" alt="Añadir al carrito" className="product__add-icon"></img>
            </div>
        </Link>
    )
}

export default Producto;
