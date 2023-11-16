package com.example.guidedlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Summary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        val extras = intent.extras
        if (extras != null){
            var firstName = extras.getString("FirstName")
            var lastName = extras.getString("LastName")
            var phone = extras.getString("Phone")
            var birthDate = extras.getString("DOB")
            var isDegreeCert = extras.getString("isDegreeCert")
            var degreeCert = extras.getString("degreeCertification")
            var class1 = extras.getString("Class1")
            var selected = extras.getString("Selected1")
            var class2 = extras.getString("Class2")
            var selected2 = extras.getString("Selected2")
            var class3 = extras.getString("Class3")
            var selected3 = extras.getString("Selected3")
            var class4 = extras.getString("Class4")
            var selected4 = extras.getString("Selectod4")

            val txtStudent = findViewById<TextView>(R.id.idTxtStudent)
            val txtPhone = findViewById<TextView>(R.id.idTxtPhone)
            val txtBirthDate = findViewById<TextView>(R.id.idTxtBirth)
            val txtDegreePlan = findViewById<TextView>(R.id.idTxtDegreePlan)
            val extMajor = findViewById<TextView>(R.id.idTxtMajor)
            val txtClassSchedule = findViewById<TextView>(R.id.idMlTxtClassSchedule)
        }
    }
}