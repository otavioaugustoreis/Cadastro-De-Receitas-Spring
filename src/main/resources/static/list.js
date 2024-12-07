async function carregarReceitas() {
    try {
        const response = await fetch('http://localhost:8080/receita');

        if (response.ok) {
            const receitas = await response.json();
            const tbody = document.getElementById('receitas-lista');
            const tabela = document.getElementById('tabela-receitas');
            const mensagem = document.getElementById('mensagem-sem-receitas');

            tbody.innerHTML = '';

            if (receitas.length > 0) {
                receitas.forEach((receita) => {
                    const tr = document.createElement('tr');
                    tr.innerHTML = `
                        <td>${receita.id}</td>
                        <td>${receita.nome}</td>
                    `;
                    tbody.appendChild(tr);
                });
                tabela.style.display = 'table';
                mensagem.style.display = 'none';
            } else {
                tabela.style.display = 'none';
                mensagem.style.display = 'block';
            }
        } else {
            console.error('Erro ao carregar receitas', response.status);
        }
    } catch (error) {
        console.error('Erro na requisição:', error);
        alert('Não foi possível carregar as receitas. Tente novamente.');
    }
}

carregarReceitas();
