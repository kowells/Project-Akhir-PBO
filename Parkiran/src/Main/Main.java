/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import View.ViewParkir;
import Controller.ControllerParkir;
import Model.ModelParkirImpls;
import java.io.IOException;
/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
       
        ViewParkir view = new ViewParkir();
        ModelParkirImpls modelParkir = new ModelParkirImpls();
        ControllerParkir controllerParkir = new ControllerParkir(modelParkir, view);
        
    }
    
}
