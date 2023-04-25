package com.example.QuizApp.Model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
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

    private Long uid;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;

    public Users(Long uid, String name, String email) {
        this.uid = uid;
        this.name = name;
        this.email = email;
    }

    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
