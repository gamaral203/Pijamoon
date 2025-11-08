async function carregarProdutos() {
    try {
        const resposta = await fetch("/produtos");
        const produtos = await resposta.json();

        const div = document.getElementById("produtos");
        div.innerHTML = "";

        produtos.forEach(p => {
            const item = document.createElement("div");
            item.classList.add("produto");
            item.innerHTML = `
        <h3>${p.nome}</h3>
        <p>${p.descricao}</p>
        <p><strong>R$ ${p.preco.toFixed(2)}</strong></p>
      `;
            div.appendChild(item);
        });
    } catch (e) {
        console.error("Erro ao carregar produtos:", e);
    }
}

carregarProdutos();
