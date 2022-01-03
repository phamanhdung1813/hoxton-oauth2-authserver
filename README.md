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


