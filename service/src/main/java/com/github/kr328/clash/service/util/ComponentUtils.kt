package com.github.kr328.clash.service.util

import android.content.ComponentName
import android.content.Intent
import com.github.kr328.clash.core.Global
import kotlin.reflect.KClass

val KClass<*>.componentName: ComponentName
    get() = ComponentName.createRelative(Global.application, this.java.name)

val KClass<*>.intent: Intent
    get() = Intent(Global.application, this.java)
