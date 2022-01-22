package hu.varga.tamas.beadando1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity6 extends AppCompatActivity {

    EditText name,email;
    Button button7, button8;
    SharedPreferences sp;
    String nameStr, emailStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        name = findViewById(R.id.editTextsp1);
        email = findViewById(R.id.editTextsp2);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);

        sp = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameStr = name.getText().toString();
                emailStr = email.getText().toString();

                SharedPreferences.Editor editor = sp.edit();

                editor.putString("name",nameStr);
                editor.putString("email",emailStr);
                editor.commit();

                Toast.makeText(MainActivity6.this,"Adatok mentve",Toast.LENGTH_LONG).show();
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6 = new Intent(MainActivity6.this, OtherPage.class);
                startActivity(intent6);
            }
        });
    }
}