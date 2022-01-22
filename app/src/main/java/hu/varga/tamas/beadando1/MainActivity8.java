package hu.varga.tamas.beadando1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity8 extends AppCompatActivity {

    private TextView mTextViewResult;
    private EditText mEditTextNumber1;
    private EditText mEditTextNumber2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        mTextViewResult=findViewById(R.id.text_view_result);
        mEditTextNumber1=findViewById(R.id.edit_text_number1);
        mEditTextNumber2=findViewById(R.id.edit_text_number2);

        Button buttonOpenActivity2 = findViewById(R.id.button_open_activity2);
        buttonOpenActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mEditTextNumber1.getText().toString().equals("")
                || mEditTextNumber2.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity8.this,"Adja meg a számokat!",Toast.LENGTH_SHORT).show();
                } else {
                    int number1 = Integer.parseInt(mEditTextNumber1.getText().toString());
                    int number2 = Integer.parseInt(mEditTextNumber2.getText().toString());

                    Intent intent = new Intent(MainActivity8.this, MainActivity8_1.class);
                    intent.putExtra("number1",number1);
                    intent.putExtra("number2",number2);
                    startActivityForResult(intent,1);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                int result = data.getIntExtra("result",0);
                mTextViewResult.setText(""+result);
            }
            if(resultCode == RESULT_CANCELED){
                mTextViewResult.setText("Nem választott ki semmit");
            }
        }
    }
}