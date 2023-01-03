package com.haris.truecaller.repositories

import com.haris.truecaller.data.RequestType

interface MainRepository {

    suspend fun fetch(type: RequestType): String
}