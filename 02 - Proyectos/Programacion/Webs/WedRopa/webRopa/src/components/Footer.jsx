import { Link } from "react-router-dom";
import Contacto from "./Contacto";

function Footer (){
    return (
        <footer>
            <p className="footer__text">&copy; 2025 WedRopa - Todos los derechos reservados.</p>
            <Link to="Contacto">Contacto</Link>
            <Link to="SobreNosotros">Sobre nosotros</Link>
        </footer>
    )
}
export default Footer;