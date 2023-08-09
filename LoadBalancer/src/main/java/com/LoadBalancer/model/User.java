package com.LoadBalancer.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "UserDetailsTable")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @Schema(description = "Name of the user", example = "Vijay")
    private  String name;
    @Schema(description = "email of the user", example = "VijayTest@gmail.com")
    private  String email;
    @Schema(description = "userName of the user", example = "VijayTest@123")
    private  String userName;
}
