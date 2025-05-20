import { Link } from "react-router-dom";
import "../styles/header.css"

function Header() {

    return (
        <header>
            <div className="header__left">
                <nav className="header__menu">
                    <a href="#" className="header__menu-link">Ropa</a>
                    <a href="#" className="header__menu-link">Joyas</a>
                </nav>
            </div>

            <div className="header__title-container">
                <Link className="header__title" to={"/"} >WedRopa</Link>
            </div>

            <div className="header__icons">
                <img src="src/assets/search.svg" alt="Buscar" className="header__icon"></img>
                <img src="src/assets/shopping-cart.svg" alt="Carrito" className="header__icon"></img>
                <img src="src/assets/user.svg" alt="Perfil" className="header__icon"></img>
            </div>

        </header>
    )
  }
  
  export default Header;