package com.nightlos.exp1.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    public static final int admin=10,user=20;
    @Id
    private Integer id;
    private String account;
    private String password;
    private Integer role;
}
