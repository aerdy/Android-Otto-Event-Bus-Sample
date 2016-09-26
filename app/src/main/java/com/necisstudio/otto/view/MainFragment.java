package com.necisstudio.otto.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.necisstudio.otto.R;
import com.necisstudio.otto.events.EventSection;
import com.necisstudio.otto.events.EventSection2;
import com.necisstudio.otto.manage.EventBus;
import com.squareup.otto.Produce;
import com.squareup.otto.Subscribe;

/**
 * Created by vim on 26/09/16.
 */

public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,container,false);
        Button btnTest = (Button)view.findViewById(R.id.btnTest);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getInstance().post(new EventSection("data fragment"));
                //jika hanya string dia akan memanggil getMessage yang hanya meminta string
                //EventBus.getInstance().post("HEEE");
            }
        });

        Button btnTest2 = (Button)view.findViewById(R.id.btnTest2);
        btnTest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getInstance().post(new EventSection2("data fragment"));
                //jika hanya string dia akan memanggil getMessage yang hanya meminta string
                //EventBus.getInstance().post("HEEE");
            }
        });

        return view;
    }
    @Subscribe
    public void getMessage(String data){
        Toast.makeText(getActivity(),data,Toast.LENGTH_SHORT).show();
    }

    //pertama kali jalan ketika fragment dibuka
    @Produce
    public String productEvent(){
        return "Starting up";
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getInstance().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getInstance().unregister(this);
        super.onStop();
    }
}
