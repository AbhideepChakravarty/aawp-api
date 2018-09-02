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
public class Human<T> {
    private T job;

    public Human(T race) {
        this.job = race;
    }

    public T getJob() {
        return job;
    }

    public void setJob(T race) {
        this.job = race;
    }
    
    
}
