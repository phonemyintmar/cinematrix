package mm.com.cinematrix.business.show.impl;

import com.pm.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import mm.com.cinematrix.business.show.IShowBusiness;
import mm.com.cinematrix.db.repo.ShowRepo;
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
