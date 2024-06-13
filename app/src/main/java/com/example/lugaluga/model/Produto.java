package com.example.lugaluga.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Produto implements Parcelable {
    private String nomeProduto;
    private String descricao;
    private Double preco;
    private int quantidade;
    private boolean status;

    public Produto(String nomeProduto, String descricao, Double preco, int quantidade, boolean status) {
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
        preco = in.readDouble();
        quantidade = in.readInt();
        status = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nomeProduto);
        dest.writeString(descricao);
        dest.writeDouble(preco);
        dest.writeInt(quantidade);
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
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

