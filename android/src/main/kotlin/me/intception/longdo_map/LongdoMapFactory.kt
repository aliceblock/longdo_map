package me.intception.longdo_map

import android.content.Context
import io.flutter.plugin.common.PluginRegistry
import io.flutter.plugin.common.StandardMessageCodec
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory

class LongdoMapFactory(private val registrar: PluginRegistry.Registrar) : PlatformViewFactory(StandardMessageCodec()) {
    override fun create(context: Context?, viewId: Int, args: Any?): PlatformView {
        return LongdoMap(registrar, viewId, args);
    }
}