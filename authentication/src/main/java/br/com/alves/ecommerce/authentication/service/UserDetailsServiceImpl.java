package br.com.alves.ecommerce.authentication.service;

import br.com.alves.ecommerce.authentication.domain.User;
import br.com.alves.ecommerce.authentication.domain.util.UserDetailsImpl;
import br.com.alves.ecommerce.authentication.repository.IUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final IUserRepository userRepository;

    public UserDetailsServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("User not found."));
        return new UserDetailsImpl(user);
    }
}
