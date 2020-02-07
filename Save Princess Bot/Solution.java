import java.util.Scanner;

public class Solution {

static void displayPathtoPrincess(int n, String [] grid){
    
    char[][] c = new char[n][n];
    int[] p_index = new int[2], m_index = new int[2];
    
    for(int i=0; i<n; i++){
        c[i] = grid[i].toCharArray();
    }
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(c[i][j]=='p'){
                p_index[0] = i;
                p_index[1] = j;
            }
            else if(c[i][j]=='m'){
                m_index[0] = i;
                m_index[1] = j;
            }
        }
    }
    
    // System.out.println("p_index x= " + p_index[0]);
    // System.out.println("p_index y= " + p_index[1]);
    // System.out.println("m_index x= " + m_index[0]);
    // System.out.println("m_index y= " + m_index[1]);
    
    int x_distance = p_index[0]-m_index[0], y_distance = p_index[1]-m_index[1];
    
    // System.out.println(" x dist = " + x_distance);
    // System.out.println(" y dist = " + y_distance);
    
    if(!(x_distance==0 && y_distance==0)){
        if(y_distance==0){
            if(x_distance<0){
                for(int i=0; i<Math.abs(x_distance); i++){
                    System.out.println("RIGHT");
            }
        }
            else if(x_distance>0){
                for(int i=0; i<x_distance; i++){
                    System.out.println("LEFT");
                }
            }
        }
        
        if(x_distance==0){
            if(y_distance<0){
                for(int i=0; i<Math.abs(y_distance); i++){
                    System.out.println("UP");
                }
            }
            else if(y_distance>0){
                for(int i=0; i<y_distance; i++){
                    System.out.println("DOWN");
                }
            }
        }
        
        if(y_distance<0){
            for(int i=0; i<Math.abs(y_distance); i++){
                System.out.println("UP");
            }
        }
        else if(y_distance>0){
            for(int i=0; i<y_distance; i++){
                System.out.println("DOWN");
            }
        }    
        if(x_distance<0){
            for(int i=0; i<Math.abs(x_distance); i++){
                System.out.println("LEFT");
            }
        }
        else if(x_distance>0){
            for(int i=0; i<x_distance; i++){
                System.out.println("RIGHT");
            }
        }
    }
    
  }

public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m;
        m = in.nextInt();
        String grid[] = new String[m];
        for(int i = 0; i < m; i++) {
            grid[i] = in.next();
        }

    displayPathtoPrincess(m,grid);
    }
}