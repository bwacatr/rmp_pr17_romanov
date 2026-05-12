package com.bignerdranch.android.prakt17_3_romanov

import java.util.Date
import java.util.UUID


data class Crime(var name:String = "", var status: Boolean = false, val id: UUID = UUID.randomUUID(),val date:Date = Date())

