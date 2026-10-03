package com.example.appcirculobarra;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class MiFragmento extends Fragment {

    /**
     * Nueva instancia del fragmento
     * */
    public static MiFragmento newInstance() {
        return new MiFragmento();
    }

    /**
     * La interfaz del fragmento
     * */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mifragmento, container, false);
    }

}
