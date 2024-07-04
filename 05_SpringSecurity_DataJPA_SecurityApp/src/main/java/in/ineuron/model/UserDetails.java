package in.ineuron.model;

import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Table(name="SECURITY_USERS")
@Entity
public class UserDetails {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Integer uid;
	@Column(length=20,unique=true,nullable=false)
	private String uname;
	@Column(length=150,unique=true,nullable=false)
	private String pwd;
	@Column(length=20,unique=true,nullable=false)
	private String mail;
	private boolean status=true;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="SECURITY_ROLES",joinColumns = @JoinColumn(name="USER_ID",referencedColumnName = "uid"))
	@Column(name="role")
	private Set<String> roles;

	public UserDetails(Integer uid, String uname, String pwd, String mail, boolean status, Set<String> roles) {
		this.uid = uid;
		this.uname = uname;
		this.pwd = pwd;
		this.mail = mail;
		this.status = status;
		this.roles = roles;
	}

	public UserDetails() {
	}

	@Override
	public String toString() {
		return "UserDetails [uid=" + uid + ", uname=" + uname + ", pwd=" + pwd + ", mail=" + mail + ", status=" + status
				+ ", roles=" + roles + "]";
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

}
