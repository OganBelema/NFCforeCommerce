package com.oganbelema.nfcforecommerce.util

object Util {

    fun byteArrayToHexString(byteArray: ByteArray?) : String {
        if (byteArray != null){
            return byteArray.joinToString("") {
                java.lang.String.format("%02x", it)
            }
        }
        return ""
    }
}