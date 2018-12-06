package com.azemar.ads.mockup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastro extends AppCompatActivity {

    private EditText nomeCadastro;
    private EditText loginCadastro;
    private EditText passwordCadastro;
    private Button salvarCadastro;

    private UsuarioPreferencia usuarioPreferencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        nomeCadastro = findViewById(R.id.editNomeCadastro);
        loginCadastro = findViewById(R.id.editLoginCadastro);
        passwordCadastro = findViewById(R.id.editPasswordCadastro);
        salvarCadastro = findViewById(R.id.btnSalvarCadastro);

        usuarioPreferencia = new UsuarioPreferencia(getApplicationContext());

        salvarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(!nomeCadastro.getText().toString().isEmpty()){

                    if(!loginCadastro.getText().toString().isEmpty()){

                        if(!passwordCadastro.getText().toString().isEmpty()){

                            usuarioPreferencia.setNome(nomeCadastro.getText().toString());
                            usuarioPreferencia.setLogin(loginCadastro.getText().toString());
                            usuarioPreferencia.setSenha(passwordCadastro.getText().toString());

                            Intent intentCad = new Intent(Cadastro.this, Acesso.class);
                            startActivity(intentCad);


                        }else{

                            passwordCadastro.requestFocus();
                            Toast.makeText(Cadastro.this, "Favor digitar uma senha", Toast.LENGTH_SHORT).show();

                        }


                    }else{

                        loginCadastro.requestFocus();
                        Toast.makeText(Cadastro.this, "Campo login não pode estar vazio", Toast.LENGTH_SHORT).show();

                    }


                }else{

                    nomeCadastro.requestFocus();
                    Toast.makeText(Cadastro.this, "Campo nome não pode estar vazio", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
