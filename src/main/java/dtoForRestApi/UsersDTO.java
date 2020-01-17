package dtoForRestApi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsersDTO {

    @JsonProperty("id")
    private String id;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("email")
    private String email;
    @JsonProperty("age")
    private Integer age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public static final class UsersDTOBuilder {
        private String id;
        private String firstName;
        private String lastName;
        private String email;
        private Integer age;

        public UsersDTOBuilder() {
        }

        public static UsersDTOBuilder anUsersDTO() {
            return new UsersDTOBuilder();
        }

        public UsersDTOBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public UsersDTOBuilder withFirstName(String FirstName) {
            this.firstName = FirstName;
            return this;
        }

        public UsersDTOBuilder withLastName(String LastName) {
            this.lastName = LastName;
            return this;
        }

        public UsersDTOBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UsersDTOBuilder withAge(Integer age) {
            this.age = age;
            return this;
        }

        public UsersDTO build() {
            UsersDTO usersDTO = new UsersDTO();
            usersDTO.setId(id);
            usersDTO.setFirstName(firstName);
            usersDTO.setLastName(lastName);
            usersDTO.setEmail(email);
            usersDTO.setAge(age);
            return usersDTO;
        }

    }
}
