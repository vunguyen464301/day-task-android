package com.android_app.day_task_android;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.android_app.day_task_android.databinding.ActivityDetailsProjectBinding;
import com.android_app.day_task_android.databinding.ContentDetailsProjectBinding;
import com.android_app.day_task_android.databinding.FooterDetailsProjectBinding;
import com.android_app.day_task_android.databinding.HeaderNavigationBinding;

public class ProjectDetails extends AppCompatActivity {
  private ActivityDetailsProjectBinding binding;
  private HeaderNavigationBinding headerNavigationBinding;
  private ContentDetailsProjectBinding contentDetailsProjectBinding;
  private FooterDetailsProjectBinding footerDetailsProjectBinding;
  private Resources resources;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = ActivityDetailsProjectBinding.inflate(getLayoutInflater());
    headerNavigationBinding = binding.header;
    contentDetailsProjectBinding = binding.content;
    footerDetailsProjectBinding = binding.footer;

    setContentView(binding.getRoot());
    resources = getResources();

    bindingHeader();
    bindingContent();
    bindingFooter();

  }

  private void bindingHeader() {
    Drawable iconLeft = resources.getDrawable(R.drawable.back_icon, getTheme());
    Drawable iconRight = resources.getDrawable(R.drawable.edit_icon, getTheme());
    String text = resources.getString(R.string.project_details);
    headerNavigationBinding.iconLeft.setImageDrawable(iconLeft);
    headerNavigationBinding.text.setText(text);
    headerNavigationBinding.iconRight.setImageDrawable(iconRight);
    headerNavigationBinding.iconLeft.setOnClickListener(v -> {
      finish();
    });
  }

  private void bindingContent() {
    bindingTextTitle();
    bindingDueDate();
    bindingProjectTeams();
    bindingTextDetails();
    bindingProgress();
    bindingItemTask();
  }

  private void bindingFooter() {
    String text = resources.getString(R.string.project_details_add_task);
    footerDetailsProjectBinding.buttonAddTask.textView.setText(text);
    footerDetailsProjectBinding.buttonAddTask.button.setOnClickListener(v -> {
      Intent intent = new Intent(this, CreateTask.class);
      startActivity(intent);
    });
  }

  private void bindingTextTitle() {

    contentDetailsProjectBinding.textTitle.setText("Real Estate App Design");
  }

  private void bindingDueDate() {
    Drawable icon = resources.getDrawable(R.drawable.calender_close_icon, this.getTheme());
    contentDetailsProjectBinding.buttonDueDate.iconView.setImageDrawable(icon);
    contentDetailsProjectBinding.buttonDueDate.textView.setVisibility(View.GONE);
  }

  private void bindingProjectTeams() {
    Drawable icon = resources.getDrawable(R.drawable.members_icon, this.getTheme());
    contentDetailsProjectBinding.buttonProjectTeams.iconView.setImageDrawable(icon);
    contentDetailsProjectBinding.buttonProjectTeams.textView.setVisibility(View.GONE);
  }

  private void bindingTextDetails() {
    contentDetailsProjectBinding.textDetails.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled");
  }

  private void bindingProgress() {
    contentDetailsProjectBinding.progressBar.statusProgress.setMax(100);
    contentDetailsProjectBinding.progressBar.statusProgress.setProgress(60);
    contentDetailsProjectBinding.progressBar.textProgress.setText("60%");
  }

  private void bindingItemTask() {
    Drawable icon = resources.getDrawable(R.drawable.ticker_circle_success_icon, this.getTheme());
    contentDetailsProjectBinding.itemTask.text.setText("User interviews");
    contentDetailsProjectBinding.itemTask.statusTask.iconView.setImageDrawable(icon);
    contentDetailsProjectBinding.itemTask.statusTask.textView.setVisibility(View.GONE);
  }


}
