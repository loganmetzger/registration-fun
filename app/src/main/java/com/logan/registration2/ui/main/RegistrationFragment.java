package com.logan.registration2.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.logan.registration2.R;

public class RegistrationFragment extends Fragment {
    private UserViewModel mUserViewModel;

    EditText etName;
    EditText etEmail;
    EditText etUsername;
    EditText etPassword;
    Button registerButton;

    public RegistrationFragment() {

    }

    public static RegistrationFragment newInstance() {
        return new RegistrationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.registration_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        etName = getView().findViewById(R.id.reg_name_et);
        etEmail = getView().findViewById(R.id.reg_email_et);
        etUsername = getView().findViewById(R.id.reg_username_et);
        etPassword = getView().findViewById(R.id.reg_password_et);
        registerButton = getView().findViewById(R.id.reg_complete_button);

        registerButton.setOnClickListener(v -> {
            mUserViewModel.createUser(
                    etName.getText().toString(),
                    etEmail.getText().toString(),
                    etUsername.getText().toString(),
                    etPassword.getText().toString()
            );
            NavHostFragment.findNavController(this).navigate(R.id.destination_user_list_fragment);
        });

        mUserViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);
    }

}