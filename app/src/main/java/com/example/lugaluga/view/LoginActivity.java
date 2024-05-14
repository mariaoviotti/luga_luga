package com.example.lugaluga.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lugaluga.R;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    private Button buttonLogin;
    private TextInputLayout inputEmail, inputSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        inputEmail = findViewById(R.id.outlinedTextField);
        inputSenha = findViewById(R.id.outlinedTextField2);
        buttonLogin = findViewById(R.id.button);

        Intent intent = new Intent(this, MainActivity.class);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validaEmailSenha()) {
                    startActivity(intent);
                }

                if (validaSenha()) {
                startActivity(intent);
                    }

            }
        });
    }

    public boolean validaEmailSenha(){
        if (inputEmail.getEditText() != null
                && inputEmail.getEditText().getText().toString().equals("")){
            inputEmail.setError("Informe o email:");
            return false;
        }

        return true;
    }
    public boolean validaSenha(){
        if(inputSenha.getEditText() != null
                && inputSenha.getEditText().getText().toString().equals("")){
            inputSenha.setError("Informe a senha:");
            return false;
        }
        return true;
    }

}