package com.android_app.day_task_android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android_app.day_task_android.databinding.ActivitySignUpBinding;
import com.android_app.day_task_android.databinding.ContentSignUpBinding;

public class SignUp extends AppCompatActivity {
  private ActivitySignUpBinding binding;
  private ContentSignUpBinding contentBinding;
  private Context context;
  private Resources resources;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivitySignUpBinding.inflate(getLayoutInflater());
    contentBinding = binding.content;
    context = SignUp.this;
    resources = context.getResources();

    setContentView(binding.getRoot());

    bindingInputFullName();
    bindingInputEmail();
    bindingInputPassword();
    bindingButtonSignUp();
    bindingButtonGoogle();
    bindingButtonSignIn();
  }

  @SuppressLint("UseCompatLoadingForDrawables")
  private void bindingInputFullName() {
    contentBinding.inputFullName.iconLeft.setImageDrawable(resources.getDrawable(R.drawable.full_name_icon, this.getTheme()));
    contentBinding.inputFullName.iconRight.setVisibility(View.GONE);
  }

  @SuppressLint("UseCompatLoadingForDrawables")
  private void bindingInputEmail() {
    contentBinding.inputEmail.iconLeft.setImageDrawable(resources.getDrawable(R.drawable.email_icon, this.getTheme()));
    contentBinding.inputEmail.iconRight.setVisibility(View.GONE);
  }

  @SuppressLint("UseCompatLoadingForDrawables")
  private void bindingInputPassword() {
    contentBinding.inputPassword.iconLeft.setImageDrawable(resources.getDrawable(R.drawable.password_icon, this.getTheme()));
    contentBinding.inputPassword.iconRight.setImageDrawable(resources.getDrawable(R.drawable.hidden_icon, this.getTheme()));
  }

  private void bindingButtonSignUp() {
    String text = resources.getString(R.string.sign_up);
    contentBinding.buttonSignUp.buttonPrimary.setText(text);
    contentBinding.buttonSignUp.buttonPrimary.setOnClickListener(v -> {
      String title = resources.getString(R.string.app_notification);
      String message = resources.getString(R.string.app_coming_soon);
      MyAlertDialog.showAlertDialog(context, title, message);
    });
  }

  @SuppressLint("UseCompatLoadingForDrawables")
  private void bindingButtonGoogle() {
    String text = resources.getString(R.string.sign_in_google);
    Drawable drawable = resources.getDrawable(R.drawable.google_icon, context.getTheme());
    contentBinding.buttonGoogle.iconView.setImageDrawable(drawable);
    contentBinding.buttonGoogle.textView.setText(text);
    contentBinding.buttonGoogle.button.setOnClickListener(v -> {

      String title = resources.getString(R.string.app_notification);
      String message = resources.getString(R.string.app_coming_soon);
      MyAlertDialog.showAlertDialog(context, title, message);
    });
  }

  private void bindingButtonSignIn() {
    contentBinding.buttonSignIn.setOnClickListener(v -> {
      finish();
    });
  }
}
