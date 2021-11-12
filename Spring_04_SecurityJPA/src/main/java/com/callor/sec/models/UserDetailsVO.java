package com.callor.sec.models;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

/**
 * spring security 에서
 * 회원 인증 정보(회원정보)를 담아서 사용할 UserVO는
 * 반드시 UserDetails 인터페이스를 상속하여 작성하도록 하고 있다.
 */
/**
 * 인터페이스를 사용하는 이유
 *    security 에 내장된 어떤 연산에서 사용자 정보를 읽고, 쓰기를 시도하려고 한다.
 *    내 맘대로 vo 의 변수를 선언하고, getter와 setter 도 임의로 선언을 하게 된다면
 *    Security 의 어떤 연산이 VO 객체에 값을 쓰거나(setter) 읽을때(getter)할 때
 *    문제를 일으킬 수 있다.
 *    즉, 코드 오류를 방지할 수 있다.
 *
 * lombok을 사용하는 이유
 *    인터페이스를 상속받으면
 *    method 를 정해진 이름으로 강제 선언 해야하는데
 *    여기서는 lombok 의 기능을 사용하기 위하여
 *    정해진 이름으로 각각 member 변수를 선언하고
 *    lombok 을 사용하여 getter, setter 를 선언한다.
 *    즉, 우리가 좀더 편하게 커스터마이징 하기 위함이다.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_members")
public class UserDetailsVO implements UserDetails {

    // 필수조건은 아니지만
    // 이게 있으면 스프링이 클라이언트 사이에서 데이터를 주고받을때
    // 오류를 적게 낸다고 한다.
    // (있어도 되고 없어도 되고)
    private static final long serialVersionID = 1L;

    /* 필수로 선언해야할 변수들 */
    @Id
    @Column(columnDefinition = "VARCHAR(125)", nullable = false)
    private String username;

    // 512정도면 어떤 암호화여도 대체로 저장 가능할 것임
    @Column(columnDefinition = "VARCHAR(512)")
    private String password;

    private boolean isEnabled;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;

    // table 을 생성할 때 이 변수는 칼럼으로 설정하지 말라
    @Transient
    private Collection<? extends GrantedAuthority> authorities;

    /* 필요에 따라 추가하여 사용하는 변수들 */
    private String email;
    private String tel;
    private String address;


}
