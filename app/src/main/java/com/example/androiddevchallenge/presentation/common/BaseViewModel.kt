package com.example.androiddevchallenge.presentation.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseViewModel : ViewModel()

object EmptyViewModel : BaseViewModel()

sealed class ViewModelProviderFactory : ViewModelProvider.Factory {
    abstract val model: BaseViewModel

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(model::class.java)) {
            return model as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}