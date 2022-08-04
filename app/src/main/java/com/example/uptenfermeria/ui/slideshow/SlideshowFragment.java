package com.example.uptenfermeria.ui.slideshow;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.uptenfermeria.R;
import com.example.uptenfermeria.databinding.FragmentSlideshowBinding;
import com.example.uptenfermeria.methods.RetrofitClient;
import com.example.uptenfermeria.methods.UserService;
import com.example.uptenfermeria.models.User;
import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SlideshowFragment extends Fragment {


    private FragmentSlideshowBinding binding;
    private static final String TAG = "MainActivity";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;

    }




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = binding.loginEmail.getEditText().getText().toString();
                String password = binding.loginPassword.getEditText().getText().toString();

                UserService service = RetrofitClient.getRetrofitInstance().create(UserService.class);
                Call<User> call = service.loginUser(email, password);
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful()){

                            Log.e(TAG, "onResponse: " + new Gson().toJson(response.code()));
                            Log.e(TAG, "onResponse: " + new Gson().toJson(response.body().getName()));
                            Navigation.findNavController(view).navigate(R.id.nav_log_to_message);


                        }else{
                            Log.e(TAG, "onResponseFail: " + new Gson().toJson(response.code()));
                            try {
                                Log.e(TAG, "onResponseFail: " + new Gson().toJson(response.errorBody().string()) );

                            } catch (IOException e) {
                                e.printStackTrace();
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
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}