import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class UserDAO {
    private Map<Integer, User> db = new HashMap<Integer, User>();

    public UserDAO() {}

    public boolean save(User user) {
        for(User u : db.values()) {
            if(u.getId().equals(user.getId())) {
                return false;
            }
        }

        int size = db.size();
        db.put(size+1, user);
        return size + 1 == db.size();
    }

    public User find(User user) {
        User retUser = null;
        for(User u : db.values()) {
            if(u.getId().equals(user.getId()) && u.getPw().equals(user.getPw())) {
                 retUser = new User(u.getId(), u.getName(), "");
                return retUser;
            }
        }
        return retUser;
    }

    public User update(User user) {
        User retUser = null;
        for(User u : db.values()) {
            if(u.getId().equals(user.getId()) && u.getName().equals(user.getName())) {
                u.setPw(user.getPw());
                retUser = new User(u.getId(), u.getName(), "");
                return retUser;
            }
        }
        return retUser;
    }

    public boolean delete(User user) {
        for(Map.Entry<Integer, User> entry : db.entrySet()) {
            Integer id = entry.getKey();
            User u = entry.getValue();
            if(u.getId().equals(user.getId()) && u.getName().equals(user.getName())) {
                db.remove(id);
                return true;
            }
        }
        return false;
    }
}
