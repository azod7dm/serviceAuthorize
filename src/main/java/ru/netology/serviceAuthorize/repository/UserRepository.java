package ru.netology.serviceAuthorize.repository;

import org.springframework.stereotype.Component;
import ru.netology.serviceAuthorize.model.Authorities;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {

    // Пример данных пользователей. На практике вы бы получали данные из БД или другого источника.
    private final List<UserData> usersData;

    public UserRepository() {
        usersData = new ArrayList<>();
        usersData.add(new UserData("user1", "password1", List.of(Authorities.READ, Authorities.WRITE)));
        usersData.add(new UserData("user2", "password2", List.of(Authorities.READ)));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        for (UserData userData : usersData) {
            if (userData.username().equals(user) && userData.password().equals(password)) {
                return userData.authorities();
            }
        }
        return new ArrayList<>(); // Возвращаем пустой список, если пользователь не найден
    }

    // Определение класса record UserData
    public record UserData(String username, String password, List<Authorities> authorities) {}
}