package de.telekom.bmp.data;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Indexed;
import com.google.code.morphia.annotations.Version;

/**
 * 
 * @author Daniel
 */
@Entity
public class User {

	@Id
	ObjectId id;

	@Version
	long version;

	public String name;

	public String firstName;

	public String company;

	@Indexed(unique = true)
	public String email;

	public String password;

	public UserRole role;

	public boolean valid;

	// public states
	public boolean registered = false;

	public Set<String> apps = new TreeSet<>();

	public User() {
	}

	public User(String name, String mail, UserRole role) {
		this.name = name;
		this.email = mail;
		this.role = role;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public void setRegistered(boolean registered) {
		this.registered = registered;
	}

	public void setApps(Set<String> apps) {
		this.apps = apps;
	}

	/**
	 * Create a user object with some default data
	 * 
	 * @return a user instance
	 */
	public static User createUser(String mailPrefix) {
		long postfixIdentifier = createPostfixId();
		User newUser = new User();

		newUser.email = createMailAlias(mailPrefix, postfixIdentifier);
		newUser.password = "12345!QAY";
		newUser.firstName = addIdentifier("max", postfixIdentifier);
		newUser.name = addIdentifier("mustermann", postfixIdentifier);
		newUser.company = addIdentifier("companyName", postfixIdentifier);
		newUser.registered = false;
		newUser.role = UserRole.USER;
		newUser.valid = false;

		return newUser;
	}

	private static String addIdentifier(String value, long identifier) {
		return value + "+" + identifier;
	}

	private static String createMailAlias(String mailPrefix, long identifier) {
		if ("".equals(mailPrefix)) {
			mailPrefix = "mybmptestuser";
		}
		return addIdentifier(mailPrefix, identifier) + "@gmail.com";
	}

	private static long createPostfixId() {
		return (new Date()).getTime();
	}
}
