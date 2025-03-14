const password = document.getElementById('password1');
const confirmpassword = document.getElementById('password2');
const submitbtn = document.getElementById('submitbutton');
submitbtn.disabled=true
const msg =document.getElementById('msgsenha')
msg.style.display='none'

function verificarSenha() {
  
  if (password.value === confirmpassword.value && password.value!=="" && confirmpassword.value!=="") {
    
    submitbtn.disabled = false;
    confirmpassword.style.borderColor=''
    msg.style.display='none'
        
  } else {
    
    submitbtn.disabled = true; 
    confirmpassword.style.borderColor='red'
    msg.style.display='inline'
  
  }
  if (password.value === "" && confirmpassword.value === "") {
    confirmpassword.style.borderColor = '';
    msg.style.display = 'none';
  }
}
password.addEventListener('input', verificarSenha);
confirmpassword.addEventListener('input', verificarSenha);
