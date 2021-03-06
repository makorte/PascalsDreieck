/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.maxkorte;

public class PascalsDreieck {
    protected int zeilen;
    protected int[][] dreieck;

    public PascalsDreieck(int zeilen) {
        if (zeilen < 2) throw new IllegalArgumentException("Das Dreieck sollte mindestens 2 Zeilen haben");

        this.zeilen = zeilen;
        initDreieck();
    }

    public void initDreieck() {
        dreieck = new int[zeilen][];
        for (int i = 0; i < zeilen; i++){
            dreieck[i] = new int[i+1];
        }
    }

    public void berechneDreieck(){
        for (int i = 0; i < dreieck.length; i++){
            dreieck[i][0] = 1;
            dreieck[i][dreieck[i].length-1] = 1;

            for (int j = 1; j < dreieck[i].length-1; j++){
                dreieck[i][j] = dreieck[i-1][j-1] + dreieck[i-1][j];
            }
        }
    }

    public int[] getZeile(int zeile){
        if (zeile < 1 || zeile > dreieck.length) throw new IllegalArgumentException("zeile should be " +
                "from 1 to length of dreieck");

        return dreieck[zeile-1];
    }

    public String toString(){
        String s = "";

        for (int[] zeile:dreieck){
            for (int num:zeile) s += num + " ";
            s += "\n";
        }

        return s;
    }

    public static void main(String[] args) {
        PascalsDreieck d = new PascalsDreieck(4);
        d.initDreieck();
        d.berechneDreieck();

        System.out.println(d);
    }
}
