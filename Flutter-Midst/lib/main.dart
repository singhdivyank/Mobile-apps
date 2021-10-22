import 'package:flutter/material.dart';
import 'package:flutter_midst/pages/faculty_page.dart';
import 'package:flutter_midst/pages/miscellaneous_page.dart';
import 'package:flutter_midst/pages/parents_page.dart';
import 'package:flutter_midst/pages/students_page.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  static String title = "Midst";

  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Flutter Demo',
      theme: ThemeData(primarySwatch: Colors.blue,),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key? key, required this.title}) : super(key: key);

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {

  @override
  Widget build(BuildContext context) => Scaffold(
    drawer: const NavigatonDrawerWidget(),
    appBar: AppBar(title: Text(MyApp.title),),
  );
}

class NavigatonDrawerWidget extends StatelessWidget {
  final padding = const EdgeInsets.symmetric(horizontal: 20);

  const NavigatonDrawerWidget({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    String name = 'TIET, Derabassi';
    String email = 'www.thapar.edu';
    String urlImage = 'https://studentcorner.epsiindia.org/upload/college/TI_LOGO.png';

    return Drawer(
      child: Material(
        color: const Color.fromRGBO(50, 75, 205, 1),
        child: ListView(
          children: <Widget>[
            buildHeader(
              urlImage: urlImage,
              name: name,
              email: email
            ),
            const SizedBox(height: 16,),
            buildMenuItem(
              text: 'Parents',
              icon: Icons.people,
              onClicked: () => selectedItem(context, 0),
            ),
            const SizedBox(height: 16,),
            buildMenuItem(
              text: 'Students',
              icon: Icons.person_pin,
              onClicked: () => selectedItem(context, 1),
            ),
            const SizedBox(height: 16,),
            buildMenuItem(
              text: 'Faculty',
              icon: Icons.account_balance,
              onClicked: () => selectedItem(context, 2),
            ),
            const SizedBox(height: 16,),
            buildMenuItem(
              text: 'Miscellaneous',
              icon: Icons.person_add,
              onClicked: () => selectedItem(context, 3),
            ),
          ],
        ),
      ),
    );
  }

  buildMenuItem({ required String text, required IconData icon,
    VoidCallback? onClicked }) {
    const color = Colors.white;
    final hoverColor = Colors.white70;

    return ListTile(
      leading: Icon(icon, color: color,),
      title: Text(text,
          style: const TextStyle(color: color)),
      hoverColor: hoverColor,
      onTap: onClicked,);
  }

  selectedItem(BuildContext context, int i) {
    switch(i) {
      case 0:
        Navigator.of(context).push(MaterialPageRoute(
          builder: (context) => ParentsPage(),
        ));
        break;
      case 1:
        Navigator.of(context).push(MaterialPageRoute(
          builder: (context) => StudentsPage(),
        ));
        break;
      case 2:
        Navigator.of(context).push(MaterialPageRoute(
          builder: (context) => FacultyPage(),
        ));
        break;
      case 3:
        Navigator.of(context).push(MaterialPageRoute(
          builder: (context) => MiscellaneousPage(),
        ));
        break;
    }
  }

  buildHeader({ required String urlImage, required String name,
    required String email }) {
      return InkWell(
        child: Container(
          padding: padding.add(const EdgeInsets.symmetric(vertical: 40)),
          child: Row(
            children: [
              CircleAvatar(radius: 30, backgroundImage: NetworkImage(urlImage),),
              const SizedBox(width: 20),
              Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(
                    name,
                    style: const TextStyle(fontSize: 20, color: Colors.white),
                  ),
                  const SizedBox(height: 4,),
                  Text(
                    email,
                    style: const TextStyle(fontSize: 14, color: Colors.white),
                  ),
                ],
              ),
            ],
          ),
        ),
      );
  }
}
