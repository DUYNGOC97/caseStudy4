package com.codegym.casestudy4.service.impl;

import com.codegym.casestudy4.dto.UserDto;
import com.codegym.casestudy4.entity.Customer;
import com.codegym.casestudy4.entity.Roles;
import com.codegym.casestudy4.entity.User;
import com.codegym.casestudy4.mapper.UserMapper;
import com.codegym.casestudy4.repository.CustomerRepository;
import com.codegym.casestudy4.repository.RoleRepository;
import com.codegym.casestudy4.repository.UserRepository;
import com.codegym.casestudy4.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private CustomerRepository customerRepository;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder,
                           CustomerRepository customerRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.customerRepository = customerRepository;
    }
    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        Roles role = roleRepository.findByName("ROLE_CUSTOMER");
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
        User user1 = userRepository.findByUsername(user.getUsername());
        Customer customer = new Customer(user1);
        customerRepository.save(customer);
    }
    public boolean isPasswordCorrect(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
    private Roles checkRoleExist() {
        Roles role = new Roles();
        role.setName("ROLE_CUSTOMER");
        return roleRepository.save(role);
    }

    @Override
    public User findUserByEmail(String email) {
         return userRepository.findByEmail(email);
    }
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDto findUserById(long id) {
        User user = userRepository.findById(id);
        UserDto userDto = UserMapper.toDto(user);
        return userDto;
    }


    //        @Override
//    public List<UserDto> findAllUser() {
//        List<User> users = userRepository.findAll();
//        return users.stream()
//                .map((user) -> mapToUserDto(user))
//                .collect(Collectors.toList());
//    }
    public User login(String username){
        return userRepository.findByUsername(username);
    }

//    private UserDto mapToUserDto(User user) {
//        UserDto userDto = new UserDto();
////        String[] str = user.getUsername().split(" ");
////        userDto.setFirstName(str[0]);
////        userDto.setLastName(str[1]);
//        userDto.setUsername(user.getUsername());
//        userDto.setEmail(user.getEmail());
//        return userDto;
//    }
}
