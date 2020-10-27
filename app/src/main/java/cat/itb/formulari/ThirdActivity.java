package cat.itb.formulari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    private Button b_show;
    private Button b_share;
    private String out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Bundle bundle = getIntent().getExtras();
        final String nom = bundle.getString("nom");
        final int edat = bundle.getInt("edat");
        final boolean hola = bundle.getBoolean("hola");

        b_show = findViewById(R.id.b_show);
        b_share = findViewById(R.id.b_share);

        b_share.setEnabled(false);
        b_share.setBackgroundColor(getResources().getColor(R.color.disabled));

        b_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hola){
                    out = "Hola "+nom+"! Com portes aquest "+edat+" anys?";
                }else{
                    out = "Adéu "+nom+", ens veiem quan facis "+(edat+1)+" anys.";
                }
                Toast.makeText(ThirdActivity.this, out, Toast.LENGTH_SHORT).show();
                b_show.setEnabled(false);
                b_show.setVisibility(View.INVISIBLE);
                b_share.setEnabled(true);
                b_share.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            }
        });

        b_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, out);
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });
    }
}