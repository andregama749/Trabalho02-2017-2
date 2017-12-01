package br.edu.iff.pooa20172.trabalho02_2017_2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    int ind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        Bundle dados = intent.getExtras();
        this.ind = dados.getInt("ind");

        ((EditText) findViewById(R.id.et_nome)).setText(dados.getString("nome"));
        ((EditText) findViewById(R.id.et_local)).setText(dados.getString("local"));
        ((EditText) findViewById(R.id.et_data)).setText(dados.getString("data"));
        ((EditText) findViewById(R.id.et_promotor)).setText(dados.getString("promotor"));
        ((EditText) findViewById(R.id.et_patrocinio)).setText(dados.getString("patrocinio"));
        ((EditText) findViewById(R.id.et_capacidade)).setText(Integer.toString(dados.getInt("capacidade")));
        ((EditText) findViewById(R.id.et_valor)).setText(Float.toString(dados.getFloat("valorIngresso")));
    }

    @Override
    public void finish() {
        Intent intent = new Intent();

        Bundle bundle = new Bundle();
        bundle.putInt("ind", ind);

        bundle.putString("nome", ((EditText) findViewById(R.id.et_nome)).getText().toString());
        bundle.putString("local", ((EditText) findViewById(R.id.et_local)).getText().toString());
        bundle.putString("data", ((EditText) findViewById(R.id.et_data)).getText().toString());
        bundle.putString("promotor", ((EditText) findViewById(R.id.et_promotor)).getText().toString());
        bundle.putString("patrocinio", ((EditText) findViewById(R.id.et_patrocinio)).getText().toString());
        bundle.putInt("capacidade", Integer.parseInt(((EditText) findViewById(R.id.et_capacidade)).getText().toString()));
        bundle.putFloat("valorIngresso", Float.parseFloat(((EditText) findViewById(R.id.et_valor)).getText().toString()));

        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        super.finish();
    }
}