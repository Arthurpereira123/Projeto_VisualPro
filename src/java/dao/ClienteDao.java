package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import util.DbUtil;

public class ClienteDao {

    private Connection connection;

    public ClienteDao() {
        connection = DbUtil.getConnection();
    }

    public void addCliente(Cliente cliente) {
        try {
            PreparedStatement prep = connection
                    .prepareStatement("insert into cliente (nome, login, senha, email, telefone, cpf, endereco) values (?, ?, ?, ?, ?, ?, ?)");
            prep.setString(1, cliente.getNome());
            prep.setString(2, cliente.getLogin());
            prep.setString(3, cliente.getSenha());
            prep.setString(4, cliente.getEmail());
            prep.setString(5, cliente.getTelefone());
            prep.setString(6, cliente.getCpf());
            prep.setString(7, cliente.getEndereco());
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCliente(int id) {
        try {
            PreparedStatement prep = connection
                    .prepareStatement("delete from cliente where id=?");
            prep.setInt(1, id);
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCliente(Cliente cliente) {
        try {
            PreparedStatement prep = connection
                    .prepareStatement("update cliente set nome=?, login=?, senha=?, email=?, telefone=?, cpf=?, endereco=? where id=?");
            prep.setString(1, cliente.getNome());
            prep.setString(2, cliente.getLogin());
            prep.setString(3, cliente.getSenha());
            prep.setString(4, cliente.getEmail());
            prep.setString(5, cliente.getTelefone());
            prep.setString(6, cliente.getCpf());
            prep.setString(7, cliente.getEndereco());
            prep.setInt(8, cliente.getId());
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> getAllClientes() {
        List<Cliente> listaDeCliente = new ArrayList<Cliente>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from cliente");
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setLogin(rs.getString("login"));
                cliente.setSenha(rs.getString("senha"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEndereco(rs.getString("endereco"));
                listaDeCliente.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaDeCliente;
    }

    public Cliente getClienteByLogin(String login) {
        Cliente cliente = new Cliente();
        try {
            PreparedStatement prep = connection.prepareStatement("select * from cliente where login=?");
            prep.setString(1, login);
            ResultSet rs = prep.executeQuery();

            if (rs.next()) {
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setLogin(rs.getString("login"));
                cliente.setSenha(rs.getString("senha"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEndereco(rs.getString("endereco"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }
}