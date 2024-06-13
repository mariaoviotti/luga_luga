package com.example.lugaluga.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.lugaluga.model.Produto;
import com.example.lugaluga.R;

public class ProdutoActivity extends AppCompatActivity {

    private Produto produto;

    private TextView nomeProduto, qtdProduto, precoProduto, descProduto;

    private Button alugaBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_produto);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);


        nomeProduto = findViewById(R.id.ProdutoTv);
        qtdProduto = findViewById(R.id.qtdProdutoTv);
        precoProduto = findViewById(R.id.precoProdutoTv);
        descProduto = findViewById(R.id.descricaoTv);

        alugaBtn = findViewById(R.id.alugaBtn);


        produto = getIntent().getExtras().getParcelable("produto");
        if (!produto.isStatus()){
            alugaBtn.setEnabled(false);
            alugaBtn.setText("Indisponivel");
        }
        nomeProduto.setText(produto.getNomeProduto());
        qtdProduto.setText(String.valueOf(produto.getQuantidade()));
        precoProduto.setText(String.valueOf(produto.getPreco()));
        descProduto.setText(produto.getDescricao());

        alugaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ProdutoActivity.this);
                builder.setMessage("Deseja realmente alugar este produto?");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ProdutoActivity.this, "Concluido", Toast.LENGTH_SHORT).show();
                        alugaBtn.setText("Solicitado");
                        alugaBtn.setEnabled(false);
                        alugaBtn.setBackgroundColor(getColor(R.color.yelow));
                    }

                });

                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });


    }
}