package Dominio;

import org.junit.Assert;
import org.junit.Test;

public class ClienteTest {

    @Test
    public void deveValidarDadosObrigatorios() {
        try {
            Cliente cliente = new Cliente(null, null, "joao",
                    null, null, "", "123456789101213", null);

        } catch (IllegalArgumentException exception) {
            Assert.assertTrue(exception.getMessage().contains("informe um nome valido"));
            Assert.assertTrue(exception.getMessage().contains("informe um cpf valido"));
            Assert.assertTrue(exception.getMessage().contains("informe um email valido"));
            Assert.assertTrue(exception.getMessage().contains("informe um telefone valido"));
            Assert.assertTrue(exception.getMessage().contains("informe uma rua valida"));
            Assert.assertTrue(exception.getMessage().contains("informe um bairro valido"));
            Assert.assertTrue(exception.getMessage().contains("informe um cep valido"));
            Assert.assertTrue(exception.getMessage().contains("informe uma cidade valida"));
        }
    }

    @Test
    public void deveValidarQuantidadeDeCampos() {
        Cliente cliente1 = new Cliente("joao", "12345678910", "joao@gmail.com",
                "123456", "av ipiranga", "partenon", "12345678", "porto alegre");

        Assert.assertEquals("joao", cliente1.getNome());
    }
}
