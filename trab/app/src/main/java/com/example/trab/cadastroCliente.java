package com.example.trab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trab.modelo.Cliente;

public class cadastroCliente extends AppCompatActivity {

    private Button btSalvar;
    private EditText edNomeCliente;
    private EditText edCpfCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);

        btSalvar = findViewById(R.id.btSalvarCliente);
        edNomeCliente = findViewById(R.id.edNomeCliente);
        edCpfCliente = findViewById(R.id.edCpfCliente);

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarCliente();
            }
        });
    }

    private void salvarCliente() {
        if(edNomeCliente.getText().toString().isEmpty()) {
            edNomeCliente.setError("Informe o nome do cliente!");
            return;
        }
        if(edCpfCliente.getText().toString().isEmpty()) {
            edCpfCliente.setError("Informe o Cpf do cliente!");
            return;
        }

        Cliente cliente = new Cliente();
        cliente.setNome(edNomeCliente.getText().toString());
        cliente.setCpf(edCpfCliente.getText().toString());

        Controller.getInstance().salvarCliente(cliente);

        Toast.makeText(cadastroCliente.this,
                "Cliente Cadastrado com sucesso",
                Toast.LENGTH_SHORT).show();

        this.finish();
    };
}