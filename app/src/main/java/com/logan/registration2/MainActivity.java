package com.logan.registration2;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Navigation.findNavController(this, R.id.fragment_host_container).setGraph(R.navigation.registration_nav_graph);
    }
}