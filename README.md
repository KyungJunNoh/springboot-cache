# Spring Boot Cache

캐시는 자주 쓰이는 정보 나 반복적으로 동일한 결과를 돌려주는 경우에    
지속적으로 DBMS 혹은 서버에 요청하는 것이 아닌 메모리에 데이터를    
저장하였다가 데이터를 불러다가 쓰는 것을 의미합니다.   
따라서 서버나 DBMS에 부담을 덜어주고, 엄청 빠르기 때문에 많은 시스템에서 사용하고 있습니다.

예를 들어서 브랜드 조회 와 상품 조회에 적합하다고 볼 수 있습니다.

Spring 에서는 cache 를 사용할 수 있도록 지원을 하는데 spring-boot-starter-cache 라이브러리는   
다른 서드파티 모듈을 사용할 수 있도록 추상화를 지원하고 ( 다른 모듈인 ehcache, redis 등의 모듈을 쉽게 사용할 수 있도록 지원 ),   
다른 서드파티 모듈이 추가되지 않는다면 로컬에 저장이 됩니다.

### Ehcache 
- Ehcache 오픈 소스 기반의 Local Cache 입니다.
- 속도가 빠르며 경량 Cache 라는 특징이 있습니다.

[ehcache 사용](https://github.com/KyungJunNoh/spring-cache/tree/master/ehcache)
