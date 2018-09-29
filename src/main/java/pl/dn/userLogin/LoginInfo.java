package pl.dn.userLogin;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicUpdate;
import pl.dn.security.role.Role;
import pl.dn.user.User;

@Entity
@Table(name = "login_info")
@DynamicUpdate(true)
public class LoginInfo {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

	@JsonIgnore
    private String username;
    @JsonIgnore
	private String password;

    @ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

    private boolean enabled = true;

	public LoginInfo() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
