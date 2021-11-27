package Repositorio;

import Dominio.Cliente;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClienteDAOTeste{

    private ClienteDAO clienteDAO;

    @Before
    public void iniciar(){
        clienteDAO = new ClienteDAO();
    }
    @After
    public void limpar(){
        clienteDAO.deletarTodos();
    }
    @Test
    public void deveSalvarCliente(){
        Cliente cliente = new Cliente("aa" , "123456" , "aa@gmail.com" , "1234567" , "rua a" ,
                "aaa" , "123445" , "poa");
        clienteDAO.add(cliente);

    }

}
