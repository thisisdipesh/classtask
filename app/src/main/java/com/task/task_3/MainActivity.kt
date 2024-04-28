package com.task.task_3

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.task.task_3.ui.theme.Task3Theme
import java.text.SimpleDateFormat
import java.util.Calendar


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var i = 0;
        super.onCreate(savedInstanceState)
        var view=   setContentView(R.layout.mainactivity);
        findViewById<TextView>(R.id.textView).setText("Task - 3")
        var radioGrouping =findViewById<RadioGroup>(R.id.radioGroup)
        var button =findViewById<Button>(R.id.button)
        var changeImageButton =findViewById<Button>(R.id.imagebutton)
        findViewById<ImageView>(R.id.imageView).setImageResource(R.drawable.coke)
        val autotextView
                = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        val dataList
                = listOf("one", "two", "three", "four")
        val adapter
                = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, dataList)
        autotextView.setAdapter(adapter)
        autotextView.threshold=1

        changeImageButton.setOnClickListener {
           i=(i+1)%2;
           if(i == 0){
               findViewById<ImageView>(R.id.imageView).setImageResource(R.drawable.coke)
           }
            else {
               findViewById<ImageView>(R.id.imageView).setImageResource(R.drawable.sign)
           }
        };
        button.setOnClickListener {
            Log.e("dssd",radioGrouping.checkedRadioButtonId.toString());
            when (radioGrouping.checkedRadioButtonId) {
                R.id.radioButton -> {
openDatePicker();
                }

                R.id.radioButton2 -> {
                    openTimePicker();
                }

                R.id.radioButton3 -> {
                    showToast();
                }

                R.id.radioButton4 -> {
                    openAlertDialog();
                }

                R.id.radioButton5 -> {
                    showSnackbar();
                }

                else -> {
                }
            }

        }
    }

    fun openTimePicker() {
        var hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        var min = Calendar.getInstance().get(Calendar.MINUTE);
        val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
         }
        var dialog =TimePickerDialog(this,timeSetListener,hour,min,false );
        dialog.show();
    }
    fun openDatePicker() {
        var  calendar = Calendar.getInstance();
        val datePickerDialog = DatePickerDialog(
            this, {DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                  },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        // Show the DatePicker dialog
        datePickerDialog.show()
    }
    fun openAlertDialog() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.apply {
            setTitle("Success")
            setMessage("Alert has been shown")
        }.create().show()
    }

    fun showToast() {
        Toast.makeText(this, "Toast has been called", Toast.LENGTH_LONG).show();
    }
    fun showSnackbar() {
        Toast.makeText(this, "Toast has been called", Toast.LENGTH_LONG);
    }
}
