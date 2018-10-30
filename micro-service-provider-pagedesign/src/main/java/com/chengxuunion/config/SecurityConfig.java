package com.chengxuunion.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 安全配置
 *
 * @author kutome
 * @date 2018年10月30日
 * @version V1.0
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		//在内存中使用BCryptPasswordEncoder加密方式进行加密，用户名：user，密码：password加密后的密文，用户角色为USER
		auth
			.inMemoryAuthentication()
				.passwordEncoder(new BCryptPasswordEncoder())
				.withUser("user")
				.password(new BCryptPasswordEncoder().encode("password")).roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// /login不需要验证
		// 其它请求需要有USER角色
		// 支持默认的FormLogin验证
		// 支持默认的HTTP Basic验证
		http
			.authorizeRequests()
				.antMatchers("/login").permitAll()
				.anyRequest().hasRole("USER")
				.and()
			.formLogin()
				.and()
			.csrf().disable()
			.httpBasic();	
	}
	
}
