package controller;

import dao.ClienteDao;
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
        ClienteDao cd = new ClienteDao();
        
        f.setNome(request.getParameter("nome"));
        f.setLogin(request.getParameter("login"));
        f.setSenha(request.getParameter("senha"));
        f.setEmail(request.getParameter("email"));
        f.setTelefone(request.getParameter("telefone"));
        f.setCpf(request.getParameter("cpf"));
        f.setEmpresa(request.getParameter("empresa"));
        f.setId(Integer.parseInt(request.getParameter("id")));
        String opcao = request.getParameter("opcao");
        
        
            fd.addFuncionario(f);
            String resposta = "Cadastro realizado com sucesso!";
            request.setAttribute("resposta", resposta);
            request.getRequestDispatcher("cadastro.jsp").forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            FuncionarioDao fd = new FuncionarioDao();
            List<Funcionario> lista = fd.getAllFuncionarios();
            request.setAttribute("funcionarios", lista);
            request.getRequestDispatcher("agendamento.jsp").forward(request, response);
        }
}