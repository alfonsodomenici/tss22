import { html,render } from "../lib/lit-html.js";

export default class UserHomeView extends HTMLElement{
    constructor(){
        super();
    }

    connectedCallback(){
        render(this.view(),this);
    }

    view(){
        return html`
            <h1>UserHomeView</h1>

        `
    }

}
customElements.define("bkm-user-home",UserHomeView);