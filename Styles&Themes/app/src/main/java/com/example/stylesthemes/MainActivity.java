package com.example.stylesthemes;

import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

// Brenna Pavlinchak
// AID - C202502
// MainActivity

public class MainActivity extends AppCompatActivity
{
    private FrameLayout frameLayout;
    private TextView frameText;
    private EditText editText;
    private RadioGroup backgroundColorGroup, textColorGroup;
    private SwitchCompat boldSwitch;
    private RadioButton colorRed;
    private RadioButton colorBlue;
    private RadioButton colorGreen;
    private RadioButton colorBlack;
    private RadioButton textColorRed;
    private RadioButton textColorBlue;
    private RadioButton textColorBlack;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            setContentView(R.layout.activity_main_landscape);
        }
        else
        {
            setContentView(R.layout.activity_main_portrait);
        }

        frameLayout = findViewById(R.id.frameLayout);
        frameText = findViewById(R.id.frameText);
        editText = findViewById(R.id.editText);
        backgroundColorGroup = findViewById(R.id.backgroundColorGroup);
        textColorGroup = findViewById(R.id.textColorGroup);
        boldSwitch = findViewById(R.id.boldSwitch);

        RadioButton colorRed = findViewById(R.id.colorRed);
        RadioButton colorBlue = findViewById(R.id.colorBlue);
        RadioButton colorGreen = findViewById(R.id.colorGreen);
        RadioButton textColorRed = findViewById(R.id.textColorRed);
        RadioButton textColorBlue = findViewById(R.id.textColorBlue);
        RadioButton textColorBlack = findViewById(R.id.textColorBlack);

        backgroundColorGroup.setOnCheckedChangeListener((group, checkedId) ->
        {
            if (checkedId == R.id.colorRed)
            {
                frameLayout.setBackgroundColor(getResources().getColor(R.color.red, getTheme()));
            }
            else if (checkedId == R.id.colorBlue)
            {
                frameLayout.setBackgroundColor(getResources().getColor(R.color.blue, getTheme()));
            }
            else if (checkedId == R.id.colorGreen)
            {
                frameLayout.setBackgroundColor(getResources().getColor(R.color.green, getTheme()));
            }
        });

        textColorGroup.setOnCheckedChangeListener((group, checkedId) ->
        {
            if (checkedId == R.id.textColorRed)
            {
                frameText.setTextColor(getResources().getColor(R.color.red, getTheme()));
            }
            else if (checkedId == R.id.textColorBlue)
            {
                frameText.setTextColor(getResources().getColor(R.color.blue, getTheme()));
            }
            else if (checkedId == R.id.textColorBlack)
            {
                frameText.setTextColor(getResources().getColor(R.color.black, getTheme()));
            }
        });

        editText.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count)
            {
                frameText.setText(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        boldSwitch.setOnCheckedChangeListener((buttonView, isChecked) ->
        {
            frameText.setTypeface(null, isChecked ? Typeface.BOLD : Typeface.NORMAL);
        });
    }
}