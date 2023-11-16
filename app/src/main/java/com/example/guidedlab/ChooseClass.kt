package com.example.guidedlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckedTextView
import android.widget.RadioButton
import android.widget.RadioGroup

class ChooseClass : AppCompatActivity() {

    private var firstName: String? = ""
    private var lastName: String? = ""
    private var phone: String? = ""
    private var birthDate: String? = ""
    private var isDegreeCert: String? = ""
    private var degreeCertification: String? = ""

    private var ctv1: CheckedTextView? = null
    private var ctv2: CheckedTextView? = null
    private var ctv3: CheckedTextView? = null
    private var ctv4: CheckedTextView? = null

    private lateinit var rb1: RadioButton
    private var rb2: RadioButton? = null
    private var rb3: RadioButton? = null
    private var rb4: RadioButton? = null
    private var rb5: RadioButton? = null
    private var rb6: RadioButton? = null
    private var rb7: RadioButton? = null
    private var rb8: RadioButton? = null

    private var rg1: RadioGroup? = null
    private var rg2: RadioGroup? = null
    private var rg3: RadioGroup? = null
    private var rg4: RadioGroup? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_class)

        ctv1 = findViewById<CheckedTextView>(R.id.idCtvMad107)
        ctv2 = findViewById<CheckedTextView>(R.id.idCtvMad155)
        ctv3 = findViewById<CheckedTextView>(R.id.idCtvMad157)
        ctv4 = findViewById<CheckedTextView>(R.id.idCtvMad257)

        rb1 = findViewById<RadioButton>(R.id.idRb1)
        rb2 = findViewById<RadioButton>(R.id.idRb2)
        rb3 = findViewById<RadioButton>(R.id.idRb3)
        rb4 = findViewById<RadioButton>(R.id.idRb4)
        rb5 = findViewById<RadioButton>(R.id.idRb5)
        rb6 = findViewById<RadioButton>(R.id.idRb6)
        rb7 = findViewById<RadioButton>(R.id.idRb7)
        rb8 = findViewById<RadioButton>(R.id.idRb8)

        val btnNext = findViewById<Button> (R.id.idBtnChooseClassNext)

        val extras = intent.extras
        if(extras != null){
            firstName = extras.getString("FirstName")
            lastName = extras.getString("LastName")
            birthDate = extras.getString("DOB")
            isDegreeCert = extras.getString("isDegreeCert")
            degreeCertification = extras.getString("DegreeCert")
        }

        btnNext.setOnClickListener {
            var radioButton: RadioButton
            var ctv1Text = ""
            var ctv2Text = ""
            var ctv3Text = ""
            var ctv4Text = ""

            var radio1Text = ""
            var radio2Text = ""
            var radio3Text = ""
            var radio4Text = ""

            rg1 = findViewById<RadioGroup>(R.id.idRgMad107)
            rg2 = findViewById<RadioGroup>(R.id.idRgMad155)
            rg3 = findViewById<RadioGroup>(R.id.idRgMad157)
            rg4 = findViewById<RadioGroup>(R.id.idRGMad257)

            var selectedTime1 = 0
            var selectedTime2 = 0
            var selectedTime3 = 0
            var selectedTime4 = 0

            if (ctv1!!.isChecked){
                ctv1Text = ctv1!!.text.toString()
                selectedTime1 = rg1!!.checkedRadioButtonId
                radioButton = findViewById(selectedTime1)
                radio1Text = radioButton.text.toString()
            }
            if (ctv2!!.isChecked) {
                ctv2Text = ctv2!!.text.toString()
                selectedTime2 = rg2!!.checkedRadioButtonId
                radioButton = findViewById(selectedTime2)
                radio2Text = radioButton.text.toString()
            }
            if (ctv3!!.isChecked) {
                ctv3Text = ctv3!!.text.toString()
                selectedTime1 = rg3!!.checkedRadioButtonId
                radioButton = findViewById(selectedTime3)
                radio1Text = radioButton.text.toString()
            }
            if (ctv4!!.isChecked) {
                ctv1Text = ctv4!!.text.toString()
                selectedTime4 = rg4!!.checkedRadioButtonId
                radioButton = findViewById(selectedTime4)
                radio1Text = radioButton.text.toString()
            }
        }





    }
}