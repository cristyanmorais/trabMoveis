package com.example.trab;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btCadastroCliente;
    private Button btCadastroItemVenda;
    private Button btLancamentoPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCadastroCliente = findViewById(R.id.btCadastroCliente);
        btCadastroItemVenda = findViewById(R.id.btCadastroItemVenda);
        btLancamentoPedido = findViewById(R.id.btLancamentoPedido);

        btCadastroCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActivity(cadastroCliente.class);
            }
        });

        btCadastroItemVenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActivity(cadastroItemVenda.class);
            }
        });

        btLancamentoPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActivity(lancamentoPedido.class);
            }
        });
    }

    private void abrirActivity(Class<?> activity) {
        Intent intent = new Intent(MainActivity.this, activity);
        startActivity(intent);
    }
}