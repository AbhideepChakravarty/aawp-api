/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastserve.aawp.api;

/**
 *
 * @author Admin
 */
public class Person extends Human<Police> {
    private String name;
    
    public Person(Police race) {
        super(race);
    }    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
