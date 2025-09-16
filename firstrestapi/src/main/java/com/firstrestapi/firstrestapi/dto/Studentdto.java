package com.firstrestapi.firstrestapi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Studentdto {

    private Long Id;
    private String Name;
    private String Email;

//    public Student(long id, String name, String email) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//    }
}
