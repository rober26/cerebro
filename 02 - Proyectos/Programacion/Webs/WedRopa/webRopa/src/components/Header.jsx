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
                <h1 className="header__title">WedRopa</h1>
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