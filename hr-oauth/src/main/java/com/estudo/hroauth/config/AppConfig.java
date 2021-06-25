//package com.estudo.hroauth.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
//import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
//
//@Configuration
//public class AppConfig {
//
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public JwtAccessTokenConverter AccessTokenConnverter(){
//         JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
//         tokenConverter.setSigningKey("MY-SECRET-KEY");//metodos depreciados, pode ser que não funcione
//         return tokenConverter;
//    }
//    @Bean
//    public JwtTokenStore tokenStore(){
//        return new JwtTokenStore(AccessTokenConnverter());//metodos depreciados, pode ser que não funcione
//    }
//
//
//}
