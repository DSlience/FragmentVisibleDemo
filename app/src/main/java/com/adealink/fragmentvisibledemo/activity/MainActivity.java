package com.adealink.fragmentvisibledemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.adealink.fragmentvisibledemo.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goViewPagerFragment(View view) {
        startActivity(new Intent(this, ViewPagerFragmentActivity.class));
    }

    public void goManagerFragment(View view) {
        startActivity(new Intent(this, ManagerFragmentActivity.class));
    }

    public void goXmlFragment(View view) {
        startActivity(new Intent(this, XmlFragmentActivity.class));
    }

    public void goObjectAnim(View view) {
        startActivity(new Intent(this, PropertyAnimDemoActivity.class));
    }

    public void goImageDemo(View view) {
        startActivity(new Intent(this, ImgDemoActivity.class));
    }
}
