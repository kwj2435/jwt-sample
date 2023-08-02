## Redis 기반 JWT 토큰 인증, 인가 Sample
### Project Environment
Spring Boot 3.1.1  
Spring Data JPA : latest  
Spring Data Redis : 3.1.1  
Spring Security : latest  
H2 DataBase

Redis

### Feature Summary  

1. 회원 가입
- 일반 이메일, 패스워드 회원가입  

2. 로그인  
- AccessToken, RefreshToken 발급
- AccessToken은 클라이언트에서 관리하며, RefreshToken은 서버(Redis)에서 관리한다.

3. 인증, 인가
- API 접근시 Header에 담겨진 AccessToken을 통해 인증후 인가 과정을 진행한다.
- AccessToken이 만료됐을 경우 AccessToken에 담겨진 Email값으로 Redis의 RefreshToken을 가져온다.
- RefreshToken이 Redis에 존재하지 않을 경우(만료) 로그인을 다시 요청한다.
- AccessToken을 이용해 API 요청을 보낼때마다 RefreshToken 유효시간을 초기화 한다.  
(사용도중 토큰이 만료되지 않도록 하기 위해) 


### API
내 정보 조회 - GET ( /api/member )
회원가입 - POST ( /api/member/regist )  
로그인 - POST ( /api/security/auth )
로그아웃 - DELETE ( /api/security/logout )
RefreshToken 재발급 - POST ( /api/security/renew/refresh )

