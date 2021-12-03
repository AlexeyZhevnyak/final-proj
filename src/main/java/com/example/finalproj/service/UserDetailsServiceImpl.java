package com.example.finalproj.service;

import com.example.finalproj.model.Programmer;
import com.example.finalproj.model.ProgrammerUserDetail;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final ProgrammerService programmerService;
    private final HttpSession session;
    public UserDetailsServiceImpl(ProgrammerService programmerService, HttpSession session) {
        this.programmerService = programmerService;
        this.session = session;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<Programmer> programmers = programmerService.getAll();
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        Programmer programmer = programmers.stream()
            .filter(p -> p.getLogin().equals(s))
            .findFirst()
            .get();
        session.setAttribute("currentUserId", programmer.getId());
        authorities.add(new SimpleGrantedAuthority(programmer.getRole().name()));
        ProgrammerUserDetail programmerUserDetail = new ProgrammerUserDetail();
        programmerUserDetail.setProgrammer(programmer);
        programmerUserDetail.setAuthorities(authorities);
        return programmerUserDetail;
    }
}
