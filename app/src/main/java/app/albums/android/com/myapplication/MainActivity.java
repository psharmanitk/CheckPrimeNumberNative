package app.albums.android.com.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private AppCompatButton checkButton;
    private EditText numberTv;
    private TextView resultTv;
    private Context mContext;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native boolean stringFromJNI(long num);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        numberTv = findViewById(R.id.sample_text);
        resultTv = findViewById(R.id.resultTv);
        checkButton = findViewById(R.id.checkButton);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long num = Integer.parseInt(numberTv.getText().toString());
                final boolean result = stringFromJNI(num);
                Log.d("priya", "result is " + result);
                String str;
                if (result == true) {
                    str = "Number is prime";
                    //Toast.makeText(mContext, str, Toast.LENGTH_SHORT).show();
                }
                else {
                    str = "Number is not prime";
                    //Toast.makeText(mContext, "Number is not prime", Toast.LENGTH_SHORT).show();
                }
                resultTv.setText(str);
            }
        });
        numberTv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                resultTv.setText("");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

}
