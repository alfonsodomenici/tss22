export default class RestException{
    constructor(resp,error){
        this.response = resp;
        this.error = error;
    }
}