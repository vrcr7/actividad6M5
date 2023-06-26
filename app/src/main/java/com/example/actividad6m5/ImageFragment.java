package com.example.actividad6m5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.actividad6m5.databinding.FragmentImageBinding;


public class ImageFragment extends Fragment {
FragmentImageBinding imaBinding;
ImageView imagen;
Button boton;
TextView texto;

    public ImageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        imaBinding=FragmentImageBinding.inflate(inflater, container, false);
        boton=imaBinding.botonVolver;
        texto=imaBinding.descripcion;
        imagen=imaBinding.imageView;
        NavController navController = Navigation.findNavController(getActivity(), R.id.fragmentContainerView);
        Bundle valores=getArguments();
        texto.setText(valores.getString("dato"));

        Glide.with(this).load(valores.getString("url")).into(imagen);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigateUp();
            }
        });
        return imaBinding.getRoot();
    }
}