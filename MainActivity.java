package com.example.devavanc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int nbcoul;
    int test = 0;                   //variable qui permet de s'incrémenter et de compter chaque test
    int[] tabps = new int[4];
    int[] tabpscopie = new int[4];
    int[] tabt = new int[4];
    int essai = 5;
    int cache = 0;
    int valide = 0;                 //compteur du nombre de victoire (bp=4) pour éviter la triche à la fin
    int triche = 0;                 // 0 = pas de triche        1 = triche
    int but1 = 0, but2 = 0, but3 = 0, but4 = 0;    //0 button activé    1 button desact
    int compteurvalid = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView changebutton4 = (TextView) findViewById(R.id.button);                     //DEFINIR ET RESET --> DEFINIR
        changebutton4.setText("DEFINIR");


    }

    public void buttonOnClicRESET(View v) {

        EditText nbc = findViewById(R.id.editText9);            // SAISI D'UN NOMBRE DE COULEUR
        String nbcs = (nbc.getText().toString());
        nbcoul = (Integer.parseInt(nbcs));

        essai = 5;

        cache = 0;

        valide = 0;

        triche = 0;


        for (int i = 0; i < tabps.length; i++) {                  //CREATION COMBINAISON SECRETE ALEATOIRE EN FONCTION DU NOMBRE DE COULEUR
            tabps[i] = new Random().nextInt(nbcoul);

        }

        TextView changebutton5 = (TextView) findViewById(R.id.button);                     //DEFINIR --> DEFINIR ET RESET
        changebutton5.setText("DEFINIR ET RESET");

        System.arraycopy(tabps, 0, tabpscopie, 0, tabps.length);            //CREATION D'UNE COPIE DE LA SOLUTION SECRETE

       // Log.d("MMI20", "la combinaison secrète est : " + tabps[0] + " " + tabps[1] + " " + tabps[2] + " " + tabps[3]);
        Log.d("MMI20", "---------------------------------------------------");
        Log.d("MMI20", "la combinaison secrète est : " + tabpscopie[0] + " " + tabpscopie[1] + " " + tabpscopie[2] + " " + tabpscopie[3]);


        TextView changetxtps = (TextView) findViewById(R.id.pttxt0);                     //RESET DES CHAMPS TEXTES
        changetxtps.setText(" ");
        TextView changetxt = (TextView) findViewById(R.id.bp);
        changetxt.setText(" ");
        TextView changetxt2 = (TextView) findViewById(R.id.mp);
        changetxt2.setText(" ");


        TextView changetxtps2 = (TextView) findViewById(R.id.pttxt2);                     //RESET DES CHAMPS TEXTES
        changetxtps2.setText(" ");
        TextView changetxt8 = (TextView) findViewById(R.id.bp2);
        changetxt8.setText(" ");
        TextView changetxt3 = (TextView) findViewById(R.id.mp2);
        changetxt3.setText(" ");


        TextView changetxtps6 = (TextView) findViewById(R.id.pttxt3);                     //RESET DES CHAMPS TEXTES
        changetxtps6.setText(" ");
        TextView changetxt4 = (TextView) findViewById(R.id.bp3);
        changetxt4.setText(" ");
        TextView changetxt5 = (TextView) findViewById(R.id.mp3);
        changetxt5.setText(" ");


        TextView changetxtps3 = (TextView) findViewById(R.id.pttxt4);                     //RESET DES CHAMPS TEXTES
        changetxtps3.setText(" ");
        TextView changetxt6 = (TextView) findViewById(R.id.bp4);
        changetxt6.setText(" ");
        TextView changetxt7 = (TextView) findViewById(R.id.mp4);
        changetxt7.setText(" ");


        TextView changetxtps4 = (TextView) findViewById(R.id.pttxt5);                     //RESET DES CHAMPS TEXTES
        changetxtps4.setText(" ");
        TextView changetxt10 = (TextView) findViewById(R.id.bp5);
        changetxt10.setText(" ");
        TextView changetxt9 = (TextView) findViewById(R.id.mp5);
        changetxt9.setText(" ");

        TextView changetxtpt2 = (TextView) findViewById(R.id.pstxt);                     //AFFICHAGE DU NOMBRE D'ESSAI DISPONIBLE
        changetxtpt2.setText("Vous avez " + essai + " essai(s)");

        TextView changen0 = (TextView) findViewById(R.id.n0);
        changen0.setText("1 :");

        TextView changen1 = (TextView) findViewById(R.id.n1);
        changen1.setText("2 :");

        TextView changen2 = (TextView) findViewById(R.id.n2);
        changen2.setText("3 :");

        TextView changen3 = (TextView) findViewById(R.id.n3);
        changen3.setText("4 :");

        TextView changen4 = (TextView) findViewById(R.id.n4);
        changen4.setText("5 :");


        test = 0;


    }

    public void buttonOnClicCACHE(View v) {                                        //FAIRE APARRAITRE LA SOLUTION
        if (cache == 0) {
            TextView changetxtpt10 = (TextView) findViewById(R.id.pstxt);
            changetxtpt10.setText(tabpscopie[0] + " " + tabpscopie[1] + " " + tabpscopie[2] + " " + tabpscopie[3]);
            TextView changetxtbut = (TextView) findViewById(R.id.showbutton);
            changetxtbut.setText("CACHER");
            cache++;
            triche = 1;
        } else {                                                                  //CACHER LA SOLUTION
            if (test > 0) {
                TextView changetxtpt15 = (TextView) findViewById(R.id.pstxt);
                changetxtpt15.setText("Vous avez " + essai + " essai(s)");
            }
            TextView changetxtpt11 = (TextView) findViewById(R.id.pstxt);
            changetxtpt11.setText(" ");
            TextView changetxtbut = (TextView) findViewById(R.id.showbutton);
            changetxtbut.setText("MONTRER");
            cache = 0;
        }


    }

    public void buttonOnClicRED(View v) {

        if (but1 == 0) {
            Button colourbut1 = (Button) findViewById(R.id.buttonred);
            colourbut1.setBackgroundColor(Color.RED);

            if (compteurvalid == 0) {                                                               //PREMIERE VALIDATION
                EditText changechamp1 = (EditText) findViewById(R.id.tentativ1);
                changechamp1.setText("0");
                String schangechamp1 =  (changechamp1.getText().toString());
                tabt[0] = (Integer.parseInt(schangechamp1));
            }

            if (compteurvalid == 1) {                                                               //2ème VALIDATION
                EditText changechamp1 = (EditText) findViewById(R.id.tentativ2);
                changechamp1.setText("0");
                String schangechamp1 =  (changechamp1.getText().toString());
                tabt[1] = (Integer.parseInt(schangechamp1));
            }

            if (compteurvalid == 2) {                                                               //3ème VALIDATION
                EditText changechamp1 = (EditText) findViewById(R.id.tentativ3);
                changechamp1.setText("0");
                String schangechamp1 =  (changechamp1.getText().toString());
                tabt[2] = (Integer.parseInt(schangechamp1));
            }

            if (compteurvalid == 3) {                                                               //4ème VALIDATION
                EditText changechamp1 = (EditText) findViewById(R.id.tentativ4);
                changechamp1.setText("0");
                String schangechamp1 =  (changechamp1.getText().toString());
                tabt[3] = (Integer.parseInt(schangechamp1));
            }

                    but1++; }                                                                       //DESACT --> ACTIVATION DU BOUTTON

        else {
            Button colourbut2 = (Button) findViewById(R.id.buttonred);
            colourbut2.setBackgroundColor(Color.WHITE);
            but1--;
        }

    }

    public void buttonOnClicGREEN(View v) {
        if (but2 == 0) {
            Button colourbut3 = (Button) findViewById(R.id.buttongreen);
            colourbut3.setBackgroundColor(Color.GREEN);

            if (compteurvalid == 0) {
                EditText changechamp1 = (EditText) findViewById(R.id.tentativ1);
                changechamp1.setText("1");
                String schangechamp1 =  (changechamp1.getText().toString());
                tabt[0] = (Integer.parseInt(schangechamp1));
            }

            if (compteurvalid == 1) {
                EditText changechamp1 = (EditText) findViewById(R.id.tentativ2);
                changechamp1.setText("1");
                String schangechamp1 =  (changechamp1.getText().toString());
                tabt[1] = (Integer.parseInt(schangechamp1));
            }

            if (compteurvalid == 2) {
                EditText changechamp1 = (EditText) findViewById(R.id.tentativ3);
                changechamp1.setText("1");
                String schangechamp1 =  (changechamp1.getText().toString());
                tabt[2] = (Integer.parseInt(schangechamp1));
            }

            if (compteurvalid == 3) {
                EditText changechamp1 = (EditText) findViewById(R.id.tentativ4);
                changechamp1.setText("1");
                String schangechamp1 =  (changechamp1.getText().toString());
                tabt[3] = (Integer.parseInt(schangechamp1));
            }

            but2++; }


        else {
            Button colourbut4 = (Button) findViewById(R.id.buttongreen);
            colourbut4.setBackgroundColor(Color.WHITE);
            but2--;
        }
    }

    public void buttonOnClicBLUE(View v) {
        if (but3 == 0) {
            Button colourbut5 = (Button) findViewById(R.id.buttonblue);
            colourbut5.setBackgroundColor(Color.BLUE);

            if (compteurvalid == 0) {
                EditText changechamp1 = (EditText) findViewById(R.id.tentativ1);
                changechamp1.setText("2");
                String schangechamp1 =  (changechamp1.getText().toString());
                tabt[0] = (Integer.parseInt(schangechamp1));
            }

            if (compteurvalid == 1) {
                EditText changechamp1 = (EditText) findViewById(R.id.tentativ2);
                changechamp1.setText("2");
                String schangechamp1 =  (changechamp1.getText().toString());
                tabt[1] = (Integer.parseInt(schangechamp1));
            }

            if (compteurvalid == 2) {
                EditText changechamp1 = (EditText) findViewById(R.id.tentativ3);
                changechamp1.setText("2");
                String schangechamp1 =  (changechamp1.getText().toString());
                tabt[2] = (Integer.parseInt(schangechamp1));
            }

            if (compteurvalid == 3) {
                EditText changechamp1 = (EditText) findViewById(R.id.tentativ4);
                changechamp1.setText("2");
                String schangechamp1 =  (changechamp1.getText().toString());
                tabt[3] = (Integer.parseInt(schangechamp1));
            }
            but3 ++;
        }

            else {
                Button colourbut6 = (Button) findViewById(R.id.buttonblue);
                colourbut6.setBackgroundColor(Color.WHITE);
                but3--;
            }
        }

        public void buttonOnClicYELLOW (View v){
            if (but4 == 0) {
                Button colourbut7 = (Button) findViewById(R.id.buttonyellow);
                colourbut7.setBackgroundColor(Color.YELLOW);

                if(compteurvalid == 0) {
                    EditText changechamp1 = (EditText) findViewById(R.id.tentativ1);
                    changechamp1.setText("3");
                    String schangechamp1 =  (changechamp1.getText().toString());
                    tabt[0] = (Integer.parseInt(schangechamp1));

                }

                if(compteurvalid == 1) {
                    EditText changechamp1 = (EditText) findViewById(R.id.tentativ2);
                    changechamp1.setText("3");
                    String schangechamp1 =  (changechamp1.getText().toString());
                    tabt[1] = (Integer.parseInt(schangechamp1));
                }

                if(compteurvalid == 2) {
                    EditText changechamp1 = (EditText) findViewById(R.id.tentativ3);
                    changechamp1.setText("3");
                    String schangechamp1 =  (changechamp1.getText().toString());
                    tabt[2] = (Integer.parseInt(schangechamp1));
                }

                if(compteurvalid == 3) {
                    EditText changechamp1 = (EditText) findViewById(R.id.tentativ4);
                    changechamp1.setText("3");
                    String schangechamp1 =  (changechamp1.getText().toString());
                    tabt[3] = (Integer.parseInt(schangechamp1));
                }

                but4++; }

            else {
                Button colourbut8 = (Button) findViewById(R.id.buttonyellow);
                colourbut8.setBackgroundColor(Color.WHITE);
                but4--;
            }
        }


        public void buttonOnClicValider (View v){
            compteurvalid++;
        }

        public void buttonOnClicTESTER (View v){

            compteurvalid = 0;
            int bp = 0;
            int mp = 0;


            essai = essai - 1;


            // DEFINITION DE LA COMBINAISON SECRETE GRACE AUX CHAMPS DE TEXTE

                        /* EditText ts1 = findViewById(R.id.editText1);
                        String s1 = (ts1.getText().toString());
                        tabps[0] = (Integer.parseInt(s1));



                        EditText ts2 = findViewById(R.id.editText2);
                        String s2 = (ts2.getText().toString());
                        tabps[1] = (Integer.parseInt(s2));


                        EditText ts3 = findViewById(R.id.editText3);
                        String s3 = (ts3.getText().toString());
                        tabps[2] = (Integer.parseInt(s3));


                        EditText ts4 = findViewById(R.id.editText4);
                        String s4 = (ts4.getText().toString());
                        tabps[3] = (Integer.parseInt(s4)); */


            // Log.d( "MMI20", "la combinaison secrète est : "+tabps[0]+" "+tabps[1]+" "+tabps[2]+" "+tabps[3]);
            Log.d("MMI20", "la combinaison secrète est : " + tabpscopie[0] + " " + tabpscopie[1] + " " + tabpscopie[2] + " " + tabpscopie[3]);

            // DEFINITION DE LA TENTATIVE GRACE AUX CHAMPS DE TEXTE

            EditText tj1 = findViewById(R.id.tentativ1);
            String t1 = (tj1.getText().toString());
            tabt[0] = (Integer.parseInt(t1));

            EditText tj2 = findViewById(R.id.tentativ2);
            String t2 = (tj2.getText().toString());
            tabt[1] = (Integer.parseInt(t2));

            EditText tj3 = findViewById(R.id.tentativ3);
            String t3 = (tj3.getText().toString());
            tabt[2] = (Integer.parseInt(t3));


            EditText tj4 = findViewById(R.id.tentativ4);
            String t4 = (tj4.getText().toString());
            tabt[3] = (Integer.parseInt(t4));


            Log.d("MMI20", "la tentative est : " + tabt[0] + " " + tabt[1] + " " + tabt[2] + " " + tabt[3]);


            for (int i = 0; i < tabt.length; i++) {           //on test si il y a des bp EN PREMIER
                if (tabt[i] == tabps[i]) {
                    bp++;
                    tabt[i] = nbcoul + 1;                         //on change la valeur de pt pour les éliminer des équat° futurs
                    tabps[i] = nbcoul + 2;                        //on change tabps[i] avec une valeur =/= de tabt[i] pour éviter des erreurs de mp

                    if (bp == 4 && test < 5) {
                        TextView changetxtpt = (TextView) findViewById(R.id.pstxt);
                        changetxtpt.setText("BRAVO LA SOLUTION ETAIT : " + tabpscopie[0] + " " + tabpscopie[1] + " " + tabpscopie[2] + " " + tabpscopie[3]);     //ON AFFICHE LA SOLUTION COPIE
                        valide++;
                    }
                }
            }

            for (int i = 0; i < tabt.length; i++) {               //on test si il y a des mp EN DEUXIÈME
                for (int j = 0; j < tabps.length; j++) {          //on parcourt le tableau ligne par ligne puis colonne par colonne

                    if (tabt[i] == tabps[j]) {
                        mp++;
                        tabt[i] = nbcoul + 1;                             //on change la valeur de pt pour les éliminer des équat° futurs
                        tabps[j] = nbcoul + 2;                            //on change tabps[i] avec une valeur =/= de tabt[i] pour éviter des erreurs de mp
                    }
                }
            }


            // AFFICHAGE NOMBRE DE BIEN PLACE ET MAL PLACE

            Log.d("MMMMMI", "bien placé=" + bp);
            Log.d("MMMMMI", "mal placé=" + mp);


            String stringps = t1 + " " + t2 + " " + t3 + " " + t4;

            if (test == 0) {                                                                     //AFFICHAGE DE LA 1ère TENTATIVE
                TextView changetxtps = (TextView) findViewById(R.id.pttxt0);
                changetxtps.setText(stringps);
                TextView changetxt = (TextView) findViewById(R.id.bp);
                changetxt.setText("Nb de bp :" + bp);
                TextView changetxt2 = (TextView) findViewById(R.id.mp);
                changetxt2.setText("Nb de mp :" + mp);

                if (bp != 4) {
                    TextView changetxtpt8 = (TextView) findViewById(R.id.pstxt);
                    changetxtpt8.setText("Faux, il vous reste " + essai + " essai(s)");
                }

                if (bp != 4 && valide != 0) {                                               // CHANGEMENT ALORS QUE BON ESSAI 1
                    TextView changetxtpt21 = (TextView) findViewById(R.id.pstxt);
                    changetxtpt21.setText("Mais tu avais bon ! C'était : " + tabpscopie[0] + " " + tabpscopie[1] + " " + tabpscopie[2] + " " + tabpscopie[3]);
                }

                if (bp != 4 && triche == 1) {                                               //FAUX + TRICHE
                    TextView changetxtpt38 = (TextView) findViewById(R.id.pstxt);
                    changetxtpt38.setText("Tu as faux même en trichant... ! C'était : " + tabpscopie[0] + " " + tabpscopie[1] + " " + tabpscopie[2] + " " + tabpscopie[3]);
                }

                if (bp == 4 && triche == 1) {                               // EMPECHER LA TRICHE
                    TextView changetxtpt83 = (TextView) findViewById(R.id.pstxt);
                    changetxtpt83.setText("Tu as bon mais tu as triché chenapan... : " + tabpscopie[0] + " " + tabpscopie[1] + " " + tabpscopie[2] + " " + tabpscopie[3]);
                }


            }


            if (test == 1) {                                                                    //AFFICHAGE DE LA 2ème TENTATIVE
                TextView changetxtps2 = (TextView) findViewById(R.id.pttxt2);
                changetxtps2.setText(stringps);
                TextView changetxt8 = (TextView) findViewById(R.id.bp2);
                changetxt8.setText("Nb de bp :" + bp);
                TextView changetxt3 = (TextView) findViewById(R.id.mp2);
                changetxt3.setText("Nb de mp :" + mp);

                if (bp != 4) {
                    TextView changetxtpt6 = (TextView) findViewById(R.id.pstxt);
                    changetxtpt6.setText("Faux, il vous reste " + essai + " essai(s)");
                }

                if (bp != 4 && valide != 0) {                                               // CHANGEMENT ALORS QUE BON ESSAI 2
                    TextView changetxtpt21 = (TextView) findViewById(R.id.pstxt);
                    changetxtpt21.setText("Mais tu avais bon ! C'était : " + tabpscopie[0] + " " + tabpscopie[1] + " " + tabpscopie[2] + " " + tabpscopie[3]);
                }

                if (bp != 4 && triche == 1) {                                               //FAUX + TRICHE
                    TextView changetxtpt39 = (TextView) findViewById(R.id.pstxt);
                    changetxtpt39.setText("Tu as faux même en trichant... ! C'était : " + tabpscopie[0] + " " + tabpscopie[1] + " " + tabpscopie[2] + " " + tabpscopie[3]);
                }

                if (bp == 4 && triche == 1) {                               // EMPECHER LA TRICHE
                    TextView changetxtpt82 = (TextView) findViewById(R.id.pstxt);
                    changetxtpt82.setText("Tu as bon mais tu as triché chenapan... : " + tabpscopie[0] + " " + tabpscopie[1] + " " + tabpscopie[2] + " " + tabpscopie[3]);
                }


            }

            if (test == 2) {                                                                     //AFFICHAGE DE LA 3ème TENTATIVE
                TextView changetxtps2 = (TextView) findViewById(R.id.pttxt3);
                changetxtps2.setText(stringps);
                TextView changetxt4 = (TextView) findViewById(R.id.bp3);
                changetxt4.setText("Nb de bp :" + bp);
                TextView changetxt5 = (TextView) findViewById(R.id.mp3);
                changetxt5.setText("Nb de mp :" + mp);

                if (bp == 4 && triche == 1) {                               // EMPECHER LA TRICHE
                    TextView changetxtpt81 = (TextView) findViewById(R.id.pstxt);
                    changetxtpt81.setText("Tu as bon mais tu as triché chenapan... : " + tabpscopie[0] + " " + tabpscopie[1] + " " + tabpscopie[2] + " " + tabpscopie[3]);
                }

                if (bp != 4) {
                    TextView changetxtpt5 = (TextView) findViewById(R.id.pstxt);
                    changetxtpt5.setText("Faux, il vous reste " + essai + " essai(s)");
                }

                if (bp != 4 && valide != 0) {                                   // CHANGEMENT ALORS QUE BON ESSAI 3
                    TextView changetxtpt21 = (TextView) findViewById(R.id.pstxt);
                    changetxtpt21.setText("Mais tu avais bon ! C'était : " + tabpscopie[0] + " " + tabpscopie[1] + " " + tabpscopie[2] + " " + tabpscopie[3]);

                    if (bp != 4 && triche == 1) {                                               //FAUX + TRICHE
                        TextView changetxtpt40 = (TextView) findViewById(R.id.pstxt);
                        changetxtpt40.setText("Tu as faux même en trichant... ! C'était : " + tabpscopie[0] + " " + tabpscopie[1] + " " + tabpscopie[2] + " " + tabpscopie[3]);
                    }
                }

            }


            if (test == 3) {                                                     //AFFICHAGE DE LA 4ème TENTATIVE
                TextView changetxtps3 = (TextView) findViewById(R.id.pttxt4);
                changetxtps3.setText(stringps);
                TextView changetxt6 = (TextView) findViewById(R.id.bp4);
                changetxt6.setText("Nb de bp :" + bp);
                TextView changetxt7 = (TextView) findViewById(R.id.mp4);
                changetxt7.setText("Nb de mp :" + mp);

                if (bp == 4 && triche == 1) {                               // EMPECHER LA TRICHE
                    TextView changetxtpt80 = (TextView) findViewById(R.id.pstxt);
                    changetxtpt80.setText("Tu as bon mais tu as triché chenapan... : " + tabpscopie[0] + " " + tabpscopie[1] + " " + tabpscopie[2] + " " + tabpscopie[3]);
                }

                if (bp != 4) {
                    TextView changetxtpt4 = (TextView) findViewById(R.id.pstxt);
                    changetxtpt4.setText("Faux, il vous reste " + essai + " essai(s)");
                }

                if (bp != 4 && valide != 0) {                                            // CHANGEMENT ALORS QUE BON ESSAI 4
                    TextView changetxtpt21 = (TextView) findViewById(R.id.pstxt);
                    changetxtpt21.setText("Mais tu avais bon ! C'était : " + tabpscopie[0] + " " + tabpscopie[1] + " " + tabpscopie[2] + " " + tabpscopie[3]);
                }

                if (bp != 4 && triche == 1) {                                               //FAUX + TRICHE
                    TextView changetxtpt41 = (TextView) findViewById(R.id.pstxt);
                    changetxtpt41.setText("Tu as faux même en trichant... ! C'était : " + tabpscopie[0] + " " + tabpscopie[1] + " " + tabpscopie[2] + " " + tabpscopie[3]);
                }

            }


            if (test > 3) {                                                          //AFFICHAGE DE LA 5ème TENTATIVE
                TextView changetxtps3 = (TextView) findViewById(R.id.pttxt5);
                changetxtps3.setText(stringps);
                TextView changetxt8 = (TextView) findViewById(R.id.bp5);
                changetxt8.setText("Nb de bp :" + bp);
                TextView changetxt9 = (TextView) findViewById(R.id.mp5);
                changetxt9.setText("Nb de mp :" + mp);


                if (bp == 4 && triche == 1) {                               // EMPECHER LA TRICHE
                    TextView changetxtpt23 = (TextView) findViewById(R.id.pstxt);
                    changetxtpt23.setText("Tu as bon mais tu as triché chenapan... : " + tabpscopie[0] + " " + tabpscopie[1] + " " + tabpscopie[2] + " " + tabpscopie[3]);
                }


                if (bp != 4 && valide != 0) {                                            // CHANGEMENT ALORS QUE BON ESSAI 5
                    TextView changetxtpt21 = (TextView) findViewById(R.id.pstxt);
                    changetxtpt21.setText("Mais tu avais bon ! C'était : " + tabpscopie[0] + " " + tabpscopie[1] + " " + tabpscopie[2] + " " + tabpscopie[3]);
                }

                if (bp != 4) {                                                           // FAUX AU BOUT DES 5 ESSAIS
                    TextView changetxtpt40 = (TextView) findViewById(R.id.pstxt);
                    changetxtpt40.setText("Désolé, tu as perdu... La solution était : " + tabpscopie[0] + " " + tabpscopie[1] + " " + tabpscopie[2] + " " + tabpscopie[3]);
                }

                if (bp != 4 && triche == 1) {                                               //FAUX + TRICHE
                    TextView changetxtpt42 = (TextView) findViewById(R.id.pstxt);
                    changetxtpt42.setText("Tu as faux même en trichant... ! C'était : " + tabpscopie[0] + " " + tabpscopie[1] + " " + tabpscopie[2] + " " + tabpscopie[3]);
                }


            }
            /* EditText changechamp1 = (EditText) findViewById(R.id.tentativ1);                //VIDER LES CHAMPS TENTATIVE
            changechamp1.setText("");
            EditText changechamp2 = (EditText) findViewById(R.id.tentativ2);
            changechamp2.setText("");
            EditText changechamp3 = (EditText) findViewById(R.id.tentativ3);
            changechamp3.setText("");
            EditText changechamp4 = (EditText) findViewById(R.id.tentativ4);
            changechamp4.setText(""); */

            System.arraycopy(tabpscopie, 0, tabps, 0, tabps.length);        //DUPLICATION DU TABLEAU POUR AFFICHER LA BONNE SOLUTION (sans le +1/+2 de l'algo)

            test = test + 1;


        }


    }



