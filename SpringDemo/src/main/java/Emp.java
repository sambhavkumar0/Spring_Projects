

public class Emp {
    private int id;
    private String name;
    private Address address; // dependency

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Emp [id=" + id + ", name=" + name + ", address=" + address + "]";
    }
}
