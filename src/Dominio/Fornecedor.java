package Dominio;

import java.util.ArrayList;
import java.util.List;

public class Fornecedor {

    private long id_fornecedor;
    private String nomeFantasia;
    private String cnpj;
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

    public Fornecedor(String nomeFantasia, String cnpj, String email,
                      String telefone, String rua, String bairro , String cep
    ,String cidade , String estado) {
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        validar();
    }

    protected void validar() {
        if (nomeFantasia == null || nomeFantasia.isBlank() || nomeFantasia.length() > 100) {
            mensagens.add("informe um nomeFantasia valido");
        }
        if (cnpj == null || cnpj.isBlank() || cnpj.length() > 20) {
            mensagens.add("informe um cnpj valido");
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
            mensagens.add("informe uma cidade valida");
        }
        if (estado == null || estado.isBlank() || estado.length() > 2) {
            mensagens.add("informe um estado valido");
        }
        if (!mensagens.isEmpty()) {
            throw new IllegalArgumentException(mensagens.toString());
        }
    }

    public long getId_fornecedor() {
        return id_fornecedor;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
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

    public List<String> getMensagens() {
        return mensagens;
    }
}
