package com.example.instadev.view.auth.login


import android.util.Log
import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instadev.domain.entity.UserEntity
import com.example.instadev.domain.usecase.Login
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(val login: Login): ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState()) //se puede modificar
    //no se puede  modificar y lo escuchan los composables
    //se actualiza cuando actualizo _uiState
    val uiState: StateFlow<LoginUiState>  = _uiState

    fun onEmailChange(email: String) {
        //el objeto no se puede modificar
        //update me devuelve el objeto, hacemos una copia
        //y cambiamos lo que deseamos cambiar
        _uiState.update{ state ->
            state.copy(email = email)
        }
        verifyLogin()
    }

    fun onPasswordChange(password: String) {
        _uiState.update{ state ->
            state.copy(password = password)
        }
        verifyLogin()
    }

    fun onClickSelected() {
        //las corrutinas permiten mandar tareas asincronas  y que nos avise cuando finalizan
        //si dispara en el io para que no corra el el main que es la ui y entonces bloquearia la app hasta q termine
        viewModelScope.launch(Dispatchers.IO,) {
            val response: UserEntity? = login(_uiState.value.email, _uiState.value.password)

            //si vamos a hacer algo en la ui tenemos que hacerlo en el hilo principal
            withContext(Dispatchers.Main) {
                if(response != null) {
                    Log.i("login","success ${response.name}")
                }else{
                    Log.i("login","unsuccess")
                }
            }
        }
    }


    private fun verifyLogin() {
        val enabledLogin: Boolean =
            isEmailValid(uiState.value.email) && isPasswordValid(uiState.value.password)
        _uiState.update {
            it.copy(isLoginEnabled = enabledLogin)
        }
    }

    private fun isEmailValid(email:String):Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun isPasswordValid(password: String):Boolean = password.length >= 6
}

data class LoginUiState(
    val email:String = "rrufino71@gmail.com",
    val password:String = "123456789",
    val isLoading:Boolean = false,
    val isLoginEnabled: Boolean = false
)
