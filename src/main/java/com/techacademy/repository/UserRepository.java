package com.techacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techacademy.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
                     //JpaRepositoryのジェネリクスの中は<扱うエンティティクラス（今回はUser),扱うエンティティクラスの主キーの型（今回はInteger)>
}
