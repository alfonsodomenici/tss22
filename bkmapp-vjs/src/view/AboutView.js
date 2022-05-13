import { html,render } from "../lib/lit-html.js";

export default class AboutView extends HTMLElement{
    constructor(){
        super();
    }

    connectedCallback(){
        render(this.view(),this);
    }

    view(){
        return html`
            <h1>AboutView</h1>

        `
    }

}
customElements.define("bkm-about",AboutView);