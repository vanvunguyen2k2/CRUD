package com.example.crud.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.jmx.export.annotation.ManagedAttribute;

@Entity
@Table(name = "token")
@Data
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "access_token")
    private String accessToken;

    @Column(name = "refresh_token")
    private String refreshToken;

    @Column(name = "is_logged_out")
    private boolean loggedOut;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
