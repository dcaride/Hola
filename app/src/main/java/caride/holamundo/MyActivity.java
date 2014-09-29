package caride.holamundo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;


public class MyActivity extends Activity {

    Button btnAlerta;
    Button btnMensajeToast;
    RelativeLayout miLayout;
    private static final String LOGCAT = "HolaMundo";

    Button btnCambia;
    EditText nombre;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        inicializa();

    }

    public void inicializa(){

        btnAlerta = (Button)findViewById(R.id.btnAlerta);
        btnAlerta.setOnClickListener(raebtnAlerta);
        btnMensajeToast = (Button)findViewById(R.id.btnMensajeToast);
        btnMensajeToast.setOnClickListener(raebtnMensajeToast);

        miLayout = (RelativeLayout)findViewById(R.id.miLayout);

        btnCambia = (Button) findViewById(R.id.btnCambia);
        btnCambia.setOnClickListener(raeCambia);

        nombre = (EditText)findViewById(R.id.editTextNombre);






    }

    public void lanzaToast(int text){

        Toast mensaje = Toast.makeText(this, text, Toast.LENGTH_LONG);
        mensaje.setGravity(Gravity.CENTER, 0,0);
        mensaje.show();

    }

    public View.OnClickListener raeCambia = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(MyActivity.this, Prueba.class);
            intent.putExtra("nombre", nombre.getText().toString());
            startActivity(intent);


        }
    };

    public View.OnClickListener raebtnAlerta = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.e("--->", "alerta");
            lanzaAlerta();

        }
    };

    public View.OnClickListener raebtnMensajeToast = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d("--->", "toast");
            lanzaToast(R.string.toast);

        }
    };


    public void lanzaAlerta(){

        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setTitle("Mi primera alerta");
        alerta.setMessage("Quieres cambiar de color el fondo??");
        alerta.setCancelable(true);
        alerta.setPositiveButton("Aceptar", raeAceptarAlerta);
        alerta.setNegativeButton("Cancelar", raeAceptarAlerta);
        alerta.setIcon(R.drawable.ic_launcher);
        alerta.create().show();

    }



    private DialogInterface.OnClickListener raeAceptarAlerta = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {

            switch (i){
                case DialogInterface.BUTTON_POSITIVE:

                    Random rand = new Random();
                    int color = Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
                    miLayout.setBackgroundColor(color);

                    Log.e(LOGCAT, "Mensaje de ERROR");
                    Log.d(LOGCAT, "Mensaje de DEPURACION");
                    Log.i(LOGCAT, "Mensaje de INFORMACION");
                    Log.w(LOGCAT, "Mensaje de WARNING");

                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    dialogInterface.cancel();


            }

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Log.i("--->", "pulsado menu");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
