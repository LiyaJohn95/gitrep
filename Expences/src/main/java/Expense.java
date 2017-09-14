
public class Expense {
	
private int sno;
private float exp;
private String purpose;
private String day;


public Expense() {
	
}

public Expense(int sno) {
	this.sno=sno;
}

public Expense(int sno, Float exp, String purpose, String day) {
	this(exp, purpose, day);
	this.sno=sno;
}

public Expense(Float exp, String purpose, String day) {
	this.exp = exp;
	this.purpose = purpose;
	this.day = day;
}

public int getSno() {
	return sno;
}

public void setSno(int sno) {
	this.sno = sno;
}

public Float getExp() {
	return exp;
}

public void setExp(Float exp) {
	this.exp = exp;
}

public String getPurpose() {
	return purpose;
}

public void setPurpose(String purpose) {
	this.purpose = purpose;
}

public String getDay() {
	return day;
}

public void setDay(String day) {
	this.day = day;
}

@Override
public String toString() {
	// TODO Auto-generated method stub
	return "Expense [sno=" + sno + ", exp=" + exp + ", purpose=" + purpose + ", day=" + day + "]";
}


}
