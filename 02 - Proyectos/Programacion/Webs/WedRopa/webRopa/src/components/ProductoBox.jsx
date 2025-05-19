import { Link } from "react-router-dom";

function Producto ({nombre,img,precio}){
    return (
        <Link className="product" to="producto">
            <img src={img} alt={nombre} className="product__img"></img>
            <div className="product__info">
                <p className="product__price">{precio}€</p>
                <p>{nombre}</p>
                <img src="src/assets/plus.svg" alt="Añadir al carrito" className="product__add-icon"></img>
            </div>
        </Link>
    )
}

export default Producto;
