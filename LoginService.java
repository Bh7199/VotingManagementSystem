package votingsystem;

import java.io.IOException;

public class LoginService {
	/**
	 * Log into the system
	 * 
	 * @param username
	 * @param password
	 * @return true if login is successful, else false
	 */
	Voter login(String username, String password) {

		VoterDaoInterface dao = new VoterDaoDB();

		Voter voter = null;
		try {
			voter = dao.searchByUsernameAndPassword(username, password);
		} catch (IOException e) {
			System.out.println("Some issue occurred");
			e.printStackTrace();
		}

		return voter;
	}

	public void login() {
		

	}

}
