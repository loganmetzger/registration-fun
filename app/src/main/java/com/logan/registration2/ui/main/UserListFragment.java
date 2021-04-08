package com.logan.registration2.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.logan.registration2.R;
import com.logan.registration2.ui.main.adapter.UserAdapter;

public class UserListFragment extends Fragment {
    UserViewModel mUserViewModel;
    RecyclerView usersRv;
    Button backToRegister;

    public UserListFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.user_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUserViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);
        usersRv = view.findViewById(R.id.user_list_rv);
        UserAdapter userAdapter = new UserAdapter(mUserViewModel.getAllUsersList());
        usersRv.setAdapter(userAdapter);
        usersRv.setLayoutManager(new LinearLayoutManager(requireContext()));

        backToRegister = view.findViewById(R.id.user_list_back_button);

        backToRegister.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.destination_registration_fragment);
        });

    }
}
