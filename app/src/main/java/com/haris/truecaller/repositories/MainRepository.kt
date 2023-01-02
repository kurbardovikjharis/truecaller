package com.haris.truecaller.repositories

interface MainRepository {

    suspend fun fetch(type: RequestType): String
}