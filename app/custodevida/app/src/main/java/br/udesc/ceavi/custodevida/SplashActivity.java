package br.udesc.ceavi.custodevida;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import br.udesc.ceavi.custodevida.API.CustoVidaService;
import br.udesc.ceavi.custodevida.model.Researcher;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SplashActivity extends Activity {

    private List<Researcher> researchers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new ResearchersAsyncTask().execute();
    }

    private class ResearchersAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {

            String url = "http://10.1.1.198:8080/custovidawebservice";
            RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(url).build();

            CustoVidaService service = restAdapter.create(CustoVidaService.class);

            String option = "seekall";
            service.seekResearchers(option, new Callback<List<Researcher>>() {
                @Override
                public void success(List<Researcher> researchers, Response response) {
                    for(Researcher r: researchers){
                        System.out.println("--->  "+r.toString());
                    }
                    Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(i);
                }

                @Override
                public void failure(RetrofitError error) {
                    System.out.println("---> "+error.toString());
                    Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(i);
                }
            });
            return null;
        }
    }
}
