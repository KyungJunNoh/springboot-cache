package com.example.ehcache;

public interface MemberRepository {
    Member findByNameNoCache(String name);
    Member findByNameCache(String name);
    void refresh(String name);
}
