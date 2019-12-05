package controller;

import dao.ClienteDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;

@WebServlet(name = "UpdateCliente", urlPatterns = {"/UpdateCliente"})
public class UpdateCliente extends HttpServlet {
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
        c.setId(Integer.parseInt(request.getParameter("endereco")));
        
        cd.updateCliente(c);
        String resposta = "Dados atualizados com sucesso!";
        request.setAttribute("resposta", resposta);
        request.getRequestDispatcher("cadastro.jsp").forward(request, response);
    }
}