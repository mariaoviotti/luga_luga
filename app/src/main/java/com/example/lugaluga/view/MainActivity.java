package com.example.lugaluga.view;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lugaluga.Produto;
import com.example.lugaluga.R;
import com.example.lugaluga.RecyclerItemClickListener;
import com.example.lugaluga.view.adapter.AdapterProduto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterProduto adapterProduto;

    private List<Produto> produtoList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.listaProdutos);

        CriarListaProduto();

        adapterProduto = new AdapterProduto(produtoList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterProduto);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }

            @Override
            public void onLongItemClick(View view, int position) {

            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));







    }
    public void CriarListaProduto(){

        Produto produto;

        produto = new Produto("Iphone 13",
                "Iphone 13 64gb",
                3200,
                "10",
                true);

        produtoList.add(produto);

          produto = new Produto("Fone",
                "Bluetooth",
                1300,
                "15",
                true);

        produtoList.add(produto);
        produto = new Produto("Iphone 14",
                "Iphone 14 128gb",
                4500,
                "19",
                true);

        produtoList.add(produto);

        produto = new Produto("CD",
                "Disco",
                100,
                "13",
                true);

        produtoList.add(produto);

        produto = new Produto("USB",
                "Cabo",
                150,
                "23",
                true);

        produtoList.add(produto);
        produto = new Produto("Samsung s23",
                "Samsung s23 64gb",
                3000,
                "45",
                true);

        produtoList.add(produto);
        produto = new Produto("Samsung galaxy A",
                "Samsung galaxy A 64gb",
                2300,
                "78",
                true);

        produtoList.add(produto);
        produto = new Produto("Macbook Pro",
                "Macbook Pro Preto 128gb",
                5500,
                "9",
                true);

        produtoList.add(produto);
        produto = new Produto("Apple Watch",
                "Cor preta",
                3562,
                "34",
                true);

        produtoList.add(produto);
        produto = new Produto("Iphone 11",
                "Iphone 11 256gb",
                2300,
                "56",
                true);

        produtoList.add(produto);

    }
}
}