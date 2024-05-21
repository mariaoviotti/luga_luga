package com.example.lugaluga.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.lugaluga.Produto;
import com.example.lugaluga.R;
import com.example.lugaluga.RecyclerItemClickListener;
import com.example.lugaluga.view.adapter.AdapterProduto;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProdutoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProdutoFragment extends Fragment {

    private RecyclerView recyclerView;
    private AdapterProduto adapterProduto;

    private List<Produto> produtoList = new ArrayList<>();


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProdutoFragment() {
        // Required empty public constructor
    }

    public static ProdutoFragment newInstance(String param1, String param2) {
        ProdutoFragment fragment = new ProdutoFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_produto, container, false);

        recyclerView = view.findViewById(R.id.listaProdutos);

        CriarListaProduto();

        adapterProduto = new AdapterProduto(produtoList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterProduto);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {

                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(getContext(), ProdutoActivity.class);
                        intent.putExtra("produto", produtoList.get(position));
                        startActivity(intent);

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Toast.makeText(getContext(), produtoList.get(position).getDescricao(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }));
        return view;
    }

    public void CriarListaProduto() {

        Produto produto;

        produto = new Produto("Iphone 13",
                "Iphone 13 64gb",
                3200,
                "10",
                false);

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
                false);

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
                false);

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
                false);

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
