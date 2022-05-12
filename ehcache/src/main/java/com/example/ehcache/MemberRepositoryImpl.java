package com.example.ehcache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepositoryImpl implements MemberRepository{

    private static Logger logger = LoggerFactory.getLogger(MemberRepositoryImpl.class);

    /**
     * 캐시를 사용하지 않고 이름으로 멤버를 조회할 때 매번 2초의 시간이 걸리는걸 나타내기위함
     * @param name
     * @return member
     */
    @Override
    public Member findByNameNoCache(String name) {
        slowQuery(2000);
        return new Member(0, name+"@gmail.com", name);
    }

    /**
     * 캐시를 사용하여 최근에 멤버를 조회 한 기록이 있다면 다음 조회할때 해당 쿼리를 실행하지 않는다.
     * @param name
     * @return member
     */
    @Override
    @Cacheable(value="findMemberCache", key="#name")
    public Member findByNameCache(String name) {
        slowQuery(2000);
        return new Member(0, name+ "@gmail.com", name);
    }

    /**
     * name 에 해당하는 키 값을 찾아서 삭제하여 캐시를 초기화
     * @param name
     * @return member
     */
    @Override
    @CacheEvict(value = "findMemberCache", key="#name")
    public void refresh(String name) {
        logger.info(name + "의 Cache Clear!");
    }

    /**
     * 쿼리를 실행하는것을 나타내기 위한 스레드 슬립
     * @param seconds
     */
    private void slowQuery(long seconds) {
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
