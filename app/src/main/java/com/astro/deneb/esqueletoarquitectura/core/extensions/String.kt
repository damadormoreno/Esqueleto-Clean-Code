package com.astro.deneb.esqueletoarquitectura.core.extensions

import java.util.regex.Pattern

fun String.extractYTId(): String? {
    var vId: String? = null
    val pattern = Pattern.compile(
        "^https?://.*(?:youtu.be/|v/|u/\\w/|embed/|watch?v=)([^#&?]*).*$",
        Pattern.CASE_INSENSITIVE
    )
    val matcher = pattern.matcher(this)
    if (matcher.matches()) {
        vId = matcher.group(1)
    }
    return vId
}