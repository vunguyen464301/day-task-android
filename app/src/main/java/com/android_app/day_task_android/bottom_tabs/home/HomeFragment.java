package com.android_app.day_task_android.bottom_tabs.home;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.android_app.day_task_android.MainActivity;
import com.android_app.day_task_android.R;
import com.android_app.day_task_android.databinding.CardOnGoingProjectBinding;
import com.android_app.day_task_android.databinding.ContentHomeBinding;
import com.android_app.day_task_android.databinding.FragmentHomeBinding;
import com.android_app.day_task_android.databinding.HeaderHomeBinding;

public class HomeFragment extends Fragment {

  private FragmentHomeBinding binding;
  private ContentHomeBinding contentHomeBinding;
  private HeaderHomeBinding headerHomeBinding;
  //  private HomeFragment context;
  private Resources resources;

  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    HomeViewModel homeViewModel =
        new ViewModelProvider(this).get(HomeViewModel.class);

    binding = FragmentHomeBinding.inflate(inflater, container, false);
    View viewRoot = binding.getRoot();

    resources = getResources();

    contentHomeBinding = binding.content;
    headerHomeBinding = binding.header;

    bindingTextName();
    bindingInput();
    bindingSearchButton();
    bindingProgress();

//    final C textView = binding.contentOnGoingProject;
//    homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
    return viewRoot;
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }

  private void bindingTextName() {
    headerHomeBinding.textName.setText("Nguyen Anh Vu");
  }

  private void bindingInput() {
    contentHomeBinding.inputSearch.iconLeft.setImageDrawable(resources.getDrawable(R.drawable.search_icon, this.getActivity().getTheme()));
    contentHomeBinding.inputSearch.input.setHint(resources.getString(R.string.home_search_tasks));
  }

  private void bindingSearchButton() {
    contentHomeBinding.buttonSearch.iconView.setImageDrawable(resources.getDrawable(R.drawable.filter_icon, this.getActivity().getTheme()));
    contentHomeBinding.buttonSearch.textView.setVisibility(View.GONE);
//    contentHomeBinding.buttonSearch.iconView
  }

  private void bindingProgress() {
    CardOnGoingProjectBinding cardOnGoingProjectBinding = contentHomeBinding.contentOnGoingProject;
    cardOnGoingProjectBinding.textProgress.setText("90%");
    ProgressBar progressBar = cardOnGoingProjectBinding.progress;
    progressBar.setProgress(90);
    progressBar.setMax(100);
  }
}