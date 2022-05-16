package com.example.testdb.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "test")
@Entity
public class TestEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "column1")
    private String column1;

    @Column(name = "column2")
    private String column2;

    @Column(name = "column3")
    private String column3;

    @Column(name = "column4")
    private String column4;

    @Column(name = "column5")
    private String column5;

    @Column(name = "column6")
    private String column6;

    @Column(name = "column7")
    private String column7;

    @Column(name = "column8")
    private String column8;
}

/*
* CREATE TABLE TEST (
    id integer primary key NOT NULL DEFAULT nextval('test_id'),
    column1 varchar(50),
    column2 varchar(50),
    column3 varchar(50),
    column4 varchar(50),
    column5 varchar(50),
    column6 varchar(50),
    column7 varchar(50),
    column8 varchar(50)
);

*
*
*
*
*
*
* */

