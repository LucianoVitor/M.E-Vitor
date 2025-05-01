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

// Agendamento de visitas
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







