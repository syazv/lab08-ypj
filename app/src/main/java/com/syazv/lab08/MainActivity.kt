package com.syazv.lab08

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import com.syazv.lab08.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val pizzaSizes = arrayOf("Please Select Size","Small","Medium",
        "Large","Extra Large")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


       binding.sizeSeekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {

           // Bila seekbar bergerak/berubah nilai
           override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
               binding.sizeTextView.text = pizzaSizes[progress]
           }
            // Bila seekbar mula ditekan
           override fun onStartTrackingTouch(seekBar: SeekBar?) {
               binding.sizeTextView.text = "Seekbar mula ditekan"
           }
            // Bila seekbar habis ditekan (padam TO-DO kalau tidak diperlukan)
           override fun onStopTrackingTouch(seekBar: SeekBar?) {

           }
       })

        binding.dateBtn.setOnClickListener {
            val c = Calendar.getInstance()
            val day = c.get(Calendar.DAY_OF_MONTH)
            val month = c.get(Calendar.MONTH)
            val year = c.get(Calendar.YEAR)

            val myDatePicker =
                DatePickerDialog(this,android.R.style.ThemeOverlay,
                    DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                        binding.dateTextView.text = "$dayOfMonth/${month+1}/$year" },
                    year,
                    month,
                    day
                )
            myDatePicker.show()
        }

        binding.timeBtn.setOnClickListener {
            val c = Calendar.getInstance ()
            val hour = c.get (Calendar.HOUR_OF_DAY)
            val minutes =c.get (Calendar. MINUTE)

            val myTimePicker = TimePickerDialog (this,
                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                    val hourFormatted = String.format("%02d", hourOfDay)
                    val minuteFormatted = String.format("%02d", minute)
                    binding.timeTextView.text = "$hourFormatted:$minuteFormatted" },
            hour,
            minutes,
                true)

            myTimePicker.show()
        }

        binding.scheduleBtn.setOnClickListener {
            var intent = Intent( this, ThanksActivity::class.java)
            intent.putExtra("name", binding.nameEditText.text.toString())
            intent.putExtra("phone", binding.phoneEditText.text.toString())
            intent.putExtra("size", binding.sizeTextView.text.toString())
            intent.putExtra("date", binding.dateTextView.text.toString())
            intent.putExtra("time", binding.timeTextView.text.toString())

            startActivity(intent)
        }


    }
}