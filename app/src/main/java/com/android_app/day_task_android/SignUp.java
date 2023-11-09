package com.android_app.day_task_android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

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
    bindingAcceptDayTask();
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

  private void bindingAcceptDayTask(){
    String acceptText = resources.getString(R.string.sign_up_i_have_read_and_agree_daytask);
    String privacyText = " " + resources.getString(R.string.sign_up_privacy_policy) + " ";
    String commaText=",";
    String termText = " " + resources.getString(R.string.sign_up_term_and_condition) + " ";
    int primaryColor = resources.getColor(R.color.primary, getTheme());

    SpannableStringBuilder builder = new SpannableStringBuilder();

    SpannableString span1 = new SpannableString(acceptText);
    builder.append(span1);

    SpannableString privacySpan = new SpannableString(privacyText);
    ClickableSpan clickablePrivacySpan = new ClickableSpan() {
      @Override
      public void onClick(View widget) {
        // Handle the click event for span2;
        String title = resources.getString(R.string.app_notification);
        String message = resources.getString(R.string.app_coming_soon);
        MyAlertDialog.showAlertDialog(context, title, message);
      }
    };
    privacySpan.setSpan(clickablePrivacySpan, 0, privacySpan.length(), 0);
    privacySpan.setSpan( new ForegroundColorSpan(primaryColor), 0, privacyText.length(), 0);
    builder.append(privacySpan);

    builder.append(commaText);

    SpannableString termSpan = new SpannableString(termText);
    ClickableSpan clickableTermSpan = new ClickableSpan() {
      @Override
      public void onClick(View widget) {
        // Handle the click event for span2;
        String title = resources.getString(R.string.app_notification);
        String message = resources.getString(R.string.app_coming_soon);
        MyAlertDialog.showAlertDialog(context, title, message);
      }
    };
    termSpan.setSpan(clickableTermSpan, 0, termSpan.length(), 0);
    termSpan.setSpan(new ForegroundColorSpan(primaryColor), 0, termSpan.length(), 0);
    builder.append(termSpan);

    contentBinding.textAccept.setText(builder);
    // Enable ClickableSpan's click handling
    contentBinding.textAccept.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
  }

  /*
  @Deprecated
   */
  private void bindingAcceptDayTaskTest() {
    String acceptText = resources.getString(R.string.sign_up_i_have_read_and_agree_daytask);
    String privacyText = " " + resources.getString(R.string.sign_up_privacy_policy) + " ";
    String termText = " " + resources.getString(R.string.sign_up_term_and_condition) + " ";
    int primaryColor = resources.getColor(R.color.primary, getTheme());

    SpannableStringBuilder spanText = new SpannableStringBuilder();
    spanText.append(acceptText);
    spanText.append(privacyText);
    spanText.setSpan(new ClickableSpan() {
      @Override
      public void onClick(View widget) {
        // On Click Action
        String title = resources.getString(R.string.app_notification);
        String message = resources.getString(R.string.app_coming_soon);
        MyAlertDialog.showAlertDialog(context, title, message);
      }

      @Override
      public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(primaryColor);    // you can use custom color
        textPaint.setTextSize(50);
      }
    }, spanText.length() - privacyText.length(), spanText.length(), 0);

    spanText.append(",");
    spanText.append(termText);
    spanText.setSpan(new ClickableSpan() {
      @Override
      public void onClick(View widget) {
        // On Click Action
        String title = resources.getString(R.string.app_notification);
        String message = resources.getString(R.string.app_coming_soon);
        MyAlertDialog.showAlertDialog(context, title, message);
      }

      @Override
      public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(primaryColor);    // you can use custom color
        textPaint.setTextSize(50);
      }
    }, spanText.length() - termText.length(), spanText.length(), 1);

    contentBinding.textAccept.setMovementMethod(LinkMovementMethod.getInstance());
    contentBinding.textAccept.setText(spanText);
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
