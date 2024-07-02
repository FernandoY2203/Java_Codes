import "./styles.css"
import logoImg from "../../assets/img/Logo.svg"


function Header() {
    return (
        <header>
            <div className="dsmeta-logo-container">
                <img src={logoImg} alt="DSMeta"/>
                    <h1>DSMeta</h1>
                    <p>
                        Desenvolvido por
                        <a href="https://www.instagram.com/devsuperior.ig/?hl=pt">@devsuperior.ig</a>
                    </p>
            </div>
        </header>
    )
}

export default Header