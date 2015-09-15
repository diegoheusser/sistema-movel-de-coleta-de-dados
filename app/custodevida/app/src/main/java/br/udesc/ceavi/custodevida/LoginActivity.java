package br.udesc.ceavi.custodevida;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.SQLOutput;
import java.util.List;

import br.udesc.ceavi.custodevida.base.AppContext;
import br.udesc.ceavi.custodevida.model.Control;
import br.udesc.ceavi.custodevida.model.Researcher;
import br.udesc.ceavi.custodevida.retrofit.response.ControlResponse;
import br.udesc.ceavi.custodevida.retrofit.response.ResearcherResponse;
import br.udesc.ceavi.custodevida.retrofit.service.ControlService;
import br.udesc.ceavi.custodevida.retrofit.service.ResearcherService;
import br.udesc.ceavi.custodevida.util.MD5;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;

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
                    AppContext.RESEARCHER = r;
                    Toast.makeText(LoginActivity.this,"Logado!",Toast.LENGTH_LONG).show();
                    new ControlAsyncTask().execute();
                }
            }
        });
    }

    private class ControlAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            RestAdapter restAdapter = new RestAdapter.Builder().
                    setEndpoint(AppContext.SERVICE_URL).setConverter(new GsonConverter(gson)).build();

            ControlService service = restAdapter.create(ControlService.class);

            String option = "seekall";
            service.seekControlsByResearcher(option, AppContext.RESEARCHER.getId(), new Callback<ControlResponse>() {
                @Override
                public void success(ControlResponse controlResponse, Response response) {
                    System.out.println("SUCCESS -->"+controlResponse.toString());
                    Intent i = new Intent(LoginActivity.this,ControlActivity.class);
                    startActivity(i);
                }

                @Override
                public void failure(RetrofitError error) {
                    error.printStackTrace();
                }
            });
            return null;
        }
    }

}
