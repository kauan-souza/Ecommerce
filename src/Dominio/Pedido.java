package Dominio;

import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

    private long id_pedido;
    private LocalDateTime dataCompra;
    private Fornecedor fornecedor;
    private Cliente cliente;
    private Double valorTotal;
    private Double valorTotalItens;
    private Double valorFrete;
    public List<Item> itens = new ArrayList<>();

    protected List<String> mensagens = new ArrayList<>();

    public Pedido(LocalDateTime dataCompra, Fornecedor fornecedor, Cliente cliente) {
        this.dataCompra = dataCompra;
        this.fornecedor = fornecedor;
        this.cliente = cliente;
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
        if (!mensagens.isEmpty()) {
            throw new IllegalArgumentException(mensagens.toString());
        }
    }

    public Double getValorFrete() {
        return valorFrete;
    }

    public long getId_pedido() {
        return id_pedido;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public Cliente getCliente() {
        return cliente;
    }
}


