package dao;

import domain.User;

public interface UserDao {

    public void addUser(User user) throws Exception;


    public User findUser(User user)throws Exception;


    public boolean findUserByName(String name);


}
