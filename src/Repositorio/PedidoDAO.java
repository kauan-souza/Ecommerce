package Repositorio;

import Dominio.*;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {

    private Connection conexao;

    public PedidoDAO() {
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

    public void add(Pedido model) {
        try {
            String sql = "INSERT INTO Pedido(dataCompra, id_fornecedor, id_client, valorFrete ) VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setObject(1, model.getDataCompra());
            preparedStatement.setLong(2, model.getFornecedor().getId_fornecedor());
            preparedStatement.setLong(3, model.getCliente().getId_cliente());
            preparedStatement.setDouble(4, model.getValorFrete());

            preparedStatement.execute();

            long pedido_id = 0;

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    pedido_id = (generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
            for (Item item : model.itens) {
                String sqlItem = "INSERT INTO Item (id_produto, id_Pedido, quantidade) VALUES (?,?,?)";
                PreparedStatement preparedStatement1 = conexao.prepareStatement(sqlItem);
                preparedStatement1.setLong(1, item.getProduto().getId_produto());
                preparedStatement1.setLong(2, pedido_id);
                preparedStatement1.setLong(3, item.getQuantidade());
                preparedStatement1.execute();
            }
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
    public List<Pedido> buscarTodosPedidos() {

        List<Pedido> pedidos = new ArrayList<>();
        try {

            String sql = "select * from pedido p " +
                    "inner join fornecedor f on f.id_fornecedor = p.id_fornecedor " +
                    "inner join cliente c on c.id_cliente = p.id_cliente " +
                    "inner join item i on i.id_pedido = p.id_pedido " +
                    "inner join produto pr on pr.id_produto = i.id_produto";
            Statement preparedStatement = conexao.createStatement();
            ResultSet resultados = preparedStatement.executeQuery(sql);

            List<Item> itens = new ArrayList<>();
            LocalDateTime dataCompra = null;
            double valorFrete = 0;
            Cliente cliente = null;
            Fornecedor fornecedor = null;

            while (resultados.next()) {

                //pedido
                dataCompra = resultados.getObject("dataCompra", LocalDateTime.class);
                valorFrete = resultados.getDouble("valorFrete");
                //fornecedor
                var nomeFantasia = resultados.getString("nomeFantasia");
                var cnpj = resultados.getString("cnpj");
                var emailFornecedor = resultados.getString("emailFornecedor");
                var telefoneFornecedor = resultados.getString("telefoneFornecedor");
                var ruaFornecedor = resultados.getString("ruaFornecedor");
                var bairroFornecedor = resultados.getString("bairroFornecedor");
                var complementoFornecedor = resultados.getString("complementoFornecedor");
                var cepFornecedor = resultados.getString("cepFornecedor");
                var cidadeFornecedor = resultados.getString("cidadeFornecedor");
                var estadoFornecedor = resultados.getString("estadoFornecedor");
                fornecedor = new Fornecedor(nomeFantasia, cnpj , emailFornecedor , telefoneFornecedor , ruaFornecedor , bairroFornecedor,
                        cepFornecedor, cidadeFornecedor, estadoFornecedor);
                //cliente
                var nomeCliente = resultados.getString("nomeCliente");
                var cpf = resultados.getString("cpf");
                var emailCliente = resultados.getString("emailCliente");
                var telefoneCliente = resultados.getString("telefoneCliente");
                var ruaCliente = resultados.getString("ruaCliente");
                var numeroCliente = resultados.getString("numeroCliente");
                var bairroCliente = resultados.getString("bairroCliente");
                var complementoCliente = resultados.getString("complementoCliente");
                var cepCliente = resultados.getString("cepCliente");
                var cidadeCliente = resultados.getString("cidadeCliente");
                var estadoCliente = resultados.getString("estadoCliente");
                cliente = new Cliente(nomeCliente, cpf, emailCliente, telefoneCliente, ruaCliente, bairroCliente,cepCliente, cidadeCliente);
                //produto
                var quantidade = resultados.getInt("quantidade");
                var nomeProduto = resultados.getString("nomeProduto");
                var descricaoProduto = resultados.getString("descricao");
                var valorUnitario = resultados.getDouble("valorUnitario");
                Produto produto = new Produto(nomeProduto, descricaoProduto, valorUnitario);
                Item item = new Item(produto, quantidade);
                System.out.println(item.getProduto().getNome());
                System.out.println(item.getProduto().getDescricao());
                System.out.println(item.getProduto().getValorUnitario());
                itens.add(item);
            }
            pedidos.add(new Pedido(dataCompra, fornecedor, cliente));

        } catch (SQLException sqlException) {

            sqlException.printStackTrace();
        }
        if (pedidos.isEmpty()) {

            throw new IllegalArgumentException("Nenhum pedido encontrado!");
        }
        return pedidos;

    }

//    public void buscarPorId() {
//        try {
//            String query = "SELECT * FROM PEDIDO p " +
//                    "inner join Fornecedor f on p.id_fornecedor = f.id_fornecedor " +
//                    "inner join Cliente c on p.id_cliente = c.id_cliente " +
//                    "inner join Item i on p.id_pedido = i.id_item " +
//                    "inner join Produto pr on pr.id_produto = i.id_produto ";
//            PreparedStatement preparedStatement = conexao.prepareStatement(query);
//            ResultSet rs = preparedStatement.executeQuery();
//            while(rs.next()){
//                String nomeFantasia =  rs.getString("nomeFornecedor" );
//                Fornecedor fornecedor = new Fornecedor()
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
