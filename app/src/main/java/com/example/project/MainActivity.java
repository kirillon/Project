package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
    }

    public void FemaleClicked(View view){

        RadioButton button2_male= findViewById(R.id.radioButton);
        RadioButton button2_female= findViewById(R.id.radioButton2);

        button2_female.setChecked(false);
        button2_male.setChecked(false);
        button2_female.setChecked(true);
    }
    public void MaleClicked(View view){

        RadioButton button2_male= findViewById(R.id.radioButton);
        RadioButton button2_female= findViewById(R.id.radioButton2);
        button2_male.setChecked(false);
        button2_female.setChecked(false);
        button2_male.setChecked(true);
    }
    public void ImtCounter(View view){

        EditText  Mass_View= findViewById(R.id.editTextNumberSigned);
        EditText Height_View = findViewById(R.id.editTextNumber2);
        System.out.println(Height_View.getText());
        if ((!Height_View.getText().toString().isEmpty()) & (!Mass_View.getText().toString().isEmpty())){
            double Height = Double.parseDouble(Height_View.getText().toString())/100;
            double Mass = Double.parseDouble(Mass_View.getText().toString());
            double IMT = Mass/(Height*Height);
            TextView Answer = findViewById(R.id.textView6);
            TextView AnswerText = findViewById(R.id.textView7);
            Answer.setText(String.format("ИМТ %.2f", IMT));
            if (IMT<= 16) {
                AnswerText.setText("Значительный дефицит массы тела");
            } else if (IMT> 16 && IMT <=18.5) {
                AnswerText.setText("Дефицит массы тела");
            }else if (IMT> 18.5 && IMT <=25){
                AnswerText.setText("Норма");
            }else if (IMT> 25 && IMT <=30){
                AnswerText.setText("Лишний вес");
            }else if (IMT> 30 && IMT <=35){
                AnswerText.setText("Ожирение первой степени");
            }else if (IMT> 35 && IMT <=40){
                AnswerText.setText("Ожирение второй степени");
            }else if (IMT>40){
                AnswerText.setText("Ожирение третьей степени");
            }
        }
        else{
            Toast.makeText(getApplicationContext(), "Введены не все данные", Toast.LENGTH_SHORT).show();
        }
    }
}