package com.example.desapp

import android.util.Base64
import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException
import javax.crypto.BadPaddingException
import javax.crypto.Cipher
import javax.crypto.IllegalBlockSizeException
import javax.crypto.NoSuchPaddingException
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

object DESHelper {

    private const val ALGORITHM = "DES"

    @Throws(NoSuchAlgorithmException::class, NoSuchPaddingException::class, InvalidKeyException::class,
        IllegalBlockSizeException::class, BadPaddingException::class)
    fun encrypt(input: String, key: String): String {
        val cipher = Cipher.getInstance(ALGORITHM)
        cipher.init(Cipher.ENCRYPT_MODE, getKey(key))
        val encryptedBytes = cipher.doFinal(input.toByteArray())
        return Base64.encodeToString(encryptedBytes, Base64.DEFAULT)
    }

    @Throws(NoSuchAlgorithmException::class, NoSuchPaddingException::class, InvalidKeyException::class,
        IllegalBlockSizeException::class, BadPaddingException::class)
    fun decrypt(input: String, key: String): String {
        val cipher = Cipher.getInstance(ALGORITHM)
        cipher.init(Cipher.DECRYPT_MODE, getKey(key))
        val decryptedBytes = cipher.doFinal(Base64.decode(input, Base64.DEFAULT))
        return String(decryptedBytes)
    }

    private fun getKey(key: String): SecretKey {
        val keyBytes = key.toByteArray().copyOf(8)
        return SecretKeySpec(keyBytes, ALGORITHM)
    }
}