package com.mobeom.local_currency.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Component
interface UserService {

    Optional<User> findUserbyUserId(String user);

    User update(User selectUser);

    void delete(User selectUser);

    Optional<User> findUser(Long id);

    Optional<User> createUser(User user);
}

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<User> findUserbyUserId(String user) {
        Optional<User> idCheck = userRepository.findByUserId(user);
        return idCheck;
    }

    @Override
    public User update(User selectUser) {
        return userRepository.save(selectUser);
    }

    @Override
    public void delete(User selectUser) {
        userRepository.delete(selectUser);
    }

    @Override
    public Optional<User> findUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> createUser(User user) {
        User createUser = new User();
        createUser.setUserId(user.getUserId());
        createUser.setPassword(user.getPassword());
        createUser.setName(user.getName());
        createUser.setBirthDate(user.getBirthDate());
        createUser.setGender(user.getGender());
        createUser.setEmail(user.getEmail());
        createUser.setAdminKey(0);
        createUser.setJoinDate(LocalDate.now());
        createUser.setDefaultAddr(user.getDefaultAddr());
        createUser.setOptionalAddr(user.getOptionalAddr());
        
        System.out.println(createUser);
        User savedUser = userRepository.save(createUser);
        return Optional.of(savedUser);
    }

}
