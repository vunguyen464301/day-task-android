package com.android_app.day_task_android;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android_app.day_task_android.databinding.ActivityContactDetailsBinding;
import com.android_app.day_task_android.databinding.ContentContactDetailsBinding;
import com.android_app.day_task_android.databinding.HeaderNavigationBinding;

public class ContactDetails extends AppCompatActivity {
  private ActivityContactDetailsBinding binding;
  private HeaderNavigationBinding headerNavigationBinding;
  private ContentContactDetailsBinding contentContactDetailsBinding;
  private Resources resources;
  private Context context;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityContactDetailsBinding.inflate(getLayoutInflater());
    headerNavigationBinding = binding.header;
    contentContactDetailsBinding = binding.content;
    resources = getResources();
    context =this;

    setContentView(binding.getRoot());

    bindingHeader();
    bindingContent();
  }

  private void bindingHeader() {
    String text = resources.getString(R.string.contact_details);
    Drawable iconRight = resources.getDrawable(R.drawable.back_icon, getTheme());
    headerNavigationBinding.text.setText(text);
    headerNavigationBinding.iconLeft.setImageDrawable(iconRight);
    headerNavigationBinding.iconLeft.setOnClickListener(v -> {
      finish();
    });
    headerNavigationBinding.iconRight.setVisibility(View.INVISIBLE);
  }

  private void bindingContent() {
    bindingAdd();
    bindingDelete();
    bindingBlock();
    bindingUnblock();
  }

  private void bindingAdd() {
    Drawable icon = resources.getDrawable(R.drawable.add_icon, this.getTheme());
    String text = resources.getString(R.string.contact_details_add);
    contentContactDetailsBinding.buttonAdd.buttonChildren.iconView.setImageDrawable(icon);
    contentContactDetailsBinding.buttonAdd.buttonChildren.textView.setVisibility(View.GONE);
    contentContactDetailsBinding.buttonAdd.buttonChildren.button.setPadding(30, 0, 30, 0);
    contentContactDetailsBinding.buttonAdd.text.setText(text);
    contentContactDetailsBinding.buttonAdd.buttonParent.setOnClickListener(v->{
      String title = resources.getString(R.string.app_notification);
      String message = resources.getString(R.string.app_coming_soon);
      MyAlertDialog.showAlertDialog(context, title, message);
    });
  }

  private void bindingDelete() {
    Drawable icon = resources.getDrawable(R.drawable.delete_icon, this.getTheme());
    String text = resources.getString(R.string.contact_details_delete);
    contentContactDetailsBinding.buttonDelete.buttonChildren.iconView.setImageDrawable(icon);
    contentContactDetailsBinding.buttonDelete.buttonChildren.textView.setVisibility(View.GONE);
    contentContactDetailsBinding.buttonDelete.buttonChildren.button.setPadding(30, 0, 30, 0);
    contentContactDetailsBinding.buttonDelete.text.setText(text);
    contentContactDetailsBinding.buttonDelete.buttonParent.setOnClickListener(v->{
      String title = resources.getString(R.string.app_notification);
      String message = resources.getString(R.string.app_coming_soon);
      MyAlertDialog.showAlertDialog(context, title, message);
    });
  }

  private void bindingBlock() {
    Drawable icon = resources.getDrawable(R.drawable.block_icon, this.getTheme());
    String text = resources.getString(R.string.contact_details_block);
    contentContactDetailsBinding.buttonBlock.buttonChildren.iconView.setImageDrawable(icon);
    contentContactDetailsBinding.buttonBlock.buttonChildren.textView.setVisibility(View.GONE);
    contentContactDetailsBinding.buttonBlock.buttonChildren.button.setPadding(30, 0, 30, 0);
    contentContactDetailsBinding.buttonBlock.text.setText(text);
    contentContactDetailsBinding.buttonBlock.buttonParent.setOnClickListener(v->{

      String title = resources.getString(R.string.app_notification);
      String message = resources.getString(R.string.app_coming_soon);
      MyAlertDialog.showAlertDialog(context, title, message);
    });
  }

  private void bindingUnblock() {
    Drawable icon = resources.getDrawable(R.drawable.accessibility_icon, this.getTheme());
    String text = resources.getString(R.string.contact_details_un_block);
    contentContactDetailsBinding.buttonUnblock.buttonChildren.iconView.setImageDrawable(icon);
    contentContactDetailsBinding.buttonUnblock.buttonChildren.textView.setVisibility(View.GONE);
    contentContactDetailsBinding.buttonUnblock.buttonChildren.button.setPadding(30, 0, 30, 0);
    contentContactDetailsBinding.buttonUnblock.text.setText(text);
    contentContactDetailsBinding.buttonUnblock.buttonParent.setOnClickListener(v->{
      String title = resources.getString(R.string.app_notification);
      String message = resources.getString(R.string.app_coming_soon);
      MyAlertDialog.showAlertDialog(context, title, message);
    });
  }


}
