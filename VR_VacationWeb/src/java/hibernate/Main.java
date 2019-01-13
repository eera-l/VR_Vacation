/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

/**
 *
 * @author EerAmore
 */
public class Main {
    
    public static void main(String[] agrs) {
       DBHelper db = new DBHelper();
       
       
       
       db.assignOrderToPackage(1, 3);
    }
    
}
