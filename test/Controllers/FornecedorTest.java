package Controllers;

import org.junit.Assert;
import org.junit.Test;

public class FornecedorTest {

    @Test
    public void deveValidarDadosObrigatorios() {
//        Cliente cliente = new Cliente("joao" , "12345678910" ,"joao@gmail.com" ,
//                "123456" , "av ipiranga" , "partenon" , "12345678" , "porto alegre");

        try {
            Fornecedor fornecedor = new Fornecedor(null, null, "joao",
                    null, null, null, null, null , null);

        } catch (IllegalArgumentException exception) {
            Assert.assertTrue(exception.getMessage().contains("informe um nomeFantasia valido"));
            Assert.assertTrue(exception.getMessage().contains("informe um cnpj valido"));
            Assert.assertTrue(exception.getMessage().contains("informe um email valido"));
            Assert.assertTrue(exception.getMessage().contains("informe um telefone valido"));
            Assert.assertTrue(exception.getMessage().contains("informe uma rua valida"));
            Assert.assertTrue(exception.getMessage().contains("informe um bairro valido"));
            Assert.assertTrue(exception.getMessage().contains("informe um cep valido"));
            Assert.assertTrue(exception.getMessage().contains("informe uma cidade valida"));
            Assert.assertTrue(exception.getMessage().contains("informe um estado valido"));

        }
    }
}

