package ir.androidexception.andexalertdialogexample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import ir.androidexception.andexalertdialog.AndExAlertDialog;
import ir.androidexception.andexalertdialog.AndExAlertDialogListener;
import ir.androidexception.andexalertdialog.Font;
import ir.androidexception.andexalertdialog.InputType;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button sample1, sample2, sample3, sample4, sample5, sample6, sample7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sample1 = findViewById(R.id.button_sample_1);
        sample2 = findViewById(R.id.button_sample_2);
        sample3 = findViewById(R.id.button_sample_3);
        sample4 = findViewById(R.id.button_sample_4);
        sample5 = findViewById(R.id.button_sample_5);
        sample6 = findViewById(R.id.button_sample_6);
        sample7 = findViewById(R.id.button_sample_7);
        sample1.setOnClickListener(this);
        sample2.setOnClickListener(this);
        sample3.setOnClickListener(this);
        sample4.setOnClickListener(this);
        sample5.setOnClickListener(this);
        sample6.setOnClickListener(this);
        sample7.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == sample1){
            new AndExAlertDialog.Builder(this)
                .setMessage("Do you want to do this action?")
                .setPositiveBtnText("Ok")
                .setNegativeBtnText("Cancel")
                .setCancelableOnTouchOutside(true)
                .OnPositiveClicked(new AndExAlertDialogListener() {
                    @Override
                    public void OnClick(String input) {
                        Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show();
                    }
                })
                .OnNegativeClicked(new AndExAlertDialogListener() {
                    @Override
                    public void OnClick(String input) {
                        Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                    }
                })
                .build();
        }
        else if(v == sample2){
            new AndExAlertDialog.Builder(this)
                .setTitle("Confirm delete")
                .setMessage("Are you sure you want to delete this file?")
                .setPositiveBtnText("Yes")
                .setNegativeBtnText("No")
                .setImage(R.drawable.delete,15)
                .setCancelableOnTouchOutside(true)
                .OnPositiveClicked(new AndExAlertDialogListener() {
                    @Override
                    public void OnClick(String input) {
                        Toast.makeText(MainActivity.this, "Yes", Toast.LENGTH_SHORT).show();
                    }
                })
                .OnNegativeClicked(new AndExAlertDialogListener() {
                    @Override
                    public void OnClick(String input) {
                        Toast.makeText(MainActivity.this, "No", Toast.LENGTH_SHORT).show();
                    }
                })
                .build();
        }
        else if(v == sample3){
            new AndExAlertDialog.Builder(this)
                .setTitle("Enter Password")
                .setMessage("Please enter your password to login")
                .setPositiveBtnText("Ok")
                .setNegativeBtnText("Cancel")
                .setImage(R.drawable.password,20)
                .setEditText(true,false, "password",InputType.PASSWORD)
                .setCancelableOnTouchOutside(true)
                .OnPositiveClicked(new AndExAlertDialogListener() {
                    @Override
                    public void OnClick(String input) {
                        Toast.makeText(MainActivity.this, "you typed " + input, Toast.LENGTH_SHORT).show();
                    }
                })
                .OnNegativeClicked(new AndExAlertDialogListener() {
                    @Override
                    public void OnClick(String input) {
                        Toast.makeText(MainActivity.this, "you typed " + input, Toast.LENGTH_SHORT).show();
                    }
                })
                .build();
        }
        else if(v == sample4){
            new AndExAlertDialog.Builder(this)
                    .setPositiveBtnText("Change Profile")
                    .setNegativeBtnText("Remove")
                    .setImage(R.drawable.profile,80)
                    .setCancelableOnTouchOutside(true)
                    .OnPositiveClicked(new AndExAlertDialogListener() {
                        @Override
                        public void OnClick(String input) {
                            Toast.makeText(MainActivity.this, "Change Profile", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .OnNegativeClicked(new AndExAlertDialogListener() {
                        @Override
                        public void OnClick(String input) {
                            Toast.makeText(MainActivity.this, "Remove", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .build();
        }
        else if(v == sample5){
            new AndExAlertDialog.Builder(this)
                    .setMessage("آیا مایل به انجام این کار هستید؟")
                    .setPositiveBtnText("بله")
                    .setNegativeBtnText("خیر")
                    .setFont(Font.IRAN_SANS)
                    .setCancelableOnTouchOutside(true)
                    .OnPositiveClicked(new AndExAlertDialogListener() {
                        @Override
                        public void OnClick(String input) {
                            Toast.makeText(MainActivity.this, "بله", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .OnNegativeClicked(new AndExAlertDialogListener() {
                        @Override
                        public void OnClick(String input) {
                            Toast.makeText(MainActivity.this, "خیر", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .build();
        }
        else if(v == sample6){
            new AndExAlertDialog.Builder(this)
                    .setTitle("تایید حذف")
                    .setMessage("آیا مایل به حذف این فایل هستید؟")
                    .setPositiveBtnText("بله")
                    .setNegativeBtnText("خیر")
                    .setImage(R.drawable.delete,15)
                    .setFont(Font.IRAN_SANS)
                    .setCancelableOnTouchOutside(true)
                    .OnPositiveClicked(new AndExAlertDialogListener() {
                        @Override
                        public void OnClick(String input) {
                            Toast.makeText(MainActivity.this, "بله", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .OnNegativeClicked(new AndExAlertDialogListener() {
                        @Override
                        public void OnClick(String input) {
                            Toast.makeText(MainActivity.this, "خیر", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .build();
        }
        else if(v == sample7){
            new AndExAlertDialog.Builder(this)
                    .setTitle("ورود به سیستم")
                    .setMessage("برای ورود به سیستم لطفا رمز عبور خود را وارد کنید")
                    .setPositiveBtnText("تایید")
                    .setNegativeBtnText("لغو")
                    .setImage(R.drawable.password,20)
                    .setEditText(true,false, "رمز عبور",InputType.PASSWORD)
                    .setFont(Font.IRAN_SANS)
                    .setCancelableOnTouchOutside(true)
                    .OnPositiveClicked(new AndExAlertDialogListener() {
                        @Override
                        public void OnClick(String input) {
                            Toast.makeText(MainActivity.this, "شما " + input + " را تایپ کردید", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .OnNegativeClicked(new AndExAlertDialogListener() {
                        @Override
                        public void OnClick(String input) {
                            Toast.makeText(MainActivity.this, "شما " + input + " را تایپ کردید", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .build();
        }
    }
}
