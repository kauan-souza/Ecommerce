package Controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

    private Date dataCompra;
    private Fornecedor fornecedor;
    private Cliente cliente;
    private Double valorTotal;
    private Double valorTotalItens;
    private Double valorFrete;
    public List<Item> itens = new ArrayList<>();

    protected List<String> mensagens = new ArrayList<>();

    public Pedido(Date dataCompra, Fornecedor fornecedor, Cliente cliente, Double valorTotal,
             Double valorTotalItens) {
        this.dataCompra = dataCompra;
        this.fornecedor = fornecedor;
        this.cliente = cliente;
        this.valorTotal = valorTotal;
        this.valorTotalItens = valorTotalItens;
        validar();
    }
    protected void validar() {
        if (dataCompra == null ) {
            mensagens.add("informe uma dataCompra");
        }
        if (fornecedor == null ) {
            mensagens.add("informe um fornecedor");
        }
        if (cliente == null ) {
            mensagens.add("informe um cliente");
        }
        if (valorTotal == null || valorTotal > 0) {
            mensagens.add("informe um valorTotal");
        }
        if (valorTotalItens == null || valorTotal > 0) {
            mensagens.add("informe um valorTotalItens");
        }
        if (!mensagens.isEmpty()) {
            throw new IllegalArgumentException(mensagens.toString());
        }
    }
}


