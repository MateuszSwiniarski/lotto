package pl.rodzyn.lotto;

public class MessagePrinter {

    public void printText(String text) {
        System.out.println(text);
    }

    public void printMessage(int size) {
        switch (size) {
            case 0:
                printText("You haven't hit any numbers");
                break;
            case 1:
                printText("You hit one number");
                break;
            case 2:
                printText("You hit two numbers");
                break;
            case 3:
                printText("You hit three numbers");
                break;
            case 4:
                printText("You hit four numbers");
                break;
            case 5:
                printText("You hit five numbers");
                break;
            case 6:
                printText("YOU WIN, you hit 6 numbers");
                break;
        }
    }

    public void formatString(String text) {
        String formattedText = String.format("%25s", text);
        System.out.print(formattedText + " ");
    }

    public void formatInteger(int number) {
        String formattedText = String.format("%2s", number);
        System.out.print(formattedText + " ");
    }
}
