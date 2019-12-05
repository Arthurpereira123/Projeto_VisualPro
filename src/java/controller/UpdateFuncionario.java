package controller;

import dao.ClienteDao;
import dao.FuncionarioDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Funcionario;

@WebServlet(name = "UpdateFuncionario", urlPatterns = {"/UpdateFuncionario"})
public class UpdateFuncionario extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Funcionario f = new Funcionario();
        FuncionarioDao fd = new FuncionarioDao();
        
        f.setNome(request.getParameter("nome"));
        f.setLogin(request.getParameter("login"));
        f.setSenha(request.getParameter("senha"));
        f.setEmail(request.getParameter("email"));
        f.setTelefone(request.getParameter("telefone"));
        f.setCpf(request.getParameter("cpf"));
        f.setEmpresa(request.getParameter("empresa"));
        f.setId(Integer.parseInt(request.getParameter("id")));
        
        fd.updateFuncionario(f);
        String resposta = "Dados atualizados com sucesso!";
        request.setAttribute("resposta", resposta);
        request.getRequestDispatcher("cadastro.jsp").forward(request, response);
    }
}