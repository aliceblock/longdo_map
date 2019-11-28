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
      ),
    );
  }
}
