package Controllers;

import java.util.ArrayList;
import java.util.List;

public class Produto {
    private String nome;
    private String descricao;
    private Double valorUnitario;

    protected List<String> mensagens = new ArrayList<>();

    public Produto(String nome) {
        this.nome = nome;
        validar();
    }
    protected void validar() {
        if (nome == null || nome.isBlank()) {
            mensagens.add("informe um nome");
        }
        if (!mensagens.isEmpty()) {
            throw new IllegalArgumentException(mensagens.toString());
        }
    }
}