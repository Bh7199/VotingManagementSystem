package votingsystem;

import java.io.IOException;
import java.sql.SQLException;

public class VoterService {

//------------------------------------------------------------------------------------------------------
//Voter Registration

	public Voter voterRegistration(Voter voter) throws IOException, SQLException, ClassNotFoundException {
		VoterDaoInterface dao = new VoterDaoDB();

		dao.voterRegistration(voter);

		System.out.println("Voter Register successfully!");
		return voter;

	}
//----------------------------------------------------------------------------------------------------------
//Candidate Registration

	public Candidate CandidateRegistration(Candidate candidate)
			throws IOException, SQLException, ClassNotFoundException {
		VoterDaoInterface dao = new VoterDaoDB();

		dao.CandidatesRegistration(candidate);

		System.out.println("Candidate Register successfully!");
		return candidate;
	}

// -----------------------------------------------------------------------------------------------------
// View all voters
	public void viewAll() throws IOException {
		VoterDaoInterface dao = new VoterDaoDB();
		dao.viewAll();
	}

//-------------------------------------------------------------------------------------------------------
// SearchbyUsername	    
	public boolean checkIfUserNameExists(String username) {

		VoterDaoInterface dao = new VoterDaoDB();
		Voter voter = null;
		try {
			voter = dao.searchByUsername(username);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Some issue occurred");
			e.printStackTrace();
		}
		if (voter == null) {
			return false;
		} else {
			return true;
		}
	}

//--------------------------------------------------------------------------------------------------
//Search voter by voterid	 
	public Voter searchById(Integer id) throws IOException {
		VoterDaoDB dao = new VoterDaoDB();
		return dao.searchById(id);

	}

//----------------------------------------------------------------------------------------------------
//Voting process	    
	public Voter votingProcess(String username, String password) throws IOException {
		VoterDaoInterface dao = new VoterDaoDB();
		return dao.searchByUsernameAndPassword(username, password);

	}

//-----------------------------------------------------------------------------------------------------
//View Candidate list	     

	public void candidatesList() throws ClassNotFoundException, SQLException {
		System.out.println("For Election 2023 Registered Party and candidates are : ");
		VoterDaoInterface dao = new VoterDaoDB();
		try {
			dao.candidatesList();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}
//-------------------------------------------------------------------------------------------------------
//Search candidate by candidateid	    

	public int searchcandidatebycandidateid(int candidateid) throws IOException, ClassNotFoundException, SQLException {
		VoterDaoInterface dao = new VoterDaoDB();
		Candidate candidate = null;
		candidate = dao.searchcandidatebycandidateid(candidateid);

		if (candidate != null) {
			

		}
		return candidateid;
	}
//------------------------------------------------------------------------------------------------------
//Voter voter	    

	public void voted() throws IOException, ClassNotFoundException, SQLException {
		System.out.println("you voted to ");
		VoterDaoInterface dao = new VoterDaoDB();
		Candidate candidate = null;
		dao.voted(candidate);

	}

//-------------------------------------------------------------------------------------------------------
//VoteCount	    
	public void voteCount(int count) throws IOException, ClassNotFoundException, SQLException {
		System.out.println("Total votes: ");
		VoterDaoInterface dao = new VoterDaoDB();
		dao.voteCount(count);

	}
//--------------------------------------------------------------------------------------------------------
//Edit VoterList	    

	public static void editVoterlist(Voter voter) throws IOException {
		VoterDaoDB dao = new VoterDaoDB();
		dao.editVoterlist(voter);
		System.out.println("Edited Successfully.");
	}

	// ---------------------------------------------------------------------------------------------------------
// View profile	    
	public void viewProfile(Voter voter) {
		VoterDaoInterface dao = new VoterDaoDB();
		if (voter != null) {
			System.out.println(voter);
		}
	}

}
