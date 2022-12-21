package votingsystem;

import java.util.Objects;

public class Candidate {
	String partyName;
	int symbol;
	static int candidateid;
	

	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Candidate(String partyName, int symbol, int candidateid) {
		this.partyName= partyName;
		this.symbol=symbol;
		this.candidateid= candidateid;
		
	}

	public String getPartyName() {
		return partyName;
		
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public int getsymbol() {
		return symbol;
	}

	public void setsymbol(int partySymbol) {
		symbol = partySymbol;

	}

	public static int getCandidateid() {
		return candidateid;
	}

	public void setCandidateid(int candidateid) {
		this.candidateid = candidateid;
	}

	@Override
	public String toString() {
		return "Candidate [partyName=" + partyName + ", symbol=" + symbol + ", candidateid=" + candidateid + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(candidateid, partyName, symbol);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidate other = (Candidate) obj;
		return candidateid == other.candidateid && Objects.equals(partyName, other.partyName)
				&& Objects.equals(symbol, other.symbol);
	}

}
