package com.firstrestapi.firstrestapi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Studentdto {

    private Long id;
    private String name;
    private String email;

//    public Studentdto(long id, String name, String email) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//    }
}
