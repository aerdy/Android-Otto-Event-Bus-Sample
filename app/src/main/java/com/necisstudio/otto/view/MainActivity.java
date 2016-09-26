package com.necisstudio.otto.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.necisstudio.otto.R;
import com.necisstudio.otto.events.EventSection;
import com.necisstudio.otto.events.EventSection2;
import com.necisstudio.otto.manage.EventBus;
import com.squareup.otto.Subscribe;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().add(R.id.frameMain, new MainFragment()).commit();
        }
    }

    @Subscribe
    public void getMessage(EventSection data){
        Toast.makeText(this,"ini toast Main"+data.section,Toast.LENGTH_SHORT).show();
    }

    @Subscribe
    public void getMessage2(EventSection2 data){
        Toast.makeText(this,"ini toast Main"+data.section,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getInstance().register(this);
    }

    @Override
    protected void onStop() {
        EventBus.getInstance().unregister(this);
        super.onStop();
    }
}
