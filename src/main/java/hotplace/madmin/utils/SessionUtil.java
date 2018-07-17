package hotplace.madmin.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import hotplace.madmin.domain.Account;


public class SessionUtil {

	public static Account getAccount() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Account user = (Account)auth.getPrincipal();
		return user;
	}
}
