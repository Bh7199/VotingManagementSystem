package votingsystem;

import java.io.IOException;
import java.sql.SQLException;

public interface VoterDaoInterface {

	public void viewAll() throws IOException;

	public Voter searchById(Integer id) throws IOException;

	public void editVoterlist(Voter voter) throws IOException;

	public Voter voterRegistration(Voter voter) throws IOException, ClassNotFoundException, SQLException;

	public Voter searchByUsernameAndPassword(String username, String password) throws IOException;

	public Voter searchByUsername(String username) throws IOException;

	public Candidate CandidatesRegistration(Candidate candidate)
			throws IOException, ClassNotFoundException, SQLException;

	public void candidatesList() throws IOException, ClassNotFoundException, SQLException;
	
	public Candidate searchcandidatebycandidateid(int candidateid)throws IOException, ClassNotFoundException, SQLException;

	public Voter voted(Candidate candidate) throws IOException, ClassNotFoundException, SQLException;

	public Candidate voteCount(int count) throws IOException, ClassNotFoundException, SQLException;
	


}
