package com.dzoms.user_settings_service.usersetting.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserSettingsRepository extends JpaRepository<UserSettingsEntity, UUID> {
    Optional<UserSettingsEntity> findUserSettingsEntityById(UUID id);
}
