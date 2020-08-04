package sg.edu.rp.c346.id19047433.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
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
    Button btnDemo1, btnDemo2, btnDemo3, btnExercise3, btnDemo4, btnDemo5;
    TextView tvDemo2, tvDemo3, tvExercise3, tvDemo4, tvDemo5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDemo1 = findViewById(R.id.buttonDemo1);
        btnDemo2 = findViewById(R.id.buttonDemo2);
        tvDemo2 = findViewById(R.id.textViewDemo2);
        btnDemo3 = findViewById(R.id.buttonDemo3);
        tvDemo3 = findViewById(R.id.textVewDemo3);
        btnExercise3 = findViewById(R.id.buttonExercise3);
        tvExercise3 = findViewById(R.id.textViewExercise3);
        btnDemo4 = findViewById(R.id.buttonDemo4);
        tvDemo4 = findViewById(R.id.textViewDemo4);
        btnDemo5 = findViewById(R.id.buttonDemo5);
        tvDemo5 = findViewById(R.id.textViewDemo5);

        //Button Demo 1
        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the Dialog Builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                /*
                //Set the dialog details
                myBuilder.setTitle("Demo 1-Simple Dialog");
                myBuilder.setMessage("I can develop Android App.");
                //.setCancelable : True allow cancelling the dialog by clicking anywhere
                //.setCancelable : False force user to click on specific place to cancel dialog
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Close", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
                 */

                //Set the dialog details
                myBuilder.setTitle("Congratulations");
                myBuilder.setMessage("You have complete a simple dialog box");
                //.setCancelable : True allow cancelling the dialog by clicking anywhere
                //.setCancelable : False force user to click on specific place to cancel dialog
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("DISMISS", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        //Button Demo 2
        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setTitle("Demo 2 Button Dialog");
                myBuilder.setMessage("Select one of the buttons below.");
                myBuilder.setCancelable(false);

                //Configure the 'positive' Button
                myBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Positive");
                    }
                });

                //Configure the 'Negative' Button
                myBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Negative");
                    }
                });

                //Configure the 'Neutral' Button
                myBuilder.setNeutralButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }

        });

        //Button Demo 3
        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Inflate the input.xml layout file
                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);

                //Obtain the UI Component in the input.xml layout
                // It needs to be defined as "Final", so that it can be used in the onclick() method later
                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);

                //Create Dialog
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                //Set the dialog view with the view from input.xml
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Demo 3 Text Input Dialog");
                //Configure Positive Button
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Extract the text entered by the user
                        String message = etInput.getText().toString();
                        //Set the text in textView
                        tvDemo3.setText(message);
                    }
                });

                //Configure Negative Button
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        //Button Exercise 3
        btnExercise3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Inflate the input.xml layout file
                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.inputexecrise3, null);
                //Obtain the UI Component in the inputExercise3.xml layout
                // It needs to be defined as "Final", so that it can be used in the onclick() method later
                final EditText etNumber1 = viewDialog.findViewById(R.id.editTextNumber1);
                final  EditText etNumber2 = viewDialog.findViewById(R.id.editTextNumber2);
                //Create Dialog
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                //Set the dialog view with the view from input.xml
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Exercise 3");
                //Configure Positive Button
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Extract the text entered by the user
                        int number1 = Integer.parseInt(etNumber1.getText().toString());
                        int number2 = Integer.parseInt(etNumber2.getText().toString());
                        int sum = number1 + number2;
                        //Set the text in textView
                        tvExercise3.setText("The sum is " + sum);
                    }
                });

                //Configure Negative Button
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        //Button Demo 4
        btnDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvDemo4.setText("Date: " + dayOfMonth + "/" + (month+1) + "/" + year);
                    }
                };
                //Create the Date Picker Dialog
                //Why month is 11 but output is dec(12) cause jan is (0) so that why dec is 11 here
                Calendar now = Calendar.getInstance();
                int year = now.get(Calendar.YEAR);
                int month = now.get(Calendar.MONTH);
                int day = now.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this, myDateListener, year, month, day);
                myDateDialog.show();
            }
        });

        //Button Demo 5
        btnDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create Time Listener to set the time
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvDemo5.setText("Time: " + hourOfDay + ":" + minute);

                    }
                };
                //Create the TimePicker Dialog
                Calendar now = Calendar.getInstance();
                int hour = now.get(Calendar.HOUR);
                int min = now.get(Calendar.MINUTE);
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this, myTimeListener, hour, min, false);
                myTimeDialog.show();
            }
        });
    }
}
