package br.udesc.ceavi.sistemamoveldecoletadedados.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import br.heusser.sistemamoveldecoletadedados.R;

public class MainActivity extends Activity {

	private Button btEntrar;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.autenticacao);
	}

	@Override
	protected void onResume() {
		super.onResume();
		btEntrar = (Button) findViewById(R.id.autenticacao_button_entrar);
		btEntrar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText edUser = (EditText) findViewById(R.id.autenticacao_edit_text_usuario);
				EditText edPassword = (EditText) findViewById(R.id.autenticacao_edit_text_senha);
		
				String user = "", password = "";
				user = edUser.getText().toString();
				password = edPassword.getText().toString();
				if(user.equals("root") && password.equals("root")){
					Intent it = new Intent(MainActivity.this, ControlActivity.class);
					startActivity(it);
				} else {
					Toast.makeText(getApplicationContext(), "Senha ou usuário inválidos!", Toast.LENGTH_SHORT).show();
				}

			}
		});
		
	}
	
	

}
