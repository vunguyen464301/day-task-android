package com.android_app.todo_list;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android_app.todo_list.databinding.ActivitySignInBinding;
import com.android_app.todo_list.databinding.ContentSignInBinding;

public class SignIn extends AppCompatActivity {

  private ActivitySignInBinding binding;
  private ContentSignInBinding contentBinding;
  private Context context;
  private Resources resources;


  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = ActivitySignInBinding.inflate(getLayoutInflater());
    contentBinding = ContentSignInBinding.bind(binding.getRoot());
    setContentView(binding.getRoot());

    context = SignIn.this;

    resources = context.getResources();

    bindingInputEmail();
    bindingInputPassword();
    bindingButtonLogin();
    bindingButtonGoogle();
    bindingButtonSignUp();
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

  private void bindingButtonLogin() {
    String text = resources.getString(R.string.sign_in);
    contentBinding.buttonSignIn.buttonPrimary.setText(text);
    contentBinding.buttonSignIn.buttonPrimary.setOnClickListener(v -> {
    });
  }
  @SuppressLint("UseCompatLoadingForDrawables")
  private void bindingButtonGoogle() {
    String text = resources.getString(R.string.sign_in_google);
   Drawable drawable = resources.getDrawable(R.drawable.google_icon, context.getTheme());

    contentBinding.buttonGoogle.iconView.setImageDrawable(drawable);
    contentBinding.buttonGoogle.textView.setText(text);
    contentBinding.buttonGoogle.button.setOnClickListener(v->{

    });
  }

  private void bindingButtonSignUp() {
    contentBinding.buttonSignUp.setOnClickListener(v -> {

    });
  }
}
