package votingsystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class VoterDaoDB implements VoterDaoInterface {

	private final static String USERNAME = "root";

	private final static String PASSWORD = "Bhbabmp1";

	private final static String URL = "jdbc:mysql://localhost:3306/voter";

//---------------------------------------------------------------------------------------------------------
//Voter Registration 
//Done ,No any issues 	
	@Override
	public Voter voterRegistration(Voter voter) throws IOException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		String insertQuery = "INSERT INTO voterlist (first_name, last_name,gender,dateofbirth,username,password)"
				+ "value ( '" + voter.getFirstName() + "', '" + voter.getLastName() + "','" + voter.getGender() + "','"
				+ voter.getDateofbirth() + "','" + voter.getUsername() + "','" + voter.getPassword() + "')";

		System.out.println(insertQuery);

		Statement statement = con.createStatement();
		int resultValue = statement.executeUpdate(insertQuery);

		if (resultValue == 2) {
			System.out.println("Failed to insert/update data. Check your data and try again.");
		}

		statement.close();
		con.close();

		return voter;

	}

//------------------------------------------------------------------------------------------------------
//View all voters
	@Override
	public void viewAll() throws IOException {
		Connection con = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String query = "SELECT * from voterlist";

			// System.out.println(query);

			statement = con.createStatement();

			ResultSet results = statement.executeQuery(query);
			System.out.println("\tVoterList");
			while (results.next()) {

				System.out.println("***************************");
				System.out.println(results.getInt(1));
				System.out.println(results.getString(2));
				System.out.println(results.getString(3));
				System.out.println(results.getString(4));
				System.out.println(results.getDate(5));
				System.out.println(results.getString(6));
				System.out.println(results.getString(7));
				System.out.println();

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

//------------------------------------------------------------------------------------------------------------
//Add table 
//Have question	
	public void addTable() {
		Connection con = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			// String query = "Create table if not exists emp1 (id int not null, fistname
			// varchar(20) not null)";

			StringBuilder query = new StringBuilder();
			query.append("Create table if not exists emp1 (id int not null, fistname varchar(20) not null)");

			statement = con.createStatement();
			statement.execute(query.toString());

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
//--------------------------------------------------------------------------------------------------------
//Search voter by id

	@Override
	public Voter searchById(Integer id) throws IOException {
		Connection con = null;
		Statement statement = null;
		Voter voter = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String query = " select * from voterlist id = '" + id + "'";

			statement = con.createStatement();
			ResultSet results = statement.executeQuery(query);
			while (results.next()) {
				voter = new Voter();
				voter.setId(results.getInt(1));
				voter.setFirstName(results.getString(2));
				voter.setLastName(results.getString(3));
				voter.setGender(Gender.getByValue(results.getString(4)));
				LocalDate dob = LocalDate.parse(results.getString(5));
				voter.setDateofbirth(dob);
				voter.setUsername(results.getString(6));
				voter.setPassword(results.getString(7));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return voter;
	}

//---------------------------------------------------------------------------------------------------------
//Search voter by username and password
//Need to have look 	
	@Override
	public Voter searchByUsernameAndPassword(String username, String password) throws IOException {
		Connection con = null;
		Statement statement = null;
		Voter voter = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String query = "select * from voterlist where username ='" + username + "' and password='" + password + "'";
			System.out.println(query);

			statement = con.createStatement();
			ResultSet results = statement.executeQuery(query);

			while (results.next()) {
				voter = new Voter();
				voter.setId(results.getInt(1));
				voter.setFirstName(results.getString(2));
				voter.setLastName(results.getString(3));
				voter.setGender(Gender.getByValue(results.getString(4)));
				LocalDate dob = LocalDate.parse(results.getString(5));
				voter.setDateofbirth(dob);
				voter.setUsername(results.getString(6));
				voter.setPassword(results.getString(7));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return voter;

	}

//---------------------------------------------------------------------------------------------------------
//Search voter by username
//need to have look	
	@Override
	public Voter searchByUsername(String username) throws IOException {
		return null;
	}

	// --------------------------------------------------------------------------------------------------------
	// Edit voterlist
	// Not done
	@Override
	public void editVoterlist(Voter voter) throws IOException {

	}

//----------------------------------------------------------------------------------------------------------
//Candidate Registration
//Done	
	@Override
	public Candidate CandidatesRegistration(Candidate candidate)
			throws IOException, ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		String insertquery = "INSERT INTO candidatelist(PartyName,PartySymbol,Candidateid)" + "value ( '"
				+ candidate.getPartyName() + "', '" + candidate.getsymbol() + "','" + candidate.candidateid + "')";

		System.out.println(insertquery);

		Statement statement = con.createStatement();
		int resultValue = statement.executeUpdate(insertquery);

		if (resultValue == 2) {
			System.out.println("Failed to insert/update data. Check your data and try again.");
		}

		statement.close();
		con.close();

		return candidate;

	}

	// ---------------------------------------------------------------------------------------------------------
	// View all Candidates
	// Done
	@Override
	public void candidatesList() throws IOException {
		Connection con = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("***************************************************\n");

			String query = "SELECT * from candidatelist";

			System.out.println(query);

			statement = con.createStatement();

			ResultSet results = statement.executeQuery(query);

			while (results.next()) {
				System.out.println("---------------------------------");
				System.out.println("PartyName:: ");
				System.out.println(results.getString(1));
				System.out.println("\nPartySymbol::");
				System.out.println(results.getString(2));
				System.out.println("\nCandidateId::");
				System.out.println(results.getString(3));
				System.out.println();

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	// ----------------------------------------------------------------------------------------------------------
	// Voting process
	// Not done
	@Override
	public Voter voted(Candidate candidate) {
		Connection con = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String query = "SELECT * from candidatelist WHERE candidateid= " + candidate.candidateid;

			System.out.println(query);
			statement = con.createStatement();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return voted(candidate);

	}

	// ---------------------------------------------------------------------------------------------------------
	// VoteCount/result
	// Not done
	@Override
	public Candidate voteCount(int count) {
		Connection con = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String query = "SELECT count FROM voting_process  WHERE candidateid ="
					+ Candidate.getCandidateid();


			System.out.println(query);
			statement = con.createStatement();

			ResultSet results = statement.executeQuery(query);

			while (results.next()) {
				System.out.println("Total votes of selected candidateid:");
				System.out.println(results.getInt(1));

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return null;

	}

	@Override
	public Candidate searchcandidatebycandidateid(int candidateid)
			throws IOException, ClassNotFoundException, SQLException {
		Connection con = null;
		Statement statement = null;
		Candidate candidate = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String query = " select * from candidatelist where candidateid = '" + Candidate.getCandidateid() + "'";

			statement = con.createStatement();
			ResultSet results = statement.executeQuery(query);
			while (results.next()) {
				candidate = new Candidate();
				
				candidate.setCandidateid(results.getInt( 3));
				candidate.setPartyName(results.getString(1));
				candidate.setsymbol(results.getInt(2));

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return candidate;
	}
	

	

}
