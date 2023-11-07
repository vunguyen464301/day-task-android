package com.android_app.todo_list;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;

import com.android_app.todo_list.databinding.ActivityMainBinding;
import com.android_app.todo_list.databinding.ContentMainBinding;

import android.content.Intent;

public class MainActivity extends AppCompatActivity {
  private ActivityMainBinding binding;
  private Context context;
  private Resources resources;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
//        setContentView(R.layout);
    binding = ActivityMainBinding.inflate(getLayoutInflater());

    context = MainActivity.this; // You can also use 'this' if you're in an Activity
    resources = context.getResources();

    //set root content
    setContentView(binding.getRoot());
    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

    String fullText = "Manage your \nTask with \n";
    String primaryText = "DayTask";
    int primaryColor = ContextCompat.getColor(context, R.color.primary);
    SpannableString spannableString = new SpannableString(fullText + primaryText);

    // Set the color for the "colored" part
    ForegroundColorSpan colorSpan = new ForegroundColorSpan(primaryColor);
    spannableString.setSpan(colorSpan, fullText.length(), fullText.length() + primaryText.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);

    binding.includeContent.textLogo.setText(spannableString);
    binding.includeContent.includeButton.buttonStart.setText("Let's Start");

    binding.includeContent.includeButton.buttonStart.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, SignIn.class);
        startActivity(intent);
      }
    });
  }

}
