package com.android_app.day_task_android;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



import com.android_app.day_task_android.databinding.ActivityProjectDetailsBinding;
import com.android_app.day_task_android.databinding.ContentProjectDetailsBinding;
import com.android_app.day_task_android.databinding.FooterProjectDetailsBinding;
import com.android_app.day_task_android.databinding.HeaderNavigationBinding;

public class ProjectDetails extends AppCompatActivity {
  private ActivityProjectDetailsBinding binding;
  private HeaderNavigationBinding headerNavigationBinding;
  private ContentProjectDetailsBinding contentProjectDetailsBinding;
  private FooterProjectDetailsBinding footerProjectDetailsBinding;
  private Resources resources;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = ActivityProjectDetailsBinding.inflate(getLayoutInflater());
    headerNavigationBinding = binding.header;
    contentProjectDetailsBinding = binding.content;
    footerProjectDetailsBinding = binding.footer;

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
    footerProjectDetailsBinding.buttonAddTask.textView.setText(text);
    footerProjectDetailsBinding.buttonAddTask.button.setOnClickListener(v -> {
      Intent intent = new Intent(this, CreateTask.class);
      startActivity(intent);
    });
  }

  private void bindingTextTitle() {
    contentProjectDetailsBinding.textTitle.setText("Real Estate App Design");
  }

  private void bindingDueDate() {
    Drawable icon = resources.getDrawable(R.drawable.calender_close_icon, this.getTheme());
    contentProjectDetailsBinding.buttonDueDate.iconView.setImageDrawable(icon);
    contentProjectDetailsBinding.buttonDueDate.textView.setVisibility(View.GONE);
  }

  private void bindingProjectTeams() {
    Drawable icon = resources.getDrawable(R.drawable.members_icon, this.getTheme());
    contentProjectDetailsBinding.buttonProjectTeams.iconView.setImageDrawable(icon);
    contentProjectDetailsBinding.buttonProjectTeams.textView.setVisibility(View.GONE);
  }

  private void bindingTextDetails() {
    contentProjectDetailsBinding.textDetails.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled");
  }

  private void bindingProgress() {
    contentProjectDetailsBinding.progressBar.statusProgress.setMax(100);
    contentProjectDetailsBinding.progressBar.statusProgress.setProgress(60);
    contentProjectDetailsBinding.progressBar.textProgress.setText("60%");
  }

  private void bindingItemTask() {
    Drawable icon = resources.getDrawable(R.drawable.ticker_circle_success_icon, this.getTheme());
    contentProjectDetailsBinding.itemTask.text.setText("User interviews");
    contentProjectDetailsBinding.itemTask.statusTask.iconView.setImageDrawable(icon);
    contentProjectDetailsBinding.itemTask.statusTask.textView.setVisibility(View.GONE);
    contentProjectDetailsBinding.itemTask.button.setOnClickListener(v -> {
      Intent intent = new Intent(this, TaskDetails.class);
      startActivity(intent);
    });
  }

}
