Redis 에서 데이터 저장, 조회, 삭제 기능 샘플코드
Redis 기본샘플 프로젝트 생성방법
IDE: IntelliJ
프레임워크: Spring Boot 3.1.5
JDK: 17
빌드 도구: Gradle
설정 파일: application.properties
1.
build.gradle 설정
implementation 'org.springframework.boot:spring-boot-starter-data-redis'
의존성은 이외에도 필요한 것들은 추가해야함
2.
application.properties 설정
spring.redis.host=localhost
spring.redis.port=6379
3.
Redis 설정 (RedisConfig.java)
Spring Boot에서 Redis를 쉽게 사용하려면 RedisTemplate을 설정
RedisTemplate<String, String> → Redis 데이터를 쉽게 저장하고 조회하도록 설정
StringRedisSerializer() → Redis에서 데이터를 저장할 때 사람이 읽을 수 있는 문자열로 저장
4.
Redis 서비스 (RedisService.java)
Redis에 값을 저장하고, 조회하고, 삭제하는 로직을 담당하는 서비스 클래스
saveValue() → Redis에 key-value 저장 + 만료 시간 설정
getValue() → Redis에서 key 값을 조회
deleteValue() → 특정 key 삭제
5.
Redis 컨트롤러 (RedisController.java)
사용자가 API 요청을 보내면 RedisService를 호출하여 데이터를 저장, 조회, 삭제하는 역할
/redis/save → 데이터를 저장하는 POST API
/redis/get → 데이터를 조회하는 GET API
/redis/delete → 데이터를 삭제하는 DELETE API
6.
Postman 또는 curl로 API 테스트 ( 본인은 Postman밖에 모름 )
-------------------------------------------------------------------------------
postman 저장 방법
http://localhost:8787/redis/save?key=test-key&value=Hello Redis&timeout=60
post → Send
아래 response 확인

cmd 창
postman 저장값 확인방법
PS C:\Users\dudes> docker exec -it redis redis-cli
>>
127.0.0.1:6379> keys *
1) "test-key"
   127.0.0.1:6379> get test-key
   "Hello Redis"
-------------------------------------------------------------------------------
