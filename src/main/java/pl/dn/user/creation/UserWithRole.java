package pl.dn.user.creation;

import pl.dn.security.role.Role;
import pl.dn.user.User;

public class UserWithRole {

    private User user;
    private Role role;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
