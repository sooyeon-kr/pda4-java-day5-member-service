public class User {
    private String id;
    private String name;
    private String pw;

    public User() {
    }
    public User(String id,String pw) {
        this.id = id;
        this.pw = pw;
    }
    public User(String id, String name, String pw) {
        this.id = id;
        this.name = name;
        this.pw = pw;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
