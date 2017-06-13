package com.example.admin.tp8_sms;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boutonEnvoyer = (Button) findViewById(R.id.envoyer);

        boutonEnvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Récupération du numéro
                EditText numeroTV = (EditText) findViewById(R.id.phone);
                String numero = numeroTV.getText().toString();

                //Récupération du contenu du message
                EditText contenuTV = (EditText) findViewById(R.id.sms_body);
                String contenu = contenuTV.getText().toString();

                //Ouverture de l'application permettant d'envoyer le SMS, avec les informations déjà saisies
                /*String uri = "smsto:" + numero;
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse(uri));
                intent.putExtra("sms_body", contenu);
                startActivity(intent);*/

                //Envoi du SMS directement
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(numero, null, contenu, null, null);
            }
        });
    }
}
