package com.yesikamilenacarvajal.misseriesapp.ui.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {

    val namevacio: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val emailvacio: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val passwordvacio: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val repasswordvacio: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val passnoigual: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val info1: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun revisarvacios(name:String, email:String, password:String, repassword:String){
        if (name == "" || email == "" || password == "" || repassword == "") {
            if (name == "") namevacio.value = 1;
            if (email == "") emailvacio.value = 1;
            if (password == "") passwordvacio.value = 1;
            if (repassword == "") repasswordvacio.value = 1;
        }
        else if (password == repassword) {
            info1.value = "Name: $name \nEmail: $email \nPassword: $password";
                //"Email: $email \nPassword: $password"
        }
        else passnoigual.value=1;
    }
}