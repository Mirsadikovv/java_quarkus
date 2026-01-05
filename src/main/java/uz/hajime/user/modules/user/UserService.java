package uz.hajime.user.modules.user;

import org.hibernate.exception.ConstraintViolationException;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import uz.hajime.user.modules.user.dto.UserCreateDto;
import uz.hajime.user.modules.user.entity.UserEntity;
import uz.hajime.user.modules.user.repository.UserRepository;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    @Transactional
    public UserEntity createUser(UserCreateDto dto) {
        try {
            UserEntity user = new UserEntity();
            user.username = dto.username;
            user.firstName = dto.firstName;
            user.lastName = dto.lastName;
            userRepository.persist(user);
            return user;
        } catch (Exception e) {
            if (e.getCause() instanceof ConstraintViolationException) {
                throw new WebApplicationException(
                        "Пользователь с таким username уже существует",
                        Response.Status.CONFLICT);
            }
            throw e;
        }
    }
}
