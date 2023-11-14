package com.android_app.day_task_android;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android_app.day_task_android.databinding.ActivityDetailsTaskBinding;
import com.android_app.day_task_android.databinding.ContentDetailsTaskBinding;
import com.android_app.day_task_android.databinding.FooterDetailsTaskBinding;
import com.android_app.day_task_android.databinding.HeaderNavigationBinding;

public class TaskDetails extends AppCompatActivity {

  private ActivityDetailsTaskBinding binding;
  private HeaderNavigationBinding headerNavigationBinding;
  private ContentDetailsTaskBinding contentDetailsTaskBinding;
  private FooterDetailsTaskBinding footerDetailsTaskBinding;
  private Resources resources;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = ActivityDetailsTaskBinding.inflate(getLayoutInflater());
    headerNavigationBinding = binding.header;
    contentDetailsTaskBinding = binding.content;
    footerDetailsTaskBinding = binding.footer;

    setContentView(binding.getRoot());
    resources = getResources();

    bindingHeader();
    bindingContent();
    bindingFooter();

  }

  private void bindingHeader() {
    Drawable iconLeft = resources.getDrawable(R.drawable.back_icon, getTheme());
    Drawable iconRight = resources.getDrawable(R.drawable.edit_icon, getTheme());
    String text = resources.getString(R.string.task_details);
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
    bindingButtonAssignedMembers();
    bindingTextDetails();
  }

  private void bindingFooter() {
    String text = resources.getString(R.string.task_details_save);
    footerDetailsTaskBinding.buttonSaveTask.textView.setText(text);
    footerDetailsTaskBinding.buttonSaveTask.button.setOnClickListener(v -> {
      finish();
    });
  }

  private void bindingTextTitle() {
    contentDetailsTaskBinding.textTitle.setText("Real Estate App Design");
  }

  private void bindingDueDate() {
    Drawable icon = resources.getDrawable(R.drawable.calender_close_icon, this.getTheme());
    contentDetailsTaskBinding.buttonDueDate.iconView.setImageDrawable(icon);
    contentDetailsTaskBinding.buttonDueDate.textView.setVisibility(View.GONE);
  }

  private void bindingButtonAssignedMembers() {
    Drawable icon = resources.getDrawable(R.drawable.members_icon, this.getTheme());
    contentDetailsTaskBinding.buttonAssignedMembers.iconView.setImageDrawable(icon);
    contentDetailsTaskBinding.buttonAssignedMembers.textView.setVisibility(View.GONE);
  }

  private void bindingTextDetails() {
    contentDetailsTaskBinding.textDetails.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled");
  }

}
