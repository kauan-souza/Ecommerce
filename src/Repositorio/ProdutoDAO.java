package Repositorio;

import Dominio.Pedido;
import Dominio.Produto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO {

        private Connection conexao;

        public ProdutoDAO() {
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
        public void add(Produto model) {
            try {
                String sql = "INSERT INTO Produto(id_produto, nome, descricao, valorUnitario) VALUES(?,?,?,?,)";
                PreparedStatement preparedStatement = conexao.prepareStatement(sql);
                preparedStatement.setLong(1, model.getId_produto());
                preparedStatement.setObject(2, model.getNome());
                preparedStatement.setString(3, model.getDescricao());
                preparedStatement.setDouble(4, model.getValorUnitario());

                preparedStatement.execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        public void deletarTodos() {
            try {
                PreparedStatement preparedStatement = conexao.prepareStatement("DELETE * FROM cliente");
                preparedStatement.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

