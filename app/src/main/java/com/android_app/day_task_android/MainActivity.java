package com.android_app.day_task_android;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.android_app.day_task_android.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

  private ActivityMainBinding binding;
  private Context context;
  private Resources resources;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //setContentView(R.layout);
    binding = ActivityMainBinding.inflate(getLayoutInflater());

    context = MainActivity.this; // You can also use 'this' if you're in an Activity
    resources = context.getResources();

    //set root content
    setContentView(binding.getRoot());
    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

    bindingText();
    bindingButtonStart();

  }
  private void bindingText(){
    String fullText = resources.getString(R.string.main_text_welcome) + " ";
    String primaryText = resources.getString(R.string.main_text_welcome_subscribe);
    int primaryColor = ContextCompat.getColor(context, R.color.primary);
    SpannableString spannableString = new SpannableString(fullText + primaryText);
    ForegroundColorSpan colorSpan = new ForegroundColorSpan(primaryColor);
    spannableString.setSpan(colorSpan, fullText.length(), fullText.length() + primaryText.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);

    binding.content.textLogo.setText(spannableString);
  }

  private void bindingButtonStart(){
  // Set the color for the "colored" part
    String startString = resources.getString(R.string.main_let_start);
    binding.content.includeButton.buttonPrimary.setText(startString);
    binding.content.includeButton.buttonPrimary.setOnClickListener(v -> {
      Intent intent = new Intent(MainActivity.this, SignIn.class);
      startActivity(intent);
    });
  }


}