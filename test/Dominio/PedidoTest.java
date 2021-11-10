package Dominio;


import org.junit.Assert;
import org.junit.Test;

public class PedidoTest {

    @Test
    public void deveValidarDadosObrigatorios() {
        try {
            Pedido pedido = new Pedido(null, null, null, null, null);
        } catch (IllegalArgumentException exception) {
            Assert.assertTrue(exception.getMessage().contains("informe uma dataCompra"));
            Assert.assertTrue(exception.getMessage().contains("informe um fornecedor"));
            Assert.assertTrue(exception.getMessage().contains("informe um cliente"));
            Assert.assertTrue(exception.getMessage().contains("informe um valorTotal"));
            Assert.assertTrue(exception.getMessage().contains("informe um valorTotalItens"));
        }
    }
}