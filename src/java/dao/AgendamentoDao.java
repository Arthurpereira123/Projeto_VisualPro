package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Agendamento;
import util.DbUtil;

public class AgendamentoDao {
    private Connection connection;

    public AgendamentoDao() {
        connection = DbUtil.getConnection();
    }

    public void agendar(Agendamento ag) {
        try {
            PreparedStatement prep = connection
                    .prepareStatement("insert into agendamento (funcionario, hora, dtagendamento, cliente) values (?, ?, ?, ?)");
            prep.setString(1, ag.getFuncionario());
            prep.setString(2, ag.getHora());
            prep.setString(3, ag.getData());
            prep.setString(4, ag.getCliente());
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
