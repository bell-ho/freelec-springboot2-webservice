package com.jojoldu.book.springboot.config.auth.dto;

import com.jojoldu.book.springboot.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import java.io.Serializable;

@Scope(value = "session",proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter
@NoArgsConstructor //없으면 null 값으로 처리해서 fail to instantiate 에러를 뿜어낸다.
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

//    public SessionUser() {
//    }

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
