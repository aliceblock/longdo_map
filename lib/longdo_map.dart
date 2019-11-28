import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';
import 'package:flutter/widgets.dart';

typedef LongdoMapCreated(LongdoMapController controller);

class LongdoMapController {
  MethodChannel _channel;

  LongdoMapController(int id) {
    _channel = MethodChannel("me.intception.longdo_map/$id");
  }

  doSomething() {
    _channel.invokeMethod("doSomething");
  }
}

class LongdoMap extends StatefulWidget {
  LongdoMapCreated onCreated;

  LongdoMap({
    Key key,
    this.onCreated,
  });

  @override
  _LongdoMapState createState() => _LongdoMapState();
}

class _LongdoMapState extends State<LongdoMap> {
  _onPlatformViewCreated(int id) {
    if (widget.onCreated == null) {
      return;
    }
    widget.onCreated(LongdoMapController(id));
  }

  @override
  Widget build(BuildContext context) {
    switch (defaultTargetPlatform) {
      case TargetPlatform.android:
        return AndroidView(
          viewType: "me.intception.longdo_map",
          onPlatformViewCreated: _onPlatformViewCreated,
        );
      default:
        return Text("$defaultTargetPlatform is not supported");
    }
  }
}
