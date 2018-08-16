package com.example.demo.democonsole.services;

import com.example.demo.democonsole.repositories.UsersRepository;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private final UsersRepository usersRepository;

    public AppUserDetailsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usersRepository.findUserByEmail(username)
                .map(user -> new User(user.getEmail(), user.getPassword(),
                        AuthorityUtils.createAuthorityList(user.getRole().name())))
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

}
