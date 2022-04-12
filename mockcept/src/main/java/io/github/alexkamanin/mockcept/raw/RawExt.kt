package io.github.alexkamanin.mockcept.raw

import android.content.Context
import android.content.res.Resources
import androidx.annotation.RawRes
import java.io.Reader

internal fun Context.json(@RawRes res: Int): String =
    resources.json(res)

private fun Resources.json(@RawRes res: Int): String =
    openRawResource(res)
        .bufferedReader()
        .use(Reader::readText)