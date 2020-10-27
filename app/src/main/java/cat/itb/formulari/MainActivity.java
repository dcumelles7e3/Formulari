package cat.itb.formulari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_nom;
    private Button b_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nom = findViewById(R.id.et_nom);
        b_next = findViewById(R.id.b_next);

        b_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = et_nom.getText().toString();
                if (nom != null && !nom.isEmpty()) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("nom", nom);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "No has introduit nom", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}