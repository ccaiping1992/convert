import com.sys.Role
import com.sys.User

class BootStrap {

    def systemService;

    def init = { servletContext ->
        if (!User.findByUsername('admin')){
            def seft = systemService.getRandomNumber(20);
            User user = new User(username: "admin",passwordHash: new Sha256Hash("123456"+seft).toHex(),salt: seft);
            user.save(flush: true);

            Role role = new Role(name: "admin")
            role.addToPermissions("*:*");
            user.addToRoles(role);
            role.save(flush: true)
        }
    }
    def destroy = {
    }
}
