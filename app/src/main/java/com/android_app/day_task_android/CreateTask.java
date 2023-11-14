package com.android_app.day_task_android;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android_app.day_task_android.databinding.ActivityCreateTaskBinding;
import com.android_app.day_task_android.databinding.ContentCreateTaskBinding;
import com.android_app.day_task_android.databinding.HeaderNavigationBinding;

public class CreateTask extends AppCompatActivity {
  private ActivityCreateTaskBinding binding;

  private HeaderNavigationBinding navigationBinding;
  private ContentCreateTaskBinding contentCreateTaskBinding;

  private Resources resources;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = ActivityCreateTaskBinding.inflate(getLayoutInflater());
    navigationBinding = binding.header;
    contentCreateTaskBinding = binding.content;

    resources = getResources();

    //set root content
    setContentView(binding.getRoot());

    bindingHeader();
    bindingButtonAddMember();
    bindingTimeAndDate();
    bindingButtonCreateTask();

  }

  private void bindingHeader() {
    String text = resources.getString(R.string.create_task);
    Drawable iconRight = resources.getDrawable(R.drawable.back_icon, getTheme());
    navigationBinding.text.setText(text);
    navigationBinding.iconLeft.setImageDrawable(iconRight);
    navigationBinding.iconLeft.setOnClickListener(v -> {
      finish();
    });
    navigationBinding.iconRight.setVisibility(View.INVISIBLE);


  }

  private void bindingButtonAddMember() {
    Drawable icon = resources.getDrawable(R.drawable.add_icon, getTheme());
    contentCreateTaskBinding.buttonAddTeamMember.iconView.setImageDrawable(icon);
    contentCreateTaskBinding.buttonAddTeamMember.textView.setVisibility(View.GONE);
  }

  private void bindingTimeAndDate() {
    Drawable iconTime = resources.getDrawable(R.drawable.clock_icon, getTheme());
    Drawable iconDate = resources.getDrawable(R.drawable.calendar_icon, getTheme());
    contentCreateTaskBinding.buttonTime.iconView.setImageDrawable(iconTime);
    contentCreateTaskBinding.buttonTime.textView.setVisibility(View.GONE);
    contentCreateTaskBinding.buttonDate.iconView.setImageDrawable(iconDate);
    contentCreateTaskBinding.buttonDate.textView.setVisibility(View.GONE);
  }

  private void bindingButtonCreateTask() {
    String text = resources.getString(R.string.create_task_save);
    contentCreateTaskBinding.buttonSave.textView.setText(text);
  }

}
