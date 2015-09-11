package br.udesc.ceavi.custodevida;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.udesc.ceavi.custodevida.retrofit.response.ResearcherResponse;
import br.udesc.ceavi.custodevida.retrofit.service.ResearcherService;
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

            //When use emulator change localhost by 10.0.2.2
            String url = "http://10.0.2.2:8084/custovidawebservice";
            RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(url).build();

            ResearcherService service = restAdapter.create(ResearcherService.class);

            String option = "seekall";
            service.seekResearchers(option, new Callback<ResearcherResponse>() {
                @Override
                public void success(ResearcherResponse obj, Response response) {
                    System.out.println("obj -> "+obj.toString());
                    List<Researcher> list = obj.getResearcherList();
                    System.out.println("list -> "+ list.toString());
                    for(Researcher r: list){
                        r.save(SplashActivity.this);
                    }
                    Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(i);
                }

                @Override
                public void failure(RetrofitError error) {
                    System.out.println(error.toString());
                    Toast.makeText(SplashActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(i);
                }
            });
            return null;
        }
    }
}
