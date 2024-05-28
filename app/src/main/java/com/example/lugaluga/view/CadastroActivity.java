package com.example.lugaluga.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lugaluga.R;
import com.example.lugaluga.controller.UsuarioController;
import com.example.lugaluga.model.Usuario;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CadastroActivity extends AppCompatActivity {
    private Spinner spinnerUf;

    private TextInputLayout inputEmail;
    private TextInputLayout inputCpf, input_nome, input_data , input_cep,
           input_cidade,  input_logradouro, input_numero , input_complemento ,
            input_bairro, input_email, input_senha;
    private TextInputLayout inputCep, inputDataNasc;

    private Button btnCadastrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle("Cadastro");
        myToolbar.setTitleTextColor(getColor(R.color.white));
        setSupportActionBar(myToolbar);

        inputCpf=findViewById(R.id.input_cpf);
        input_nome = findViewById(R.id.input_nome);
        input_data = findViewById(R.id.input_data);
        input_cep = findViewById(R.id.input_cep);
        input_cidade = findViewById(R.id.input_cidade);
        input_logradouro = findViewById(R.id.input_logradouro);
        input_numero= findViewById(R.id.input_numero);
        input_complemento = findViewById(R.id.input_complemento);
        input_bairro = findViewById(R.id.input_bairro);
        input_email = findViewById(R.id.input_email);
        input_senha = findViewById(R.id.input_senha);


        inputDataNasc = findViewById(R.id.input_data);



        inputDataNasc.getEditText().addTextChangedListener(new TextWatcher() {

            private static final String maskData = "##/##/####";
            boolean isUpdating;
            String old = "";
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String str = s.toString().replaceAll("[^0-9]*", "");
                String mask= maskData;

                String mascara = "";
                if( isUpdating) {
                    old = str;
                    isUpdating = false;
                    return;
                }
                int i = 0;
                for (char m : mask.toCharArray()) {
                    if ((m != '#' && str.length() > old.length()) || (m != '#' && str.length() < old.length() && str.length() != i)) {
                        mascara += m;
                        continue;
                    }


                    try {
                        mascara += str.charAt(i);
                    } catch (Exception e) {
                        break;
                    }
                    i++;
                }
                isUpdating = true;
                inputDataNasc.getEditText().setText(mascara);
                inputDataNasc.getEditText().setSelection(mascara.length());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        inputCpf.getEditText().addTextChangedListener(new TextWatcher() {
            private static final String maskCPF = "###.###.###-##";

            boolean isUpdating;
            String old = "";
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str = s.toString().replaceAll("[^0-9]*", "");
                String mask= maskCPF;

                String mascara = "";
                if( isUpdating) {
                    old = str;
                    isUpdating = false;
                    return;
                }
                int i = 0;
                for (char m : mask.toCharArray()) {
                    if ((m != '#' && str.length() > old.length()) || (m != '#' && str.length() < old.length() && str.length() != i)) {
                        mascara += m;
                        continue;
                    }


                    try {
                        mascara += str.charAt(i);
                    } catch (Exception e) {
                        break;
                    }
                    i++;
                }
                isUpdating = true;
                inputCpf.getEditText().setText(mascara);
                inputCpf.getEditText().setSelection(mascara.length());


            }


            @Override
            public void afterTextChanged(Editable s) {


            }
        });

        inputEmail = findViewById(R.id.input_email);
        inputCep= findViewById(R.id.input_cep);


        inputCep.getEditText().addTextChangedListener(new TextWatcher() {

            private static final String maskCEP = "#####-###";

            boolean isUpdating;
            String old = "";
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str = s.toString().replaceAll("[^0-9]*", "");
                String mask= maskCEP;

                String mascara = "";
                if( isUpdating) {
                    old = str;
                    isUpdating = false;
                    return;
                }
                int i = 0;
                for (char m : mask.toCharArray()) {
                    if ((m != '#' && str.length() > old.length()) || (m != '#' && str.length() < old.length() && str.length() != i)) {
                        mascara += m;
                        continue;
                    }


                    try {
                        mascara += str.charAt(i);
                    } catch (Exception e) {
                        break;
                    }
                    i++;
                }
                isUpdating = true;
                inputCep.getEditText().setText(mascara);
                inputCep.getEditText().setSelection(mascara.length());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        inputEmail.getEditText().addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {



            }

            @Override
            public void afterTextChanged(Editable s) {
                    Pattern pattern;
                    Matcher matcher;
                    String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
                    pattern = Pattern.compile(EMAIL_PATTERN);
                    CharSequence cs = (CharSequence) s;
                    matcher = pattern.matcher(cs);

                    if (!(matcher.matches() == true)) {
                        inputEmail.setError("Invalid email");
                    } else {
                        inputEmail.setError("");
                    }

            }
        });



        spinnerUf =(Spinner) findViewById(R.id.spinner_uf);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.uf_cadastro,
                android.R.layout.simple_spinner_item


        );
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerUf.setAdapter(adapter);

            btnCadastrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    UsuarioController crud = new UsuarioController(getApplicationContext());
                    Usuario usuario = new Usuario();
                    usuario.setNome(input_nome.getEditText().getText().toString());
                    usuario.setCPF(inputCpf.getEditText().getText().toString());
                    usuario.setDataNasc(input_data.getEditText().getText().toString());
                    usuario.setCEP(input_cep.getEditText().getText().toString());
                    usuario.setCidade(input_cidade.getEditText().getText().toString());
                    usuario.setUf(spinnerUf.getSelectedItem().toString());
                    usuario.setLogradouro(input_logradouro.getEditText().getText().toString());
                    usuario.setNumero(input_numero.getEditText().getText().toString());
                    usuario.setComplemento(input_complemento.getEditText().getText().toString());
                    usuario.setBairro(input_bairro.getEditText().getText().toString());
                    usuario.setEmail(input_email.getEditText().getText().toString());
                    usuario.setSenha(input_senha.getEditText().getText().toString());


                    String resultado;
                    resultado = crud.insereDados(usuario.getNome(),usuario.getCPF(),usuario.getDataNasc(),
                                usuario.getCEP(), usuario.getCidade(), usuario.getLogradouro(),
                                usuario.getNumero(), usuario.getComplemento(), usuario.getTelefone(),
                                usuario.getBairro(), usuario.getEmail(), usuario.getSenha(), usuario.getUf());

                    Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

                }
            });


    }
}