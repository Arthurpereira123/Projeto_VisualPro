package controller;

import dao.ClienteDao;
import dao.FuncionarioDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cliente;
import model.Funcionario;

@WebServlet(name = "Verificacao", urlPatterns = {"/Verificacao"})
public class Verificacao extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClienteDao cd = new ClienteDao();
        FuncionarioDao fd = new FuncionarioDao();
        HttpSession sessao = request.getSession();
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        Cliente c = cd.getClienteByLogin(login);
        Funcionario f = fd.getFuncionarioByLogin(login);
        
        if(login.equals(c.getLogin()) && senha.equals(c.getSenha())) {
            sessao.setAttribute("cliente", c);
            response.sendRedirect("perfilcliente.jsp");
        } else if(login.equals(f.getLogin()) && senha.equals(f.getSenha())) {
            sessao.setAttribute("funcionario", f);
            response.sendRedirect("perfilfuncionario.jsp");
        } else if(login.equals("") || senha.equals("")){
            String resposta = "Por favor, preencha todos os campos para entrar.";
            request.setAttribute("resposta", resposta);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            String resposta = "Nome de usuário ou senha incorretos. Tente novamente!";
            request.setAttribute("resposta", resposta);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        String opcao = request.getParameter("opcao");
        if("sair".equals(opcao)) {
            sessao.invalidate();
            response.sendRedirect("login.jsp");
        } else if("redirecionar".equals(opcao)) {
            Cliente c = (Cliente) sessao.getAttribute("cliente");
            Funcionario f = (Funcionario) sessao.getAttribute("funcionario");
            if(c != null) {
                response.sendRedirect("perfilcliente.jsp");
            } else if(f != null) {
                response.sendRedirect("perfilfuncionario.jsp");
            } else {
                response.sendRedirect("login.jsp");
            }
        }
    }
}