// package com.thigas.quack.infrastructure.security;
//
// import com.thigas.quack.domain.entity.UserEntity;
// import com.thigas.quack.domain.repository.IUserRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import
// org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Component;
//
// import java.util.ArrayList;
//
// @Component
// public class CustomUserDetailsService implements UserDetailsService {
//
// @Autowired
// private IUserRepository userRepository;
//
// @Override
// public UserDetails loadUserByUsername(String username) throws
// UsernameNotFoundException {
// UserEntity user = this.userRepository.findByEmail(username)
// .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
// return new
// org.springframework.security.core.userdetails.User(user.getEmail(),
// user.getPassword(),
// new ArrayList<>());
// }
// }
