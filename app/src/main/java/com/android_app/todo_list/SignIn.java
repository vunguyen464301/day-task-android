package com.android_app.todo_list;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android_app.todo_list.databinding.ActivitySignInBinding;

public class SignIn extends AppCompatActivity {

  private ActivitySignInBinding binding;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = ActivitySignInBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());


  }
}
