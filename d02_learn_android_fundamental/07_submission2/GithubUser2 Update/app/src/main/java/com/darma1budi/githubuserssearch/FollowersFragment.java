package com.darma1budi.githubuserssearch;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.darma1budi.githubuserssearch.databinding.FragmentFollowersBinding;

import java.util.List;

public class FollowersFragment extends Fragment {

    FragmentFollowersBinding fragmentFollowersBinding;
    UserDetailViewModel userDetailViewModel;

    @Override
    public View onCreateView (
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {

//        fragmentFollowersBinding = FragmentFollowersBinding.inflate(inflater, container, false);
//
//        ItemsItem userDetail = requireActivity().getIntent().getParcelableExtra(MainActivity.EXTRA_DATA);
//        String username = userDetail.getLogin();
//
//        fragmentFollowersBinding.rvFollowers.setLayoutManager(new LinearLayoutManager(getActivity()));
//        userDetailViewModel.displayFollowerList(username);
//
//        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
//
////        userDetailViewModel.followList().observe(getViewLifecycleOwner(), new Observer<List<ItemsItem>>() {
////            @Override
////            public void onChanged(List<ItemsItem> userDetails) {
////                UserListAdapter adapter = new UserListAdapter(userDetails);
////                fragmentFollowersBinding.rvFollowers.setAdapter(adapter);
////            }
////        });
//
//        userDetailViewModel.followList().observe(getViewLifecycleOwner(), followers -> {
//            UserListAdapter adapter = new UserListAdapter(followers);
//            fragmentFollowersBinding.rvFollowers.setAdapter(adapter);
//        });
//
//        userDetailViewModel.isError.observe(getViewLifecycleOwner(), isError -> {
//            Toast.makeText(getContext(), "Data tidak ditemukan!", Toast.LENGTH_SHORT).show();
//            userDetailViewModel.doneToastErrorInput();
//        });

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_followers, container, false);
//        return fragmentFollowersBinding.getRoot();
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//        fragmentFollowersBinding.rvFollowers.setLayoutManager(layoutManager);
//        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), layoutManager.getOrientation());
//        fragmentFollowersBinding.rvFollowers.addItemDecoration(itemDecoration);
//    }
}