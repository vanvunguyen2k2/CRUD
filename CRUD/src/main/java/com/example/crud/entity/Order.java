package com.example.crud.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "`Order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "user_id")
//    @JsonIgnoreProperties({"appliedJob"})
    private User user;


    @Enumerated(EnumType.STRING)
    @Column(name = "jobStatus")
    private JobStatus jobStatus;





}
