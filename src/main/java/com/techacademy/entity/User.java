package com.techacademy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private String name;

    @Column(length = 2)
    @Enumerated(EnumType.STRING)
    //このアノテーションで該当フィールドがEnum型であることを指定している
    private Gender gender;

    private Integer age; //文字列型、配列型以外にはlengthは指定できないから、これはされていない

    @Column(length = 50)
    private String email;



}
