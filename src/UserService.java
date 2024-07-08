public class UserService {
    UserDAO userDao = new UserDAO();
    public boolean join(User user) {
        return userDao.save(user);
    }

    public User login(User user) {
        return userDao.find(user);
    }
}
