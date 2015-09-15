package br.udesc.ceavi.custodevida;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.udesc.ceavi.custodevida.adapter.ControlAdapter;
import br.udesc.ceavi.custodevida.base.AppContext;
import br.udesc.ceavi.custodevida.model.Control;

public class ControlActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.control_activity);

        List<Control> list = Control.seekAllByResearcher(ControlActivity.this, AppContext.RESEARCHER.getId());

        final ListView listView = getListView();

        ControlAdapter adapter = new ControlAdapter(ControlActivity.this, list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

}
