package com.android_app.day_task_android.create_project;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android_app.day_task_android.R;
import com.android_app.day_task_android.databinding.ActivityCreateProjectBinding;
import com.android_app.day_task_android.databinding.ActivityMainBinding;
import com.android_app.day_task_android.databinding.ContentCreateProjectBinding;
import com.android_app.day_task_android.databinding.HeaderNavigationBinding;

public class CreateProject extends AppCompatActivity {

  private ActivityCreateProjectBinding binding;

  private HeaderNavigationBinding navigationBinding;
  private ContentCreateProjectBinding contentCreateProjectBinding;

  private Resources resources;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = ActivityCreateProjectBinding.inflate(getLayoutInflater());
    navigationBinding = binding.header;
    contentCreateProjectBinding = binding.content;

    resources = getResources();

    //set root content
    setContentView(binding.getRoot());

    bindingHeader();
    bindingButtonAddMember();
    bindingTimeAndDate();
    bindingButtonCreateProject();

  }

  private void bindingHeader() {
    String text = resources.getString(R.string.create_project_create_new_task);
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
    contentCreateProjectBinding.buttonAddTeamMember.iconView.setImageDrawable(icon);
    contentCreateProjectBinding.buttonAddTeamMember.textView.setVisibility(View.GONE);
  }

  private void bindingTimeAndDate() {
    Drawable iconTime = resources.getDrawable(R.drawable.clock_icon, getTheme());
    Drawable iconDate = resources.getDrawable(R.drawable.calendar_icon, getTheme());
    contentCreateProjectBinding.buttonTime.iconView.setImageDrawable(iconTime);
    contentCreateProjectBinding.buttonTime.textView.setVisibility(View.GONE);
    contentCreateProjectBinding.buttonDate.iconView.setImageDrawable(iconDate);
    contentCreateProjectBinding.buttonDate.textView.setVisibility(View.GONE);
  }

  private void bindingButtonCreateProject() {
    String text = resources.getString(R.string.create_project_create);
    contentCreateProjectBinding.buttonCreateProject.textView.setText(text);
  }

}
