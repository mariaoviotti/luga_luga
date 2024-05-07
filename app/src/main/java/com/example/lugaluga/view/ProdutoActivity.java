package com.example.lugaluga.view;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lugaluga.Produto;
import com.example.lugaluga.R;

public class ProdutoActivity extends AppCompatActivity {

    private Produto produto;

    private TextView nomeProduto, qtdProduto, precoProduto, descProduto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_produto);

        nomeProduto = findViewById(R.id.ProdutoTv);
        qtdProduto = findViewById(R.id.qtdProdutoTv);
        precoProduto = findViewById(R.id.precoProdutoTv);
        descProduto = findViewById(R.id.descricaoTv);

        produto = getIntent().getExtras().getParcelable("produto");

        nomeProduto.setText(produto.getNomeProduto());
        qtdProduto.setText(produto.getQuantidade());
        precoProduto.setText(String.valueOf(produto.getPreco()));
        descProduto.setText(produto.getDescricao());


    }
}