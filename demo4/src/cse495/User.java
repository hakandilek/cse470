package cse495;

import lombok.*;

@Data
@AllArgsConstructor
//@ToString(includeFieldNames=false)
//@EqualsAndHashCode
public class User {
//	@Getter
//	@Setter
	private String firstName;
	
//	@Getter
//	@Setter
	private String lastName;
	
	public static void main(String[] args) {
		User user1 = new User("Some", "User");
		System.out.println(user1);
		System.out.println("user1.hashCode() : " + user1.hashCode());
		User user2 = new User("Another", "User");
		System.out.println("user2.hashCode() : " + user2.hashCode());
		System.out.println(user2);
		System.out.println("user2.hashCode() : " + user2.hashCode());
		System.out.format("%s == %s : %b\n", user1, user2, user1.equals(user2));
		user2.setFirstName("Some");
		System.out.format("%s == %s : %b\n", user1, user2, user1.equals(user2));
	}
}
