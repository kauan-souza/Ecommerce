package Repositorio;

import Dominio.Cliente;
import Dominio.Fornecedor;

import java.sql.*;

public class FornecedorDAO {

    private Connection conexao;

    public FornecedorDAO() {
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
    public void add(Fornecedor model) {
        try {
            String sql = "INSERT INTO Fornecedor(id_fornecedor, nomeFantasia, cnpj, email,telefone,rua,numero,bairro," +
                    "complemento,cep,cidade,estado) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setLong(1, model.getId_fornecedor());
            preparedStatement.setString(2, model.getNomeFantasia());
            preparedStatement.setString(3, model.getCnpj());
            preparedStatement.setString(4, model.getEmail());
            preparedStatement.setString(5, model.getTelefone());
            preparedStatement.setString(6, model.getRua());
            preparedStatement.setString(7, model.getNumero());
            preparedStatement.setString(8, model.getBairro());
            preparedStatement.setString(9, model.getComplemento());
            preparedStatement.setString(10, model.getCep());
            preparedStatement.setString(11, model.getCidade());
            preparedStatement.setString(12, model.getEstado());

            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void deletarTodos() {

    }

}
