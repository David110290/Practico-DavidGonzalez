package com.example.david.practico_davidgonzalez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtUsuario;
    private EditText edtPwd;
    private Button btnIngresar;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        edtUsuario= (EditText) findViewById(R.id.txtUsuario);
        edtPwd= (EditText) findViewById(R.id.txtPwd);

        btnIngresar = (Button) findViewById(R.id.btnIngrsesar);
        btnIngresar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String usuario = edtUsuario.getText().toString();
                String pwd = edtPwd.getText().toString();
                if ( !usuario.equals("ites"))//Si el usuario no coicide muestra un msj y pone en blanco los edittext
                {
                    Toast.makeText(MainActivity.this,"Usuario incorrecto",Toast.LENGTH_LONG).show();
                    edtUsuario.setText("");
                    edtPwd.setText("");

                }
                else if (!pwd.equals("1234"))//Si la contraseña no coincide muestra un msj y pone en blanco el edittext de contraseña
                {
                    Toast.makeText(MainActivity.this,"Contraseña incorrecta",Toast.LENGTH_LONG).show();
                    edtPwd.setText("");
                }
                else //Si es correcto Llamo a la funcion actividad
                {
                    Actividad();
                }
            }


        });
    }
    private  void Actividad()
    {
        Intent intent = new Intent(this, Segunda_Activity.class);
        intent.putExtra ("USUARIO", edtUsuario.getText().toString());
        startActivity(intent);
        edtUsuario.setText("");//si elimino los textos en el oncreate me tira error y se cierra la aplicacion
        edtPwd.setText("");
    }

}

