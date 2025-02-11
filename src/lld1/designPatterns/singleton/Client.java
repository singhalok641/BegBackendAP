package lld1.designPatterns.singleton;

import org.w3c.dom.ls.LSOutput;

public class Client {

    public static void main(String[] args) {
        DbConnection dbConnection1 = DbConnection.instance;
        DbConnection dbConnection2 = DbConnection.instance;
        DbConnection dbConnection3 = DbConnection.instance;
        DbConnection dbConnection4 = DbConnection.instance;

        System.out.println("DEBUG");
    }
}
