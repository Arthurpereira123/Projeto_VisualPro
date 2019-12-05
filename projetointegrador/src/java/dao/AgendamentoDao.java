package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Agendamento;
import util.DbUtil;

public class AgendamentoDao {
    private Connection connection;

    public AgendamentoDao() {
        connection = DbUtil.getConnection();
    }

    public void agendar(Agendamento a) {
        try {
            PreparedStatement prep = connection
                    .prepareStatement("insert into agendamento (funcionario, hora, dtagendamento, cliente) values (?, ?, ?, ?)");
            prep.setString(1, a.getFuncionario());
            prep.setString(2, a.getHora());
            prep.setString(3, a.getData());
            prep.setString(4, a.getCliente());
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
