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

import br.udesc.ceavi.custodevida.model.Researcher;

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
            Gson gson = new Gson();


            return null;
        }
    }
}
