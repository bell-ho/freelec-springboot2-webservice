package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    //JpaRepository<Entity 클래스, PK 타입>을 상속하면 기본 적인 CRUD 메소드가 자동으로 생성
    // **주의** Entity 클래스와 기본 Entity Repository는 함께 위치 해야함
}
