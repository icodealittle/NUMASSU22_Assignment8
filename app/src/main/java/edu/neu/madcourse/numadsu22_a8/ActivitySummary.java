package edu.neu.madcourse.numadsu22_a8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitySummary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.user_summary);
    }

    public void sendStickerBtn(View v) {
        System.out.println("Sticker sent");
        startActivity(new Intent(ActivitySummary.this, Display.class));
    }
}
