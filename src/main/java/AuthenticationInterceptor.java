import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Verifica se l'utente è autenticato. Modifica la logica in base alla tua implementazione di autenticazione.
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	
    	boolean isLoggedIn = authentication != null && authentication.isAuthenticated();

        if (!isLoggedIn) {
            // L'utente non è autenticato, blocca l'accesso alla pagina e reindirizza alla pagina di login.
            response.sendRedirect("/OfficineTreni/login"); // Cambia "/login" con l'URL della tua pagina di login.
            return false;
        }

        // L'utente è autenticato, permetti l'accesso alla pagina.
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // Implementazione opzionale, da eseguire dopo l'elaborazione della richiesta e prima di renderizzare la vista.
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // Implementazione opzionale, da eseguire dopo il completamento dell'intera richiesta, inclusa la renderizzazione della vista (dopo la fase di renderizzazione).
    }
}