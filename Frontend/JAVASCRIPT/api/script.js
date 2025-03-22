function realizarLogin(event){
    event.preventDefault();
    login();
}


function enviarFormulario(event) {
    event.preventDefault();
    enviarDados();
}


function enviarDados(){
    const userData={
    name: document.getElementById("Name").value,
    email: document.getElementById("email").value,
    telefone: document.getElementById("phone").value,
    password: document.getElementById("password1").value
    };
   fetch("http://localhost:8080/user/create",{
    method: "POST", 
    headers:{"Content-Type": "application/json"},
    body: JSON.stringify(userData)
   })

   .then(response => response.json())
            .then(data => {console.log("Usuário cadastrado:", data)
                window.location.href ='http://127.0.0.1:5500/Frontend/HTML/index.html'
            })
            .catch(error => console.error("Erro ao cadastrar usuário:", error));
}

function login(){
    const userLogin={
        email: document.getElementById("email").value,
        password: document.getElementById("password").value
        };

    fetch("http://localhost:8080/user/auth",{
        method: "POST", 
        headers:{"Content-Type": "application/json"},
        body: JSON.stringify(userLogin)
       })
       .then(response => {
        if (!response.ok) {
            if (response.status === 401) {
                throw new Error("Credenciais Inválidas");
            }
            throw new Error(`Erro: ${response.status}`);
        }
        return response.text();
    })
                .then(data => {console.log("Resposta do servidor:",data);  
                    window.location.href ='http://127.0.0.1:5500/Frontend/HTML/index.html';
                })
                .catch(error =>{ console.error("Erro ", 401) , alert("Credenciais Inválidas, Verifique Seu Login e Senha")}); 
    }
    
   

