import 'package:fs_fe/controllers/time_counter.dart';
import 'package:fs_fe/models/message.dart';
import 'package:fs_fe/models/user.dart';
import 'package:fs_fe/services/api.dart';
import 'package:fs_fe/services/socketio.dart';
import 'package:fs_fe/ui/screens/chat/chatroom.dart';
import 'package:get/get.dart';
import 'package:image_picker/image_picker.dart';

CounterController counterController = Get.put(CounterController());


class ConversationController extends GetxController {
    late Rx<User> targetUser;
    RxList listMessage = [].obs;

    void sendMessage(userId, avtURL, content){
      var mess = Message(senderId: userId, avatarURL: avtURL, content: content, isImage: false);
      message(mess.toJson());
    }

    void sendImageMessage(userId, avtURL) async {
      final ImagePicker imagePicker = ImagePicker();
      var image = await imagePicker.pickImage(source: ImageSource.gallery);
      if (image != null) {
        var url = await upImageMessage(image.path.toString());
        var mess = Message(senderId: userId, avatarURL: avtURL, content: url, isImage: true);
        message(mess.toJson());
      }
    }

    void updateListMessage(data){
      var mess = Message.fromJson(data);
      listMessage.add(mess);
      update(['listMessage']);
      //print(listMessage);
    }

  Future<bool> toConversation(targerId) async {
    listMessage.length = 0 ;
    if (await getUserByID(targerId)) {
      await addRecentConnect(targerId);
      counterController.stopCounter();
      Get.to(() => const ChatRoomScreen());
      return true;
    }
    return false;
  }

  void getOutConversation() async {
    disconnectConversation();
    Get.back();
  }

}