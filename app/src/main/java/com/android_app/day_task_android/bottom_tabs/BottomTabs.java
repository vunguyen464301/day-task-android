package com.android_app.day_task_android.bottom_tabs;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.android_app.day_task_android.R;
import com.android_app.day_task_android.databinding.ActivityBottomTabsBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomTabs extends AppCompatActivity {
  private ActivityBottomTabsBinding binding;
  private Context context;
  private Resources resources;
  private BottomNavigationView bottomNavigationView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityBottomTabsBinding.inflate(getLayoutInflater());
    context = BottomTabs.this;
    resources = context.getResources();
    bottomNavigationView = binding.tabsBottomNavigationView;

    //set root content
    setContentView(binding.getRoot());

    BottomNavigationView navView = binding.tabsBottomNavigationView;
    // Passing each menu ID as a set of Ids because each
    // menu should be considered as top level destinations.

    NavController navController = Navigation.findNavController(this, R.id.tabs_bottom_fragment);
    NavigationUI.setupWithNavController(navView, navController);

  }

}
