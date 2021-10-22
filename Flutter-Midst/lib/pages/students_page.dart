import 'package:flutter/material.dart';
import 'package:url_launcher/url_launcher.dart';

class StudentsPage extends StatefulWidget {
  @override
  State<StudentsPage> createState() => _StudentsPageState();
}

class _StudentsPageState extends State<StudentsPage> {
  // ignore: non_constant_identifier_names
  String url_faculty = "http://www.thapar.edu/faculties/category/departments/computer-science-engineering-dera-bassi-campus-1";
  // ignore: non_constant_identifier_names
  String url_books = "http://library.thapar.edu/";
  // ignore: non_constant_identifier_names
  String url_course = "http://www.thapar.edu/images/CSSyllabus/Group%20B%20COE.pdf";

  openURL(String url) async {
    if(url == url_faculty) {
      await launch(url_faculty);
    } else if(url == url_books) {
      await launch(url_books);
    }
    else if(url == url_course) {
      await launch(url_course);
    }
    else {
      throw 'Could not launch URL';
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Students"),
        centerTitle: true,
        backgroundColor: Colors.brown,),
      body: ListView(
        padding: const EdgeInsets.all(32),
        children: [
          buildRoll(),
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
          // for showing details
          ElevatedButton(
            style: ElevatedButton.styleFrom(
              textStyle: const TextStyle(fontSize: 24),
              minimumSize: const Size.fromHeight(50),
              shape: const StadiumBorder(),
            ),
            onPressed: () {
              openURL(url_course);
            },
            child: const Text('Curriculum Details'),
          ),
          const SizedBox(height: 16),
          ElevatedButton(
            style: ElevatedButton.styleFrom(
              textStyle: const TextStyle(fontSize: 24),
              minimumSize: const Size.fromHeight(50),
              shape: const StadiumBorder(),
            ),
            onPressed: () {
              openURL(url_faculty);
            },
            child: const Text('Faculty Details'),
          ),
          const SizedBox(height: 16),
          ElevatedButton(
            style: ElevatedButton.styleFrom(
              textStyle: const TextStyle(fontSize: 24),
              minimumSize: const Size.fromHeight(50),
              shape: const StadiumBorder(),
            ),
            onPressed: () {
              openURL(url_books);
            },
            child: const Text('Book Status'),
          )
        ],
      ),
    );
  }

  buildRoll() {
    return const TextField(
      decoration: InputDecoration(
        hintText: '101816006',
        labelText: 'RollNo',
        border: OutlineInputBorder(),
      ),
      textInputAction: TextInputAction.done,
      keyboardType: TextInputType.number,
    );
  }
}
