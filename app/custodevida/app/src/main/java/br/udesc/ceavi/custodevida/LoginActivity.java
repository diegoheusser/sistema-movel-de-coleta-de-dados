package br.udesc.ceavi.custodevida;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.udesc.ceavi.custodevida.model.Researcher;
import br.udesc.ceavi.custodevida.util.MD5;

public class LoginActivity extends Activity {

    private EditText editTextUser;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        editTextUser = (EditText) findViewById(R.id.login_edit_text_user);
        editTextPassword = (EditText) findViewById(R.id.login_edit_text_password);
        buttonLogin = (Button) findViewById(R.id.login_button_login);



        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Researcher r = Researcher.seekResearcher(LoginActivity.this,
                        editTextUser.getText().toString(),
                        MD5.encrypt(editTextPassword.getText().toString()));
                if(r==null) {
                    Toast.makeText(LoginActivity.this,"Usuário ou senha inválidos",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(LoginActivity.this,"Logado!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
