package br.udesc.ceavi.custodevida.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.udesc.ceavi.custodevida.R;
import br.udesc.ceavi.custodevida.model.Control;

public class ControlAdapter extends ArrayAdapter<Control> {

    private final Context context;
    private final List<Control> values;

    public ControlAdapter(Context context, List<Control> values){
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.row_control, parent, false);
        TextView textViewPercentage = (TextView)
                view.findViewById(R.id.list_activity_control_text_view_percentage);
        TextView textViewDescription = (TextView)
                view.findViewById(R.id.list_activity_control_text_view_description);
        TextView textViewLocalization = (TextView)
                view.findViewById(R.id.list_activity_control_text_view_localization);
        textViewPercentage.setText(String.valueOf(values.get(position).getPercentage()));
        textViewDescription.setText(values.get(position).getSource().getDescription());
        textViewLocalization.setText(values.get(position).getSource().getLocalization());
        return super.getView(position, convertView, parent);
    }
}
