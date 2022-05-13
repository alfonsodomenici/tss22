import { html,render } from "../lib/lit-html.js";
import { Router } from "../lib/vaadin-router.js";

export default class MenuView extends HTMLElement{

    constructor(){
        super();
    }

    connectedCallback(){
        render(this.view(),this);
    }

    view(){
        return html`
            <nav>
                <ul>
                    <li>
                        <a href="/login" @click=${e => this.onLogin()}>Login</a>
                    </li>
                    <li>
                        <a href="/registration" @click=${e => this.onRegistration()}>Registrati</a>
                    </li>
                    <li>
                        <a href="/about">About</a>
                    </li>
                </ul>
            </nav>

        `
    }

    onLogin(e){
        Router.go("/login");
    }

    onRegistration(e){
        Router.go("/registration");
    }

}
customElements.define("bkm-menu",MenuView);