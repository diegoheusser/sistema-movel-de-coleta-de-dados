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

	private Button btLogin;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
	}

	@Override
	protected void onResume() {
		super.onResume();
		btLogin = (Button) findViewById(R.id.login_button_login);
		btLogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText edUser = (EditText) findViewById(R.id.login_edit_text_user);
				EditText edPassword = (EditText) findViewById(R.id.login_edit_text_password);
		
				String user = "", password = "";
				user = edUser.getText().toString();
				password = edPassword.getText().toString();
				if(user.equals("root") && password.equals("root")){
					Intent it = new Intent(MainActivity.this, ControlActivity.class);
					startActivity(it);
				} else {
					Toast.makeText(getApplicationContext(), R.string.login_msg_invalid_user_password, Toast.LENGTH_SHORT).show();
				}

			}
		});
		
	}
	
	

}
