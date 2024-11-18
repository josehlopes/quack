package com.thigas.quack.Infrastructure.Security;

import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Model.Request.UserDsDtoRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    //TODO: CRIAR MÉTODO PERSONALIZADO "loadByEmail"
    //TODO: DESCOBRIR PARA QUE SERVE A CLASSE UserDetailsService
    @Autowired
    private UserDsGateway userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDsDtoRequestModel user = this.userRepository.getByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        return new User(user.email(), user.password(),
                new ArrayList<>());
    }
}
