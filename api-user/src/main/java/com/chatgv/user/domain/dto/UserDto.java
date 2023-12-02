package com.chatgv.user.domain.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.sql.Date;

@Entity(name = "user")
@Getter
@Setter
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Cannot be null")
    @Size(min = 2, message = "invalid name")
    private String fullName;

    @NotBlank(message = "Cannot be null")
    @Email(message = "Invalid email")
    private String email;

    @NotBlank(message = "Cannot be null")
    @Size(min = 8, message = "Password must contain 8 characters")
    private String password;

    private String profilePic;

    private String phone;

    private Boolean isActive;

    private Boolean isReported;

    private Boolean isBlocked;

    private Date createdAt;

    private Date updatedAt;

//    @OneToOne(mappedBy = "blocked_user")
//    private BlockedUserDto blockedId;

}
