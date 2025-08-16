// JS para login e armazenamento do token JWT

document.addEventListener('DOMContentLoaded', function () {
    const form = document.getElementById('loginForm');
    form.addEventListener('submit', async function (e) {
        e.preventDefault();
        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;
        const payload = { username, password };
        try {
            const response = await fetch('http://localhost:8080/auth/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(payload)
            });
            const body = await response.json();
            if (response.ok && body.token) {
                localStorage.setItem('jwtToken', body.token);
                alert('Login realizado com sucesso!');
                window.location.href = '/HTML/gud.html';
            } else {
                alert('Erro ao logar: ' + (body.message || 'Credenciais inválidas'));
            }
        } catch (err) {
            alert('Erro de conexão com o servidor.');
        }
    });
});
