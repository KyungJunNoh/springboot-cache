package com.example.ehcache;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableCaching // 캐시를 사용하기위한 어노테이션 선언
@RequiredArgsConstructor
@SpringBootApplication
public class EhcacheApplication {

	private static Logger logger = LoggerFactory.getLogger(EhcacheApplication.class);

	private final MemberRepository memberRepository;

	/**
	 * 캐시를 사용하지 않았을때 멤버를 조회
	 * @param name
	 * @return member;
	 */
	@GetMapping("/member/nocache/{name}")
	@ResponseBody
	public Member getNoCacheMember(@PathVariable String name){
		long start = System.currentTimeMillis(); // 수행시간 측정
		Member member = memberRepository.findByNameNoCache(name); // db 조회
		long end = System.currentTimeMillis();

		logger.info(name+ "의 NoCache 수행시간 : "+ Long.toString(end-start));

		return member;
	}

	/**
	 * 캐시를 사용했을때 않았을때 멤버를 조회
	 * @param name
	 * @return member;
	 */
	@GetMapping("/member/cache/{name}")
	@ResponseBody
	public Member getCacheMember(@PathVariable String name){
		long start = System.currentTimeMillis(); // 수행시간 측정
		Member member = memberRepository.findByNameCache(name); // db 조회
		long end = System.currentTimeMillis();

		logger.info(name+ "의 Cache 수행시간 : "+ Long.toString(end-start));

		return member;
	}

	/**
	 * 캐시에 저장되있는 name 을 찾아서 초기화(제거)
	 * @param name
	 * @return member;
	 */
	@GetMapping("/member/refresh/{name}")
	@ResponseBody
	public String refresh(@PathVariable String name){
		memberRepository.refresh(name); // 캐시제거
		return "cache clear!";
	}

	public static void main(String[] args) {
		SpringApplication.run(EhcacheApplication.class, args);
	}

}
