package com.example.walmart

import java.io.Serializable
class User(fname: String, lName: String, uName: String, uPassword: String) : Serializable{
    var firstName: String = fname
    var lastName: String = lName
    var userName: String = uName
    var password: String = uPassword

}


