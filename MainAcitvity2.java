package mad.listv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


// Mandatory to write it: extends AppCompatActivity

public class MainAcitvity2 extends AppCompatActivity {

    TextView campo_texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act2);

        campo_texto = (TextView) findViewById(R.id.textoact2);
        campo_texto.setText("Hi again");


    }

}

