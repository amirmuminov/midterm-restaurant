package kz.muminov.midtermrestaraunt.service;

import kz.muminov.midtermrestaraunt.entity.Role;
import kz.muminov.midtermrestaraunt.entity.User;
import kz.muminov.midtermrestaraunt.exception.types.RoleNotFoundException;
import kz.muminov.midtermrestaraunt.exception.types.UserNotFoundException;
import kz.muminov.midtermrestaraunt.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleService roleService;

    public UserService(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(Long id){
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public User saveUser(User user){
        Set<Role> roleSet = new HashSet<>();
        for (Role role: user.getRoles()) {
            Role userRole = roleService.getRoleById(role.getId());
            if(userRole != null){
                roleSet.add(userRole);
            }
            else{
                throw new RoleNotFoundException(role.getId());
            }
        }
        user.setRoles(roleSet);
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null)
            throw new UsernameNotFoundException("The user with username " + username + " is not found");

        return user;

    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "The user with id " + id + " is deleted";
    }
}
