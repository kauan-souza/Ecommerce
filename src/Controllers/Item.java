package Controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Item {

    private Produto produto;
    private int quantidade;
    private Double valorTotalItem;

    protected List<String> mensagens = new ArrayList<>();

    public Item(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        validar();
    }
    protected void validar() {
        if (produto == null ) {
            mensagens.add("informe um produto");
        }
        if (quantidade == 0) {
            mensagens.add("informe uma quantidade");
        }
        if (!mensagens.isEmpty()) {
            throw new IllegalArgumentException(mensagens.toString());
        }
    }
}