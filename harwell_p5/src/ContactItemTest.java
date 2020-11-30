import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest {

    @Test
    public void creationFailsWithAllBlankValues() {
        Assertions.assertThrows(InvalidContactException.class,()-> {
            ContactItem c = new ContactItem("","","","");
        });
    }

    @Test
    public void creationSucceedsWithBlankEmail() {
        ContactItem c = new ContactItem("Bob","Smith", "770-123-4567","");
        assertNotEquals(null, c);
    }

    @Test
    public void creationSucceedsWithBlankFirstName() {
        ContactItem c = new ContactItem("","Smith", "770-123-4567","test@email.com");
        assertNotEquals(null, c);
    }

    @Test
    public void creationSucceedsWithBlankLastName() {
        ContactItem c = new ContactItem("Bob","", "770-123-4567","test@email.com");
        assertNotEquals(null, c);
    }

    @Test
    public void creationSucceedsWithBlankPhone() {
        ContactItem c = new ContactItem("Bob","Smith", "","test@email.com");
        assertNotEquals(null, c);
    }

    @Test
    public void creationSucceedsWithNonBlankValues() {
        ContactItem c = new ContactItem("Bob","Smith", "770-123-4567","test@email.com");
        assertNotEquals(null, c);
    }

    @Test
    public void editingFailsWithAllBlankValues() {
        ContactItem c = new ContactItem("Bob","Smith", "770-123-4567","test@email.com");
        Assertions.assertThrows(InvalidContactException.class,()-> {
            c.setFirstName("");
            c.setLastName("");
            c.setPhone("");
            c.setEmail("");
            ContactItem d = new ContactItem(c.getFirstName(), c.getLastName(), c.getPhone(), c.getEmail());
        });
    }

    @Test
    public void editingSucceedsWithBlankEmail() {
        ContactItem c = new ContactItem("Bob","Smith", "770-123-4567","test@email.com");
        c.setEmail("");
        assertEquals("Bob", c.getFirstName());
        assertEquals("Smith", c.getLastName());
        assertEquals("770-123-4567", c.getPhone());
        assertEquals("", c.getEmail());
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        ContactItem c = new ContactItem("Bob","Smith", "770-123-4567","test@email.com");
        c.setFirstName("");
        assertEquals("", c.getFirstName());
        assertEquals("Smith", c.getLastName());
        assertEquals("770-123-4567", c.getPhone());
        assertEquals("test@email.com", c.getEmail());
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactItem c = new ContactItem("Bob","Smith", "770-123-4567","test@email.com");
        c.setLastName("");
        assertEquals("Bob", c.getFirstName());
        assertEquals("", c.getLastName());
        assertEquals("770-123-4567", c.getPhone());
        assertEquals("test@email.com", c.getEmail());
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        ContactItem c = new ContactItem("Bob","Smith", "770-123-4567","test@email.com");
        c.setPhone("");
        assertEquals("Bob", c.getFirstName());
        assertEquals("Smith", c.getLastName());
        assertEquals("", c.getPhone());
        assertEquals("test@email.com", c.getEmail());
    }

    @Test
    public void editingSucceedsWithNonBlankValues() {
        ContactItem c = new ContactItem("Bob","Smith", "770-123-4567","test@email.com");
        c.setFirstName("Bill");
        c.setLastName("Snow");
        c.setPhone("111-111-1111");
        c.setEmail("test@aol.com");
        assertEquals("Bill", c.getFirstName());
        assertEquals("Snow", c.getLastName());
        assertEquals("111-111-1111", c.getPhone());
        assertEquals("test@aol.com", c.getEmail());
    }

}