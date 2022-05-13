import RestException from "./RestException.js";
import { readToken } from "../security/tokenManager.js";

const postJsonData = async (url, data, reqAuth = true) => {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    if (reqAuth === true) {
        headers.append('Authorization', `Bearer ${readToken()}`);
    }
    const resp = await fetch(url, {
        method: 'POST', // *GET, POST, PUT, DELETE, etc.
        mode: 'cors', // no-cors, *cors, same-origin
        cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached,
        headers: headers,
        body: JSON.stringify(data)
    }).catch(error => {
        throw new RestException(undefined,error);
    })
    if (!resp.ok) {
        throw new RestException(resp,undefined);
    }
    return resp.json();
}

const getJsonData = async (url, reqAuth = true) => {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    if (reqAuth === true) {
        headers.append('Authorization', `Bearer ${readToken()}`);
    }
    const resp = await fetch(url, {
        method: 'GET', // *GET, POST, PUT, DELETE, etc.
        mode: 'cors', // no-cors, *cors, same-origin
        cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached,
        headers: headers
    }).catch(error => {
        throw new RestException(undefined,error);
    })
    if (!resp.ok) {
        throw new RestException(resp,undefined);
    }
    return resp.json();
}

export { postJsonData, getJsonData };