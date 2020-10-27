package cat.itb.formulari;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private RadioGroup rg;
    private RadioButton rb;
    private SeekBar sb;
    private TextView tv_num;
    private Button b_next;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Bundle bundle = getIntent().getExtras();

        rg = findViewById(R.id.rg);
        b_next = findViewById(R.id.b_next);
        sb = findViewById(R.id.sb);
        tv_num = findViewById(R.id.tv_num);

        sb.setMin(1);
        sb.setMax(100);
        sb.setProgress(18);

        String prg = Integer.toString(sb.getProgress());
        tv_num.setText(prg);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String prg = Integer.toString(progress);
                tv_num.setText(prg);
                if (progress < 18 || progress > 60) {
                    b_next.setBackgroundColor(getResources().getColor(R.color.disabled));
                    b_next.setText(R.string.b_not);
                    b_next.setEnabled(false);
                } else {
                    b_next.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    b_next.setText(R.string.b_next);
                    b_next.setEnabled(true);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        b_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int id = rg.getCheckedRadioButtonId();
                    boolean hola;
                    rb = findViewById(id);
                    hola = rb.getId() == R.id.rb_hola;

                    Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                    intent.putExtra("nom", bundle.getString("nom"));
                    intent.putExtra("edat", sb.getProgress());
                    intent.putExtra("hola", hola);
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(SecondActivity.this, "Escull una opció", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}