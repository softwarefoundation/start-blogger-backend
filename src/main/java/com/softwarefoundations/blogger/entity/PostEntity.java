package com.softwarefoundations.blogger.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb02_post")
public class PostEntity extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postid")
    private Long postId;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "texto")
    private String texto;

    @Column(name = "data_cadastro", updatable = false)
    private LocalDateTime dataCadastro;


    @PrePersist
    private void prePersist(){
        this.dataCadastro = LocalDateTime.now();
    }

}
