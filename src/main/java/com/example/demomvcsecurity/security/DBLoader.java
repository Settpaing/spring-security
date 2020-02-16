package com.example.demomvcsecurity.security;

import com.example.demomvcsecurity.domain.Roles;
import com.example.demomvcsecurity.domain.User;
import com.example.demomvcsecurity.repository.RoleRepository;
import com.example.demomvcsecurity.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DBLoader implements CommandLineRunner {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public DBLoader(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository, RoleRepository roleRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Roles admin = new Roles();
        admin.setName("ROLE_ADMIN");
        Roles user = new Roles();
        user.setName("ROLE_USER");

        User adminUser = new User();
        adminUser.setEmail("sett@gmail.com");
        adminUser.setPassword(bCryptPasswordEncoder.encode("sett"));

        User user1 = new User();
        user1.setEmail("paing@gmail.com");
        user1.setPassword(bCryptPasswordEncoder.encode("paing"));

        //mapping
        adminUser.getRoles().add(admin);
        adminUser.getRoles().add(user);
        user1.getRoles().add(user);

      //  userRepository.save(adminUser);
      //  userRepository.save(user1);
    }
}
