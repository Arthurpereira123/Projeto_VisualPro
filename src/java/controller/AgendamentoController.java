package controller;

import dao.AgendamentoDao;
import dao.FuncionarioDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Agendamento;
import model.Cliente;
import model.Funcionario;

@WebServlet(name = "AgendamentoController", urlPatterns = {"/AgendamentoController"})
public class AgendamentoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Agendamento a = new Agendamento();
        AgendamentoDao ad = new AgendamentoDao();
        HttpSession sessao = request.getSession();
        
        Cliente c = (Cliente) sessao.getAttribute("cliente");
        Funcionario f = (Funcionario) sessao.getAttribute("funcionario");
        
        a.setHora(request.getParameter("hora"));
        a.setData(request.getParameter("data"));
        a.setFuncionario(request.getParameter("funcionario"));
        
        if(c != null){
            a.setCliente(c.getNome());
        } else if(f != null) {
            a.setCliente(f.getNome());
        }
        ad.agendar(a);
        String resposta = "Atendimento marcado para o dia " + a.getData() + " às " + a.getHora() + " com " + a.getFuncionario() + ".";
        request.setAttribute("resposta", resposta);
        request.getRequestDispatcher("ListadeFuncionarios").forward(request, response);
    }
}