package com.example.uptenfermeria.ui.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.uptenfermeria.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        final Button btn_calidad = binding.btnCalidad;
        btn_calidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
                dialog.setTitle("Buena");
                dialog.setMessage("La calidad del aire se considera satisfactoria");
                dialog.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(getContext(), "ss", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setNegativeButton("", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(getContext(), "gfd", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
            }
        });
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    public void alert(){

        AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}