package hotplace.madmin.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hotplace.madmin.dao.UserDao;
import hotplace.madmin.domain.Account;

@Service("userService")
public class UserService {

	@Resource(name="userDao")
	private UserDao userDao;
	
	public Account getUserInfo(String username) {
		return userDao.getAccount(username);
	}
}
