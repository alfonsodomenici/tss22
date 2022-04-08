console.log("script start ok..");
let txtUsr = document.getElementById("usr");
let txtPwd = document.getElementById("pwd");
let btnLogin = document.getElementById("btnLogin");
let usersElement = document.getElementById("users");

btnLogin.addEventListener("click", v => {
    v.preventDefault();
    const credential = {
        usr: txtUsr.value,
        pwd: txtPwd.value
    };
    fetch("http://localhost:8080/blogapp/resources/users/login", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
                    // 'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: JSON.stringify(credential)
    })
    .then(response => response.json())
    .then(data => {
        console.log(JSON.stringify(data));
        window.localStorage.setItem("token",data.jwt) ;
        visualizzaUsers();
    });
});

const visualizzaUsers = () => {
    console.log(window.localStorage.getItem("token"));
    fetch("http://localhost:8080/blogapp/resources/users/", {
        method: 'GET',
        headers: {
            'Authorization': 'Bearer ' + window.localStorage.getItem("token")
        }
    })
    .then(response => {
        if(response.ok === false){
            console.log("caricamento utenti non riuscito")
            console.log(response);
        }else{
            console.log('RISPOSTA OK')
            return response.json();
        }
    })
    .then(data => data.map(v => renderUser(v)).forEach(v => usersElement.appendChild(v))
    );
};

const renderUser = (v) => {
    const liElement =document.createElement("li");
    liElement.innerHTML = v.last_name;
    return liElement;
}




