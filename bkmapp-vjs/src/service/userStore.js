import { postJsonData, getJsonData } from "./rest.js";
import configData from "../config.js";
import { loggedUser } from "../security/tokenManager.js";

const url = `${configData.baseurl}/users`

const doLogin = async (usr, pwd) => {
    return postJsonData(`${url}/login`,{usr,pwd},false);
}

const searchBkm = () => {
    return getJsonData(`${url}/${loggedUser()}/bkms`)
}

export { doLogin, searchBkm };