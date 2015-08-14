package br.udesc.ceavi.custodevida;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {

    private Button btLogin = null;
    private EditText edUser = null;
    private EditText edPassword = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        loadData();
    }

    private void initComponents(){
        btLogin = (Button) findViewById(R.id.login_button_login);
        edUser = (EditText) findViewById(R.id.login_edit_text_user);
        edPassword = (EditText) findViewById(R.id.login_edit_text_password);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void loadData() {

    }

}
