package com.nk.springmvc;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {
public String firstName;

@NotNull(message="is required")
@Size(min=1)
public String lastName;
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}

}
