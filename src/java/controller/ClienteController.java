package controller;

import dao.ClienteDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;


@WebServlet(name = "ClienteController", urlPatterns = {"/ClienteController"})
public class ClienteController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cliente c = new Cliente();
        ClienteDao cd = new ClienteDao();
        
        c.setNome(request.getParameter("nome"));
        c.setLogin(request.getParameter("login"));
        c.setSenha(request.getParameter("senha"));
        c.setEmail(request.getParameter("email"));
        c.setTelefone(request.getParameter("telefone"));
        c.setCpf(request.getParameter("cpf"));
        c.setEndereco(request.getParameter("endereco"));
        
        cd.addCliente(c);
        String resposta = "Cadastro realizado com sucesso!";
        request.setAttribute("resposta", resposta);
        request.getRequestDispatcher("cadastro.jsp").forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClienteDao cd = new ClienteDao();
        int id = Integer.parseInt(request.getParameter("opcao"));
        cd.deleteCliente(id);
        response.sendRedirect("index.jsp");
    }
}