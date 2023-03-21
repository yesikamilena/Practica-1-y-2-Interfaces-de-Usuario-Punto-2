package com.yesikamilenacarvajal.misseriesapp.ui.signup

import android.app.Activity
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.google.android.material.snackbar.Snackbar
import com.yesikamilenacarvajal.misseriesapp.R
import com.yesikamilenacarvajal.misseriesapp.databinding.ActivitySignUpBinding
import kotlin.math.pow
import androidx.fragment.app.DialogFragment
import java.text.DateFormat
import java.util.*



class SignUpActivity : AppCompatActivity() {


    private lateinit var signUpBinding: ActivitySignUpBinding


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        signUpBinding = ActivitySignUpBinding.inflate(layoutInflater)
        var view = signUpBinding.root
        setContentView(view)


        /* *******************Spinner************ */
        //Se pone acá porque se tiene que modificar sin presionar antes el botón de guardar
        val spinner: Spinner = findViewById(R.id.cities_spinner)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.combo_cities,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        signUpBinding.registerButton.setOnClickListener {

            val name = signUpBinding.nameEditText.text.toString()
            val email = signUpBinding.emailEditText.text.toString()
            val password = signUpBinding.passwordEditText.text.toString()
            val repassword = signUpBinding.repPasswordEditText.text.toString()

            if (name == "" || email == "" || password == "" || repassword == "") {
                if (name == "") signUpBinding.nameEditText.error = "Campo obligatorio."
                if (email == "") signUpBinding.emailEditText.error = "Campo obligatorio."
                if (password == "") signUpBinding.passwordEditText.error = "Campo obligatorio."
                if (repassword == "") signUpBinding.repPasswordEditText.error = "Campo obligatorio."
            }
            else if (password == repassword)    {
                val genre = if(signUpBinding.maleRadioButton.isChecked)
                    "Masculino"
                else
                    "Femenino"

                var favoritesGenre = ""
                if (signUpBinding.musicCheckBox.isChecked) favoritesGenre = "Music "
                if (signUpBinding.sportsCheckBox.isChecked) favoritesGenre += "Sports "
                if (signUpBinding.readingCheckBox.isChecked) favoritesGenre += "Reading "
                if (signUpBinding.watchingMoviesCheckBox.isChecked) favoritesGenre += "Watching movies "


                /* *************DatePicker************ */
                val year = signUpBinding.datePicker.year.toString()
                var month = signUpBinding.datePicker.month.toString()
                val day = signUpBinding.datePicker.dayOfMonth.toString()

                /* *************Spinner************ */
                val city = signUpBinding.citiesSpinner.selectedItem.toString()
                
                var month2=(month.toInt()+1).toString();


                val info = "Email: $email \nPassword: $password \nGenre: $genre \nFavorite Genre: $favoritesGenre \nYear: $year \nMonth: $month2 \nDay: $day \ncity: $city"

                signUpBinding.infoTextView.text = info
            }

            else {
               signUpBinding.repPasswordTextInputLayout.error =
                    "Las contraseñas no son iguales"                         //Opcion2. Mensaje en rojo
                Snackbar.make(
                    signUpBinding.LinearLayout,
                    "las contraseñas no son iguales",
                    Snackbar.LENGTH_INDEFINITE
                )
                    .setAction("Aceptar") {
                        signUpBinding.repPasswordEditText.setText("")
                        signUpBinding.repPasswordTextInputLayout.isErrorEnabled = false
                    }
                    .show()   //Opción3. Mensaje de burbuja oscura
            }
        }
    }
}