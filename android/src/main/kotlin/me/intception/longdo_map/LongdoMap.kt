package me.intception.longdo_map

import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.longdo.api.Map
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.PluginRegistry
import io.flutter.plugin.platform.PlatformView
import com.longdo.api.MapGLSurfaceView
import io.flutter.plugin.common.StandardMessageCodec

class LongdoMap(private val registrar: PluginRegistry.Registrar, viewId: Int, args: Any?) : PlatformView, MethodChannel.MethodCallHandler {
    private val channel = MethodChannel(registrar.messenger(), "me.intception.longdo_map/$viewId")
    private lateinit var longdoMap: Map
    private val mapView = getLongdoMap(registrar)

    init {
        channel.setMethodCallHandler(this)
    }

    private fun getLongdoMap(registrar: PluginRegistry.Registrar): MapGLSurfaceView {
        return MapGLSurfaceView(registrar.context()).also { it.setListener { longdoMap = it } }
    }

    override fun getView(): View {
        return mapView
    }

    override fun dispose() {
        
    }

    override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
        when (call.method) {
//            "goToCurrentLocation" -> {
//                longdoMap.updateAndShowCurrentLocation()
//            }
            "zoomIn" -> {
                longdoMap.zoomIn()
            }
            "zoomOut" -> {
                longdoMap.zoomOut()
            }
            else -> result.notImplemented()
        }
    }
}