/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package approject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author munirhkhaled
 */
@Entity
@Table(name = "USER")
public class user implements java.io.Serializable {

    @Id
    @Column(name = "user_id")
    private int user_id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "age")
    private String age;
     @Column(name="gender")
     private String gender;
  @Column(name="name")
     private String name;
     
    @JoinColumn(name = "user_id", referencedColumnName = "lettersAndNumbers")
    @OneToOne
    public lettersAndNumbers lettersAndNumbersLearned = new lettersAndNumbers();

    public user() {
    }

    public user(int user_id,String email,
        String password, String age,String gender, String name) {
        this.user_id = user_id;
        this.email = email;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.name = name; 
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public user(int user_id, String password) {
        this.user_id = user_id;
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    
     public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public lettersAndNumbers getLettersAtndNumbersLearned() {
        return lettersAndNumbersLearned;
    }

    public void setLettersAtndNumbersLearned(lettersAndNumbers lettersAtndNumbersLearned) {
        this.lettersAndNumbersLearned = lettersAtndNumbersLearned;
    }

}