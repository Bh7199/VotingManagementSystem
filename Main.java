package votingsystem;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		// Initialize service and utilities

		Scanner scan = new Scanner(System.in);
		LoginService login = new LoginService();
		VoterService voterServices = new VoterService();

		Voter voter = null;
		while (true) {
			System.out.println("\n\n\t\t\t ****Welcome To Voting Application****\t\t\n\n");
			System.out.println("Authorized personName:");
			String name = scan.nextLine();
			System.out.println("Autthorization id:");
			String id = scan.nextLine();
			if (name.equals("Sushant") && (id.contentEquals("election"))) {
				System.out.println("You can proceed further.");

			} else {
				System.out.println("Not a authorized person.");
				continue;
			}
			break;

		}
		int choice = 0;
		System.out.println("\n\n \t\t\t\t Welcome to Voting system \t\t\n\n");

		login.login();

		while (true) {

			// Admin functionalities
			System.out.println("1. Voter Registration");
			System.out.println("2. View  Voter List ");
			System.out.println("3.Candidate Registration");
			System.out.println("4. View Candidate list");
			System.out.println("5. Voting process ");
			System.out.println("6.Voting Result ");
			System.out.println("7. Logout");
			System.out.println("\n\tEnter your choice::");

			choice = scan.nextInt();
			// --------------------------------------------------------------------------------------------------------
			// VOTER REGISTRATION
			// ----------------------------------------------------------------------------------------------
			if (choice == 1) {
				// Voter Registration
				System.out.println();
				System.out.println("Enter first name::");
				String firstName = scan.next();

				System.out.println("Enter last name:: ");
				String lastName = scan.next();
				Gender g = null;
				while (true) {
					System.out.println("1.Male\t 2.Female\t 3.Others");
					System.out.println("Choose the gender.");
					int genderChoice = scan.nextInt();
					if (genderChoice == 1) {
						g = Gender.MALE;
					} else if (genderChoice == 2) {
						g = Gender.FEMALE;
					} else if (genderChoice == 3) {
						g = Gender.OTHERS;
					} else {
						System.out.println("Invalid option.");
						continue;
					}
					break;
				}

				String username;
				while (true) {
					System.out.println("Enter username::");
					username = scan.next();
					if (voterServices.checkIfUserNameExists(username)) {
						System.out.println("This username has been taken.");
						continue;
					}
					break;
				}

				System.out.println("Enter password::");
				String password = scan.next();
				System.out.println("Enter Date of birth yyyy-mm-dd:");
				String dob = scan.next();
				LocalDate date = LocalDate.parse(dob);

				Voter voter1 = new Voter(firstName, lastName, g, username, password);
				voter1.setDateofbirth(date);
				voterServices.voterRegistration(voter1);
//---------------------------------------------------------------------------------------------------
				// VIEW ALL VOTERS
//-------------------------------------------------------------------------------------------------------				
			} else if (choice == 2) {
				// view all voters
				voterServices.viewAll();

//-----------------------------------------------------------------------------------------------------------
				// CANDIDATE REGISTRATION
//----------------------------------------------------------------------------------------------------------				
			} else if (choice == 3) {
				// candidate Registration

				System.out.println("Enter Party Name :");
				String partyName = scan.next();

				System.out.println("Party Symbol :");
				int symbol = scan.nextInt();

				System.out.println("Candidate id :");
				int candidateid = scan.nextInt();

				Candidate canditate1 = new Candidate(partyName, symbol, candidateid);
				voterServices.CandidateRegistration(canditate1);

				continue;

			} else if (choice == 4) {
//-----------------------------------------------------------------------------------------------------------
				// view all candidates

				voterServices.candidatesList();

			} else if (choice == 5) {
//----------------------------------------------------------------------------------------------------------				
// Voting process
				while (true) {
					System.out.println("\n\n\t\t\t**** Welcome to Voting Programme**** \n"
							+ "\n\t\t Please Enter your user name and password to start voting\n\n\t\t");
					System.out.println("\nEnter your username::");
					String username = scan.next();

					System.out.println("Enter your password");
					String password = scan.next();

					voter = voterServices.votingProcess(username, password);

					if (voter != null) {
						System.out.println("\n\t\t\tChoose your Party and Symbol for Vote ");
					} else {
						System.out.println(
								"You are not registered in Voter list yet.Please make sure your username and password");
						continue;
					}

					voterServices.candidatesList();

					System.out.println("Select a canditateid from candidate list to vote:");
					int candidateid = scan.nextInt();

					// Condition to select candidate
					
					int candidate = voterServices.searchcandidatebycandidateid(candidateid);
					VoterService vs = new VoterService();
					//int candidate = vs.searchcandidatebycandidateid(candidateid);

					if (vs.searchcandidatebycandidateid(candidateid) == candidateid) {
						System.out.println("You voted to candidate having id: " + candidate);
						

					} else {
						System.out.println("Candidateid you  entered doesnot exist and your vote is dismissed.");
					}
				}
			} else if (choice == 6) {
//-----------------------------------------------------------------------------------------------------------				
				// Voting result /Vote count
				
				voterServices.voteCount(choice);

			} else if (choice == 7) {
//------------------------------------------------------------------------------------------------------------				
				// Logout
				System.out.println("Logged out successfully!");
				break;
			} else {
				System.out.println("Invalid Choice.");
			}
		}

	}

}
