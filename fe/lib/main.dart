import 'package:fs_fe/config/themes/theme.dart';
import 'package:fs_fe/controllers/setting/setting_controller.dart';
import 'package:fs_fe/controllers/user/notificationController.dart';
import 'package:fs_fe/controllers/user/userController.dart';
import 'package:fs_fe/ui/screens/chat/calling/video_calling.dart';
import 'package:fs_fe/ui/screens/chat/calling/voice_calling.dart';
import 'package:fs_fe/ui/screens/chat/music/music.dart';
import 'package:fs_fe/ui/screens/chat/report/report.dart';
import 'package:fs_fe/ui/screens/home/mainscreen.dart';
import 'package:fs_fe/ui/screens/open_image/image.dart';
import 'package:fs_fe/ui/screens/profile/edit/edit.dart';
import 'package:fs_fe/ui/screens/welcome/forgot/forgot.dart';
import 'package:fs_fe/ui/screens/welcome/forgot/reset_password.dart';
import 'package:fs_fe/ui/screens/welcome/forgot/verify.dart';
import 'package:fs_fe/ui/screens/welcome/login/login.dart';
import 'package:fs_fe/ui/screens/welcome/signup/before_login.dart';
import 'package:fs_fe/ui/screens/welcome/signup/signup.dart';
import 'package:fs_fe/ui/screens/welcome/signup/waiting_before.dart';
import 'package:fs_fe/ui/screens/welcome/splash/splash.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:get_storage/get_storage.dart';

import 'ui/screens/profile/add_image/add_image.dart';

void main() async {
  await GetStorage.init();
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    // SystemChrome.setEnabledSystemUIOverlays([SystemUiOverlay.top]);
    return GetMaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Familiar Stranger',
      theme: AppTheme.light,
      home: const SplashScreen(),
      // home: const LoginScreen(),
      initialBinding: InitialBinding(),

      //initialRoute: '/loginScreen',
      getPages: [
        GetPage(name: "/mainScreen", page: () => const MainScreen()),
        GetPage(name: "/loginScreen", page: () => const LoginScreen()),
        GetPage(name: "/forgotScreen", page: () => const ForgotScreen()),
        GetPage(name: "/signUpScreen", page: () => const SignUpScreen()),
        GetPage(
            name: "/waitingScreen",
            page: () => const WaitingBeforeLoginScreen()),
        GetPage(
            name: "/beforeLoginScreen", page: () => const BeforeLoginScreen()),
        GetPage(name: "/editProfileScreen", page: () => const EditScreen()),
        GetPage(name: "/verifyScreen", page: () => const VerifyScreen()),
        GetPage(
            name: "/resetPasswordScreen",
            page: () => const ResetPasswordScreen()),
        GetPage(name: "/image", page: () => const ImageScreen()),
        GetPage(name: "/addImageScreen", page: () => const AddImageScreen()),
        GetPage(name: "/voice_calling", page: () => const VoiceCallingScreen()),
        GetPage(name: "/video_calling", page: () => const VideoCallingScreen()),
        GetPage(name: "/musicScreen", page: () => const MusicScreen()),
        GetPage(name: "/reportScreen", page: () => const ReportScreen()),
      ],
    );
  }
}

class InitialBinding implements Bindings {
  @override
  void dependencies() {
    Get.lazyPut(() => SettingController(), fenix: true);
    Get.lazyPut(() => UserController(), fenix: true);
    Get.lazyPut(() => NotificationController(), fenix: true);
  }
}
