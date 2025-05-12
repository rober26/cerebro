import { Link } from "react-router-dom";
import Contacto from "./Contacto";

function Footer (){
    return (
        <footer className="footer">
            <p className="footer__text">&copy; 2025 WedRopa - Todos los derechos reservados.</p>
            <Link to="Contacto">Contacto</Link>
        </footer>
    )
}
export default Footer;