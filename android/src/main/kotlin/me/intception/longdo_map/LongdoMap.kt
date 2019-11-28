package me.intception.longdo_map

import android.view.View
import android.widget.Toast
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.PluginRegistry
import io.flutter.plugin.platform.PlatformView
import com.longdo.api.MapGLSurfaceView

class LongdoMap(private val registrar: PluginRegistry.Registrar, viewId: Int, args: Any?) : PlatformView, MethodChannel.MethodCallHandler {
    private val channel = MethodChannel(registrar.messenger(), "me.intception.longdo_map/$viewId")
    private val longdoMap = getLongdoMap(registrar)

    init {
        channel.setMethodCallHandler(this)
    }

    private fun getLongdoMap(registrar: PluginRegistry.Registrar): MapGLSurfaceView {
        return MapGLSurfaceView(registrar.context())
    }

    override fun getView(): View {
        return longdoMap
    }

    override fun dispose() {
        
    }

    override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
        when (call.arguments) {
            "doSomething" -> {
                Toast.makeText(registrar.context(), "Do something", Toast.LENGTH_LONG)
            }
            else -> result.notImplemented()
        }
    }
}