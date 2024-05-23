package com.dzoms.user_settings_service.usersetting.service;

import com.dzoms.user_settings_service.usersetting.domain.UserSettingsEntity;
import com.dzoms.user_settings_service.usersetting.domain.UserSettingsRepository;
import com.dzoms.user_settings_service.usersetting.mapping.UserSettingsMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import transfer.contract.domain.common.OperationStatus;
import transfer.contract.domain.usersettings.UserSettingsOperationErrorCode;
import transfer.contract.domain.usersettings.UserSettingsOperationResultTo;
import transfer.contract.domain.usersettings.UserSettingsTo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserSettingsCreateUseCase {
    private final UserSettingsRepository repository;
    private final UserSettingsMapper mapper;

    @Transactional
    public UserSettingsEntity createUserSettings(UUID userId, final UserSettingsTo settingsTo) {

        UserSettingsEntity entity = mapper.mapFromTo(settingsTo);
        entity.setId(userId);
        repository.save(entity);

        return entity;
    }
}
