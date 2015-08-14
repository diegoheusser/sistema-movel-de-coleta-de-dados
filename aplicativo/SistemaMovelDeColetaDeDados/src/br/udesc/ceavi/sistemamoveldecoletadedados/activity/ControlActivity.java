package br.udesc.ceavi.sistemamoveldecoletadedados.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Dialog;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import br.heusser.sistemamoveldecoletadedados.R;
import br.udesc.ceavi.sistemamoveldecoletadedados.adapter.ControlAdapter;
import br.udesc.ceavi.sistemamoveldecoletadedados.model.Control;
import br.udesc.ceavi.sistemamoveldecoletadedados.model.Source;

public class ControlActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Source s1 = new Source();
		s1.setDescription("Nardelão");
		s1.setLocalization("Centro");
		Source s2 = new Source();
		s2.setDescription("Super 10");
		s2.setLocalization("Bairro Pinheiro");
		Source s3 = new Source();
		s3.setDescription("Super mercado Niterói");
		s3.setLocalization("Bairro Niterói");
		Control c1 = new Control();
		c1.setSource(s1);
		Control c2 = new Control();
		c2.setSource(s2);
		Control c3 = new Control();
		c3.setSource(s3);
		
		List<Control> list = new ArrayList<Control>();
		list.add(c1);
		list.add(c2);
		list.add(c3);
		
		setListAdapter( new ControlAdapter(this, list));
		
	}



	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Control o = (Control) this.getListAdapter().getItem(position);
		String item = o.getSource().getDescription();
		
		final Dialog dialog = new Dialog(this);
		dialog.setContentView(R.layout.custom_dialog_option);
		dialog.setTitle(R.string.custom_dialog_option_title);
		
		final Button btOpen = (Button) dialog.findViewById(R.id.custom_dialog_option_open);
		final Button btSend = (Button) dialog.findViewById(R.id.custom_dialog_option_send);
		
		btOpen.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dialog.cancel();
			}
		});
		
		btSend.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dialog.cancel();
			}
		});
		
		dialog.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.research, menu);
		getActionBar().setBackgroundDrawable(R.drawable.primary);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
			case R.id.menu_research_update:{
				Toast.makeText(this, "Atualizando...", Toast.LENGTH_SHORT).show();
				break;
			}
		}
		return true;
	}
	
}
