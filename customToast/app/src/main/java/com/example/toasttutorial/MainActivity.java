package com.example.toasttutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button connectBtn = findViewById(R.id.connectBtn);

        //Inflating the layout custom layout created for the toast
        LayoutInflater inflater = getLayoutInflater();
        View customLayout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_container));

        //The components:
        // 1. an imageview to display the logo
        // 2. a textview to display the text
        TextView textView = customLayout.findViewById(R.id.text);
        textView.setText(R.string.error_msg);
        ImageView imageView = customLayout.findViewById(R.id.icon_toast);
        imageView.setImageResource(R.drawable.error);

        //Initialize the toast object and display it
        final Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(customLayout);

        //Setting on click event listener on fake connect button
        connectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                toast.show();

                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
