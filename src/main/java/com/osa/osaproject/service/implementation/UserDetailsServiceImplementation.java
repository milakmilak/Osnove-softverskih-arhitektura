package com.osa.osaproject.service.implementation;

import com.osa.osaproject.model.Administrator;
import com.osa.osaproject.model.Kupac;
import com.osa.osaproject.model.Prodavac;
import com.osa.osaproject.service.AdministratorService;
import com.osa.osaproject.service.KupacService;
import com.osa.osaproject.service.ProdavacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

    @Autowired
    public KupacService kupacService;

    @Autowired
    public ProdavacService prodavacService;

    @Autowired
    public AdministratorService administratorService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Administrator admin = administratorService.findByUsername(username);
        Kupac kupac = kupacService.findByUsername(username);
        Prodavac prodavac = prodavacService.findByUsername(username);

        if(admin == null && kupac == null && prodavac == null) {
            throw new UsernameNotFoundException("There is no user with username: " + username);
        }

        if(admin != null) {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            String role = admin.getRole().toString();

            grantedAuthorities.add(new SimpleGrantedAuthority(role));

            return new User(admin.getUsername(), admin.getPassword(), grantedAuthorities);
        }

        if(kupac != null) {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            String role = kupac.getRole().toString();

            grantedAuthorities.add(new SimpleGrantedAuthority(role));

            return new User(kupac.getUsername(), kupac.getPassword(), grantedAuthorities);
        }

        if(prodavac != null) {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            String role = prodavac.getRole().toString();

            grantedAuthorities.add(new SimpleGrantedAuthority(role));

            return new User(prodavac.getUsername(), prodavac.getPassword(), grantedAuthorities);
        }

        return null;

    }
}
