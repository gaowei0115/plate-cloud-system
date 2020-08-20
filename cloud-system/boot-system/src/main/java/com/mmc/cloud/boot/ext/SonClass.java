package com.mmc.cloud.boot.ext;

/**
 * @packageName：com.mmc.cloud.boot.ext
 * @desrciption:
 * @author: GW
 * @date： 2020-08-19 9:51
 * @history: (version) author date desc
 */
public class SonClass extends ParentClass {

    public SonClass(){
        System.out.println("son class ----");
    }

    @Override
    public void fun() {
        System.out.println("son fun....");
    }


    public static void main(String[] args) {
        ParentClass parentClass = new SonClass();
        parentClass.fun();

        System.out.println("------------------------------------------");

        SonClass sonClass = new SonClass();
        sonClass.fun();
    }
}
