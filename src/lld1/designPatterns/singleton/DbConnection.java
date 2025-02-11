package lld1.designPatterns.singleton;

public class DbConnection {
    public static DbConnection instance = new DbConnection();
    String url;
    String username;
    String password;

    private DbConnection(){}

    public static DbConnection getInstance() {
        if(instance == null) {
            instance = new DbConnection();
        }
        return instance;
    }

}
