package br.ufc.quixada.dsdm.paymentsmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button Cadastrar;
    private Button Salas;
    private Button Principal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cadastrar = findViewById(R.id.btn_cadastro);
        Salas = findViewById(R.id.btn_salas);
        Principal = findViewById(R.id.btn_principal);

        Cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        Salas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, RoomActivity.class);
//                startActivity(intent);
            }
        });
    }
}
