# DeepLinkAndroidTV

如何直接從我的Android應用程序打開Goog​​le Play商店？
https://adabai.com/questions/a30781562173626.html

    final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
    try {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
    } catch (android.content.ActivityNotFoundException anfe) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
    }

Movie Deeplink for Netflix Android TV app (com.netflix.ninja)
https://localcoder.org/movie-deeplink-for-netflix-android-tv-app-com-netflix-ninja

  Intent netflix = new Intent();
  netflix.setAction(Intent.ACTION_VIEW);
  netflix.setData(Uri.parse("http://www.netflix.com/watch/70202141"));
  netflix.putExtra("source","30"); // careful: String, not int
  netflix.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
  getActivity().startActivity(netflix);
  
  
   public void OpenNFX() {
      Intent netflix = new Intent();
      netflix.setAction(Intent.ACTION_VIEW);
      netflix.setData(Uri.parse("http://www.netflix.com/watch/70291117"));
      netflix.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
      getActivity().startActivity(netflix);
  }
  
  
  
  //使用 Url scheme
val netflix = Intent()
netflix.action = Intent.ACTION_VIEW
netflix.data =Uri.parse("http://video.friday.tw/home?linkType=10&linkValue=2413_3")
//netflix.putExtra("search", "30") // careful: String, not int
netflix.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
startActivity(netflix)

//使用Intent 開啟第三方app
val intent = Intent()
intent.setAction("com.friday.tvapp")
intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
intent.addFlags(0x01000000) //20210913 sdk > 8.0 要喚起背景app 需要使用
intent.putExtra("linkType", "10")//詳細頁10
intent.putExtra("linkValue", "2413_3")//contentId_contentType
startActivity(intent)


//開啟Android app store 
val appPackageName: String ="net.fetnet.fetvod.tv"
try {
   startActivity(
       Intent(
           Intent.ACTION_VIEW,
           Uri.parse("market://details?id=$appPackageName")
       )
   )
} catch (anfe: ActivityNotFoundException) {
   startActivity(
       Intent(
           Intent.ACTION_VIEW,          Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")
       )
   )
}



