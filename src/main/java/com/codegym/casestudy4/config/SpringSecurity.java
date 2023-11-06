package com.codegym.casestudy4.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@Configuration
@EnableWebSecurity
public class SpringSecurity {
//    cung cấp thông tin chi tiết người dùng cho Spring Security.
    @Autowired
    private UserDetailsService userDetailsService;
//    Đối tượng PasswordEncoder chịu trách nhiệm mã hóa mật khẩu.
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
//    Đối tượng SecurityFilterChain chịu trách nhiệm lọc các yêu cầu đến ứng dụng.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        vô hiệu hóa tính năng bảo vệ CSRF(buộc người dùng thực hiện các hành động mà họ không mong muốn)
        http.csrf().disable()
                //cấu hình truy cập cho các điểm cuối
                .authorizeHttpRequests((authorize) ->
                        authorize.antMatchers("/register/**").permitAll()
                                .antMatchers("/index").permitAll()
                                .antMatchers("/users").hasRole("CUSTOMER")
                ).formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/users")
                                .permitAll()
                ).logout(
                        //cấu hình đăng xuất
                        logout -> logout
                                //phương thức được sử dụng để đặt URL đăng xuất.
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                        cho phép tất cả các yêu cầu HTTP.
                                .permitAll()
                );
        return http.build();
    }
//định cấu hình cơ chế xác thực
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                // chỉ định dịch vụ chi tiết người dùng.
                .userDetailsService(userDetailsService)
                //chỉ định bộ mã hóa mật khẩu.
                .passwordEncoder(passwordEncoder());
    }
}
