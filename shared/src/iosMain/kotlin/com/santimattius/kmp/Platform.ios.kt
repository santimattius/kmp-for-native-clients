package com.santimattius.kmp

import platform.UIKit.UIDevice
import platform.darwin.NSObject

class IOSPlatform : Platform {
    override val name: String =
        UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()