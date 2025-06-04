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
//(orçamento.html) Término da página de Solicitar de Orçamentos
//(orçamento.html) Começo da página de Carrinho de pagamentos
let carrinho = JSON.parse(localStorage.getItem('carrinho')) || [];

function salvarCarrinho() {
    localStorage.setItem('carrinho', JSON.stringify(carrinho));
}

function adicionarAoCarrinho(nome, preco) {
    const itemExistente = carrinho.find(item => item.nome === nome);
    if (itemExistente) {
        itemExistente.quantidade += 1;
    } else {
        carrinho.push({ nome, preco, quantidade: 1 });
    }
    salvarCarrinho();
    alert(`"${nome}" foi adicionado ao carrinho!`);
}

function removerDoCarrinho(nome) {
    carrinho = carrinho.filter(item => item.nome !== nome);
    salvarCarrinho();
    exibirCarrinho();
}

function alterarQuantidade(nome, quantidade) {
    const item = carrinho.find(item => item.nome === nome);
    if (item) {
        item.quantidade = quantidade;
        if (item.quantidade <= 0) {
            removerDoCarrinho(nome);
        } else {
            salvarCarrinho();
            exibirCarrinho();
        }
    }
}

function exibirCarrinho() {
    const carrinhoContainer = document.getElementById('carrinho-itens');
    carrinhoContainer.innerHTML = '';

    if (carrinho.length === 0) {
        carrinhoContainer.innerHTML = '<p>Seu carrinho está vazio.</p>';
        document.getElementById('total').innerText = 'Total: R$ 0,00';
        return;
    }

    carrinho.forEach(item => {
        const div = document.createElement('div');
        div.classList.add('item-carrinho');
        div.innerHTML = `
            <div class="detalhes-item">
                <h4>${item.nome}</h4>
                <p>Preço: R$ ${item.preco.toFixed(2)}</p>
                <p>
                    Quantidade:
                    <button onclick="alterarQuantidade('${item.nome}', ${item.quantidade - 1})">-</button>
                    ${item.quantidade}
                    <button onclick="alterarQuantidade('${item.nome}', ${item.quantidade + 1})">+</button>
                </p>
                <p>Subtotal: R$ ${(item.preco * item.quantidade).toFixed(2)}</p>
            </div>
            <button class="btn-remover" onclick="removerDoCarrinho('${item.nome}')">Remover</button>
        `;
        carrinhoContainer.appendChild(div);
    });

    const total = carrinho.reduce((acc, item) => acc + item.preco * item.quantidade, 0);
    document.getElementById('total').innerText = `Total: R$ ${total.toFixed(2)}`;
}

function finalizarCompra() {
    if (carrinho.length === 0) {
        alert('Seu carrinho está vazio!');
        return;
    }
    alert('Obrigado pela sua compra! 🛍️\nEm breve entraremos em contato.');
    carrinho = [];
    salvarCarrinho();
    exibirCarrinho();
}

window.onload = exibirCarrinho;
