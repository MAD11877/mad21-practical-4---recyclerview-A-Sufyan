package sg.edu.np.practical2;

public class User{
    public String name;
    public String description;
    public Integer id;
    public Boolean followed;
    public int randomNumber;

    public User(String name, String description, Integer id, Boolean followed, int randomNumber) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.followed = followed;
        this.randomNumber = randomNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getFollowed() {
        return followed;
    }

    public void setFollowed(Boolean followed) {
        this.followed = followed;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }
}
