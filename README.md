# Spring Boot Cache

캐시는 **자주 쓰이는 정보** 나 **반복적으로 동일한 결과**를 돌려주는 경우에    
지속적으로 DBMS 혹은 서버에 요청하는 것이 아닌 **메모리에 데이터를    
저장하였다가 데이터를 불러다가 쓰는 것을 의미**합니다.   
따라서 서버나 DBMS 에 부담을 덜어주고, 엄청 빠르기 때문에 많은 시스템에서 사용하고 있습니다.

예를 들어서 브랜드 조회 와 상품 조회에 적합하다고 볼 수 있습니다.

Spring 에서는 cache 를 사용할 수 있도록 지원을 하는데 `spring-boot-starter-cache` 라이브러리는   
**다른 서드파티 모듈**을 사용할 수 있도록 추상화를 지원하고 ( 다른 모듈인 ehcache, redis 등의 모듈을 쉽게 사용할 수 있도록 지원 ),   
다른 서드파티 모듈이 추가되지 않는다면 **로컬에 저장**이 됩니다.

### Ehcache 
- Ehcache 오픈 소스 기반의 `Local Cache` 입니다.
- 속도가 빠르며 `경량 Cache` 라는 특징이 있습니다.

[ehcache 사용](https://github.com/KyungJunNoh/spring-cache/tree/master/ehcache)

### Redis
- Redis 는 Memcached 와 비슷한 캐시 시스템으로서 동일한 기능을 제공하면서 영속성, 다양한 데이터 구조와 같은 부가적인 기능을 지원하고 있다.
즉, `인메모리 데이터베이스` 이다.
- Redis 를 사용하는 이유중 하나는 다른 디비들과는 다르게 `다양한 자료구조`를 가지고 있다는 점이다.
```
레디스는 고성능 키-벨류 저장소로서 문자열, 리스트, 해시, 셋, 정렬된 셋 형식의 데이터를 지원하는 NoSQL 이다.
```

[Redis 사용](https://github.com/KyungJunNoh/spring-cache/tree/master/redis)

- Redis Reference   
[TIL에 정리된 Redis](https://github.com/KyungJunNoh/TIL/blob/main/Backend/Unclassified/redis.md)   
[개발하면서 참고한 Redis 공식문서](https://docs.spring.io/spring-data/data-redis/docs/2.4.14/reference/html/#introduction)