package pl.rodzyn.games.lotto.service;

public class MessagePrinter {

    public void printText(String text) {
        System.out.println(text);
    }

    public String printMessage(int size) {
        String result = "";
        switch (size) {
            case 0:
                result = "You haven't hit any numbers";
                break;
            case 1:
                result = "You hit " + size + " number";
                break;
            case 6:
                result = "YOU WIN, you hit " + size + " numbers";
                break;
            default:
                result = "You hit " + size + " numbers";
                break;
        }
        return result;
    }
}
