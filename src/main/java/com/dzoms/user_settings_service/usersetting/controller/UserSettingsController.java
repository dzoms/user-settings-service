package com.dzoms.user_settings_service.usersetting.controller;

import com.dzoms.user_settings_service.usersetting.domain.UserSettingsEntity;
import com.dzoms.user_settings_service.usersetting.domain.UserSettingsRepository;
import com.dzoms.user_settings_service.usersetting.service.UserSettingsCreateUseCase;
import com.dzoms.user_settings_service.usersetting.service.UserSettingsFindUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import transfer.contract.domain.usersettings.UserSettingsOperationResultTo;
import transfer.contract.domain.usersettings.UserSettingsTo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user-settings")
@CrossOrigin
public class UserSettingsController {

    private final UserSettingsCreateUseCase createUseCase;
    private final UserSettingsFindUseCase findUseCase;

    @PostMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public UserSettingsEntity createUserSettings(final @Valid @RequestBody UserSettingsTo settingsTo) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return createUseCase.createUserSettings(UUID.fromString(authentication.getName()), settingsTo);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<UserSettingsEntity> getUserSettings(final @Valid @PathVariable UUID id) {
        UserSettingsEntity userSettings = findUseCase.findById(id);
        return ResponseEntity.ok(userSettings);
    }

    @GetMapping(produces = "application/json")
    public List<UserSettingsEntity> getUsers() {
        return findUseCase.gelAll();
    }
}
