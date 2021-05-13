package com.ilkeyucel.btmobilapp;

import android.app.Person;

import java.util.ArrayList;

public class PersonInfo {
    private final String userName;
    private final String password;
    private final String name;
    private final String lastName;

    public PersonInfo(String userName, String password, String name, String lastName) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
    }

    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        PersonInfo that = (PersonInfo) other;
        return (this.userName.equals(that.userName));
    }

    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }

    public static ArrayList<PersonInfo> getPersonList() {
        ArrayList persons = new ArrayList();
        persons.add( new PersonInfo("aaa@tt.com", "1q2w3e","test1", "user1"));
        persons.add( new PersonInfo("bbb@tt.com", "1q2w3e","test2", "user2"));
        persons.add( new PersonInfo("ccc@tt.com", "1q2w3e","test3", "user3"));
        return persons;
    }

}
