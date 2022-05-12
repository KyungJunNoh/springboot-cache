package com.example.ehcache;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

/**
 * 캐시를 사용하기위한 설정 클래스
 */
@Component // 해당 클래스를 컴포넌트에 등록
@RequiredArgsConstructor // cache Manager 를 사용하기위한 의존성 주입
public class CacheManagerCheck implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(CacheManagerCheck.class);

    private final CacheManager cacheManager;

    /**
     * 실행되면 로그에 캐시가 사용되고있다는것을 출력
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        logger.info("\n\n" + "=========================================================\n"
                + "Using cache manager: " + this.cacheManager.getClass().getName() + "\n"
                + "=========================================================\n\n");
    }
}
