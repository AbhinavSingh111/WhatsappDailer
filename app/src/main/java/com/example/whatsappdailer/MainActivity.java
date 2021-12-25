package com.example.whatsappdailer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText input;
    Button send;
    ToggleButton toggleButton;
    String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.editTextPhone);
        send = findViewById(R.id.button2);
        toggleButton = findViewById(R.id.toggleButton2);
        send.setBackgroundColor(getColor(R.color.whatsappbutton));

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    input.setInputType(1);
                    input.setHint("Enter Username");
                    send.setBackgroundColor(getColor(R.color.instabutton));
                }
                else
                {
                    input.setInputType(3);
                    input.setHint("Enter Number");
                    send.setBackgroundColor(getColor(R.color.whatsappbutton));

                }
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(toggleButton.isChecked())
                    {

                        instagram();
                    }
                    else
                    {
                        whatsapp();
                    }
            }
        });

    }
    private void whatsapp()
    {
        number=input.getText().toString();
        if(number.equals(null) || number.length() != 10)
        {
            Toast.makeText(MainActivity.this,"Enter the Proper Number",Toast.LENGTH_SHORT).show();
        }
        else
        {
            String link = "https://wa.me/91";
            link=link+number;
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(link));
            startActivity(i);
            input.setText("");
        }


    }
    private void instagram()
    {
        number= String.valueOf(input.getText());
        Pattern regex = Pattern.compile("[$&+,:;=?@#|/'<>^*()%!-]");

        if (number.equals(null) || number.length()>30||regex.matcher(number).find() || number.length()==0) {
            Toast.makeText(MainActivity.this,"Enter the Proper UserName",Toast.LENGTH_SHORT).show();
        }
        else
        {
            String link = "http://instagram.com/_u/";
            link=link+number;
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(link));
            startActivity(i);
            input.setText("");
        }





    }
}