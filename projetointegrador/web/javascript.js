function mostrarOcultar(obj) {
    if(obj == 'tblDados') {
        document.getElementById('tblDados').hidden = false;
        document.getElementById('tblAtendimentos').hidden = true;
        document.getElementById('formCliente').hidden = true;
    } else if(obj == 'tblAtendimentos'){
        document.getElementById('tblAtendimentos').hidden = false;
        document.getElementById('tblDados').hidden = true;
        document.getElementById('formCliente').hidden = true;
    } else if(obj == 'formCliente') {
        document.getElementById('formCliente').hidden = false;
        document.getElementById('tblDados').hidden = true;
        document.getElementById('tblAtendimentos').hidden = true;
    }
}

function mostrarForm(obj) {
    if(obj == 'formCliente') {
        document.getElementById('formCliente').hidden = false;
        document.getElementById('formFuncionario').hidden = true;
        document.getElementById('confirmacao').hidden = true;
        document.getElementById('imgcadastro').hidden = true;
    } else {
        document.getElementById('formFuncionario').hidden = false;
        document.getElementById('formCliente').hidden = true;
        document.getElementById('confirmacao').hidden = true;
        document.getElementById('imgcadastro').hidden = true;
    }
}

function confirmacao(clogin) {
    alert('Deseja realmente excluir?')
}