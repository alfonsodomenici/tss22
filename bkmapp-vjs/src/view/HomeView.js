import { html,render } from "../lib/lit-html.js";

export default class HomeView extends HTMLElement{
    constructor(){
        super();
    }

    connectedCallback(){
        render(this.view(),this);
    }

    view(){
        return html`
            <h1>HomeView</h1>

        `
    }

}
customElements.define("bkm-home",HomeView);