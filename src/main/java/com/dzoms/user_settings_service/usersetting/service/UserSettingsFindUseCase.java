package com.dzoms.user_settings_service.usersetting.service;

import com.dzoms.user_settings_service.usersetting.domain.UserSettingsEntity;
import com.dzoms.user_settings_service.usersetting.domain.UserSettingsRepository;
import com.dzoms.user_settings_service.usersetting.mapping.UserSettingsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import transfer.contract.domain.usersettings.UserSettingsTo;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserSettingsFindUseCase {

    private final UserSettingsMapper mapper;
    private final UserSettingsRepository repository;

    public UserSettingsEntity findById(UUID id) {
        return repository.findUserSettingsEntityById(id).orElse(null);
    }

    public List<UserSettingsEntity> gelAll() {
        return repository.findAll();
    }
}
