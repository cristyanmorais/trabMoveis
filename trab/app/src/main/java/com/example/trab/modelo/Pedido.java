package com.example.trab.modelo;

import java.util.ArrayList;

public class Pedido {

    private int codigo;
    private Cliente cliente;
    private ArrayList<ItemVenda> listaItens;
    private double valorTotal;

    public Pedido() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<ItemVenda> getListaItens() {
        return listaItens;
    }

    public void setListaItens(ArrayList<ItemVenda> listaItens) {
        this.listaItens = listaItens;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
