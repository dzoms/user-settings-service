package com.dzoms.user_settings_service.usersetting.mapping;

import com.dzoms.user_settings_service.usersetting.domain.UserSettingsEntity;
import lombok.RequiredArgsConstructor;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import transfer.contract.domain.usersettings.UserSettingsTo;

@Mapper(componentModel = "spring")
@RequiredArgsConstructor
public abstract class UserSettingsMapper {

    public abstract UserSettingsEntity mapFromTo(UserSettingsTo to);

    public abstract UserSettingsTo mapFromEntity(UserSettingsEntity entity);
}
