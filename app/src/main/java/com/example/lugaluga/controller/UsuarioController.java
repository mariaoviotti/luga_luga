package com.example.lugaluga.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;



public class UsuarioController {
    private SQLiteDatabase db;
    private CriarBanco banco;

    public  UsuarioController(Context context){
        banco = new CriarBanco(context);

    }
    public String insereDados( String nome, String cpf, String dataNasc, String cep, String municipio, String logradouro, int numero ,
                               String complemento , String bairro , int telefone, String email, String senha, String uf){

        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriarBanco.UF, uf) ;
        valores.put(CriarBanco.NOME, nome);
        valores.put(CriarBanco.CPF, nome);
        valores.put(CriarBanco.DATA_NASC, nome);
        valores.put(CriarBanco.CEP, nome);
        valores.put(CriarBanco.MUNICIPIO, nome);
        valores.put(CriarBanco.LOGRADOURO, nome);
        valores.put(CriarBanco.NUMERO, nome);
        valores.put(CriarBanco.COMPLEMENTO, nome);
        valores.put(CriarBanco.BAIRRO, nome);
        valores.put(CriarBanco.TELEFONE, nome);
        valores.put(CriarBanco.EMAIL, nome);
        valores.put(CriarBanco.SENHA, nome);

        resultado = db.insert(CriarBanco.NOME_TABELA, null, valores);
        db.close();

        if(resultado == -1){
            return  "Erro ao inserir o registro";
        }

        return "Inserido com sucesso";

    }
}
