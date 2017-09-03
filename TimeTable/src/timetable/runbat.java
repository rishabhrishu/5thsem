/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Vika$h
 */
public class runbat {

    runbat(){
         try{
    PrintWriter writer = new PrintWriter("new.bat", "UTF-8");
    writer.println("a.exe");
    writer.println("exit");

    writer.close();
            String[] command = {"cmd.exe", "/C", "Start", "new.bat"};
            Process p =  Runtime.getRuntime().exec(command);  
                   }
        catch (IOException e) {
}
    }
    
}

