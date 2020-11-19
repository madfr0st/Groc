/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frost.groc.DBMS;

import com.frost.groc.DBMS.*;
import org.sqlite.core.DB;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author suman
 */
public class dao {
    public static void main(String[] args) throws IOException {
        try {
            DBMS dbms = new DBMS();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public static void updateImages() throws IOException, SQLException, ClassNotFoundException {
        DBMS dbms = new DBMS();
        int a = 0;
        File file = new File("C:\\Users\\suman\\Documents\\NetBeansProjects\\Groc\\src\\main\\webapp\\images\\name.txt");
        BufferedReader inp = new BufferedReader(new FileReader(file));
        while (true) {
            String s1 = inp.readLine();
            if(s1 != null && !s1.split(" ")[0].equals("**")){
                System.out.println(s1);
                if(s1.equals("fruits")){
                    a = 1;
                }
                else if (s1.equals("vegetables")){
                    a = 2;
                }
                else if(s1.equals("grocery")){
                    a = 3;
                }

                if(a==1 && !s1.equals("fruits")){
                    String s2 = "images/fruits/"+s1+".jpg";
                    dbms.insertImage(s1,s2);
                }
                if(a==2 && !s1.equals("vegetables")){
                    String s2 = "images/vegetables/"+s1+".jpg";
                    dbms.insertImage(s1,s2);
                }
                if(a==3 && !s1.equals("grocery")){
                    String s2 = "images/grocery/"+s1+".jpg";
                    dbms.insertImage(s1,s2);
                }

            }
            if(s1==null){
                break;
            }
        }
    }

}
