package com.example.uptenfermeria.ui.message;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.text.util.LinkifyCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.uptenfermeria.R;
import com.example.uptenfermeria.methods.RetrofitClient;
import com.example.uptenfermeria.methods.UserService;
import com.example.uptenfermeria.methods.WaqiClient;
import com.example.uptenfermeria.methods.WaqiService;
import com.example.uptenfermeria.models.User;
import com.example.uptenfermeria.models.Waqi;
import com.example.uptenfermeria.models.WaqiAttributions;
import com.example.uptenfermeria.ui.slideshow.SlideshowFragment;
import com.example.uptenfermeria.ui.slideshow.SlideshowViewModel;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MessageFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */


public class MessageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MessageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MessageFragment newInstance(String param1, String param2) {
        MessageFragment fragment = new MessageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    private static final String TAG = "MainActivity";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_message, container, false);


    }


    private SlideshowViewModel slideshowViewModel;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnEnviar = view.findViewById(R.id.btn_buscar);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWaqi();
            }
        });


    }

    public void getWaqi(){
        WaqiService waqiService = WaqiClient.getRetrofitWaqiInstance().create(WaqiService.class);
        Call<Waqi> call = waqiService.getClima("London");

        call.enqueue(new Callback<Waqi>() {
            @Override
            public void onResponse(Call<Waqi> call, Response<Waqi> response) {
                if (response.isSuccessful()) {

                    Log.e(TAG, "onResponse" + response.code()+ " "+ response.body().getData().getAqi());

                    String waqiCities = response.body().getData().getCity().getName();
                    WaqiAttributions[] waqis = response.body().getData().getAttributions();
                    for (WaqiAttributions attributions: waqis){
                        Log.e(TAG, "onResponseHola" + attributions.getName()+ " " + waqiCities );
                    }



                }else{
                    Log.e(TAG, "onFail" + response.code());
                }

            }

            @Override
            public void onFailure(Call<Waqi> call, Throwable t) {
                Log.e(TAG, "onFailure : ", t.getCause());
            }
        });
    }


}