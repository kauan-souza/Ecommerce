package Controllers;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String rua;
    private String numero;
    private String bairro;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;

    protected List<String> mensagens = new ArrayList<>();

    public Cliente(String nome, String cpf, String email, String telefone, String rua, String bairro, String cep, String cidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        validar();
    }

    protected void validar() {
        if (nome == null || nome.isBlank() || nome.length() > 100) {
            mensagens.add("informe um nome valido");
        }
        if (cpf == null || cpf.isBlank() || cpf.length() > 20) {
            mensagens.add("informe um cpf valido");
        }
        if (!email.contains("@") || !email.contains(".com") || email.length() > 100) {
            mensagens.add("informe um email valido");
        }
        if (telefone == null || telefone.isBlank() || telefone.length() > 20) {
            mensagens.add("informe um telefone valido");
        }
        if (rua == null || rua.isBlank() || rua.length() > 100) {
            mensagens.add("informe uma rua valida");
        }
        if (bairro == null || bairro.isBlank() || bairro.length() > 50) {
            mensagens.add("informe um bairro valido");
        }
        if (cep == null || cep.isBlank() || cep.length() > 10) {
            mensagens.add("informe um cep valido");
        }
        if (cidade == null || cidade.isBlank() || cidade.length() > 50) {
            mensagens.add("informe uma cidade valida ");
        }
        if (!mensagens.isEmpty()) {
            throw new IllegalArgumentException(mensagens.toString());
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }
}
