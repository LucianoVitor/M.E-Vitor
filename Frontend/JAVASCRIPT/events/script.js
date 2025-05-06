document.addEventListener("DOMContentLoaded", () => {
    const images = document.querySelectorAll(".slides img");
    let index = 0;

    function showSlide(i) {
        images.forEach((img, idx) => {
            img.style.display = idx === i ? "block" : "none";
        });
    }

    document.querySelector(".prev").addEventListener("click", () => {
        index = index > 0 ? index - 1 : images.length - 1;
        showSlide(index);
    });

    document.querySelector(".next").addEventListener("click", () => {
        index = index < images.length - 1 ? index + 1 : 0;
        showSlide(index);
    });

    showSlide(index);
});

//(visita.html) Começo da página de Agendamento de Visitas
document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("form-agendamento");
    const mensagem = document.getElementById("mensagem");

    const datasAgendadas = {}; // Simulando um banco de dados

    form.addEventListener("submit", function (e) {
        e.preventDefault();

        const data = document.getElementById("data").value;
        const horario = document.getElementById("horario").value;

        const chave = `${data}-${horario}`;

        if (datasAgendadas[chave]) {
            mensagem.textContent = "Esse horário já está reservado!";
            mensagem.style.color = "red";
        } else {
            datasAgendadas[chave] = true;
            mensagem.textContent = "Visita agendada com sucesso!";
            mensagem.style.color = "green";
            form.reset();
        }
    });
});
//(visita.html) Término da página de Agendamento de Visitas

//(orçamento.html) Começo da página de Solicitar de Orçamentos
document.addEventListener("DOMContentLoaded", () => {
    const telefoneInput = document.getElementById("telefone");
    const emailInput = document.getElementById("email");
    const selectDesenho = document.getElementById("desenho");
    const uploadDesenho = document.getElementById("upload-desenho");
    const form = document.getElementById("form-orcamento");

    // Máscara de telefone
    telefoneInput.addEventListener("input", function (e) {
        let input = e.target.value.replace(/\D/g, "");
        if (input.length > 11) input = input.slice(0, 11);

        let formatado = "";

        if (input.length > 0) formatado += "(" + input.substring(0, 2);
        if (input.length >= 3) formatado += ") " + input.substring(2, 7);
        if (input.length >= 8) formatado += "-" + input.substring(7);

        telefoneInput.value = formatado;
    });

    // Mostrar ou ocultar upload de desenho
    selectDesenho.addEventListener("change", () => {
        if (selectDesenho.value === "sim") {
            uploadDesenho.classList.remove("d-none");
        } else {
            uploadDesenho.classList.add("d-none");
        }
    });

    // Função de validação de e-mail
    function validarEmail(email) {
        const regex = /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
        return regex.test(email);
    }

    // Validação do formulário de orçamento
    form.addEventListener("submit", (e) => {
        if (!validarEmail(emailInput.value)) {
            e.preventDefault();
            alert("Por favor, insira um e-mail válido.");
            emailInput.focus();
            return;
        }

        e.preventDefault();
        alert("Solicitação enviada com sucesso! Entraremos em contato em breve.");
        form.reset();
        uploadDesenho.classList.add("d-none");
    });
});
//(orçamento.html) Começo da página de Solicitar de Orçamentos