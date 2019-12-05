package controller;

import dao.AgendamentoDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Agendamento;
import model.Cliente;

@WebServlet(name = "AgendamentoController", urlPatterns = {"/AgendamentoController"})
public class AgendamentoController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Agendamento a = new Agendamento();
        AgendamentoDao ad = new AgendamentoDao();
        HttpSession sessao = request.getSession();
        
        Cliente c = (Cliente) sessao.getAttribute("cliente");
        a.setHora(request.getParameter("hora"));
        a.setData(request.getParameter("data"));
        a.setFuncionario(request.getParameter("funcionario"));
        a.setCliente(c.getNome());
        ad.agendar(a);
    }
}