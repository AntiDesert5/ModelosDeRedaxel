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
    EditText a,b,c,d,div,noRedes,q;
    TextView ver,mr1,di1,df1,result,result2,ipinicialf,ipfinalf;
    Button b1;
    private int totnu=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);


        a = (EditText) findViewById(R.id.o1);
        result = (TextView) findViewById(R.id.TextViewRes);
        result2 = (TextView) findViewById(R.id.hola);
        b = (EditText) findViewById(R.id.o2);
        c = (EditText)findViewById(R.id.o3);
        q = (EditText) findViewById(R.id.o4);
        d = (EditText) findViewById(R.id.o4);
        b1 = (Button) findViewById(R.id.b1);
        div = (EditText) findViewById(R.id.sub);
        ver = (TextView) findViewById(R.id.val);
        mr1 = (TextView) findViewById(R.id.mr);
        di1 = (TextView) findViewById(R.id.di);
        df1 = (TextView) findViewById(R.id.df);
        ipinicialf = (TextView) findViewById(R.id.ipinicialf);
        ipfinalf = (TextView) findViewById(R.id.ipfinalf);

        b1.setOnClickListener(this);

    }



    @Override
    public void onClick(View view) {
        sub();
    }

    public void sub(){
        int m;
        String c2;
        if (a.getText().toString().isEmpty() || b.getText().toString().isEmpty() || c.getText().toString().isEmpty() || d.getText().toString().isEmpty() || div.getText().toString().isEmpty()){

            Toast.makeText(this,"De favor llena todos los campos",Toast.LENGTH_LONG).show();
        }
        else {// si no estan vacios
            ver.setText("  ");
            int u = Integer.parseInt(a.getText().toString());
            int d = Integer.parseInt(b.getText().toString());
            int t = Integer.parseInt(c.getText().toString());
            int c = Integer.parseInt(q.getText().toString());
            int n = Integer.parseInt(div.getText().toString());
            noRedes=(EditText) findViewById(R.id.noRedes);
            int nu= Integer.parseInt(noRedes.getText().toString());
            double n1=(Math.log(nu))/(Math.log(2));
            int be=(int)Math.ceil(n1);
            System.out.println(be);//aqui funciona


            int a=0,f,g = 0,g2=0,n2=1,D=n;
            int s=d;
            int g1=d,g12=t,g13=c;
            if (u > 255 || d > 255 || t > 255 || c > 254) {// que no pasen de 255
                ver.setText("Verifique direccion ip");
                Toast.makeText(this,"Verifica la direccion IP ingresada",Toast.LENGTH_LONG).show();
            }
            else{
                System.out.println(u);
                int f2=c;
                f2++;
                totnu=be+n;
                di1.setText(""+u+"."+d+"."+t+"."+f2+"/"+totnu);
                    if(n>=24){
                        n=n-24;
                        n2=4;
                    } else if (n>=16){
                        n=n-16;
                        n2=3;
                    }else if (n>=8){
                        n=n-8;
                        n2=2;
                    }

                    if (n==1){
                        g=128;
                        g2=128;
                    }else if(n==2){
                        g=64;
                        g2=192;
                    }else if(n==3){
                        g=32;
                        g2=224;
                    }else if(n==4){
                        g=16;
                        g2=240;
                    }else if(n==5){
                        g=8;
                        g2=248;
                    }else if(n==6){
                        g=4;
                        g2=252;
                    }else if(n==7){
                        g=2;
                        g2=254;
                    }else if(n==8){
                        g=1;
                        g2=255;
                    }

                    if(n2==1){
                        mr1.setText(g2+".0.0.0");
                    }else if(n2==2){
                        mr1.setText("255."+g2+".0.0");
                    }else if(n2==3){
                        mr1.setText("255.255."+g2+".0");
                    }else if(n2==4){
                        mr1.setText("255.255.255"+g2);
                    }
                if(n2==1){
                 int aux=u+g-1;
                    c--;
                    c--;
                    d--;
                    t--;

                    if(d<0){
                        d=255;
                    }
                    if(t<0){
                        t=255;
                    }
                    if(c<0){
                        c=254;
                    }
                    df1.setText(aux+" "+d+" "+t+" "+c);
                    System.out.println(aux+" "+d+" "+t+" "+c);
                }else if(n2==2){
                    int aux=d+g-1;
                    c--;
                    c--;
                    t--;


                    if(t<0){
                        t=255;
                    }
                    if(c<0){
                        c=254;
                    }
                    df1.setText(u+"."+aux+"."+t+"."+c);
                }else if(n2==3){
                    int aux=t+g-1;
                    c--;
                    c--;
                    if(c<0){
                        c=254;
                    }
                    df1.setText(u+"."+d+"."+aux+"."+c);

                }else if(n2==4){
                }

                    int p=0,mo=2,mo2;
                int i,e=0;
                double x=0;
                for(i=0;i<10;i++) {
                    i--;
                    x = Math.pow(2, p);
                    if(x>=nu){
                        i=100;
                    }else{
                        p++;
                    }
                }


                n=D+p;
                System.out.println("Numero de saltos final: "+n+" "+p);
                if(n>=24){
                    n=n-24;
                    n2=4;
                } else if (n>=16){
                    n=n-16;
                    n2=3;
                }else if (n>=8){
                    n=n-8;
                    n2=2;
                }

                int k=n;
                System.out.println("Num Sal: "+k);
                if (k==1){
                    g=128;
                    g2=128;
                }else if(k==2){
                    g=64;
                    g2=192;
                }else if(k==3){
                    g=32;
                    g2=224;
                }else if(k==4){
                    g=16;
                    g2=240;
                }else if(k==5){
                    g=8;
                    g2=248;
                }else if(k==6){
                    g=4;
                    g2=252;
                }else if(k==7){
                    g=2;
                    g2=254;
                }else if(k==8){
                    g=1;
                    g2=255;
                }
                System.out.println("s tiebe: "+s);
                System.out.println("Numero de saltos: "+g);

                    result2.setText("Subredes\n");
                if(n2==0){
                    mr1.setText(g2+".0.0.0");
                }else if(n2==1){
                    for(i=0;i<nu;i++){
                        s=s+g;
                        System.out.println(s);
                        result2.setText(result2.getText()+"\n"+(s-8)+"."+g1+"."+g12+"."+g13);
                        ipinicialf.setText(result2.getText()+"\n"+u+"."+g1+"."+g12+"."+"1");
                    }
                }else if(n2==2){
                    for(i=0;i<nu;i++){
                        s=s+g;
                        System.out.println(s);
                        if((s-8)>=255){
                            u++;
                            s=s-256;
                        }
                        result2.setText(result2.getText()+"\n"+u+"."+(s-8)+"."+g12+"."+g13);
                        ipinicialf.setText(result2.getText()+"\n"+u+"."+(s-7)+"."+g12+"."+"1");

                    }
                }else if(n2==3){
                    mr1.setText("255.255."+g2+".0");
                    for(i=0;i<nu;i++){
                        //s=s+g;
                        s=s+g;
                        if((s)>=255){
                            g1++;
                            s=s-256;
                        }
                        result2.setText(result2.getText()+"\n"+u+"."+g1+"."+(s)+"."+g12);
                        ipinicialf.setText(result2.getText()+"\n"+u+"."+g1+"."+(s)+"."+"1");

                    }
                }else if(n2==4){
                    mr1.setText("255.255.255."+g2);for(i=0;i<nu;i++){
                        s=s+g;
                        //aqui
                        if((s-8)>=255){
                            g12++;
                            s=s-256;
                        }
                        result2.setText(result2.getText()+"\n"+u+"."+g1+"."+g12+"."+(s-8));
                        ipinicialf.setText(result2.getText()+"\n"+u+"."+g1+"."+g12+"."+(s-7));

                    }
                }
                System.out.println(p);

            }


        }
    }

}



