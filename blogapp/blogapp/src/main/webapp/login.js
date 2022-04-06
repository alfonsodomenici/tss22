console.log("script start ok..");
let txtUsr = document.getElementById("usr");
let txtPwd = document.getElementById("pwd");
let btnLogin = document.getElementById("btnLogin");

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
    }).then(response => response.json())
            .then(data => console.log(data))
});



