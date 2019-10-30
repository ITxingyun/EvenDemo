package com.xingyun.evendemo.mvvm

class FriendWebsite(val data: List<Website>, val errorCode: Int, val errorMsg: String)

class Website(val icon: String, val id: Int, val link: String, val name: String, val order: Int, val visible: Int)