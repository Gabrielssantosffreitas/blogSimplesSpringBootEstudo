// JS para criar, editar e deletar artigo usando JWT
// O token JWT deve estar salvo em localStorage com a chave 'jwtToken'

document.addEventListener('DOMContentLoaded', function () {
    // CRIAR ARTIGO
    const criarForm = document.querySelectorAll('section form')[0];
    criarForm.addEventListener('submit', async function (e) {
        e.preventDefault();
        const titulo = document.getElementById('titulo').value;
        const resumo = document.getElementById('resumo').value;
        const conteudo = document.getElementById('conteudo').value;
        const token = localStorage.getItem('jwtToken');
        const payload = { titulo, resumo, conteudo };
        try {
            const response = await fetch('http://localhost:8080/artigo/post_artigo', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': 'Bearer ' + token
                },
                body: JSON.stringify(payload)
            });
            const body = await response.text();
            if (response.ok) {
                alert('Artigo criado com sucesso!');
                criarForm.reset();
            } else {
                alert('Erro ao criar artigo: ' + body);
            }
        } catch (err) {
            alert('Erro de conexão com o servidor.');
        }
    });

    // EDITAR ARTIGO
    const editarForm = document.querySelectorAll('section form')[1];
    editarForm.addEventListener('submit', async function (e) {
        e.preventDefault();
        const id = editarForm.querySelector('#id').value;
        const titulo = editarForm.querySelector('#titulo').value;
        const resumo = editarForm.querySelector('#resumo').value;
        const conteudo = editarForm.querySelector('#conteudo').value;
        const token = localStorage.getItem('jwtToken');
        const payload = { titulo, resumo, conteudo };
        try {
            const response = await fetch(`http://localhost:8080/artigo/editar_artigo/${id}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': 'Bearer ' + token
                },
                body: JSON.stringify(payload)
            });
            const body = await response.text();
            if (response.ok) {
                alert('Artigo editado com sucesso!');
                editarForm.reset();
            } else {
                alert('Erro ao editar artigo: ' + body);
            }
        } catch (err) {
            alert('Erro de conexão com o servidor.');
        }
    });

    // DELETAR ARTIGO
    const deletarForm = document.querySelectorAll('section form')[2];
    deletarForm.addEventListener('submit', async function (e) {
        e.preventDefault();
        const id = deletarForm.querySelector('#id').value;
        const token = localStorage.getItem('jwtToken');
        try {
            const response = await fetch(`http://localhost:8080/artigo/deletar_artigo/${id}`, {
                method: 'DELETE',
                headers: {
                    'Authorization': 'Bearer ' + token
                }
            });
            const body = await response.text();
            if (response.ok) {
                alert('Artigo deletado com sucesso!');
                deletarForm.reset();
            } else {
                alert('Erro ao deletar artigo: ' + body);
            }
        } catch (err) {
            alert('Erro de conexão com o servidor.');
        }
    });
});
