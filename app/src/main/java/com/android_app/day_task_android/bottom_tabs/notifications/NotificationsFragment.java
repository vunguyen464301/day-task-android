package com.android_app.day_task_android.bottom_tabs.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.android_app.day_task_android.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {
  private FragmentNotificationsBinding binding;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    NotificationsViewModel notificationsViewModel = new ViewModelProvider(this).get(NotificationsViewModel.class);
    binding = FragmentNotificationsBinding.inflate(inflater, container, false);

    View viewRoot = binding.getRoot();

    return viewRoot;
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }
}
