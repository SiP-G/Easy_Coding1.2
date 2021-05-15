package com.example.easycoding;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Text_Content_Activity extends AppCompatActivity {
    private TextView text_content;
    private Typeface face1;
    private ImageView iContent;
    private int category = 0;
    private int position = 0;
    private int [] array_prog = {R.string.prog_1,R.string.prog_2};
    private int [] array_dost = {R.string.dost_1,R.string.dost_2};
    private int [] array_image = {R.drawable.c_plus_plus,R.drawable.python};

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        text_content = findViewById(R.id.text_main_content);
        iContent = findViewById(R.id.imageContent);
        init();
        reciveIntent();
    }
    private void reciveIntent()
    {
        Intent i = getIntent();
        if (i != null)
        {
            category = i.getIntExtra("category", 0);
            position = i.getIntExtra("position", 0);
        }
        switch (category){
            case 0:
                iContent.setImageResource(array_image[position]);
                text_content.setText(array_prog[position]);
                break;
            case 1:
                iContent.setImageResource(array_image[position]);
                text_content.setText(array_dost[position]);
                break;
            case 2:

                break;
        }
    }
    private void init()
    {
        text_content = findViewById(R.id.text_main_content);
        iContent = findViewById(R.id.imageContent);
        face1 = Typeface.createFromAsset(this.getAssets(),"fonts/Lobster-Regular.ttf");
        text_content.setTypeface(face1);
    }
}
