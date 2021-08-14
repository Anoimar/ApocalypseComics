package com.thernat.ageofapocalypse.api

import com.thernat.ageofapocalypse.BuildConfig
import java.math.BigInteger
import java.security.MessageDigest

object ApiHashProvider {
    fun getHash(time: String) = BigInteger(1, MessageDigest.getInstance("MD5")
            .digest("${time}${BuildConfig.PRIVATE_KEY}${BuildConfig.API_KEY}"
                .toByteArray())).toString(16).padStart(32, '0')
}