package pl.rodzyn.lotto.service;

public class MessagePrinter {

    public void printText(String text) {
        System.out.println(text);
    }

    public void printTextInTheSameLine(String text){
        System.out.print(text);
    }

    public String printMessage(int size) {
        String result = "";
        switch (size) {
            case 0:
                result = "You haven't hit any numbers";
                break;
            case 1:
                result = "You hit one number";
                break;
            case 2:
                result = "You hit two numbers";
                break;
            case 3:
                result = "You hit three numbers";
                break;
            case 4:
                result = "You hit four numbers";
                break;
            case 5:
                result = "You hit five numbers";
                break;
            case 6:
                result = "YOU WIN, you hit 6 numbers";
                break;
        }
        return result;
    }

    public void formatString(String text) {
        String formattedText = String.format("%25s", text);
        printTextInTheSameLine(formattedText + " ");
    }

    public void formatInteger(int number) {
        String formattedText = String.format("%2s", number);
        printTextInTheSameLine(formattedText + " ");
    }
}
