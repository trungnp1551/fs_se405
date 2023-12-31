import 'package:fs_fe/config/utils/export_file.dart';
import 'package:flutter/cupertino.dart';

// ignore: must_be_immutable
class LeftClick extends StatelessWidget {
  String title;
  VoidCallback press;
  LeftClick({Key? key, required this.title, required this.press}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    Size size = MediaQuery.of(context).size;
    return GestureDetector(
      onTap: press,
      child: Container(
        alignment: Alignment.center,
        height: 72*size.height/896,
        width: 186*size.width/414,
        decoration: BoxDecoration(
          color: secondaryColor,
          borderRadius: const BorderRadius.only(topLeft: Radius.circular(10.0), topRight: Radius.circular(20.0), bottomLeft: Radius.circular(20.0)),
          border: Border.all(width: 3, color: fieldBorder),
        ),
        child: Text(title, style: const TextStyle(fontFamily: 'Poppins', fontWeight: FontWeight.bold, fontSize: 20, color: secondaryText ),
      ),
      )
    );
  }
}