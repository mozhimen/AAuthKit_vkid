package com.vk.id.internal.log

import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper

/**
 * [LogEngine] implementation that logs to Android's Logcat.
 */
internal class AndroidLogcatLogEngine : LogEngine {
    override fun log(
        logLevel: LogEngine.LogLevel,
        tag: String,
        message: String,
        throwable: Throwable?
    ) {
        when (logLevel) {
            LogEngine.LogLevel.INFO -> UtilKLogWrapper.i(tag, message)
            LogEngine.LogLevel.DEBUG -> UtilKLogWrapper.d(tag, message)
            LogEngine.LogLevel.ERROR -> UtilKLogWrapper.e(tag, message, throwable)
        }
    }
}
