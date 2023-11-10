package com.android_app.day_task_android;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android_app.day_task_android.databinding.ActivityBottomTabsBinding;

public class BottomTabs extends AppCompatActivity {
  private ActivityBottomTabsBinding binding;
  private Context context;
  private Resources resources;

  @Override
  protected void onCreate( Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityBottomTabsBinding.inflate(getLayoutInflater());
    context = BottomTabs.this;
    resources = context.getResources();

    //set root content
    setContentView(binding.getRoot());
  }

}
