package Controllers;

import org.junit.Assert;
import org.junit.Test;

public class ProdutoTest {

    @Test
    public void deveValidarDadosObrigatorios() {
        try {
            Produto produto = new Produto(null);
        }catch (IllegalArgumentException exception){
            Assert.assertTrue(exception.getMessage().contains("informe um nome"));

        }
    }
}
