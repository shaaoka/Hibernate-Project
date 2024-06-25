package com.team6.model;

public class MemberBean {

	private String account;
	private String mName;
	private String password;
	private String mEmail;
	private String mPhone;
	private String birthday;
	private Integer permissions;
	
	public MemberBean() {}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getmEmail() {
		return mEmail;
	}

	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}

	public String getmPhone() {
		return mPhone;
	}

	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Integer getPermissions() {
		return permissions;
	}

	public void setPermissions(Integer permissions) {
		this.permissions = permissions;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemberBean [account=");
		builder.append(account);
		builder.append(", mName=");
		builder.append(mName);
		builder.append(", password=");
		builder.append(password);
		builder.append(", mEmail=");
		builder.append(mEmail);
		builder.append(", mPhone=");
		builder.append(mPhone);
		builder.append(", birthday=");
		builder.append(birthday);
		builder.append(", permissions=");
		builder.append(permissions);
		builder.append("]");
		return builder.toString();
	}

	public String saveToCsv() {
		String csv = account +","+ mName+","+password+","+mEmail+","+mPhone+","+birthday+","+permissions;
		return csv;
	}
	
	public String saveToXml() {
//		String xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+"\n"+"<Root>"+"\n";
		String xml="<Row>\n"
				   +"<account>"+account+"/<account>\n"
				   +"<mName>"+mName+"</mName>\n"
				   +"<password>"+password+"</password>\n"
				   +"<mEmail>"+mEmail+"</mEmail>\n"
				   +"<mPhone>"+mPhone+"</mPhone>\n"
				   +"<birthday>"+birthday+"</birthday>\n"
				   +"<permissions>"+permissions+"</permissions>\n"
				   +"</Row>\n";
		return xml;
	}
	
	public String saveToJson() {
//		String json="[";
		String json="{\n\"account\":\""+account+"\",\n"
					+"\"mName\":\""+mName+"\",\n"
					+"\"password\":\""+password+"\",\n"
					+"\"mEmail\":\""+mEmail+"\",\n"
					+"\"mPhone\":\""+mPhone+"\",\n"
					+"\"birthday\":\""+birthday+"\",\n"
					+"\"permissions\":\""+permissions+"\"\n},";
//		json=json.substring(1, json.length()-1)+"\n]";
		return json;
	}
}
