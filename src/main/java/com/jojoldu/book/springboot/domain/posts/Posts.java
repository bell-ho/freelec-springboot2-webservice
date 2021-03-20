package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor  //기본 생성자 자동추가
@Entity //JPA의 어노테이션 : 테이블과 링크될 클래스임을 나타냄
public class Posts {

    @Id //해당 테이블의 PK빌드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK생성 규칙 IDENTITY를 추가해야지 auto increment가 됨
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //해당 클래스의 빌더 패턴 클래스를 생성 , 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
