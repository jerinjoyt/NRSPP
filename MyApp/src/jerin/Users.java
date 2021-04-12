package jerin;

public class Users 
{
String email;
String f_name;
String l_name;
String pword;

public Users (String email,String fname,String lname,String pword)
{
	this.email =email;
	this.f_name = fname;
	this.l_name= lname;
	this.pword= pword;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getF_name() {
	return f_name;
}

public void setF_name(String f_name) {
	this.f_name = f_name;
}

public String getL_name() {
	return l_name;
}

public void setL_name(String l_name) {
	this.l_name = l_name;
}

public String getPword() {
	return pword;
}

public void setPword(String pword) {
	this.pword = pword;
}
}
