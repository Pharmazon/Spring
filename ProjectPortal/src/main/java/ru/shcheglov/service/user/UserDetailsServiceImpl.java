package ru.shcheglov.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shcheglov.model.user.Role;
import ru.shcheglov.model.user.UserProfile;
import ru.shcheglov.repository.user.RoleRepository;
import ru.shcheglov.repository.user.UserProfileRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 28.12.2018
 */

@Service("userDetailsService")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        final UserProfile userProfile = findByLogin(login);
        if (userProfile == null) throw new UsernameNotFoundException("User not found.");

        User.UserBuilder builder = User.withUsername(login);
        builder.password(userProfile.getUser().getPassword());
        
        final List<Role> userRoles = roleRepository.findAll();
        final List<String> roles = new ArrayList<>();
        for (final Role role : userRoles) roles.add(role.getName());
        builder.roles(roles.toArray(new String[] {}));

        return builder.build();
    }

    private UserProfile findByLogin(String login) {
        if (login == null || login.isEmpty()) return null;
        return userProfileRepository.findOneByLogin(login);
    }

}
