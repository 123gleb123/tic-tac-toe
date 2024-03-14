
import java.util.Scanner;

public class Main {
  static char[][] map;
  static Scanner scanner;
  static final int MAP_SIZE = 3;

  static final char EMPTY_FIELD = '*';
  static final char X_FIELD = 'X';
  static final char O_FIELD = 'O';

//_______________________________________________________________________________________________
  
  public static void main(String[] args) {//вывод в консоль 
    init();//игра иницилизируется 
    printMap();//печатается карта
    while(true){
      humanTurn();//Ход игрока
      printMap();//печатается карта после хода игрока
      
      if(checkWin(X_FIELD)){
        System.out.println("Вы победили!😎");
        break;
      }
        if(checkDraw()){
          System.out.println("Ничья");
          break;
        }
      
      aiTurn();//Ход компа
      printMap();//печатается карта после хода компа

      if(checkWin(O_FIELD)){
        System.out.println("победил комп!😢");
        break;
      }
        if(checkDraw()){
          System.out.println("Ничья");
          break;
      }
    }
  }

//_______________________________________________________________________________________________

  public static boolean checkWin(char playerField){//проверка на победу
    if(map[0][0] == playerField && map[0][1] == playerField && map[0][2] == playerField) return true;
    if(map[1][0] == playerField && map[1][1] == playerField && map[1][2] == playerField) return true;
    if(map[2][0] == playerField && map[2][1] == playerField && map[2][2] == playerField) return true;

    if(map[0][0] == playerField && map[1][0] == playerField && map[2][0] == playerField) return true;
    if(map[0][1] == playerField && map[1][1] == playerField && map[2][1] == playerField) return true;
    if(map[0][2] == playerField && map[1][2] == playerField && map[2][2] == playerField) return true;

    if(map[0][0] == playerField && map[1][1] == playerField && map[2][2] == playerField) return true;
    if(map[0][2] == playerField && map[1][1] == playerField && map[2][0] == playerField) return true;

    return false;
  }

//_______________________________________________________________________________________________

  public static boolean checkDraw(){//проверка на ничью
    for(int i =0; i < MAP_SIZE; i++){
      for(int j =0; j < MAP_SIZE; j++){
        if(map[i][j] == EMPTY_FIELD){
          return false;
        }
      }
    }
    return true;
  }
  
//_______________________________________________________________________________________________
  
  public static boolean isCellValid(int x, int y){//проверка на валидность клетки
    if(x<0 || y<0 || x >=MAP_SIZE || y>= MAP_SIZE){
      return false;
    }
    if(map[y][x] != EMPTY_FIELD){
      return false;
    }
    return true;
  }

//_______________________________________________________________________________________________
  
  public static void aiTurn(){//ход компа
    int x,y;
    System.out.println("Ход компа ");
    do{
        x = (int)(Math.random()*MAP_SIZE);
        y = (int)(Math.random()*MAP_SIZE);
    }while(isCellValid(x,y) == false);
    map[y][x] = O_FIELD;
  }
//_______________________________________________________________________________________________
  public static void humanTurn(){//ход игрока
    int x,y;
    do{
        System.out.println("Ход игрока. Введите координаты для хода X Y");
        x = scanner.nextInt() - 1;
        y = scanner.nextInt() - 1;
    }while(isCellValid(x,y) == false);
    map[y][x] = X_FIELD;
  }

//_______________________________________________________________________________________________
  
  public static void printMap(){//блок отвечает за вывод карты
    // 0 1 2 3
    // 1 * * *
    // 2 * * *
    // 3 * * *
      for(int i = 0; i <= MAP_SIZE; i++){
      System.out.print(i+ " ");
    
    }
    System.out.println();
    for(int i = 0; i < MAP_SIZE; i++){
        System.out.print((i+1)+ " ");
        for(int j = 0; j < MAP_SIZE; j++){
          System.out.print(map[i][j]+ " ");
      }
      System.out.println();
    }
    System.out.println();
  }

//_______________________________________________________________________________________________
  
  public static void  init(){//инициализация карты 
    map = new char[MAP_SIZE][MAP_SIZE];
    for(int i = 0; i < MAP_SIZE; i++){
      for(int j = 0; j < MAP_SIZE; j++){
        map[i][j] = EMPTY_FIELD; 
      }
    }
    scanner = new Scanner(System.in);
  }
}