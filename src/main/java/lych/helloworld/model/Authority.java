package lych.helloworld.model;

import org.springframework.security.core.GrantedAuthority;

public enum Authority implements GrantedAuthority {

    User,
    Admin;

    @Override
    public String getAuthority() {

        return this.name();
    }
}
