package com.android_app.todo_list;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;

import com.android_app.todo_list.databinding.ActivityMainBinding;

import android.content.Intent;

public class MainActivity extends AppCompatActivity {
  private ActivityMainBinding binding;
  private Context context;
  private Resources resources;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
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

    binding.includeContent.textLogo.setText(spannableString);
  }

   private void bindingButtonStart(){
    // Set the color for the "colored" part
    String startString = resources.getString(R.string.main_let_start);
    binding.includeContent.includeButton.buttonPrimary.setText(startString);
    binding.includeContent.includeButton.buttonPrimary.setOnClickListener(v -> {
      Intent intent = new Intent(MainActivity.this, SignIn.class);
      startActivity(intent);
    });
  }

}
