package com.example.stylesthemes;

import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.FrameLayout;
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

        backgroundColorGroup.setOnCheckedChangeListener((group, checkedId) ->
        {
            int color = getResources().getColor(
                    checkedId == R.id.colorRed ? R.color.red :
                            checkedId == R.id.colorBlue ? R.color.blue :
                                    R.color.green, getTheme());

            frameLayout.setBackgroundColor(color);

            if (getSupportActionBar() != null)
            {
                getSupportActionBar().setBackgroundDrawable(
                        new android.graphics.drawable.ColorDrawable(color));
            }

            getWindow().setStatusBarColor(color);
        });

        textColorGroup.setOnCheckedChangeListener((group, checkedId) ->
                frameText.setTextColor(getResources().getColor(
                        checkedId == R.id.textColorRed ? R.color.red :
                                checkedId == R.id.textColorBlue ? R.color.blue :
                                        R.color.green, getTheme())));

        editText.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                frameText.setText(s);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        boldSwitch.setOnCheckedChangeListener((buttonView, isChecked) ->
                frameText.setTypeface(null, isChecked ? Typeface.BOLD : Typeface.NORMAL));
    }
}