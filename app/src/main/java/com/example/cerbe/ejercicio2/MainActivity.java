package com.example.cerbe.ejercicio2;
//BY: Gutierrez Merida Cristhian David

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.InputFilter;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rl;
    ScrollView sv;
    LinearLayout ll;
    private static final String LOGTAG="INFO";
    TextView tvTitulo,tvNombre,tvApellido,tvNumCuenta,tvCorreo,tvGenero,tvFacultad;
    EditText cNombre,cApellido,cNumCuenta,cCorreo;
    CheckBox cGenero1,cGenero2,cFacultad1,cFacultad2,cFacultad3,cFacultad4,cFacultad5;
    Button btnEnviar;
    int valGenero,valFacultad;
    Alumno alumno;
    String genero,facultad;
    Context contexto=this;
    VerificarEmail verifica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.r1);
        if(Build.VERSION.SDK_INT>=23)
            rl.setBackgroundColor(getApplicationContext().getColor(R.color.colorFondo));
        else
            rl.setBackgroundColor(getResources().getColor(R.color.colorFondo));

        sv = new ScrollView(this);
        ll = new LinearLayout(this);
        tvTitulo = new TextView(this);
        tvNombre = new TextView(this);
        tvApellido = new TextView(this);
        tvNumCuenta = new TextView(this);
        tvCorreo = new TextView(this);
        tvGenero = new TextView(this);
        tvFacultad = new TextView(this);

        cNombre = new EditText(this);
        cApellido = new EditText(this);
        cNumCuenta = new EditText(this);
        cCorreo = new EditText(this);
        cGenero1 = new CheckBox(this);
        cGenero2 = new CheckBox(this);
        cFacultad1 = new CheckBox(this);
        cFacultad2 = new CheckBox(this);
        cFacultad3 = new CheckBox(this);
        cFacultad4 = new CheckBox(this);
        cFacultad5 = new CheckBox(this);
        btnEnviar = new Button(this);

        sv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT,LinearLayoutCompat.LayoutParams.MATCH_PARENT));
        rl.addView(sv);
        ll.setLayoutParams(new LinearLayout.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT,LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
        ll.setOrientation(LinearLayout.VERTICAL);
        sv.addView(ll);

        tvTitulo.setText(getResources().getString(R.string.titulo1));
        tvTitulo.setLayoutParams(new LinearLayout.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT,LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
        tvTitulo.setBackgroundColor(getResources().getColor(android.R.color.background_light));
        tvTitulo.setGravity(17);
        tvTitulo.setTextColor(getResources().getColor(R.color.colorPrimary));
        tvTitulo.setTextSize(TypedValue.COMPLEX_UNIT_SP,48);
        ll.addView(tvTitulo);

        tvNombre.setText(getResources().getString(R.string.tnombre));
        tvNombre.setLayoutParams(new LinearLayout.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT,LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
        tvNombre.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        tvNombre.setTextColor(getResources().getColor(android.R.color.holo_orange_dark));
        tvNombre.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
        ll.addView(tvNombre);

        cNombre.setHint(getResources().getString(R.string.cnombre));
        cNombre.setLayoutParams(new LinearLayout.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT,LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
        cNombre.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        cNombre.setEms(10);
        cNombre.setFilters(new InputFilter[]{new InputFilter.LengthFilter(30)});
        cNombre.setTextColor(getResources().getColor(android.R.color.background_dark));
        ll.addView(cNombre);

        tvApellido.setText(getResources().getString(R.string.tapellido));
        tvApellido.setLayoutParams(new LinearLayout.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT,LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
        tvApellido.setBackgroundColor(getResources().getColor(R.color.tv2));
        tvApellido.setTextColor(getResources().getColor(android.R.color.holo_orange_dark));
        tvApellido.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
        ll.addView(tvApellido);

        cApellido.setHint(getResources().getString(R.string.capellido));
        cApellido.setLayoutParams(new LinearLayout.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT,LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
        cApellido.setBackgroundColor(getResources().getColor(R.color.tv2));
        cApellido.setEms(10);
        cApellido.setFilters(new InputFilter[]{new InputFilter.LengthFilter(30)});
        cApellido.setTextColor(getResources().getColor(android.R.color.background_dark));
        ll.addView(cApellido);

        tvNumCuenta.setText(getResources().getString(R.string.tnumcuenta));
        tvNumCuenta.setLayoutParams(new LinearLayout.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT,LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
        tvNumCuenta.setBackgroundColor(getResources().getColor(R.color.tv3));
        tvNumCuenta.setTextColor(getResources().getColor(android.R.color.holo_orange_dark));
        tvNumCuenta.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
        ll.addView(tvNumCuenta);

        cNumCuenta.setHint(getResources().getString(R.string.cnumcuenta));
        cNumCuenta.setLayoutParams(new LinearLayout.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT,LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
        cNumCuenta.setBackgroundColor(getResources().getColor(R.color.tv3));
        cNumCuenta.setEms(10);
        cNumCuenta.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});
        cNumCuenta.setTextColor(getResources().getColor(android.R.color.background_dark));
        cNumCuenta.setInputType(2);
        ll.addView(cNumCuenta);

        tvCorreo.setText(getResources().getString(R.string.tcorreo));
        tvCorreo.setLayoutParams(new LinearLayout.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT,LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
        tvCorreo.setBackgroundColor(getResources().getColor(R.color.tv4));
        tvCorreo.setTextColor(getResources().getColor(android.R.color.holo_orange_dark));
        tvCorreo.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
        ll.addView(tvCorreo);

        cCorreo.setHint(getResources().getString(R.string.ccorreo));
        cCorreo.setLayoutParams(new LinearLayout.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT,LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
        cCorreo.setBackgroundColor(getResources().getColor(R.color.tv4));
        cCorreo.setEms(10);
        cCorreo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(35)});
        cCorreo.setTextColor(getResources().getColor(android.R.color.background_dark));
        ll.addView(cCorreo);

        tvGenero.setText(getResources().getString(R.string.tgenero));
        tvGenero.setLayoutParams(new LinearLayout.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT,LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
        tvGenero.setBackgroundColor(getResources().getColor(R.color.tv5));
        tvGenero.setTextColor(getResources().getColor(android.R.color.holo_orange_dark));
        tvGenero.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
        ll.addView(tvGenero);

        cGenero1.setText(getResources().getString(R.string.tgenero1));
        cGenero1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT,LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
        cGenero1.setBackgroundColor(getResources().getColor(R.color.tv5));
        ll.addView(cGenero1);

        cGenero2.setText(getResources().getString(R.string.tgenero2));
        cGenero2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT,LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
        cGenero2.setBackgroundColor(getResources().getColor(R.color.tv5));
        ll.addView(cGenero2);

        tvFacultad.setText(getResources().getString(R.string.tfacultad));
        tvFacultad.setLayoutParams(new LinearLayout.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT,LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
        tvFacultad.setBackgroundColor(getResources().getColor(R.color.tv6));
        tvFacultad.setTextColor(getResources().getColor(android.R.color.holo_orange_dark));
        tvFacultad.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
        ll.addView(tvFacultad);

        cFacultad1.setText(getResources().getString(R.string.tfacultad1));
        cFacultad1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT,LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
        cFacultad1.setBackgroundColor(getResources().getColor(R.color.tv6));
        ll.addView(cFacultad1);

        cFacultad2.setText(getResources().getString(R.string.tfacultad2));
        cFacultad2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT,LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
        cFacultad2.setBackgroundColor(getResources().getColor(R.color.tv6));
        ll.addView(cFacultad2);

        cFacultad3.setText(getResources().getString(R.string.tfacultad3));
        cFacultad3.setLayoutParams(new LinearLayout.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT,LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
        cFacultad3.setBackgroundColor(getResources().getColor(R.color.tv6));
        ll.addView(cFacultad3);

        cFacultad4.setText(getResources().getString(R.string.tfacultad4));
        cFacultad4.setLayoutParams(new LinearLayout.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT,LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
        cFacultad4.setBackgroundColor(getResources().getColor(R.color.tv6));
        ll.addView(cFacultad4);

        cFacultad5.setText(getResources().getString(R.string.tfacultad5));
        cFacultad5.setLayoutParams(new LinearLayout.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT,LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
        cFacultad5.setBackgroundColor(getResources().getColor(R.color.tv6));
        ll.addView(cFacultad5);

        btnEnviar.setText(getResources().getString(R.string.tEnviar));
        btnEnviar.setLayoutParams(new LinearLayout.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT,LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
        btnEnviar.setBackgroundColor(getResources().getColor(android.R.color.holo_purple));
        btnEnviar.setTextColor(getResources().getColor(android.R.color.background_light));
        ll.addView(btnEnviar);


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valGenero=0;
                valFacultad=0;

                //Valida Nombre
                if(cNombre.length()==0){
                    Toast.makeText(getApplicationContext(),
                            getResources().getString(R.string.mensajeNom),Toast.LENGTH_SHORT).show();
                }

                //Valida Apellido
                if(cApellido.length()==0){
                    Toast.makeText(getApplicationContext(),
                            getResources().getString(R.string.mensajeApell),Toast.LENGTH_SHORT).show();
                }

                //Valida Numero de cuenta
                if(cNumCuenta.length()!=10){
                    Toast.makeText(getApplicationContext(),
                            getResources().getString(R.string.mensajeNum),Toast.LENGTH_SHORT).show();
                }

                //Valida Correo
                verifica = new VerificarEmail(cCorreo.getText().toString());
                if(verifica.verifica()!=true){
                    Toast.makeText(getApplicationContext(),
                            getResources().getString(R.string.mensajeCorreo),Toast.LENGTH_SHORT).show();
                }

                //Valida Genero
                if(cGenero1.isChecked()==true){
                    valGenero++;
                    genero=cGenero1.getText().toString();
                }
                if(cGenero2.isChecked()==true){
                    valGenero++;
                    genero=cGenero2.getText().toString();
                }
                if(valGenero!=1){
                    Toast.makeText(getApplicationContext(),
                            getResources().getString(R.string.mensajeGenero),Toast.LENGTH_SHORT).show();
                }


                //Valida Facultad
                if(cFacultad1.isChecked()==true){
                    valFacultad++;
                    facultad=cFacultad1.getText().toString();
                }
                if(cFacultad2.isChecked()==true){
                    valFacultad++;
                    facultad=cFacultad2.getText().toString();
                }
                if(cFacultad3.isChecked()==true){
                    valFacultad++;
                    facultad=cFacultad3.getText().toString();
                }
                if(cFacultad4.isChecked()==true){
                    valFacultad++;
                    facultad=cFacultad4.getText().toString();
                }
                if(cFacultad5.isChecked()==true){
                    valFacultad++;
                    facultad=cFacultad5.getText().toString();
                }

                if(valFacultad!=1){
                    Toast.makeText(getApplicationContext(),
                            getResources().getString(R.string.mensajeFac),Toast.LENGTH_SHORT).show();
                }


                //Toast Alumno y LOGTAG
                if(valGenero==1 && valFacultad==1 && cNumCuenta.length()==10 && cNombre.length()!=0 && cApellido.length()!=0 && verifica.verifica()==true){
                    alumno = new Alumno(cNombre.getText().toString(),cApellido.getText().toString(),
                            Long.parseLong(cNumCuenta.getText().toString()),cCorreo.getText().toString(),
                            genero,facultad,contexto);

                    Toast.makeText(getApplicationContext(),alumno.toString(),Toast.LENGTH_LONG).show();
                    Log.i(LOGTAG, alumno.toString());
                }
            }
        });
    }
}
