package com.techacademy.entity;

import org.hibernate.validator.constraints.Length;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PreRemove;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data  //「getter/setter、toString、hashCode、equals」のメソッドを生成
@Entity
@Table(name ="user") //MySQlのエンティティが紐づくテーブルの指定
public class User {

    public static enum Gender{
        男性,女性
    }

    @Id //主キー
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //主キーの値を一意（かぶりなし）に自動生成するアノテーション
    private Integer id;


    @Column(length = 20,nullable = false)
    @NotEmpty//これはバリデーションといい（Validation）、データやプロセスが特定の規則や条件を満たしているかどうかを検証するプロセスです。
    @Length(max=20)
    private String name;

    @Column(length = 2)
    @Enumerated(EnumType.STRING)
    @NotNull
    //このアノテーションで該当フィールドがEnum型であることを指定している
    private Gender gender;

    @Min(0)
    @Max(120)
    private Integer age; //文字列型、配列型以外にはlengthは指定できないから、これはされていない

    @Column(length = 50)
    @Email
    @Length(max=50)
    private String email;

    @OneToOne(mappedBy="user")
    private Authentication authentication;


    @PreRemove
    @Transactional
    private void preRemove() {
        if(authentication != null) {
            authentication.setUser(null);

        }
    }







}
