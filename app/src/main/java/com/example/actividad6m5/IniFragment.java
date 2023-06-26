package com.example.actividad6m5;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;

import com.example.actividad6m5.databinding.FragmentIniBinding;

import java.util.ArrayList;
import java.util.List;

public class IniFragment extends Fragment implements Adapter.OnItemClickListener {
    private RecyclerView recyclerView;
    private Adapter adapter;
    private List<datosLista> dataList;
    public FragmentIniBinding iniBinding;
    public int indice;

    List<datosLista> data=new ArrayList<>();

    public IniFragment() {
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
        iniBinding=FragmentIniBinding.inflate(inflater, container, false);
        if (dataList!=null){
            dataList.clear();
        }
        dataList=getData();
        recyclerView=iniBinding.recyclerFragment;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new Adapter(dataList);
        adapter.setOnItemClickListener(this);
        recyclerView.setAdapter(adapter);


        return iniBinding.getRoot();
    }
//agregar datos a la lista
    private List<datosLista> getData(){
        datosLista item=new datosLista("https://www.educaciontrespuntocero.com/wp-content/uploads/2019/02/girasoles-978x652.jpg","Girasoles");
        data.add(item);
        datosLista item1=new datosLista("https://unsplash.com/photos/UBvtBr_FmrY/download?force=true&w=640","Zhuo Cheng you");
        data.add(item1);
        datosLista item02 = new datosLista("https://unsplash.com/photos/pNoP-qVwBFQ/download?force=true&w=640","billow926");
        data.add(item02);
        datosLista item03 = new datosLista("https://unsplash.com/photos/LfJx0gqqiEc/download?force=true&w=640","Philipp Deiß");
        data.add(item03);
        datosLista item04 = new datosLista("https://unsplash.com/photos/_p8gVNNsWw4/download?force=true&w=640","Joshua Earle");
        data.add(item04);
        datosLista item05 = new datosLista("https://unsplash.com/photos/rnPGCe7LsQo/download?force=true&w=640","Melnychuk Nataliya");
        data.add(item05);
        datosLista item06 = new datosLista("https://unsplash.com/photos/k2DbTXQ0yrQ/download?force=true&w=640","Teagan Maddux");
        data.add(item06);
        datosLista item07 = new datosLista("https://unsplash.com/photos/kZH8X0q4Nvo/download?force=true&w=640","Chen Liu");
        data.add(item07);
        datosLista item08 = new datosLista("https://unsplash.com/photos/iNqJx-VOceI/download?force=true&w=640","John Fornander");
        data.add(item08);
        datosLista item09 = new datosLista("https://unsplash.com/photos/mNWrQ9O6KZw/download?force=true&w=640","Parker");
        data.add(item09);
        datosLista item10 = new datosLista("https://unsplash.com/photos/8pb7Hq539Zw/download?force=true&w=640","XPS");
        data.add(item10);
        datosLista item11 = new datosLista("https://unsplash.com/photos/l8BvDmt8Ac4/download?force=true&w=640","J. whack");
        data.add(item11);
        datosLista item12 = new datosLista("https://unsplash.com/photos/q0wqYpyWDpc/download?force=true&w=640", "Amstrong");
        data.add(item12);
        return data;
    }

    @Override
    public void onItemClick(int position) {
        indice=position;
        datosLista eleccion=dataList.get(indice);

        Bundle bundle=new Bundle();
        bundle.putString("url", eleccion.getUrl());
        bundle.putString("dato", eleccion.getDato());

        NavController navController= Navigation.findNavController(getActivity(), R.id.fragmentContainerView);
        navController.navigate(R.id.action_iniFragment_to_imageFragment,bundle);
    }
}