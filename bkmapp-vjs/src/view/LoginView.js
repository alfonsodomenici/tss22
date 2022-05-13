import { html, render } from "../lib/lit-html.js";
import { doLogin } from "../service/userStore.js";
import { storeToken } from "../security/tokenManager.js";
import { Router } from "../lib/vaadin-router.js";

export default class LoginView extends HTMLElement {
    constructor() {
        super();
        this.state = {};
    }

    connectedCallback() {
        render(this.view(), this);
    }

    view() {
        return html`
            <h1>Bkmtest web component</h1>
            <form method="POST">
                <input type="text" @change=${e => this.onInputChange(e)} name="usr" id="usr">
                <input type="password" @change=${e => this.onInputChange(e)} name="pwd" id="pwd">
                <button @click=${e => this.onLogin(e)}>Invia</button>
            </form>
        `
    }

    onLogin(e) {
        e.preventDefault();
        doLogin(this.state.usr, this.state.pwd)
            .then(data => {
                storeToken(data.jwt);
                Router.go("/user-home");
            }).catch(restex => {
                console.log(restex)
                if (restex.response) {
                    const { status, statusText } = restex.response;
                    alert(`login fallita. risposta:${statusText}`);
                } else {
                    alert(`login fallita. errore imprevisto:${restex.error.message}`);
                }
            });
    }

    onInputChange(e) {
        const { target } = e;
        const { name, value } = target;
        this.state[name] = value;
    }

}
customElements.define("bkm-login", LoginView);