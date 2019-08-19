package com.zoontek.rnbootsplash;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RNBootSplashActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    try {
      int resId = this.getResources().getIdentifier("build_config_package", "string", this.getPackageName());
      Intent intent = new Intent(this, Class.forName(this.getString(resId) + ".MainActivity"));

      // Pass along FCM messages/notifications etc.
      Bundle extras = getIntent().getExtras();
      if (extras != null) {
        intent.putExtras(extras);
      }

      startActivity(intent);
      finish();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
