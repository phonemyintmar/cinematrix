package mm.com.cinematrix.controller.admin;

import mm.com.cinematrix.business.movie.dto.MovieRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin
@RolesAllowed("ROLE_ADMIN")
public class AdminShowController {

    @PostMapping("")
    public ResponseEntity<?> addMovie(@Valid @RequestBody MovieRequest movieRequest, Principal principal){
        return ResponseEntity.ok(List.of(movieRequest,principal));
    }

    @GetMapping("/test")
    public String test(Principal principal){
        System.out.println(principal);
        return "test";
    }
}
