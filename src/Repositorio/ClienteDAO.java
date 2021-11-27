package Repositorio;

import Dominio.Cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {

    private Connection conexao;

    public ClienteDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/ecommerce";
            conexao = DriverManager.getConnection(url, "root", "123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void add(Cliente model) {
        try {
            String sql = "INSERT INTO Cliente(nome, cpf, email, telefone, rua," +
                    "bairro, cep, cidade, estado) VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, model.getNome());
            preparedStatement.setString(2, model.getCpf());
            preparedStatement.setString(3, model.getEmail());
            preparedStatement.setString(4, model.getTelefone());
            preparedStatement.setString(5, model.getRua());
            preparedStatement.setString(6, model.getBairro());
            preparedStatement.setString(7, model.getCep());
            preparedStatement.setString(8, model.getCidade());
            preparedStatement.setString(9, model.getEstado());

            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void deletarTodos() {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("DELETE * FROM cliente");
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}


