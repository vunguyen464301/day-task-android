package com.android_app.day_task_android.bottom_tabs.messages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.android_app.day_task_android.databinding.FragmentMessagesBinding;

public class MessagesFragment extends Fragment {

  private FragmentMessagesBinding binding;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    MessagesViewModel messagesViewModel = new ViewModelProvider(this).get(MessagesViewModel.class);

    binding = FragmentMessagesBinding.inflate(inflater, container, false);
    View viewRoot = binding.getRoot();

    return viewRoot;
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }
}
