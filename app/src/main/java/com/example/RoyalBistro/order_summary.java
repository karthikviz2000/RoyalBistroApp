package com.example.RoyalBistro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

public class order_summary extends AppCompatActivity {

    TextView order_text;
    String existing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        order_text=(TextView)findViewById(R.id.order_summary);
        final GlobalClass globalVariable = (GlobalClass)getApplicationContext();
        if(globalVariable.order_summary!=null){
            String existing=globalVariable.order_summary.getText().toString();
            order_text.setText(existing);
        }

    }


}
