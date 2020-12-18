package io.realworld.android

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.realworld.android.data.UserRepo
import io.realworld.api.models.entities.User
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    private val _user = MutableLiveData<User?>()
    val user: LiveData<User?> = _user

    fun getCurrentUser(token: String) = viewModelScope.launch {
        UserRepo.getCurrentUser(token)?.let {
            _user.postValue(it)
        }
    }

    fun login(email: String, password: String) = viewModelScope.launch {
        UserRepo.login(email, password)?.let {
            _user.postValue(it)
        }
    }

    fun signup(username: String, email: String, password: String) = viewModelScope.launch {
        UserRepo.signup(username, email, password)?.let {
            _user.postValue(it)
        }
    }

    fun logout() {
        _user.postValue(null)
    }

    fun update(
        bio: String?,
        username: String?,
        image: String?,
        email: String?,
        password: String?
    ) = viewModelScope.launch {
        UserRepo.updateUser(bio, username, image, email, password)?.let {
            _user.postValue(it)
        }
    }
}