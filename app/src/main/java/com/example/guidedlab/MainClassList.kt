package com.example.guidedlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Switch
import android.widget.TextView
import org.w3c.dom.Text

class MainClassList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_class_list)

        val swDegreeCert = findViewById<Switch>(R.id.idSwDegreeCert)
        val spnDegree = findViewById<Spinner>(R.id.idSpnrMajor)
        val spnCertificate = findViewById<Spinner>(R.id.idSpnrCert)
        val txtCertificate = findViewById<TextView>(R.id.idTxtCertSpnrLabel)
        val txtDegree = findViewById<TextView>(R.id.idTxtMajorSpnrLabel)
        val btnNext = findViewById<Button>(R.id.idBtnNext)

        val firstName = findViewById<EditText>(R.id.idEdtTxtFirstName)
        val lastName = findViewById<EditText>(R.id.idEdtTxtLastName)
        val phone = findViewById<EditText>(R.id.idEdtTxtPhoneNumber)
        val spMonth = findViewById<Spinner>(R.id.idSpnrMonth)
        val txtDay =  findViewById<EditText>(R.id.idEdtTxtDay)
        val txtYear = findViewById<EditText>(R.id.idEdtTxtYear)

        firstName.requestFocus()

        swDegreeCert.setOnCheckedChangeListener {buttonView, isChecked ->
            if (isChecked){
                spnDegree.visibility = View.VISIBLE
                txtDegree.visibility = View.VISIBLE
                spnCertificate.visibility = View.GONE
                txtCertificate.visibility = View.GONE

            }else {
                spnCertificate.visibility = View.VISIBLE
                txtCertificate.visibility = View.VISIBLE
                spnDegree.visibility = View.GONE
                txtDegree.visibility = View.GONE

            }

        }

        btnNext.setOnClickListener {
            if(checkData()){
                var doBirth = ""
                doBirth = spMonth.selectedItem.toString() + "/" + txtDay.text.toString() + "/" + txtYear.text.toString()
                val nextScreen = Intent(this@MainClassList, ChooseClass::class.java)
                nextScreen.putExtra("First Name", firstName.text.toString())
                nextScreen.putExtra("Last Name", lastName.text.toString())
                nextScreen.putExtra("Phone", phone.text.toString())
                nextScreen.putExtra("DOB", doBirth)

                if (spnDegree.visibility == View.VISIBLE){
                    nextScreen.putExtra("isDegreeCert", "Degree")
                    nextScreen.putExtra("degreeCert", spnDegree.selectedItem.toString())
                }else{
                    nextScreen.putExtra("isDegreeCert", "Certificate")
                    nextScreen.putExtra("degreeCert", spnCertificate.selectedItem.toString())
                }

                // start activity
                startActivity(nextScreen)
            }
        }
    }
    private fun checkData(): Boolean {
        val firstName = findViewById<EditText>(R.id.idEdtTxtFirstName)
        val lastName = findViewById<EditText>(R.id.idEdtTxtLastName)
        val phone = findViewById<EditText>(R.id.idEdtTxtPhoneNumber)
        val txtDay =  findViewById<EditText>(R.id.idEdtTxtDay)
        val txtYear = findViewById<EditText>(R.id.idEdtTxtYear)

        if (firstName.text.toString().isEmpty()){
            firstName.error = "First Name cannot be blank"
            firstName.requestFocus()
            return false
        }
        if (lastName.text.toString().isEmpty()){
            lastName.error = "First name cannot be blank"
            lastName.requestFocus()
            return false
        }
        if (firstName.text.toString().isEmpty()){
            firstName.error = "Last name cannot be blank"
            firstName.requestFocus()
            return false
        }
        if (phone.text.toString().isEmpty()) {
            phone.error = "Phone number cannot be blank"
            phone.requestFocus()
            return false
        }
        if (txtDay.text.toString().isEmpty()) {
            txtDay.error = "Day cannot be blank"
            txtDay.requestFocus()
            return false
        }
        if (txtYear.text.toString().isEmpty()) {
            txtYear.error = "Year cannot be blank"
            txtYear.requestFocus()
            return false
        }

        return true
    }
}