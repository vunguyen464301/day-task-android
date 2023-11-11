package com.android_app.day_task_android.bottom_tabs.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.android_app.day_task_android.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

  private FragmentHomeBinding binding;

  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    HomeViewModel homeViewModel =
        new ViewModelProvider(this).get(HomeViewModel.class);

    binding = FragmentHomeBinding.inflate(inflater, container, false);
    View viewRoot = binding.getRoot();

    final TextView textView = binding.textHome;
    homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
    return viewRoot;
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }
}