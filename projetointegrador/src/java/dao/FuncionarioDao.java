package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Funcionario;
import util.DbUtil;

public class FuncionarioDao {

    private Connection connection;

    public FuncionarioDao() {
        connection = DbUtil.getConnection();
    }

    public void addFuncionario(Funcionario funcionario) {
        try {
            PreparedStatement prep = connection
                    .prepareStatement("insert into funcionario (nome, login, senha, email, telefone, cpf, empresa) values (?, ?, ?, ?, ?, ?, ?)");
            prep.setString(1, funcionario.getNome());
            prep.setString(2, funcionario.getLogin());
            prep.setString(3, funcionario.getSenha());
            prep.setString(4, funcionario.getEmail());
            prep.setString(5, funcionario.getTelefone());
            prep.setString(6, funcionario.getCpf());
            prep.setString(7, funcionario.getEmpresa());
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFuncionario(int id) {
        try {
            PreparedStatement prep = connection
                    .prepareStatement("delete from funcionario where id=?");
            prep.setInt(1, id);
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateFuncionario(Funcionario func) {
        try {
            PreparedStatement prep = connection
                    .prepareStatement("update funcionario set nome=?, login=?, senha=?, email=?, telefone=?, cpf=?, empresa=? where id=?");
            prep.setString(1, func.getNome());
            prep.setString(2, func.getLogin());
            prep.setString(3, func.getSenha());
            prep.setString(4, func.getEmail());
            prep.setString(5, func.getTelefone());
            prep.setString(6, func.getCpf());
            prep.setString(7, func.getEmpresa());
            prep.setInt(8, func.getId());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Funcionario> getAllFuncionarios() {
        List<Funcionario> listaDeFuncionario = new ArrayList<Funcionario>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from funcionario");
            while (rs.next()) {
                Funcionario func = new Funcionario();
                func.setId(rs.getInt("id"));
                func.setNome(rs.getString("nome"));
                func.setLogin(rs.getString("login"));
                func.setSenha(rs.getString("senha"));
                func.setEmail(rs.getString("email"));
                func.setTelefone(rs.getString("telefone"));
                func.setCpf(rs.getString("cpf"));
                func.setEmpresa(rs.getString("empresa"));
                func.setAvaliacao(rs.getFloat("avaliacao"));
                listaDeFuncionario.add(func);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaDeFuncionario;
    }

    public Funcionario getFuncionarioByLogin(String login) {
        Funcionario funcionario = new Funcionario();
        try {
            PreparedStatement prep = connection.prepareStatement("select * from funcionario where login=?");
            prep.setString(1, login);
            ResultSet rs = prep.executeQuery();

            if (rs.next()) {
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setLogin(rs.getString("login"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setEmpresa(rs.getString("empresa"));
                funcionario.setAvaliacao(rs.getFloat("avaliacao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionario;
    }
}