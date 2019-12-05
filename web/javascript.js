function mostrarOcultar(obj) {
    if(obj == 'tblDados') {
        document.getElementById('tblDados').hidden = false;
        document.getElementById('formCliente').hidden = true;
        document.getElementById('formFuncionario').hidden = true;
    } else if(obj == 'formCliente'){
        document.getElementById('formCliente').hidden = false;
        document.getElementById('tblDados').hidden = true;
        document.getElementById('formFuncionario').hidden = true;
    } else if(obj == 'formFuncionario') {
        document.getElementById('formFuncionario').hidden = false;
        document.getElementById('tblDados').hidden = true;
        document.getElementById('formCliente').hidden = true;
    }
}
    
function mostrarForm(obj) {
    if(obj == 'formCliente') {
        document.getElementById('formCliente').hidden = false;
        document.getElementById('formFuncionario').hidden = true;
        document.getElementById('imgcadastro').hidden = true;
        document.getElementById('resposta').hidden = true;
    } else {
        document.getElementById('formFuncionario').hidden = false;
        document.getElementById('formCliente').hidden = true;
        document.getElementById('imgcadastro').hidden = true;
        document.getElementById('resposta').hidden = true;
    }
}

function confirmacao() {
    alert('Deseja realmente remover sua conta?');
}