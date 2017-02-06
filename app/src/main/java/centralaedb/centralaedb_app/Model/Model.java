package centralaedb.centralaedb_app.Model;
import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by victo on 31/10/2015.
 */
public class Model {

    //Connection

    public static String ip = "http://192.168.1.24";
    public static String porta = "";
    public static String url = ip + porta +"/api/mobile/";

}


