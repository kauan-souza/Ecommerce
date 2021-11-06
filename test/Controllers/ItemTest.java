package Controllers;

import org.junit.Assert;
import org.junit.Test;

public class ItemTest {

    @Test
    public void deveValidarDadosObrigatorios() {
        try {
            Item item = new Item(null , 0) ;
        } catch (IllegalArgumentException exception) {
            Assert.assertTrue(exception.getMessage().contains("informe um produto"));
            Assert.assertTrue(exception.getMessage().contains("informe uma quantidade"));

        }
    }
}
