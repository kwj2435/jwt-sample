## Spring Security + Redis 기반 JWT 토큰 활용 인증, 인가 구현 

### Skill Stack  
Java 17  
Spring Boot 2.7.11  
Spring Security (latest)  
Spring Data JPA (latest)  
Redis  
H2 Database (latest)  
Docker, Docker Compose

### How To Run  
```run docker```

### Summary (구현 기능 목록 및 각 기능 로직 설명)
<img src="https://user-images.githubusercontent.com/34668108/232058051-30fecc96-e669-4db0-ad8b-2420d02d80db.png" width="600" height="400">

**1. 회원 가입**  
회원 가입은 모든 사용자에게 조건 없이 오픈되어야 하므로 별도의 필터링 없이 모든 요청의 진입을 허용한다.

**2. 로그인을 통한 Access Token, Refresh Token 발급**  
a. 사용자가 아이디, 패스워드를 담아 서버에 로그인 요청을 보낸다.  
b. 사용자로부터 넘겨받은 아이디, 패스워드를 서버는 UsernamePasswordAuthenticationToken으로 변환한다.  
c. AuthenticationManagerBuilder의 authenticate 메서드에 'b'에서 만들어진 토큰을 담아 호출한다.  
authenticate 메서드 호출시 Security의 UserDetailsService가 호출되며 해당 인터페이스의 loadUserByUsername 구현체를 통해 인증과정을 거친다.  
d. 정상 인증을 거친후 로그인 요청에 대한 Access Token, Refresh Token을 생성하여 유저에게 전달하며 Refresh Token은 Redis에 저장된다.

**3. Access Token 전달을 통한 인증, 인가**

**4. Access Token 만료시 Refresh Token을 이용한 Access Token 재발급**

**5. 로그아웃**  