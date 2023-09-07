package com.example.kyo.user.test;

import java.util.Date;

import com.example.kyo.levelpermission.LevelPermissionType;
import com.example.kyo.user.definition.UserModel;

public class UserMock {

    public static UserModel createMock() {
        UserModel mock = new UserModel();

        mock.setId(1L);
        mock.setName("John Doe");
        mock.setEmail("john.doe@example.com");
        mock.setNickName("johndoe");
        mock.setPassword("password123");
        mock.setCreatedAt(new Date());
        mock.setLevelPermission(LevelPermissionType.ADMIN);

        return mock;
    }

    // Métodos de configuração opcionais para personalizar os valores dos campos
    public static UserModel createMockWithCustomName(String name) {
        UserModel mock = createMock();
        mock.setName(name);
        return mock;
    }
}

