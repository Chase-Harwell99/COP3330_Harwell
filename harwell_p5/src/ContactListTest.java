import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {

    @Test
    public void addingItemsIncreasesSize() {
        ContactItem c = new ContactItem("Bob", "Smith", "770-123-4567", "test@email.com");
        ContactList tasks = new ContactList();
        tasks.add(c);
        assertEquals(1, tasks.getSize());
    }

    @Test
    public void editingItemsFailsWithAllBlankValues() {
        ContactItem c = new ContactItem("Bob", "Smith", "770-123-4567", "test@gmail.com");
        ContactList contacts = new ContactList();
        contacts.add(c);
        Assertions.assertThrows(InvalidContactException.class, () -> {
            ContactItem c1 = new ContactItem("","","","");
            contacts.editListItem(1, c1);
        });
    }

    @Test
    public void editingItemsFailsWithInvalidIndex() {
        ContactItem c = new ContactItem("Bob", "Smith", "770-123-4567", "test@gmail.com");
        ContactItem d = new ContactItem("Bill", "Snow", "352-234-1230", "test@aol.com");
        ContactList contacts = new ContactList();
        contacts.add(c);
        Assertions.assertThrows(IndexOutOfBoundsException.class, ()-> {
            contacts.editListItem(2, d);
        });
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        ContactItem c = new ContactItem("Bob", "Smith", "770-123-4567", "test@gmail.com");
        ContactItem d = new ContactItem("", "Smith", "770-123-4567", "test@gmail.com");
        ContactList contacts = new ContactList();
        contacts.add(c);
        ContactItem editedItem = contacts.editListItem(0, d);
        assertEquals("",editedItem.getFirstName());
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactItem c = new ContactItem("Bob", "Smith", "770-123-4567", "test@gmail.com");
        ContactItem d = new ContactItem("Bob", "", "770-123-4567", "test@gmail.com");
        ContactList contacts = new ContactList();
        contacts.add(c);
        ContactItem editedItem = contacts.editListItem(0, d);
        assertEquals("",editedItem.getLastName());
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        ContactItem c = new ContactItem("Bob", "Smith", "770-123-4567", "test@gmail.com");
        ContactItem d = new ContactItem("Bob", "Smith", "", "test@gmail.com");
        ContactList contacts = new ContactList();
        contacts.add(c);
        ContactItem editedItem = contacts.editListItem(0, d);
        assertEquals("",editedItem.getPhone());
    }

    @Test
    public void editingSucceedsWithNonBlankValues() {
        ContactItem c = new ContactItem("Bob", "Smith", "770-123-4567", "test@gmail.com");
        ContactItem d = new ContactItem("Bill", "Snow", "123-456-7890", "test@aol.com");
        ContactList contacts = new ContactList();
        contacts.add(c);
        ContactItem editedItem = contacts.editListItem(0, d);
        assertEquals("Bill",editedItem.getFirstName());
        assertEquals("Snow",editedItem.getLastName());
        assertEquals("123-456-7890",editedItem.getPhone());
        assertEquals("test@aol.com",editedItem.getEmail());
    }

    @Test
    public void newListIsEmpty() {
        ContactList c = new ContactList();
        assertEquals(0, c.getSize());
    }

    @Test
    public void removingItemsDecreasesSize() {
        ContactItem c = new ContactItem("Bob", "Smith", "770-123-4567", "test@gmail.com");
        ContactList contacts = new ContactList();
        contacts.add(c);
        assertEquals(1,contacts.getSize());
        contacts.removeListItem(0);
        assertEquals(0,contacts.getSize());

    }

    @Test
    public void removingItemsFailsWithInvalidIndex() {
        ContactItem c = new ContactItem("Bob", "Smith", "770-123-4567", "test@gmail.com");
        ContactList contacts = new ContactList();
        contacts.add(c);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            contacts.removeListItem(1);
        });
    }

    @Test
    public void savedContactListCanBeLoaded() {
        ContactList c = new ContactList();
        c.loadFile("outputContact.txt");
        assertNotEquals(null, c);
    }
}