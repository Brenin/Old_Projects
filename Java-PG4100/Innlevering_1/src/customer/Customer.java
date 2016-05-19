package customer;

public class Customer {
	private NameInput ni = new NameInput();
	private String name = "";

	public Customer(){
		setName(ni.nameInput());
	}
	
	public Customer(String name){
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString(){
		while(getName().trim().length() <= 0){
			System.out.print("please state a name\n");
			setName(ni.nameInput());
		}
			return "Kundens namn är: " + getName() + "\n";
	}
}
