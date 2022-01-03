# Application Back-end URL 👇
## https://hoxton-oauth2-authserver.herokuapp.com/

## OAuth2 GRANT TYPE PASSWORD

### 👉 https://hoxton-oauth2-authserver.herokuapp.com/oauth/token?grant_type=password&username=admin&password=admin&scope=write

* Optional scope with write or read (We can configure more scope on real application)

![image](https://user-images.githubusercontent.com/71564211/147980887-bc0d81c8-f306-4ed0-bb05-a5b13cf14a99.png)

## OAuth2 GRANT TYPE CLIENT-CREDENTIALS

### 👉 https://hoxton-oauth2-authserver.herokuapp.com/oauth/token?grant_type=client_credentials&scope=write

![image](https://user-images.githubusercontent.com/71564211/147980999-69b081da-fc9a-445b-a425-618cbea3f40c.png)


### 👉 https://hoxton-oauth2-authserver.herokuapp.com/oauth/token?grant_type=refresh_token&refresh_token={paste_refresh_token_released_on_other_authorization_method}&scope=write

* Refresh token can be used multiple time until the token expired (5400 seconds)

![image](https://user-images.githubusercontent.com/71564211/147981203-371fd29c-ccfe-4351-874f-ff32e59ebbac.png)

### 👉 https://hoxton-oauth2-authserver.herokuapp.com/oauth/token?grant_type=authorization_code&scope=write&code={authorization_code_released_by_oauthserver}


![image](https://user-images.githubusercontent.com/71564211/147981533-06993eb7-15a6-417f-a0a3-f6762fb6db63.png)

![image](https://user-images.githubusercontent.com/71564211/147981569-53e58ab2-9898-4210-ae8f-8e061cacb19c.png)

![image](https://user-images.githubusercontent.com/71564211/147981607-baf586e1-38e0-40d3-b27b-afb48e4a4eb1.png)

![image](https://user-images.githubusercontent.com/71564211/147981660-7c04a1b8-3de8-4b0b-a02a-18e147c589b8.png)

* Authorization code released by Oauth2 server can be used only 1 time, If you want to release new access_token, you have to refresh new token by using refresh_token url link above or release new authorization code and make the request into the server.

![image](https://user-images.githubusercontent.com/71564211/147981843-1d0a7c12-92bc-423b-9dc7-c5b31bca2289.png)

### 👉 https://hoxton-oauth2-authserver.herokuapp.com/oauth/token_key
* Crypto RSA public key and private key to allow token transfer between oauth2 authorization server and resource server
* jsk asymmetric key is available on application resource folder

* Create certification: keytool -genkeypair -alias [alias_name] -keyalg RSA -keypass [key_password] -keystore [filename.jks] -storepass [store_password]

* View certification: keytool -list -rfc --keytool [filename.jks] | openssl x509 -inform pem -pubkey

![image](https://user-images.githubusercontent.com/71564211/147982798-21b82c3a-07b3-4174-a14b-b4e71fb0ddc5.png)

![image](https://user-images.githubusercontent.com/71564211/147982438-fff5c6f4-4686-4770-8972-7a7fb699f075.png)

### 👉 Security endpoint test
![image](https://user-images.githubusercontent.com/71564211/147983106-b8ad3510-e89e-4b37-81a6-86145ceb241d.png)

![image](https://user-images.githubusercontent.com/71564211/147983137-96bc4645-317d-487f-8c87-90f11a318210.png)

![image](https://user-images.githubusercontent.com/71564211/147983168-8caa4fec-ebba-4d26-abb0-65425a7830a2.png)



