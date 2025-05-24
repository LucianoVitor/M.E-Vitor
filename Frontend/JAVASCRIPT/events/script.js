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


//(visita.html) Término da página de Agendamento de Visitas

//(orçamento.html) Começo da página de Solicitar de Orçamentos
document.addEventListener("DOMContentLoaded", () => {
    const selectDesenho = document.getElementById("desenho");
    const uploadDesenho = document.getElementById("upload-desenho");


    // Mostrar ou ocultar upload de desenho
    selectDesenho.addEventListener("change", () => {
        if (selectDesenho.value === "sim") {
            uploadDesenho.classList.remove("d-none");
        } else {
            uploadDesenho.classList.add("d-none");
        }
    });
 

});
