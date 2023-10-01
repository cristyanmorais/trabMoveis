package com.example.trab;

import com.example.trab.modelo.Cliente;
import com.example.trab.modelo.ItemVenda;
import com.example.trab.modelo.Pedido;

import java.util.ArrayList;

public class Controller {

    private static Controller instancia;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<ItemVenda> listaItens;
    private ArrayList<Pedido> listaPedidos;

    public static Controller getInstance() {
        if(instancia == null) {
            return instancia = new Controller();
        } else {
            return instancia;
        }
    }

    private Controller(){
        listaClientes = new ArrayList<>();
        listaItens = new ArrayList<>();
        listaPedidos = new ArrayList<>();
    }

    public void salvarCliente(Cliente cliente){
        listaClientes.add(cliente);
    }

    public ArrayList<Cliente> retornarClientes() {
        return listaClientes;
    }

    public void salvarItem(ItemVenda itemVenda){
        listaItens.add(itemVenda);
    }

    public ArrayList<ItemVenda> retornarItens() {
        return listaItens;
    }

    public void salvarPedido(Pedido pedido){
        listaPedidos.add(pedido);
    }

    public ArrayList<Pedido> retornarPedidos() {
        return listaPedidos;
    }
}
