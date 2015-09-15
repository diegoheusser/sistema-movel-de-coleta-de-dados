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

import br.udesc.ceavi.custodevida.base.AppContext;
import br.udesc.ceavi.custodevida.retrofit.response.ResearcherResponse;
import br.udesc.ceavi.custodevida.retrofit.service.ResearcherService;
import br.udesc.ceavi.custodevida.model.Researcher;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new ResearchersAsyncTask().execute();
    }

    private class ResearchersAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {

            RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(AppContext.SERVICE_URL).build();

            ResearcherService service = restAdapter.create(ResearcherService.class);

            String option = "seekall";
            service.seekResearchers(option, new Callback<ResearcherResponse>() {
                @Override
                public void success(ResearcherResponse obj, Response response) {
                    List<Researcher> oldResearchers = Researcher.seekAll(SplashActivity.this);
                    List<Researcher> newResearchers = obj.getResearcherList();
                    System.out.println(oldResearchers.toString());
                    System.out.println(newResearchers.toString());
                    for(Researcher r: newResearchers){
                        if(!oldResearchers.contains(r)){
                            if(r.onTheList(oldResearchers)){
                                r.update(SplashActivity.this);
                            } else {
                                r.save(SplashActivity.this);
                            }
                        }
                    }
                    Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(i);
                }

                @Override
                public void failure(RetrofitError error) {
                    System.out.println(error.toString());
                    Toast.makeText(SplashActivity.this, "Offline", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(i);
                }
            });
            return null;
        }
    }
}
