package com.dzoms.user_settings_service.usersetting.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Objects;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "user_settings_entity")
@ToString
public class UserSettingsEntity {
    @Id
    private UUID id;
    
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "avatar", nullable = false)
    private String avatar;

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        if (another == null || getClass() != another.getClass()) return false;
        UserSettingsEntity that = (UserSettingsEntity) another;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
