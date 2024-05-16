package com.example.lugaluga.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.provider.ContactsContract;

import androidx.annotation.NonNull;

import java.util.Date;

public class Usuario implements Parcelable {
    private String nome;
    private String CPF;
    private Date dataNasc;
    private String CEP;
    private  String cidade;
    private String uf;
    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    private String email;

    private String senha;

    public Usuario(String nome, String CPF, Date dataNasc, String CEP, String cidade, String uf, String logradouro, String numero, String complemento, String bairro, String email, String senha) {
        this.nome = nome;
        this.CPF = CPF;
        this.dataNasc = dataNasc;
        this.CEP = CEP;
        this.cidade = cidade;
        this.uf = uf;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.email = email;
        this.senha = senha;
    }

    protected Usuario(Parcel in) {
        nome = in.readString();
        CPF = in.readString();
        CEP = in.readString();
        cidade = in.readString();
        uf = in.readString();
        logradouro = in.readString();
        numero = in.readString();
        complemento = in.readString();
        bairro = in.readString();
        email = in.readString();
        senha = in.readString();
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(CPF);
        dest.writeString(CEP);
        dest.writeString(cidade);
        dest.writeString(uf);
        dest.writeString(logradouro);
        dest.writeString(numero);
        dest.writeString(complemento);
        dest.writeString(bairro);
        dest.writeString(email);
        dest.writeString(senha);
    }
}
