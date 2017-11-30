package br.edu.iff.pooa20172.trabalho02_2017_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class EventoAdapter extends ArrayAdapter<Evento> {

    private final Context context;
    private final ArrayList<Evento> elementos;

    public EventoAdapter(Context context, ArrayList<Evento> elementos){
        super(context, R.layout.item_evento, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item_evento, parent,false);

        TextView nomeEvento = (TextView) rowView.findViewById(R.id.tv_nome);
        TextView localEvento = (TextView) rowView.findViewById(R.id.tv_local);
        TextView dataEvento = (TextView) rowView.findViewById(R.id.tv_data);
        ImageView imagemEvento = (ImageView) rowView.findViewById(R.id.imageView);

        nomeEvento.setText(elementos.get(position).getNome());
        localEvento.setText(elementos.get(position).getLocal());
        dataEvento.setText(elementos.get(position).getData());
        imagemEvento.setImageResource(elementos.get(position).getImagem());

        return rowView;
    }
}