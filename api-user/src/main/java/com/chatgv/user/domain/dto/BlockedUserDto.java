package com.chatgv.user.domain.dto;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity(name = "blocked_user")
@Getter
@Setter
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class BlockedUserDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date createdAt;

    private Date updatedAt;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id", referencedColumnName = "id")
    private Long userId;

    private Long participantId;

}
