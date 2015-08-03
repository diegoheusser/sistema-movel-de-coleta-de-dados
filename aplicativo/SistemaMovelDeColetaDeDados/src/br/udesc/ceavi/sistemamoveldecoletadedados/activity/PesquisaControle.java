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
import br.udesc.ceavi.sistemamoveldecoletadedados.modelo.Fonte;

public class PesquisaControle extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}
	
	

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Fonte f1 = new Fonte();
		f1.setNome("Nardelão");
		f1.setLocalizacao("Centro");
		Fonte f2 = new Fonte();
		f2.setNome("Super 10");
		f2.setLocalizacao("Bairro Pinheiro");
		Fonte f3 = new Fonte();
		f3.setNome("Super mercado Niterói");
		f3.setLocalizacao("Bairro Niterói");
		br.udesc.ceavi.sistemamoveldecoletadedados.modelo.PesquisaControle p1 = new br.udesc.ceavi.sistemamoveldecoletadedados.modelo.PesquisaControle();
		p1.setFonte(f1);
		br.udesc.ceavi.sistemamoveldecoletadedados.modelo.PesquisaControle p2 = new br.udesc.ceavi.sistemamoveldecoletadedados.modelo.PesquisaControle();
		p2.setFonte(f2);
		br.udesc.ceavi.sistemamoveldecoletadedados.modelo.PesquisaControle p3 = new br.udesc.ceavi.sistemamoveldecoletadedados.modelo.PesquisaControle();
		p3.setFonte(f3);
		
		List<br.udesc.ceavi.sistemamoveldecoletadedados.modelo.PesquisaControle> lista = new ArrayList<br.udesc.ceavi.sistemamoveldecoletadedados.modelo.PesquisaControle>();
		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		
		setListAdapter( new br.udesc.ceavi.sistemamoveldecoletadedados.adapter.PesquisaControle(this, lista));
		
	}



	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		br.udesc.ceavi.sistemamoveldecoletadedados.modelo.PesquisaControle o = (br.udesc.ceavi.sistemamoveldecoletadedados.modelo.PesquisaControle) this.getListAdapter().getItem(position);
		String item = o.getFonte().getNome();
		
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
