import { html,render } from "../lib/lit-html.js";

export default class RegistrationView extends HTMLElement{
    constructor(){
        super();
    }

    connectedCallback(){
        render(this.view(),this);
    }

    view(){
        return html`
            <h1>RegistrationView</h1>

        `
    }

}
customElements.define("bkm-registration",RegistrationView);