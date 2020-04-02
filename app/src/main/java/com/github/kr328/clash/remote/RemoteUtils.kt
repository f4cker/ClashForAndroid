package com.github.kr328.clash.remote

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.github.kr328.clash.ApkBrokenActivity
import com.github.kr328.clash.service.Constants
import com.github.kr328.clash.service.ServiceStatusProvider
import com.github.kr328.clash.service.util.intent

object RemoteUtils {
    fun detectClashRunning(context: Context): Boolean {
        try {
            val authority = Uri.Builder()
                .scheme("content")
                .authority("${context.packageName}${Constants.STATUS_PROVIDER_SUFFIX}")
                .build()

            val pong = context.contentResolver.call(
                authority,
                ServiceStatusProvider.METHOD_PING_CLASH_SERVICE,
                null,
                null
            )

            return pong != null
        } catch (e: IllegalArgumentException) {
            context.startActivity(ApkBrokenActivity::class.intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))

            return false
        }
    }

    fun getCurrentClashProfileName(context: Context): String? {
        try {
            val authority = Uri.Builder()
                .scheme("content")
                .authority("${context.packageName}${Constants.STATUS_PROVIDER_SUFFIX}")
                .build()

            val pong = context.contentResolver.call(
                authority,
                ServiceStatusProvider.METHOD_PING_CLASH_SERVICE,
                null,
                null
            )

            return pong?.getString("name")
        } catch (e: IllegalArgumentException) {
            context.startActivity(ApkBrokenActivity::class.intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))

            return null
        }
    }
}