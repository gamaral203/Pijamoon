package com.Pijamoon.pijamoon_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true, name = "cpf")
    private String cpf;

    @Column(unique = true, name = "email")
    private String email;

    @Column(unique = true, name = "telefone")
    private String telefone;
}
