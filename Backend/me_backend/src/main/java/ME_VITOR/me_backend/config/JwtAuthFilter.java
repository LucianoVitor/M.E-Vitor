    package ME_VITOR.me_backend.config;

    import ME_VITOR.me_backend.Util.JwtUtil;
    import io.jsonwebtoken.io.IOException;
    import jakarta.servlet.FilterChain;
    import jakarta.servlet.ServletException;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;
    import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
    import org.springframework.security.core.context.SecurityContextHolder;
    import org.springframework.web.filter.OncePerRequestFilter;

    import java.util.List;

    public class JwtAuthFilter extends OncePerRequestFilter {

        @Override
        protected void doFilterInternal(HttpServletRequest request,
                                        HttpServletResponse response,
                                        FilterChain filterChain) throws ServletException, IOException, java.io.IOException {

            System.out.println("JwtAuthFilter: entrando no filtro para " + request.getRequestURI());

            String token = getToken(request);
            System.out.println("JwtAuthFilter: token recebido -> " + token);
            if (token != null && JwtUtil.isTokenValido(token)) {
                String username = JwtUtil.getUsername(token);
                System.out.println("JwtAuthFilter: token válido, username = " + username);


                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(username, null, List.of());
                SecurityContextHolder.getContext().setAuthentication(auth);
            } else {
                SecurityContextHolder.clearContext();
            }

            filterChain.doFilter(request, response);
        }

        private String getToken(HttpServletRequest request) {
            String header = request.getHeader("Authorization");
            if (header != null && header.startsWith("Bearer ")) {
                return header.replace("Bearer ", "");
            }
            return null;
        }
    }

