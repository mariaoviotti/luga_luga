package com.example.lugaluga;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Produto implements Parcelable {
    private String nomeProduto;
    private String descricao;
    private int preco;
    private String quantidade;
    private boolean status;

    public Produto(String nomeProduto, String descricao, int preco, String quantidade, boolean status) {
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.status = status;
    }
    public Produto(){


    }

    protected Produto(Parcel in) {
        nomeProduto = in.readString();
        descricao = in.readString();
        preco = in.readInt();
        quantidade = in.readString();
        status = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nomeProduto);
        dest.writeString(descricao);
        dest.writeInt(preco);
        dest.writeString(quantidade);
        dest.writeByte((byte) (status ? 1 : 0));
    }

    public static final Creator<Produto> CREATOR = new Creator<Produto>() {
        @Override
        public Produto createFromParcel(Parcel in) {
            return new Produto(in);
        }

        @Override
        public Produto[] newArray(int size) {
            return new Produto[size];
        }
    };

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

}

