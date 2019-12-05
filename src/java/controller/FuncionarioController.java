package controller;

import dao.FuncionarioDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Funcionario;


@WebServlet(name = "FuncionarioController", urlPatterns = {"/FuncionarioController"})
public class FuncionarioController extends HttpServlet {

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
        String opcao = request.getParameter("opcao");
        
        if(opcao.equals("Cadastrar")){
            fd.addFuncionario(f);
            String resposta = "Cadastro realizado com sucesso!";
            request.setAttribute("resposta", resposta);
            request.getRequestDispatcher("cadastro.jsp").forward(request, response);
        } else if (opcao.equals("Atualizar")){
            fd.updateFuncionario(f);
            String resposta = "Dados atualizados com sucesso!";
            request.setAttribute("resposta", resposta);
            request.getRequestDispatcher("cadastro.jsp").forward(request, response);
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FuncionarioDao fd = new FuncionarioDao();
        int id = Integer.parseInt(request.getParameter("opcao"));
        fd.deleteFuncionario(id);
        response.sendRedirect("index.jsp");
    }
}