package com.example.trab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trab.modelo.ItemVenda;

public class cadastroItemVenda extends AppCompatActivity {

    private EditText edCodigoItem;
    private EditText edDescricaoItem;
    private EditText edValorItem;
    private Button btSalvarItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_item_venda);

        edCodigoItem = findViewById(R.id.edCodigoItem);
        edDescricaoItem = findViewById(R.id.edDescricaoItem);
        edValorItem = findViewById(R.id.edValorItem);
        btSalvarItem = findViewById(R.id.btSalvarItem);

        btSalvarItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarItem();
            }
        });
    }

    private void salvarItem(){
        if(edCodigoItem.getText().toString().isEmpty()){
            edCodigoItem.setError("Informe o Código do item!");
            return;
        }
        if(edDescricaoItem.getText().toString().isEmpty()){
            edDescricaoItem.setError("Informe a descrição do item!");
            return;
        }
        if(edValorItem.getText().toString().isEmpty()){
            edValorItem.setError("Informe o Valor do item!");
            return;
        }
        ItemVenda itemVenda = new ItemVenda();
        itemVenda.setCodigo(edCodigoItem.getText().toString());
        itemVenda.setDescricao(edDescricaoItem.getText().toString());
        itemVenda.setValorUnitario(Integer.parseInt(edValorItem.getText().toString()));

        Controller.getInstance().salvarItem(itemVenda);

        Toast.makeText(cadastroItemVenda.this,
                "Item cadastrado com sucesso!",
                Toast.LENGTH_SHORT).show();

        this.finish();
    }
}