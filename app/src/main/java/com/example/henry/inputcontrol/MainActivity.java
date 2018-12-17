package com.example.henry.inputcontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner ageSpinner;
    private RadioGroup genderGroup ;
    private RadioButton maleButton;
    private RadioButton femaleButton;
    private CheckBox smokerBox;
    private TextView amountText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        genderGroup = findViewById(R.id.radioGroupGender);
        ageSpinner = findViewById(R.id.age_spinner);
        maleButton = findViewById(R.id.maleRadio);
        femaleButton = findViewById(R.id.femaleRadio);
        smokerBox = findViewById(R.id.smokerBox);
        amountText = findViewById(R.id.premiumField);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.age_group,android.R.layout.simple_dropdown_item_1line);
        ageSpinner.setAdapter(adapter);
        ageSpinner.setOnItemSelectedListener( this);

    }

    public void calculateInsurance(View view)
    {
        int premium = 0;
        int position ;
        String gender;
        boolean isSmoker = smokerBox.isChecked();
        position = ageSpinner.getSelectedItemPosition();

        if(genderGroup.getCheckedRadioButtonId() == R.id.maleRadio)
        {
            gender = "male";
        }
        else
        {
            gender = "female";
        }

        switch(position){
            case 0 :
                premium = 50;
                break;
            case 1 :
                premium = 55;
                break;
            case 2 :
                premium = 60;
                if(gender == "male")
                {
                    premium += 50;
                }
                break;
            case 3 :
                premium = 70;
                if(gender == "male")
                {
                    premium += 100;
                    if(isSmoker)
                    {
                        premium +=100;
                    }
                }
                break;
            case 4 :
                premium = 120;
                if(gender == "male")
                {
                    premium += 100;
                    if(isSmoker)
                    {
                        premium +=150;
                    }
                }
                break;
            case 5 :
                premium = 160;
                if(gender == "male")
                {
                    premium += 50;
                    if(isSmoker)
                    {
                        premium +=150;
                    }
                }
                break;
            case 6 :
                premium = 200;
                if(gender == "male")
                {
                    premium += 0;
                    if(isSmoker)
                    {
                        premium +=250;
                    }
                }
                break;
            case 7 :
                premium = 250;
                if(gender == "male")
                {
                    premium += 0;
                    if(isSmoker)
                    {
                        premium +=250;
                    }
                }
                break;
        }

        amountText.setText("RM" + premium);

    }

    public void resetEverything(View view){
        amountText.setText("");
        genderGroup.clearCheck();
        smokerBox.setChecked(false);
        ageSpinner.setSelection(0);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"Item Selected "+ position,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
