package com.android_app.day_task_android;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class MyAlertDialog {
   static void showAlertDialog(Context context, String title, String message) {
    AlertDialog.Builder builder = new AlertDialog.Builder(context);

    // Set the dialog title and message
    builder.setTitle(title);
    builder.setMessage(message);

    String okText=context.getString(R.string.ok);

    // Add a button to dismiss the dialog
    builder.setPositiveButton(okText, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        // Handle button click (if needed)
        dialog.dismiss();
      }
    });

    // Create and show the dialog
    AlertDialog alertDialog = builder.create();
    alertDialog.show();
  }

}
