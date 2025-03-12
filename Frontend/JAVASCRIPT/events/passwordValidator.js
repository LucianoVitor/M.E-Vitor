const password = document.getElementById('password1');
const confirmpassword = document.getElementById('password2');
const submitbtn = document.getElementById('submitbutton');


function verificarSenhas() {
  if (password.value === confirmpassword.value) {
    
    submitbtn.disabled = false;

  } else {
    
    submitbtn.disabled = true; 
  
  }
}
password.addEventListener('input', verificarSenhas);
confirmpassword.addEventListener('input', verificarSenhas);
