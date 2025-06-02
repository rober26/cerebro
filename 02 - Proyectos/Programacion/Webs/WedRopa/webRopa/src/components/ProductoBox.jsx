import "../styles/productBox.css"
import { useState } from "react";
import ProductoModal from "../components/ProductoModal"

function ProductoBox ({producto, }){
    const [isModalOpen, setIsModalOpen] = useState(false)
    const openModal = () => setIsModalOpen(true);
    const closeModal = () => setIsModalOpen(false);
    

    return (
        <article className="product box" onClick={openModal}>
            <img src={producto.img} alt={producto.nombre} className="product__img"></img>
            <div className="product__info">
                <p className="product__price">{producto.precio}€</p>
                <p>{producto.nombre}</p>
                <img src="src/assets/plus.svg" alt="Añadir al carrito" className="product__add-icon"></img>
            </div>
            {isModalOpen && <ProductoModal producto={producto} onClose={closeModal} />}
        </article>
    )
}

export default ProductoBox;