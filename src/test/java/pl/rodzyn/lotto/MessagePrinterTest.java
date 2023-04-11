package pl.rodzyn.lotto;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class MessagePrinterTest {

    @Test
    void when_call_printText_method(){
        //given
        MessagePrinter printer = mock(MessagePrinter.class);
        doNothing().when(printer).printText("test method");
        //when
        printer.printText("test method");
        //then
        verify(printer, times(1)).printText("test method");
    }

    @Test
    void when_call_printMessage_method(){
        //given
        MessagePrinter printer = mock(MessagePrinter.class);
        doNothing().when(printer).printMessage(3);
        //when
        printer.printMessage(3);
        //then
        verify(printer, times(1)).printMessage(3);
    }

    @Test
    void when_call_formatString_method(){
        //given
        MessagePrinter printer = mock(MessagePrinter.class);
        doNothing().when(printer).formatString("test");
        //when
        printer.formatString("test");
        //then
        verify(printer, times(1)).formatString("test");
    }

    @Test
    void when_call_formatInteger_method(){
        //given
        MessagePrinter printer = mock(MessagePrinter.class);
        doNothing().when(printer).formatInteger(123);
        //when
        printer.formatInteger(123);
        //then
        verify(printer, times(1)).formatInteger(123);
    }

}