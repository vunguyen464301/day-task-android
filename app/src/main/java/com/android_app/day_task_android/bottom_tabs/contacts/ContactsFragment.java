package com.android_app.day_task_android.bottom_tabs.contacts;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.android_app.day_task_android.ContactDetails;
import com.android_app.day_task_android.R;
import com.android_app.day_task_android.databinding.ContentContactsBinding;
import com.android_app.day_task_android.databinding.FragmentContactsBinding;
import com.android_app.day_task_android.databinding.HeaderNavigationBinding;

public class ContactsFragment extends Fragment {

  private FragmentContactsBinding binding;
  private HeaderNavigationBinding headerNavigationBinding;
  private ContentContactsBinding contentContactsBinding;

  private Resources resources;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    ContactsViewModel settingsViewModel = new ViewModelProvider(this).get(ContactsViewModel.class);
    binding = FragmentContactsBinding.inflate(inflater, container, false);
    headerNavigationBinding = binding.header;
    contentContactsBinding = binding.content;

    resources = getResources();

    View viewRoot = binding.getRoot();

    bindingHeader();
    bindingButtonItem();

    return viewRoot;
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }

  private void bindingHeader() {
    Drawable iconRight = resources.getDrawable(R.drawable.search_icon, getActivity().getTheme());
    String text = resources.getString(R.string.bottom_tab_contacts);
    headerNavigationBinding.iconRight.setImageDrawable(iconRight);
    headerNavigationBinding.text.setText(text);
  }

  private void bindingButtonItem() {
    contentContactsBinding.buttonItem.setOnClickListener(v -> {
      Intent intent = new Intent(this.getActivity(), ContactDetails.class);
      startActivity(intent);
    });
  }
}
