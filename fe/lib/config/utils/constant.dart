//Calling variable
//AppID
const String appID = "2112e5a9bf2e4877b22b7897c5bfd76b";
//Token
String token =
    "00617cb7ec4e5d845498de0f75eeac4273aIAAhwWV5ZL7WZcA4VwCdlc9NKH3KgkQ2csDgRiKjjuZI+mHTcgm379yDEADTR+sCyVB6YwEAAQDphXpj";
//Channelid / channelName
String channel = "trungggg_qwerr";
//AppCertificate
const appcertificate = "dd293bfdd1934332932cb405546b70f3";
//userID -> Random
int userID = 0;
//Token ROle
int tokenRole = 1; // use 1 for Host/Broadcaster, 2 for Subscriber/Audience
//ServerURL
//String serverUrl = "chewnodejstokengenerator-production.up.railway.app";
String serverUrl = "localhost:8080";
//     "localhost:8080"; // The base URL to your token server, for example "https://agora-token-service-production-92ff.up.railway.app" => use for NodeJS

//Token ExpiringTIme
int tokenExpireTime = 100; // Expire time in Seconds.
//Is Token expiring for renew
bool isTokenExpiring = false; // Set to true when the token is about to expire