package blog;

public class Author {
	private String name;
	private int age;
	private String mail;
	
	//Constructors
	public Author(String n)
	{
		this.name = n;
	}
	public Author(String n, String m)
	{
		this.name = n;
		this.mail = m;
	}
	public Author(String n, String m, int a)
	{
		this.name = n;
		this.mail = m;
		this.age = a;
	}
	
	//Getters n setters
	public String getName()
	{
		return name;
	}
	public void setName(String n)
	{
		this.name = n;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int a)
	{
		this.age = a;
	}
	public String getMail()
	{
		return mail;
	}
	public void setMail(String m)
	{
		this.mail = m;
	}
}
