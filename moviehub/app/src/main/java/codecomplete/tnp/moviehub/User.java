package codecomplete.tnp.moviehub;

public class User {
    private String firsName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String api_token;

    public User(String username, String password, String firsName, String lastName, String email, String api_token) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.api_token = api_token;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApi_token() {
        return api_token;
    }

    public void setApi_token(String api_token) {
        this.api_token = api_token;
    }
}
