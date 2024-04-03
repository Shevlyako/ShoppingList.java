import java.util.Scanner;

public class Shopping {

    public static void main(String[] args) {

        System.out.println("Добро пожаловать вы попали в список покупок!");

        String[] shoppingList = new String[8];
        int productCount = 0;
        int exit = 1;

        Scanner scanner = new Scanner(System.in);
        while(exit == 1){
            writeMenu();

            int actionNumber = scanner.nextInt();
            scanner.nextLine();

            switch (actionNumber){
                case 1:
                    System.out.println("Напишите продукт который хотите добавить.");
                    System.out.println("Если хотите добавить продукт из двух слов используйте знак нижнего подчеркивания");
                    String product = scanner.next();
                    int productNotFound = 0;
                    for(int i = 0; i < productCount; i++){
                        if(product.equals(shoppingList[i])){
                        System.out.println("Вы уже внесли этот продукт.");
                        } else {
                        productNotFound++;
                        }
                    }
                    if((productNotFound == productCount) && (productCount == shoppingList.length)){
                        String[] shoppingListX2 = new String[(shoppingList.length * 2)];
                        for(int i = 0; i < productCount; i++){
                            shoppingListX2[i] = shoppingList[i];
                        }
                        shoppingList = shoppingListX2;
                    }
                    if (productNotFound == productCount){
                        shoppingList[productCount] = product;
                        productCount++;
                        System.out.println("Товар " + shoppingList[(productCount-1)] +
                                           " добавлен в список под номером " + productCount);}
                    break;
                case 2:
                    System.out.println("Ваш список продуктов:");
                    for (int i = 0; i < productCount; i++){
                        System.out.println((i+1) + ". " + shoppingList[i]);
                    }
                    break;
                case 3:
                    for (int i = 0; i < productCount; i++){
                        shoppingList[i] = null;
                    }
                    productCount = 0;
                    System.out.println("Список ваших продуктов очищен.");
                    break;
                case 0:
                    System.out.println("Программа завершена");
                    exit = 0;
                    break;
                default:
                    System.out.println("Неизвестная команда.");
                    break;
            }

        }
    }
    public static void writeMenu() {
        System.out.println("Выберите номер команды:");
        System.out.println("1. Добавить товар.");
        System.out.println("2. Показать список покупок.");
        System.out.println("3. Очистить список покупок.");
        System.out.println("0. Завершить работу.");
    }
}

