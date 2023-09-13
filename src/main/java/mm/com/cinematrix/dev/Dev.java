package mm.com.cinematrix.dev;

import com.pm.springfireauth.util.RoleUtil;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Dev {

    private final RoleUtil roleUtil;

    public Dev(RoleUtil roleUtil) {
        this.roleUtil = roleUtil;
    }

//    private void test(){
//        roleUtil.addRole("SUPER_ADMIN");
//    }

}
