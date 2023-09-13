package mm.com.cinematrix.business.userBusiness.show.impl;

import com.pm.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import mm.com.cinematrix.business.userBusiness.show.IShowBusiness;
import mm.com.cinematrix.log.Loggable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;

@Service
@Slf4j
@Loggable
public class ShowBusiness implements IShowBusiness {

//    private final ShowRepo showRepo;
//
//    public ShowBusiness(ShowRepo showRepo) {
//        this.showRepo = showRepo;
//    }


    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<?> getShowsByMovieId(String movieId) {
        return ResponseUtil.onDefaultSuccess("Infra");
    }
}
