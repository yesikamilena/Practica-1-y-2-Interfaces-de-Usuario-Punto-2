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
            Log.d("saludito", "hola")
            Log.e("saludito2", "hola2")
            Log.i("saludito3", "hola3")

            /*  var email = signUpBinding.emailEditText.text.toString()
              var password = signUpBinding.passwordEditText.text.toString()
              var repPassword = signUpBinding.repPasswordEditText.text.toString()*/

            //var numero1 = signUpBinding.emailEditText.text.toString().toDouble()
            //var numero2 = signUpBinding.passwordEditText.text.toString().toDouble()
            //var suma = numero1 + numero2
            //var pot = Math.pow(numero1,numero2)
            //var raiz = Math.sqrt(numero1)
            //var raiz2= numero1.pow(numero1)

            //signUpBinding.repPasswordEditText.setText(raiz2.toString())

            val email = signUpBinding.emailEditText.text.toString()
            val password = signUpBinding.passwordEditText.text.toString()
            val reppassword = signUpBinding.repPasswordEditText.text.toString()
            val genre = if(signUpBinding.maleRadioButton.isChecked)
                "Masculino"
            else
                "Femenino"

           var favoritesGenre = ""
            if (signUpBinding.actionCheckBox.isChecked) favoritesGenre = "Acción"
            if (signUpBinding.adventureCheckBox.isChecked) favoritesGenre += "Aventura"
            if (signUpBinding.loveCheckBox.isChecked) favoritesGenre += "Romántico"
            if (signUpBinding.suspenceCheckBox.isChecked) favoritesGenre += "Suspenso"



            /* *************DatePicker************ */
            val year = signUpBinding.datePicker.year.toString()
            val month = signUpBinding.datePicker.month.toString()
            val day = signUpBinding.datePicker.dayOfMonth.toString()


            val city = signUpBinding.citiesSpinner.selectedItem.toString()


            val info = "Email: $email \nPassword: $password \nGenre: $genre \nFavorite Genre: $favoritesGenre \nYear: $year \nMonth: $month \nDay: $day \ncity: $city"


            if (password == reppassword)
                signUpBinding.infoTextView.text = info
            else{
                Toast.makeText(applicationContext,"Las contraseñas no son iguales",    Toast.LENGTH_LONG ).show()   //Opcion1. Mensaje en burbuja
                signUpBinding.repPasswordTextInputLayout.error= "Las contraseñas no son iguales"                         //Opcion2. Mensaje en rojo
                Snackbar.make(signUpBinding.LinearLayout, "las contraseñas no son iguales", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Aceptar"){
                        signUpBinding.repPasswordEditText.setText("")
                        signUpBinding.repPasswordTextInputLayout.isErrorEnabled= false
                    }
                    .show()   //Opción3. Mensaje de burbuja oscura
            }

        }
    }
}