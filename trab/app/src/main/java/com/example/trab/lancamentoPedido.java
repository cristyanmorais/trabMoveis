package com.example.trab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trab.modelo.Cliente;
import com.example.trab.modelo.ItemVenda;
import com.example.trab.modelo.Pedido;

import java.util.ArrayList;

public class lancamentoPedido extends AppCompatActivity {

    private Spinner spCliente;
    private Spinner spItem;
    private EditText edQuantidade;
    private Button btAdicionarItem;
    private TextView tvListaItens;
    private TextView tvValorTotal;
    private TextView tvTotalItens;
    private Button btSalvar;

    private ArrayList<Cliente> listaClientes;
    private int posSelCliente = 0;

    private ArrayList<ItemVenda> listaItens;
    private int posSelItem = 0;

    private ArrayList<ItemVenda> itensAdicionados;
    private double valorTotalPedido = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancamento_pedido);

        spCliente = findViewById(R.id.spCliente);
        spItem = findViewById(R.id.spItem);
        edQuantidade = findViewById(R.id.edQuantidade);
        btAdicionarItem = findViewById(R.id.btAdicionarItem);
        tvListaItens = findViewById(R.id.tvListaItens);
        tvValorTotal = findViewById(R.id.tvValorTotal);
        btSalvar = findViewById(R.id.btSalvar);

        spCliente.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int posicao, long l) {
                if(posicao > 0) {
                    posSelCliente = posicao;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spItem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int posicao, long l) {
                if (posicao > 0) {
                    posSelItem = posicao;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        carregaClientes();
        carregaItens();

        itensAdicionados = new ArrayList<>();

        btAdicionarItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adicionarItemAoPedido();
            }
        });

        // Configurar o botão "Concluir Pedido"
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                concluirPedido();
            }
        });
    }

    private void carregaClientes() {
        listaClientes = Controller.getInstance().retornarClientes();
        String[]vetClientes = new String[listaClientes.size() + 1];
        vetClientes[0] = "Selecione o cliente";
        for (int i = 0; i < listaClientes.size(); i++) {
            Cliente cliente = listaClientes.get(i);
            vetClientes[i + 1] = cliente.getNome();
        }
        ArrayAdapter<String> adapter =  new ArrayAdapter<>(
                lancamentoPedido.this,
                android.R.layout.simple_spinner_item,
                vetClientes
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spCliente.setAdapter(adapter);
    }

    private void carregaItens() {
        listaItens = Controller.getInstance().retornarItens();
        String[] vetItens = new String[listaItens.size() + 1];
        vetItens[0] = "Selecione o item";
        for (int i = 0; i < listaItens.size(); i++) {
            ItemVenda item = listaItens.get(i);
            vetItens[i + 1] = item.getCodigo();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                lancamentoPedido.this,
                android.R.layout.simple_spinner_item,
                vetItens
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spItem.setAdapter(adapter);
    }

    private void adicionarItemAoPedido() {
        if (spItem.getSelectedItemPosition() == 0) {
            Toast.makeText(this, "Selecione um item válido", Toast.LENGTH_SHORT).show();
            return;
        }
        if (Integer.parseInt(edQuantidade.getText().toString()) <= 0 || edQuantidade.getText().toString().isEmpty()) {
            edQuantidade.setError("A quantidade deve ser válida!");
            return;
        }

        int quantidade = Integer.parseInt(edQuantidade.getText().toString());

        ItemVenda itemSelecionado = listaItens.get(posSelItem - 1);
        itemSelecionado.setQuantidade(quantidade);

        double valorTotalItem = quantidade * itemSelecionado.getValorUnitario();
        valorTotalPedido += valorTotalItem;

        itensAdicionados.add(itemSelecionado);

        String textoItem = "Código: " + itemSelecionado.getCodigo() + "\n";

        if (tvListaItens.getText().toString().isEmpty()) {
            tvListaItens.setText(textoItem);
        } else {
            String itensAnteriores = tvListaItens.getText().toString();
            tvListaItens.setText(itensAnteriores + "\n" + textoItem);
        }
        tvValorTotal.setText("Valor Total: " + valorTotalPedido);

        edQuantidade.setText("");
        spItem.setSelection(0);
    }

    private void concluirPedido() {
        if (spCliente.getSelectedItemPosition() == 0) {
            Toast.makeText(this, "Selecione um cliente válido!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (itensAdicionados.size() == 0) {
            Toast.makeText(this, "Adicione algum item!", Toast.LENGTH_SHORT).show();
            return;
        }

        Cliente cliente = listaClientes.get(posSelCliente - 1);

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setListaItens(itensAdicionados);
        pedido.setValorTotal(valorTotalPedido);

        Controller.getInstance().salvarPedido(pedido);
        Toast.makeText(this, "Pedido salvo com sucesso!", Toast.LENGTH_SHORT).show();

        this.finish();
    }
}