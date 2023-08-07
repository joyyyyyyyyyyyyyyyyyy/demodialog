package sg.edu.rp.c346.id22022096.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnDemo1, btnDemo2, btnDemo3, btnex3, btnDemo4, btnDemo5;
    TextView tvDemo2, tvDemo3, tvex3, tvDemo4, tvDemo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1 = findViewById(R.id.btnDemo1);
        btnDemo2 = findViewById(R.id.btnDemo2);
        btnDemo3 = findViewById(R.id.btnDemo3);
        btnex3 = findViewById(R.id.btnex3);
        btnDemo4 = findViewById(R.id.btnDemo4);
        btnDemo5 = findViewById(R.id.btnDemo5);
        tvDemo2 = findViewById(R.id.tvDemo2);
        tvDemo3 = findViewById(R.id.tVDemo3);
        tvex3 = findViewById(R.id.tvex3);
        tvDemo4 = findViewById(R.id.tvDemo4);
        tvDemo5 = findViewById(R.id.tvDemo5);

        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //create dialog builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                //set the dialog details
                /*
                //set the title displayed in dialog
                myBuilder.setTitle("Demo 1 - Simple Dialog");
                //set the msg to display
                myBuilder.setMessage("i can develop android app");
                myBuilder.setCancelable(false);
                //set listener to be invoked when positive button of dialog is pressed
                myBuilder.setPositiveButton("close", null);
                 */

                //set the title displayed in dialog
                myBuilder.setTitle("Congratulations");
                //set the msg to display
                myBuilder.setMessage("You have completed a simple Dialog Box");
                myBuilder.setCancelable(false);
                //set listener to be invoked when positive button of dialog is pressed
                myBuilder.setPositiveButton("DISMISS", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //create dialog builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                //set the title displayed in dialog
                myBuilder.setTitle("Demo 2 Button Dialog");
                //set the msg to display
                myBuilder.setMessage("Select one of the Buttons below");
                myBuilder.setCancelable(false);

                //configure the button
                myBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("you have selected positive");
                    }
                });

                myBuilder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("you have selected negative");
                    }
                });

                //configure the 'neutral' button
                myBuilder.setNeutralButton("cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });

        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //inflate input.xml ayout file
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);

                //obtain UI component in the input.xml layout
                //needs to be defined as "final", so that it can used in the onClick() method later
                final EditText etInput = viewDialog.findViewById(R.id.etInput);

                //create dialog builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);  // Set the view of the dialog
                //set the title displayed in dialog
                myBuilder.setTitle("Demo 3-Text Input Dialog");
                //set listener to be invoked when positive button of dialog is pressed
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Extract the text entered by the user
                        String message = etInput.getText().toString();
                        // Set the text to the TextView
                        tvDemo3.setText(message);
                    }
                });
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });

        btnex3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //inflate ex3.xml layout file
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.ex3, null);

                //obtain UI components in the ex3.xml layout
                //needs to be defined as "final", so that they can be used in the onClick() method later
                final EditText etInput1 = viewDialog.findViewById(R.id.etInput1);
                final EditText etInput2 = viewDialog.findViewById(R.id.etInput2);

                //create dialog builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);  // Set the view of the dialog
                //set the title displayed in the dialog
                myBuilder.setTitle("Exercise 3");
                //set listener to be invoked when the positive button of the dialog is pressed
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Extract the numbers entered by the user
                        String num1Str = etInput1.getText().toString();
                        String num2Str = etInput2.getText().toString();

                        if (!num1Str.isEmpty() && !num2Str.isEmpty()) {
                            int num1 = Integer.parseInt(num1Str);
                            int num2 = Integer.parseInt(num2Str);

                            // Calculate the sum
                            int sum = num1 + num2;

                            // Show the result in the TextView
                            TextView tvex3 = findViewById(R.id.tvex3);
                            tvex3.setText("the sum is : " + sum);
                        }
                    }
                });
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create the listener to set the date
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvDemo4.setText("Date: " + dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
                    }
                };

                // create the date picker dialog to show the current date when it first appears
                Calendar now = Calendar.getInstance();
                int year = now.get(Calendar.YEAR);
                int month = now.get(Calendar.MONTH);
                int day = now.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,
                        myDateListener, year, month, day);
                myDateDialog.show();
            }
        });

        btnDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create the listener to set the time
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvDemo5.setText("Time: " + hourOfDay + ":" + minute);
                    }
                };

                //create the time picker dialog
                Calendar now = Calendar.getInstance();
                int hourOfDay = now.get(Calendar.HOUR_OF_DAY);  // Current Hour
                int minute = now.get(Calendar.MINUTE);  // Current Minute
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,
                        myTimeListener, hourOfDay, minute, false);
                myTimeDialog.show();
            }
        });

    }
}