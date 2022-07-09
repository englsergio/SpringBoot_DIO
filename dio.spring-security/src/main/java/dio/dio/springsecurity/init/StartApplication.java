package dio.dio.springsecurity.init;

import dio.dio.springsecurity.model.User;
import dio.dio.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class StartApplication implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Transactional
    @Override
    public void run(String... args) throws Exception {
        User user = userRepository.findByUsername("admin");
        if(user == null) {
            user = new User();
            user.setName("ADMIN");
            user.setUsername("admin");
            user.setPassword("password");
            user.getRoles().add("MANAGERS");
            userRepository.save(user);
        }
        user = userRepository.findByUsername("user");
        if(user == null) {
            user = new User();
            user.setName("USER");
            user.setUsername("user");
            user.setPassword("password");
            user.getRoles().add("USERS");
            userRepository.save(user);
        }
        System.out.println(user);
    }
}
