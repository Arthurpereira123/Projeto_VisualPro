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

@WebServlet(name = "ListadeFuncionarios", urlPatterns = {"/ListadeFuncionarios"})
public class ListadeFuncionarios extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FuncionarioDao fd = new FuncionarioDao();
        List<Funcionario> lista = fd.getAllFuncionarios();
        request.setAttribute("funcionarios", lista);
        request.getRequestDispatcher("agendamento.jsp").forward(request, response);
    }
}
