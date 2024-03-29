package com.example.appbuscacep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DadosCep extends AppCompatActivity {

    private EditText datacep, datacid, datauf, datarua, dataddd, databai, datacomp;
    private Button btmapa;
    public static final String EXTRA_MESSAGE = "com.example.appbuscacep.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_cep);

        Intent intent = getIntent();
        String cep = intent.getStringExtra(ResultCep.EXTRA_MESSAGE);

        datacep = findViewById(R.id.datacep);
        datacid = findViewById(R.id.datacid);
        datauf = findViewById(R.id.datauf);
        datarua = findViewById(R.id.datarua);
        dataddd = findViewById(R.id.dataddd);
        databai = findViewById(R.id.databai);
        datacomp = findViewById(R.id.datacomp);
        btmapa = findViewById(R.id.btmapa);

        String [] aoba = cep.split("/");

        datacep.setText(aoba[0]);
        datarua.setText(aoba[1]);
        datacomp.setText(aoba[2]);
        databai.setText(aoba[3]);
        datacid.setText(aoba[4]);
        datauf.setText(aoba[5]);
        dataddd.setText(aoba[6]);
    }

    public void sendMessage(View view) {

        String str = datarua.getText() + "," + datacomp.getText() + "," + datacid.getText() + "," + datauf.getText();
        Intent intent = new Intent(this, Mapa.class);

        intent.putExtra(EXTRA_MESSAGE, str);
        startActivity(intent);
    }
}