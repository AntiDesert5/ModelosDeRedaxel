package com.example.modelosdered;

import android.arch.lifecycle.ViewModelStoreOwner;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2ActivityIP extends AppCompatActivity implements View.OnClickListener {
    EditText a,b,c,d,div,noRedes;
    TextView ver,mr1,di1,df1,result;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_ip);


        a = (EditText) findViewById(R.id.o1);
        result = (TextView) findViewById(R.id.TextViewRes);
        b = (EditText) findViewById(R.id.o2);
        c = (EditText)findViewById(R.id.o3);
        d = (EditText) findViewById(R.id.o4);
        b1 = (Button) findViewById(R.id.b1);
        div = (EditText) findViewById(R.id.sub);
        ver = (TextView) findViewById(R.id.val);
        mr1 = (TextView) findViewById(R.id.mr);
        di1 = (TextView) findViewById(R.id.di);
        df1 = (TextView) findViewById(R.id.df);
        b1.setOnClickListener(this);

    }

    public void noRedes(){//aqui es donde esta el calculo de N y lo que falta
        noRedes=(EditText) findViewById(R.id.noRedes);
        int N;
        int noR= Integer.parseInt(noRedes.getText().toString());
        double n=(Math.log(noR))/(Math.log(2));
        int be=(int)Math.ceil(n);
        System.out.println(be);//aqui funciona
        //********
        int a1 = Integer.parseInt(a.getText().toString());
        int b1 = Integer.parseInt(b.getText().toString());
        int c1 = Integer.parseInt(c.getText().toString());
        int d1 = Integer.parseInt(d.getText().toString());
        int mas= Integer.parseInt(div.getText().toString());
        int e1 =mas+be;
        if (e1<=30 ) {
            ver.setText("Direccion y division correcta");

            //probando
            if (e1 < 8) {
                int resta = 8 - e1;//saber la posicion de la ultima x en el octeto
                int salto = (int) Math.pow(2, resta);//proximo salto para referencia
                int fin = a1 + salto - 1;
                mr1.setText(a1 + ".0.0.0");
                di1.setText(a1 + ".0.0.1");
                if (fin > 255) {//si pasa de 255
                    int sob = fin - 255 - 1;
                    df1.setText((a1 + 1) + "." + sob + ".255.254/" + e1);
                } else
                    df1.setText(fin + ".255.255.254/" + e1);
            }

            else if (e1 > 8 && e1 <= 16) {//segundo octeto direccion ip
                int resta = 16 - e1;
                int salto = (int) Math.pow(2, resta);
                int fin = b1 + salto - 1;
                mr1.setText(a1 + "." + b1 + ".0.0/" + e1);
                di1.setText(a1 + "." + b1 + ".0.1/" + e1);
                if (fin > 255) {//si pasa de 255
                    int sob = fin -255- 1;
                    df1.setText((a1 + 1) + "." + sob + ".255.254/" + e1);
                }
                else
                    df1.setText(a1 + "." + fin + ".255.254/" + e1);
            }
            else if (e1>16 && e1<=24 ){//tercer octeto direccion ip
                int resta = 24 - e1;
                int salto = (int) Math.pow(2, resta);//salto

                for (int i=0;i<=be;i++){
                    int fin = c1+salto-1;//final
                    int fin2=b1+1;
                    mr1.setText(a1+"."+b1+"."+c1+".0/"+e1);
                    di1.setText(a1+"."+b1+"."+c1+".1/"+e1);

                    System.out.println(a1+"."+b1+"."+c1+".0/"+e1);
                    System.out.println(a1+"."+b1+"."+c1+".1/"+e1);
                    if (fin>255){//si pasa de 255
                        int sob = fin-255-1;
                        result.setText(a1+"."+(b1++)+"."+sob+".254/"+e1);
                        System.out.println(a1+"."+(b1++)+"."+sob+".254/"+e1);
                    }
                    else
                        df1.setText(a1+"."+b1+"."+fin+".254/"+e1);
                    System.out.println(a1+"."+b1+"."+fin+".254/"+e1);
                }

            }



            else {//cuarto octeto direccion ip
                int resta = 32 - e1;
                int salto = (int) Math.pow(2, resta);
                int fin = d1+salto-1;
                mr1.setText(a1+"."+b1+"."+c1+".0/"+e1);
                di1.setText(a1+"."+b1+"."+c1+".1/"+e1);
                if (fin>255){//si pasa de 255
                    int sob = fin-255-1;
                    df1.setText(a1+"."+b1+"."+(c1+1)+"."+sob+"/"+e1);
                }
                else
                    df1.setText(a1+"."+b1+"."+c1+"."+d1+"/"+e1);
            }

        }

        else {
            ver.setText("Division / incorrecta");
        }


    }

    @Override
    public void onClick(View view) {
        //Verificar que no esten los campos vacios
        if (a.getText().toString().isEmpty() || b.getText().toString().isEmpty() || c.getText().toString().isEmpty() || d.getText().toString().isEmpty() || div.getText().toString().isEmpty()){
            ver.setText("Llene los campos");
        }
        else {// si no estan vacios
            int a1 = Integer.parseInt(a.getText().toString());
            int b1 = Integer.parseInt(b.getText().toString());
            int c1 = Integer.parseInt(c.getText().toString());
            int d1 = Integer.parseInt(d.getText().toString());
            int e1 = Integer.parseInt(div.getText().toString());
            if (a1>255 || b1>255 || c1> 255 || d1 > 254 ){// que no pasen de 255
                ver.setText("Verifique direccion ip");
            }
            else {//si la direccion es correcta verificar la division
                if (e1<=30 ) {
                    ver.setText("Direccion y division correcta");

                    //probando
                    if (e1 < 8) {
                        int resta = 8 - e1;//saber la posicion de la ultima x en el octeto
                        int salto = (int) Math.pow(2, resta);//proximo salto para referencia
                        int fin = a1 + salto - 1;
                        mr1.setText(a1 + ".0.0.0");
                        di1.setText(a1 + ".0.0.1");
                        if (fin > 255) {//si pasa de 255
                            int sob = fin - 255 - 1;
                            df1.setText((a1 + 1) + "." + sob + ".255.254/" + e1);
                        } else
                            df1.setText(fin + ".255.255.254/" + e1);
                    }

                    else if (e1 > 8 && e1 <= 16) {//segundo octeto direccion ip
                        int resta = 16 - e1;
                        int salto = (int) Math.pow(2, resta);
                        int fin = b1 + salto - 1;
                        mr1.setText(a1 + "." + b1 + ".0.0/" + e1);
                        di1.setText(a1 + "." + b1 + ".0.1/" + e1);
                        if (fin > 255) {//si pasa de 255
                            int sob = fin -255- 1;
                            df1.setText((a1 + 1) + "." + sob + ".255.254/" + e1);
                        }
                        else
                            df1.setText(a1 + "." + fin + ".255.254/" + e1);
                        }
                    else if (e1>16 && e1<=24 ){//tercer octeto direccion ip
                        int resta = 24 - e1;
                        int salto = (int) Math.pow(2, resta);
                        int fin = c1+salto-1;
                        mr1.setText(a1+"."+b1+"."+c1+".0/"+e1);
                        di1.setText(a1+"."+b1+"."+c1+".1/"+e1);
                        if (fin>255){//si pasa de 255
                            int sob = fin-255-1;
                            df1.setText(a1+"."+(b1+1)+"."+sob+".254/"+e1);
                        }
                        else
                            df1.setText(a1+"."+b1+"."+fin+".254/"+e1);
                        }



                    else {//cuarto octeto direccion ip
                        int resta = 32 - e1;
                        int salto = (int) Math.pow(2, resta);
                        int fin = d1+salto-1;
                        mr1.setText(a1+"."+b1+"."+c1+".0/"+e1);
                        di1.setText(a1+"."+b1+"."+c1+".1/"+e1);
                        if (fin>255){//si pasa de 255
                            int sob = fin-255-1;
                            df1.setText(a1+"."+b1+"."+(c1+1)+"."+sob+"/"+e1);
                        }
                        else
                            df1.setText(a1+"."+b1+"."+c1+"."+d1+"/"+e1);
                        }

                    }

                else {
                    ver.setText("Division / incorrecta");
                }
            }
            noRedes();
        }
    }
}
