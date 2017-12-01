package br.edu.iff.pooa20172.trabalho02_2017_2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Evento> eventos;
    private ArrayAdapter adapter;
    int resultado = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lista = (ListView) findViewById(R.id.lv_eventos);
        final ArrayList<Evento> eventos = inserirEventos();
        adapter = new EventoAdapter(this, eventos);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                Bundle bundle = eventos.get(i).toBundle();
                bundle.putInt("ind",i);
                intent.putExtras(bundle);

                startActivityForResult(intent, resultado);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (resultCode == RESULT_OK && requestCode == resultado) {
            Bundle dados = intent.getExtras();
            int i = dados.getInt("ind");
            Evento evento = eventos.get(i);

            if(dados.containsKey("nome")){
                evento.setNome(dados.getString("nome"));
            }
            if(dados.containsKey("local")){
                evento.setLocal(dados.getString("local"));
            }
            if(dados.containsKey("promotor")){
                evento.setPromotor(dados.getString("promotor"));
            }
            if(dados.containsKey("patrocinio")){
                evento.setPatrocinio(dados.getString("patrocinio"));
            }
            if(dados.containsKey("capacidade")){
                evento.setCapacidade(dados.getInt("capacidade"));
            }
            if(dados.containsKey("data")){
                evento.setData(dados.getString("data"));
            }
            if(dados.containsKey("valorIngresso")){
                evento.setValorIngresso(dados.getFloat("valorIngresso"));
            }

            adapter.notifyDataSetChanged();
        }
    }

    private ArrayList<Evento> inserirEventos(){
        eventos = new ArrayList<Evento>();

        Evento ev = new Evento("Evento A","29/11/2017","IFF",100,"Aderbal","Qualquer",150, R.drawable.cidades_lindas_mundo_2014_03);
        eventos.add(ev);

        ev = new Evento("Evento B","30/11/2017","IFF",200,"Bartolomeu","Qualquer",150, R.drawable.cidades_lindas_mundo_2014_15);
        eventos.add(ev);

        ev = new Evento("Evento C","01/12/2017","IFF",300,"Cardoso","Qualquer",150, R.drawable.cidades_lindas_mundo_2014_33);
        eventos.add(ev);

        ev = new Evento("Evento D","02/12/2017","IFF",300,"Dario","Qualquer",150, R.drawable.cidades_lindas_mundo_2014_45);
        eventos.add(ev);

        ev = new Evento("Evento E","03/12/2017","IFF",300,"Erbal","Qualquer",150, R.drawable.cidades_lindas_mundo_2014_50);
        eventos.add(ev);

        ev = new Evento("Evento F","04/12/2017","IFF",300,"Franco","Qualquer",150, R.drawable.cidades_lindas_mundo_2014_66);
        eventos.add(ev);

        ev = new Evento("Evento G","05/12/2017","IFF",300,"Galio","Qualquer",150, R.drawable.cidades_lindas_mundo_2014_70);
        eventos.add(ev);

        return eventos;
    }

}