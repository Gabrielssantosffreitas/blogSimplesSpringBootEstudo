document.addEventListener('DOMContentLoaded', function () {
    const form = document.querySelector('form');
    if (!form) return;
    form.addEventListener('submit', async function (e) {
        e.preventDefault();

        const nome = document.getElementById('nome').value;
        const username = document.getElementById('username').value;
        const senha = document.getElementById('senha').value;
        const role = document.getElementById('role').value;

        const payload = {
            nome,
            username,
            password: senha,
            role: role === "1" ? "ADMINISTRADOR" : "ANONIMO"
        };

        try {
                const response = await fetch('http://localhost:8080/auth/register', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(payload)
                });

                const responseBody = await response.text();
                console.log('Status:', response.status);
                console.log('Body:', responseBody);

                if (response.ok) {
                    alert('Cadastro realizado com sucesso!');
                    form.reset();
                } else {
                    alert('Erro ao cadastrar: ' + responseBody);
                }
        } catch (err) {
            alert('Erro de conexão com o servidor.');
        }
    });
});
