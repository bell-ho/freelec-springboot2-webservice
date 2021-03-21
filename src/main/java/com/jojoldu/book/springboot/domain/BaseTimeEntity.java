package com.jojoldu.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass   //JPA Entity 클래스들이 BaseTimeEntity 를 상속할 경우 BaseTimeEntity 클래스의 필드들도 컬럼으로 인식하도록 함
@EntityListeners(AuditingEntityListener.class)  //BaseTimeEntity 클래스에 Auding 기능을 포함시킴
public abstract class BaseTimeEntity {  //BaseTimeEntity 클래스는 모든 Entity의 상위 클래스가 되어 Entity 들의 createdDate , modifiedDate 를 자동으로 관리하는 역할

    @CreatedDate //생성되는 시간 자동저장
    private LocalDateTime createdDate;

    @LastModifiedDate   //수정되는 시간 자동저장
    private LocalDateTime modifiedDate;
}
