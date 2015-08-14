package br.udesc.ceavi.sistemamoveldecoletadedados.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import br.heusser.sistemamoveldecoletadedados.R;
import br.udesc.ceavi.sistemamoveldecoletadedados.model.Control;

public class ControlAdapter extends BaseAdapter {

	private Context context;
	private List<Control> list;


	public ControlAdapter(Context context,List<Control> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Control control = list.get(position);
		LayoutInflater inflater = 
				(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View v = inflater.inflate(R.layout.control_list, null);
		
		TextView percentage = (TextView) v.findViewById(R.id.control_list_text_view_percentage);
		percentage.setText(control.getPercentage()+"%");
		
		TextView description = (TextView) v.findViewById(R.id.control_list_text_view_description);
		description.setText(control.getSource().getDescription());
		
		TextView location = (TextView) v.findViewById(R.id.control_list_text_view_location);
		location.setText(control.getSource().getLocalization());
		
		return v;
	}

}
