package com.android_app.todo_list;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.android_app.todo_list.databinding.ActivityMainBinding;
import com.android_app.todo_list.databinding.ContentMainBinding;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
  private ActivityMainBinding binding;
  private ContentMainBinding contentMainBinding; // Declare the binding for the included layout

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
//        setContentView(R.layout);

    binding = ActivityMainBinding.inflate(getLayoutInflater());
    contentMainBinding = ContentMainBinding.bind(binding.getRoot());

    //set root content
    setContentView(binding.getRoot());

    contentMainBinding.text1.setText("ok ne");

//        binding.text1.setText("ok ne");

    contentMainBinding.buttonLogin.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, SignIn.class);
        startActivity(intent);
      }
    });
  }

}
