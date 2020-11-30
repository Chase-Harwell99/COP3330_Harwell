public class ContactItem {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    public ContactItem(String firstName, String lastName, String phone, String email) {

        if(validContact(firstName, lastName, phone, email)) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        } else {
            throw new InvalidContactException("One of the fields (first name, last name, phone number, or email) must have an input to create contact");
        }

        if(phone.equals("") || validPhone(phone)) {
            this.phone = phone;
        } else {
            throw new InvalidNumberException("A phone number must be in the format XXX-XXX-XXXX. Please input contact info again.");
        }
    }

    private boolean validPhone(String phone) {
        return phone.matches("\\d{3}-\\d{3}-\\d{4}");
    }

    private boolean validContact(String first, String last, String phone, String email) {
        return (!first.equals("") || !last.equals("") || !phone.equals("") || !email.equals(""));
    }


    protected String getPhone() {
        return phone;
    }

    protected String getLastName() {
        return lastName;
    }

    protected String getFirstName() {
        return firstName;
    }

    protected String getEmail() {
        return email;
    }

    protected void setFirstName(String first) {
        firstName = first;
    }

    protected void setLastName(String last) {
        lastName = last;
    }

    protected void setPhone(String phonenum) {
        phone = phonenum;
    }

    protected void setEmail(String emailadd) {
        email = emailadd;
    }
}
