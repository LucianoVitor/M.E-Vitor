function isAuthenticated() {
    const token = localStorage.getItem('jwtToken');
    return !!token; // retorna true se o token existir
}


function ProtectRoute(LinkId, LinkRedirect= '/Frontend/HTML/login.html'){

const rotaprotegida = document.getElementById(LinkId);
rotaprotegida.addEventListener('click', function(event){
if (!isAuthenticated()){
event.preventDefault();
window.location.href = LinkRedirect;
}

})} 

function RedirectRoute(LinkRedirect= '/Frontend/HTML/login.html') {
    if (!isAuthenticated()) {
        alert('Você precisa estar logado para acessar esta página.');
        window.location.href = LinkRedirect;
    }
}