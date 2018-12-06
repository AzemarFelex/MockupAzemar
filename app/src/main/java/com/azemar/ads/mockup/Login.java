package com.azemar.ads.mockup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText login;
    private EditText password;
    private Button entrar;
    private TextView cadastro;

    private UsuarioPreferencia usuarioPreferencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login=findViewById(R.id.edtLogin);
        password=findViewById(R.id.editPasswordCadastro);
        entrar=findViewById(R.id.btnEntrar);
        cadastro=findViewById(R.id.btnCadastro);

        usuarioPreferencia = new UsuarioPreferencia(getApplicationContext());

        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentCadastro=new Intent(Login.this, Cadastro.class);
                startActivity(intentCadastro);

            }
        });

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!login.getText().toString().isEmpty()){

                    if(!password.getText().toString().isEmpty()){

                        if((usuarioPreferencia.getLogin().equals(login.getText().toString())) &&(usuarioPreferencia.getSenha().equals(password.getText().toString()))){

                            Intent intentAcesso = new Intent(Login.this, Acesso.class);
                            startActivity(intentAcesso);

                        }else{

                            Toast.makeText(Login.this, "Usuário inválido", Toast.LENGTH_SHORT).show();
                        }



                    }else{

                        password.requestFocus();
                        Toast.makeText(Login.this, "Campo password não pode ficar vazio", Toast.LENGTH_SHORT).show();
                    }


                }else{

                    login.requestFocus();
                    Toast.makeText(Login.this, "Campo login não pode ficar vazio", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

}
