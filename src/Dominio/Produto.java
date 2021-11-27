package Dominio;

import java.util.ArrayList;
import java.util.List;

public class Produto {
    private long id_produto;
    private String nome;
    private String descricao;
    private Double valorUnitario;

    protected List<String> mensagens = new ArrayList<>();

    public Produto(String nome, String descrica, Double valorUnitario) {
        this.nome = nome;
        this.descricao = descrica;
        this.valorUnitario = valorUnitario;
        validar();
    }
    protected void validar() {
        if (nome == null || nome.isBlank()) {
            mensagens.add("informe um nome");
        }
        if (descricao == null || nome.isBlank()) {
            mensagens.add("informe uma descricao");
        }
        if (valorUnitario == null || nome.isBlank()) {
            mensagens.add("informe um valor");
        }
        if (!mensagens.isEmpty()) {
            throw new IllegalArgumentException(mensagens.toString());
        }
    }
    public long getId_produto() {
        return id_produto;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }
}