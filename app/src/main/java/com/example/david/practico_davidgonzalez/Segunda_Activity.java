package com.example.david.practico_davidgonzalez;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Segunda_Activity extends AppCompatActivity {
    private String saludo;
    private EditText edtTel;
    private Button btnMarcar;
    private Button btnFin;
    //private TextView txtBienvenido;
    String tel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_);

        Bundle parametros = getIntent().getExtras();//Tomo lo enviado en el activity-main
        saludo= "Bienvenido " + parametros.getString("USUARIO");//Concateno lo enviado en el activity-main y lo asigno al string

        TextView txtBienvenido = (TextView) findViewById(R.id.txtBinvenido);
        txtBienvenido.setText(saludo);//Asigto el string al TextView

        btnMarcar = (Button) findViewById(R.id.btnMarcar);
        btnMarcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Llamada();//Al pulsar el boton marcar Llamo a la funcion
            }
        });

        btnFin = (Button) findViewById(R.id.btnFin);

        btnFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                finish();//Al pulsar cerrar secion cierro Este activity y vuelvo al anterior
            }
        });


    }

    private void Llamada(){
        edtTel = (EditText) findViewById(R.id.edtTel);//Tomo lo que esta en el editext
        tel= edtTel.getText().toString();//Asigno lo que esta en el editext al sting
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+tel));
        startActivity(intent);
    }
}
