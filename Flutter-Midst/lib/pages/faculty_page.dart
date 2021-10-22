import 'package:flutter/material.dart';
import 'package:url_launcher/url_launcher.dart';

class FacultyPage extends StatefulWidget {
  @override
  State<FacultyPage> createState() => _FacultyPageState();
}

class _FacultyPageState extends State<FacultyPage> {
  String url = "https://webkiosk.thapar.edu/index.jsp?_ga=2.168427297.141322623.1588653363-675121206.1576325197";

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
        title: const Text("Faculty"),
        centerTitle: true,
        backgroundColor: Colors.orangeAccent,),
      body: ListView(
          padding: const EdgeInsets.all(32),
          children: [
            buildID(),
            const SizedBox(height: 24,),
            ElevatedButton(
              style: ElevatedButton.styleFrom(
                textStyle: const TextStyle(fontSize: 24),
                minimumSize: const Size.fromHeight(50),
                shape: const StadiumBorder(),
              ),
              onPressed: () {},
              child: const Text('Verify'), //
            ),
            const SizedBox(height: 16),
            buildName(),
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
              child: const Text('Student Detail'),
            ),
          ]
      ),
    );
  }

  buildID() {
    return const TextField(
      decoration: InputDecoration(
        hintText: '101816006',
        labelText: 'EmpId',
        border: OutlineInputBorder(),
      ),
      textInputAction: TextInputAction.done,
      keyboardType: TextInputType.number,
    );
  }

  buildName() {
    return const TextField(
      decoration: InputDecoration(
        hintText: 'Divyank Singh',
        labelText: 'StdName',
        border: OutlineInputBorder(),
      ),
      textInputAction: TextInputAction.done,
      keyboardType: TextInputType.number,
    );
  }
}