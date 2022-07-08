package com.example.basketballcounterapplication

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    var countA by mutableStateOf(0)
    var countB by mutableStateOf(0)
    fun inc(team: Int, toInc: Int){
        if(team>0){
            countB+=toInc
        }else
            countA+=toInc
    }

}