import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:url_launcher/url_launcher.dart';

class ParentsPage extends StatefulWidget {
  @override
  State<ParentsPage> createState() => _ParentsPageState();
}

class _ParentsPageState extends State<ParentsPage> {
  String url = 'https://eps.eshiksha.net/esh/index.php?plugin=Login&action=index';
  openURL() async {
    if(await canLaunch(url)) {
      await launch(url);
    }
    else {
      throw 'Could not launch URL';
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Parents",),
        centerTitle: true,
        backgroundColor: Colors.greenAccent,),
      body: ListView(
          padding: const EdgeInsets.all(32),
          children: [
            buildAdmin(),
            const SizedBox(height: 24,),
            ElevatedButton(
              style: ElevatedButton.styleFrom(
                textStyle: const TextStyle(fontSize: 24),
                minimumSize: const Size.fromHeight(50),
                shape: const StadiumBorder(),
              ),
              onPressed: () {},
              child: const Text('Confirm'), //
            ),
            const SizedBox(height: 16),
            ElevatedButton(
              style: ElevatedButton.styleFrom(
                textStyle: const TextStyle(fontSize: 24),
                minimumSize: const Size.fromHeight(50),
                shape: const StadiumBorder(),
              ),
              onPressed: () {
                openURL();
              },
              child: const Text('Pay Fees'),
            ),
          ]
      ),
    );
  }

  buildAdmin() {
    return const TextField(
      decoration: InputDecoration(
        hintText: '101816006',
        labelText: 'AdmNo',
        border: OutlineInputBorder(),
      ),
      textInputAction: TextInputAction.done,
      keyboardType: TextInputType.number,
    );
  }
}