package com.twu.dao;
import com.twu.entity.User;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements DAO<User>{

    private List<User> userList;

    @Override
    public List<User> getAll() {
        userList = new ArrayList<User>();

        userList.add(new User("001-1234","a1234","Peter Jackson", "peterjackson@gmail.com","(81)99999-9999"));
        userList.add(new User("002-5678","b5678","Wes Craven", "wescraven@gmail.com","(81)99999-9998"));
        userList.add(new User("003-9101","c7891", "Robert Zemeckis", "robertzemeckis@gmail.com","(81)99999-9997"));
        userList.add(new User("004-1121","d0111","Lana Wachowski", "lanawachowski@gmail.com","(81)99999-9996"));
        userList.add(new User("005-3141","e2131","Lilly Wachowski", "lilywachowski@gmail.com","(81)99999-9995"));
        userList.add(new User("006-5161","f4151","Sean S. Cunningham", "seancunningham@gmail.com","(81)99999-9994"));
        userList.add(new User("007-7181","g6171","John Carpenter", "johncarpenter@gmail.com","(81)99999-9993"));

        return userList;
    }
}
