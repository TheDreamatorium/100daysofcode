package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private EditText editTxtWeb;
    private EditText editTxtLocation;
    private EditText editTxtShare;

    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinatorLayout = findViewById(R.id.coordinatorLayout);

        editTxtWeb = findViewById(R.id.editTxtWeb);
        editTxtLocation = findViewById(R.id.editTxtLocation);
        editTxtShare = findViewById(R.id.editTxtShare);

    }

    public void openWebsite(View view) {
        if (editTxtWeb.getText().toString().length() > 0) {
            String url = editTxtWeb.getText().toString();
            Uri webPage = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, webPage);
            startActivity(intent);
        } else {
            Snackbar snackbar = Snackbar.make(coordinatorLayout,"Please enter a url" ,Snackbar.LENGTH_LONG);
            snackbar.show();
        }
    }

    public void openLocation(View view) {
        if (editTxtLocation.getText().toString().length() > 0) {
            String location = editTxtLocation.getText().toString();
            Uri addressUri = Uri.parse("geo:0,0?q=" + location);
            Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

            if(intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Snackbar snackbar = Snackbar.make(coordinatorLayout, "Location Invalid!", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        } else {
            Snackbar snackbar = Snackbar.make(coordinatorLayout, "Please enter a location", Snackbar.LENGTH_LONG);
            snackbar.show();
        }
    }

    public void shareText(View view) {
        String text = editTxtShare.getText().toString();
        String mimeType = "text/plain";

        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(text)
                .startChooser();
    }
}
