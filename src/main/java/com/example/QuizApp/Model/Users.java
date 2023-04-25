package com.example.QuizApp.Model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Users")
public class Users {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long user_id;
    @Column(name = "user_name")
    private String user_name;
    @Column(name = "user_email")
    private String user_email;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;

    public Users(String user_name, String user_email, String password, String role) {
        this.user_name = user_name;
        this.user_email = user_email;
        this.password = password;
        this.role = role;
    }
}
