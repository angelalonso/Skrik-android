package com.afonseca.skrik;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {


    public static final String PROPERTY_REG_ID = "registration_id";
    String SENDER_ID = "610647426983";
   // GoogleCloudMessaging gcm;


    public final static String EXTRA_MESSAGE = "com.afonseca.skrik.MESSAGE";

    TextView name ;
    TextView email ;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (TextView) findViewById(R.id.main_titlebar);
        email = (TextView) findViewById(R.id.email_show);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        if (sharedpreferences.contains(Name))
        {
            name.setText(sharedpreferences.getString(Name, ""));
        } else
        {
            Intent intent = new Intent(this, UserActivity.class);
            startActivity(intent);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume(){
        super.onResume();
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        if (sharedpreferences.contains(Name))
        {
            name.setText(sharedpreferences.getString(Name, ""));
        }
        email.setText(sharedpreferences.getString(Email, ""));
    }

    /** Called when the user clicks the Config button */
    public void configUser(View view) {
        Intent intent = new Intent(this, UserActivity.class);
        startActivity(intent);
    }

}
