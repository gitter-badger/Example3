package com.jplc.spaceghost.example3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Calculate extends Activity {

    private TextView tvWord;
    private String word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        tvWord = (TextView) findViewById(R.id.tv_palabra);

        Bundle b = getIntent().getExtras();
        if(b!=null){
            word = b.getString("word");
            tvWord.setText(word);
        }

    }

    @Override
    public void finish() {

        Intent data = new Intent();
        data.putExtra("retorno","el largo de la palabra es :" + tvWord.getText().toString().length());
        setResult(RESULT_OK,data);
        super.finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calculate, menu);
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
