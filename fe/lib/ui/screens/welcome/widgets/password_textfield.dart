import 'package:fs_fe/config/utils/export_file.dart';
import 'package:flutter/material.dart';

// ignore: must_be_immutable
class PasswordField extends StatelessWidget {
  TextEditingController controller;
  VoidCallback press;
  String hint;
  PasswordField(
      {Key? key,
      required this.controller,
      required this.hint,
      required this.press})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    Size size = MediaQuery.of(context).size;
    return Container(
      padding: const EdgeInsets.all(5.0),
      alignment: Alignment.center,
      height: 60 * size.height / 896,
      width: 350 * size.width / 414,
      decoration: BoxDecoration(
          color: fieldColor,
          borderRadius: BorderRadius.circular(15.0),
          border: Border.all(
            color: fieldBorder,
            width: 2,
          )),
      child: TextField(
        obscureText: true,
        textAlign: TextAlign.center,
        maxLines: 1,
        controller: controller,
        style: const TextStyle(
            fontSize: 18, color: primaryText, fontFamily: 'Poppins'),
        decoration: InputDecoration(
            border: InputBorder.none,
            hintText: hint,
            hintStyle: const TextStyle(color: primaryText),
            isCollapsed: true),
      ),
    );
  }
}
