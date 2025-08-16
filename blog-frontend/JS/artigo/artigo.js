
                document.addEventListener("DOMContentLoaded", async () => {
    const section = document.querySelector("main section");

    try {
        const response = await fetch("http://localhost:8080/artigo/todos_artigos");
        if (!response.ok) {
            throw new Error(`Erro ao buscar artigos: ${response.status}`);
        }

        const artigos = await response.json();

        artigos.forEach(artigo => {
            const articleEl = document.createElement("article");

            const h1 = document.createElement("h1");
            h1.textContent = artigo.titulo;

            const pResumo = document.createElement("p");
            pResumo.className = "resumo";
            pResumo.textContent = artigo.resumo;

            const pData = document.createElement("p");
            pData.className = "data";
            pData.textContent = formatarDataBrasileira(artigo.data); // formatação pode ser feita aqui

            const h2 = document.createElement("h2");
            h2.textContent = "Conteúdo";

            const pTexto = document.createElement("p");
            pTexto.className = "texto";
            pTexto.textContent = artigo.conteudo;

            articleEl.appendChild(h1);
            articleEl.appendChild(pResumo);
            articleEl.appendChild(pData);
            articleEl.appendChild(h2);
            articleEl.appendChild(pTexto);

            section.appendChild(articleEl);
        });
    } catch (error) {
        console.error(error);
        section.innerHTML = "<p>Erro ao carregar artigos.</p>";
    }

    function formatarDataBrasileira(dataIso) {
    const data = new Date(dataIso);
    return data.toLocaleString("pt-BR", {
        timeZone: "America/Sao_Paulo"
    });
}
});