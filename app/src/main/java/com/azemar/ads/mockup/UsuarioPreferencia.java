package com.azemar.ads.mockup;

import android.content.Context;
import android.content.SharedPreferences;

public class UsuarioPreferencia {

    private Context contexto;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private static final String ARQUIVO_PREFERENCIA= "UsuarioPreferencia";
    private int MODE=0;

    private String nome;
    private String login;
    private String senha;

    public UsuarioPreferencia(Context c) {
        this.contexto = c;
        this.preferences = c.getSharedPreferences(ARQUIVO_PREFERENCIA,MODE);
        this.editor= preferences.edit();
    }


    public String getNome() {

        return this.preferences.getString("nome", "");
    }

    public void setNome(String nome) {
        this.editor.putString("nome", nome);
        this.editor.commit();
    }

    public String getLogin() {
        return this.preferences.getString("login", "");
    }

    public void setLogin(String login) {
        this.editor.putString("login", login);
        this.editor.commit();
    }

    public String getSenha() {
        return this.preferences.getString("senha", "");
    }

    public void setSenha(String senha) {
        this.editor.putString("senha", senha);
        this.editor.commit();
    }

}
