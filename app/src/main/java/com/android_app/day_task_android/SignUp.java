package com.android_app.day_task_android;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android_app.day_task_android.databinding.ActivitySignUpBinding;

public class SignUp extends AppCompatActivity {
private ActivitySignUpBinding binding;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding= ActivitySignUpBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

  }
}
