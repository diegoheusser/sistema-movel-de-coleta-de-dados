package br.udesc.ceavi.sistemamoveldecoletadedados.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import br.heusser.sistemamoveldecoletadedados.R;

public class PesquisaControle extends BaseAdapter {

	private Context context;
	private List<br.udesc.ceavi.sistemamoveldecoletadedados.modelo.PesquisaControle> itens;


	public PesquisaControle(
			Context context,
			List<br.udesc.ceavi.sistemamoveldecoletadedados.modelo.PesquisaControle> itens) {
		super();
		this.context = context;
		this.itens = itens;
	}

	@Override
	public int getCount() {
		return itens.size();
	}

	@Override
	public Object getItem(int position) {
		return itens.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		br.udesc.ceavi.sistemamoveldecoletadedados.modelo.PesquisaControle item = itens.get(position);
		LayoutInflater inflater = 
				(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v = inflater.inflate(R.layout.item_list, null);
		TextView name = (TextView) v.findViewById(R.id.name);
		name.setText(item.getFonte().getNome());
		
		TextView location = (TextView) v.findViewById(R.id.location);
		location.setText(item.getFonte().getLocalizacao());
		
		return v;
	}

}
