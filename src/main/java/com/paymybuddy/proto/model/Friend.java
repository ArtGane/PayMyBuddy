package com.paymybuddy.proto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_friend")
@Data
public class Friend {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime creationDate;

    @ManyToMany
    private List<Profile> profiles = new ArrayList<>();

}
