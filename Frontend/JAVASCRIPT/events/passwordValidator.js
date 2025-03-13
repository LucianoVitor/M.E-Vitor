const password = document.getElementById('password1');
const confirmpassword = document.getElementById('password2');
const submitbtn = document.getElementById('submitbutton');
submitbtn.disabled=true

function verificarSenha() {
  if (password.value === confirmpassword.value && password.value!=="" && confirmpassword.value!=="") {
    
    submitbtn.disabled = false;
    confirmpassword.style.borderColor=''

  } else {
    
    submitbtn.disabled = true; 
    confirmpassword.style.borderColor='red'
  
  }
}
password.addEventListener('input', verificarSenha);
confirmpassword.addEventListener('input', verificarSenha);
