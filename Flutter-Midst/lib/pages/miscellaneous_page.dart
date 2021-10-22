import 'package:flutter/material.dart';
import 'package:url_launcher/url_launcher.dart';

class MiscellaneousPage extends StatefulWidget {
  @override
  State<MiscellaneousPage> createState() => _MiscellaneousPageState();
}

class _MiscellaneousPageState extends State<MiscellaneousPage> {
  // ignore: non_constant_identifier_names
  String url_admin = "https://admissions.thapar.edu";
  // ignore: non_constant_identifier_names
  String url_acc = "http://lmtsm.thapar.edu/index.php/a-z-directory/17-rss-feed/35-infrastructure";
  // ignore: non_constant_identifier_names
  String url_placement = "http://www.thapar.edu/placements";

  openURL(String url) async {
    if(url == url_admin) {
      await launch(url_admin);
    }
    else if(url == url_acc) {
      await launch(url_acc);
    }
    else if(url == url_placement) {
      await launch(url_placement);
    }
    else {
      throw 'Cannot be launched';
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Miscellaneous"),
        centerTitle: true,
        backgroundColor: Colors.redAccent,),
      body: ListView(
          padding: const EdgeInsets.all(32),
          children: [
            ElevatedButton(
              style: ElevatedButton.styleFrom(
                textStyle: const TextStyle(fontSize: 24),
                minimumSize: const Size.fromHeight(50),
                shape: const StadiumBorder(),
              ),
              onPressed: () {
                openURL(url_admin);
              },
              child: const Text('Admission Procedure'),
            ),
            const SizedBox(height: 16),
            ElevatedButton(
              style: ElevatedButton.styleFrom(
                textStyle: const TextStyle(fontSize: 24),
                minimumSize: const Size.fromHeight(50),
                shape: const StadiumBorder(),
              ),
              onPressed: () {
                openURL(url_acc);
              },
              child: const Text('Accommodation'),
            ),
            const SizedBox(height: 16),
            ElevatedButton(
              style: ElevatedButton.styleFrom(
                textStyle: const TextStyle(fontSize: 24),
                minimumSize: const Size.fromHeight(50),
                shape: const StadiumBorder(),
              ),
              onPressed: () {
                openURL(url_placement);
              },
              child: const Text('Placements'),
            )
          ]
      ),
    );
  }
}
