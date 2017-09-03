/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Vika$h
 */
public class Sec1Controller implements Initializable {

    @FXML
    private TableView<Data> TimeTable;
    @FXML
    private TableColumn<Data, String> Day;
    @FXML
    private TableColumn<Data, String> slot1;
    @FXML
    private TableColumn<Data, String> slot2;
    @FXML
    private TableColumn<Data, String> slot3;
    @FXML
    private TableColumn<Data, String> slot4;
    @FXML
    private TableColumn<Data, String> lab;

    /**
     * Initializes the controller class.
     */
    
    ObservableList<Data> list = FXCollections.observableArrayList();
    
 //   public static ObservableList<Data> lst = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        list.clear();
        Day.setCellValueFactory(new PropertyValueFactory<Data, String>("a"));
        slot1.setCellValueFactory(new PropertyValueFactory<Data, String>("b"));

        slot2.setCellValueFactory(new PropertyValueFactory<Data, String>("c"));
        slot3.setCellValueFactory(new PropertyValueFactory<Data, String>("d"));
        slot4.setCellValueFactory(new PropertyValueFactory<Data, String>("e"));
        lab.setCellValueFactory(new PropertyValueFactory<Data, String>("f"));

        Data qq = new Data("Monday", "sub1", "sub2", "sub3", "sub4", "lab");
        this.go();
        TimeTable.setItems(list);
    }
    
    public void go() {
        int no = (SecondController.sec)+FirstController.batch*3;
        String fileName = "test"+no+".txt";
        String line = "null";
        System.out.println("In Sec1");
      
        try {

            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringTokenizer st = new StringTokenizer(line);
            while ((line = bufferedReader.readLine()) != null) {
                String[] a = new String[6];
                int count = 0;
                st = new StringTokenizer(line, ";");
                while(st.hasMoreTokens()){
                      String s = st.nextToken();
                      if(s.equals("$"))
                          s=" ";
                      
                      a[count++]=s;
                    //  System.out.println(s);
                  }
                    
              list.add(new Data(a[0],a[1],a[2],"TEA BREAK",a[3],a[4]));
            }
        } catch (Exception e) {

        }
    }
}
