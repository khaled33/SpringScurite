package com.sid.Securite;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class JWTAuthorrizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String jwt= httpServletRequest.getHeader(ConstantSecurity.HEADER_STRING);


        if (jwt==null){
            filterChain.doFilter(httpServletRequest,httpServletResponse);
            return;
        }


        Claims clims= Jwts.parser()
                .setSigningKey(ConstantSecurity.SECRET)
                .parseClaimsJws(jwt)
                .getBody();
        String username=clims.getSubject();


        ArrayList<Map<String,String>> roles= ( ArrayList<Map<String,String>>)clims.get("roles");
        Collection<GrantedAuthority> authorities= new ArrayList<>();

        roles.forEach(r->{
            authorities.add(new SimpleGrantedAuthority(r.get("authority")));
        });


        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username,null,authorities);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(httpServletRequest,httpServletResponse);


    }
}
