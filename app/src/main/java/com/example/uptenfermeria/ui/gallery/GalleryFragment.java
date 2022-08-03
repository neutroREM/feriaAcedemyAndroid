package com.example.uptenfermeria.ui.gallery;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.uptenfermeria.databinding.FragmentGalleryBinding;
import com.example.uptenfermeria.methods.RetrofitClient;
import com.example.uptenfermeria.methods.UserService;
import com.example.uptenfermeria.models.User;

import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    private static final String TAG = "MainActivity";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGallery;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        binding.btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUser();
            }
        });
        return root;
    }

    public void addUser(){
        String name = binding.regName.getEditText().getText().toString();
        String secondName = binding.regSecondName.getEditText().getText().toString();
        String email = binding.regEmail.getEditText().getText().toString();
        String password = binding.regPassword.getEditText().getText().toString();

        UserService service = RetrofitClient.getRetrofitInstance().create(UserService.class);
        Call<User> call = service.createUser(name, secondName, email, password);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    Log.e(TAG, "onResponse " + new Gson().toJson(response.code()));
                    Log.e(TAG, "onResponse " + new Gson().toJson(response.body()));

                }else {
                    Log.e(TAG, "onFail " +new Gson().toJson(response.code()));
                    int e = 0;
                    try {
                        e = Log.e(TAG, "onFailas: " + new Gson().toJson(response.errorBody().string()));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e(TAG, "onFailure : ", t.getCause());
                Log.e(TAG, "onFailure : " +  new Gson().toJson(t.getMessage()));
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}