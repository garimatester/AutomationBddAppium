/*package experimental_ignore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.omg.CORBA.portable.InputStream;

public class ReadBashScript {

public static void readBashScript() {
        try {
        	String projectDirectory = System.getProperty("user.dir");
        	System.out.println("projectDirectory"+ projectDirectory+ "/start-appium-new.sh /");
            Process proc = Runtime.getRuntime().exec(projectDirectory+"/start-appium-new.sh /"); //Whatever you want to execute
            BufferedReader read = new BufferedReader(new InputStreamReader(
                    proc.getInputStream()));
            try {
                proc.waitFor();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            while (read.ready()) {
                System.out.println(read.readLine());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
*/