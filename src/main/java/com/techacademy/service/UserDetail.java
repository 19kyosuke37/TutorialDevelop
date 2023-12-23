package com.techacademy.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.techacademy.entity.User;

public class UserDetail implements UserDetails {
    private static final long serialVersionUID = 1L;

    private final User user;
    private final Collection<? extends GrantedAuthority> authorities;

    public UserDetail(User user) {
        this.user = user;
        this.authorities = new ArrayList<GrantedAuthority>();

    }

    public User getUser() {
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    @Override
    public String getPassword() {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    @Override
    public String getUsername() {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO 自動生成されたメソッド・スタブ
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO 自動生成されたメソッド・スタブ
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO 自動生成されたメソッド・スタブ
        return false;
    }

    @Override
    public boolean isEnabled() {
        // TODO 自動生成されたメソッド・スタブ
        return false;
    }

}
