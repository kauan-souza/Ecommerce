package Repositorio;

import Dominio.*;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class PedidoDAOTeste {

    private Fornecedor paulo;
    private Cliente jose;
    private Produto banco_de_celta;
    private Produto vidro_de_celta;
    private PedidoDAO pedidoDAO;

    @BeforeEach
    public void init() {

        pedidoDAO = new PedidoDAO();
        pedidoDAO.deletarTodos();

        paulo = new Fornecedor("PauloMecanica", "72038484000179" , "mecanica@gmail.com" , "5199999999" ,
                "protasio alves" , "carvalhada" , "6143059" , "porto alegre" , "rs");
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.add(paulo);

        jose = new Cliente("jose" , "98765432123" , "jose@gmail.com" , "5143232423", "ipiranga"
        , "partenom", "1232134534253", "porto alegre");
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.add(jose);

        banco_de_celta = new Produto("Banco de Celta", "Banco acolchoado sem revestimento", 105.99);
        vidro_de_celta = new Produto("Vidro de celta", "vidro temperado frontal de celta", 60.50);
        ProdutoDAO produtoDao = new ProdutoDAO();
        produtoDao.add(banco_de_celta);
        produtoDao.add(vidro_de_celta);
    }
    @AfterEach
    public void excluirDados() {

        pedidoDAO.deletarTodos();
    }

}
