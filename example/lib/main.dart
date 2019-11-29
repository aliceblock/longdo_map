import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:longdo_map/longdo_map.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  LongdoMapController _controller;

  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: LongdoMap(
          onCreated: (controller) {
            _controller = controller;
          },
        ),
        floatingActionButton: Column(
          mainAxisSize: MainAxisSize.max,
          mainAxisAlignment: MainAxisAlignment.end,
          children: <Widget>[
            FloatingActionButton(
              child: Icon(Icons.zoom_in),
              onPressed: () {
                _controller.zoomIn();
              },
            ),
            SizedBox(height: 10.0,),
            FloatingActionButton(
              child: Icon(Icons.zoom_out),
              onPressed: () {
                _controller.zoomOut();
              },
            )
          ],
        ),
      ),
    );
  }
}
