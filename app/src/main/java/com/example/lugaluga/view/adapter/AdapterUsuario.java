package com.example.lugaluga.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lugaluga.R;
import com.example.lugaluga.model.Usuario;

import java.util.List;

public class AdapterUsuario extends RecyclerView.Adapter<AdapterUsuario.ViewHolder> {
    private List<Usuario> usuariolist;

    public AdapterUsuario(List<Usuario> usuariolist) {
        this.usuariolist = usuariolist;
    }

    public AdapterUsuario.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View  listaUsuarios= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_usuario, parent, false);

        return new ViewHolder(listaUsuarios);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterUsuario.ViewHolder holder, int position) {
                holder.nome.setText(usuariolist.get(position).getNome());
                holder.cpf.setText(usuariolist.get(position).getCPF());
                holder.email.setText(usuariolist.get(position).getEmail());
                holder.telefone.setText(usuariolist.get(position).getTelefone());



    }

    @Override
    public int getItemCount() {
        return usuariolist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nome, cpf, email, telefone;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.nome_user);
            cpf = itemView.findViewById(R.id.cpf_user);
            email = itemView.findViewById(R.id.email_user);
            telefone = itemView.findViewById(R.id.telefone_user);

        }
    }
}
