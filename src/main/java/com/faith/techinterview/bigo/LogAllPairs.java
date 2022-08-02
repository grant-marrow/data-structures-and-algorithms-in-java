package com.faith.techinterview.bigo;

public class LogAllPairs {
    public static void main(String[] args) {
        int[] boxes = new int[]{1,2,3,4,5};

        for (int i = 0; i < boxes.length; i++) {
            for (int x = 1; x < boxes.length; x++) {
                System.out.println(boxes[i] + "-" + boxes[x]);
            }
        }

        /*

        1 2 3 4 5
        2 3 4 5
        3 4 5
        4 5
        5

         */
    }
}
