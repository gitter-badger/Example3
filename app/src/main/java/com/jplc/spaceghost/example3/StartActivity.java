package com.jplc.spaceghost.example3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.awt.font.TextAttribute;


public class StartActivity extends Activity {

    public static final int REQUEST_CODE = 10;
    EditText mWord;
    TextView mLong;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        mWord= (EditText) findViewById(R.id.editText1);
        mLong = (TextView) findViewById(R.id.textView2);


    }

    public void sendOnclick(View v){

        Intent i = new Intent(this, Calculate.class);
        i.putExtra("word", mWord.getText().toString());
        startActivityForResult(i,REQUEST_CODE);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK &&  requestCode == REQUEST_CODE){
            if (data.hasExtra("retorno")){
                mLong.setText(data.getExtras().getString("retorno"));

            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
