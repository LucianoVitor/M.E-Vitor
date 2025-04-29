function realizarLogin(event){
    event.preventDefault();
    login();
}


function enviarFormulario(event) {
    event.preventDefault();
    enviarDados();
}

function Esqueciasenha(event) {
    event.preventDefault();
    forgotPassword();
}

function confirmarToken(event){
    event.preventDefault();
    confirmPasswordChange();
}



function enviarDados(){
    const userData={
    name: document.getElementById("Name").value,
    email: document.getElementById("email").value,
    telefone: document.getElementById("phone").value,
    password: document.getElementById("password1").value
    };
   fetch("http://localhost:8081/user/create",{
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

    fetch("http://localhost:8081/user/auth",{
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
    

    function forgotPassword(){
        
    
        const userLogin={
            email: document.getElementById("email").value
            };
    
        fetch("http://localhost:8081/user/reset/request",{
            method: "PATCH", 
            headers:{"Content-Type": "application/json"},
            body: JSON.stringify(userLogin)
           })
           .then(async response => {

            if (response.ok) {
                // Se o status for 2xx (como 200 ou 204), avançamos
                console.log("Token enviado com sucesso");
                document.getElementById("formReset1").style.display = "none";
                document.getElementById("formReset2").style.display = "block";
            } else if (response.status === 400) {
                // Se houver erro (400 Bad Request)
                console.error("Erro ao enviar o token. Verifique o e-mail.");
                alert("Erro ao enviar o token.");
            } else {
                console.error("Erro desconhecido", response.status);
                alert("Erro desconhecido ao tentar redefinir a senha.");
            }
        })
        .catch(error => {
            console.error("Erro de rede ou outro erro:", error);
            alert("Erro ao enviar a requisição.");
        })
            }
            

function confirmPasswordChange(){
        
    
    const userLogin={
        email: document.getElementById("email").value,
        password: document.getElementById("newpassword").value,
        token: document.getElementById("uuidform").value
        };

    fetch("http://localhost:8081/user/reset/",{
        method: "PATCH", 
        headers:{"Content-Type": "application/json"},
        body: JSON.stringify(userLogin)
       })
       .then(async response => {

        if (response.ok) {
            // Se o status for 2xx (como 200 ou 204), avançamos
            console.log("senha enviado com sucesso")
        } else if (response.status === 400) {
            // Se houver erro (400 Bad Request)
            console.error("Erro ao enviar o token. Verifique o e-mail.");
            alert("Erro ao enviar o token.");
        } else {
            console.error("Erro desconhecido", response.status);
            alert("Erro desconhecido ao tentar redefinir a senha.");
        }
    })
    .catch(error => {
        console.error("Erro de rede ou outro erro:", error);
        alert("Erro ao enviar a requisição.");
    })
        }

