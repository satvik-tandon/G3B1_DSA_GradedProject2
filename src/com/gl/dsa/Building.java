package com.gl.dsa;

import java.util.Scanner;
import java.util.Stack;

public class Building {
    private int floors;
    private int[] size;

    public Building(int floors) {
        this.floors = floors;
        this.size = new int[floors];
    }

    public void setSize(int day, int floorSize) {
        size[day] = floorSize;
    }

    public void processFloors() {
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < floors; i++) {
            System.out.println("Day " + (i + 1) + ":");
            int currentSize = size[i];
            int nextSize = (i + 1 < floors) ? size[i + 1] : 0;

            if (currentSize >= nextSize) {
                System.out.print(currentSize + " ");

                while (!stack.isEmpty() && stack.peek() <= currentSize && stack.peek() >= nextSize)
                    System.out.print(stack.pop() + " ");
            } else
                stack.push(currentSize);

            System.out.println();
        }

        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }
}

class Floor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of floors in the building:");
        int floors = sc.nextInt();

        Building building = new Building(floors);

        for (int i = 0; i < floors; i++) {
            System.out.println("Enter floor size on Day " + (i + 1) + ":");
            int floorSize = sc.nextInt();
            building.setSize(i, floorSize);
        }

        building.processFloors();

        sc.close();
    }
}
