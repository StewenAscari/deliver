import './styles.css';
import { ReactComponent as Logo } from './logo.svg';

function NavBar(){
    return (
        <nav className="main-navbar">
            <Logo />
            <a href="home" className="logo-text">Free Delivery</a>

        </nav>
    )
}

export default NavBar;