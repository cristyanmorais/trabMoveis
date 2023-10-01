package com.example.trab.modelo;

public class ItemVenda {

    private String codigo;
    private String nome;
    private String descricao;
    private double valorUnitario;
    private int quantidade;

    public ItemVenda() {

    };

    public ItemVenda(String codigo, String nome, String descricao, double valorUnitario) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
