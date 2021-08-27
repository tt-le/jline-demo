package com.mycompany.app;

import java.io.IOException;
import java.io.PrintWriter;

import org.jline.reader.LineReader;
import org.jline.reader.impl.LineReaderImpl;
import org.jline.terminal.impl.DumbTerminal;
import org.jline.terminal.impl.LineDisciplineTerminal;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.NonBlockingReader;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        Terminal terminal;
        NonBlockingReader nbr;
        PrintWriter pw;
        String input = "";
        startupMessages();
        try {
            terminal = TerminalBuilder.builder().jna(true).jansi(false).system(true).build();
            pw = terminal.writer();
            while (!input.equals("q")) {

                try {
                    // terminal =
                    // TerminalBuilder.builder().jna(true).jansi(false).system(true).build();
                    // terminal.enterRawMode();

                    // pw.println(
                    // "To restart the server, type 'r' and press Enter.\nTo stop the server and
                    // quit dev mode, press Ctrl-C or type 'q' and press Enter.\ndevmode-demo> ");
                    terminal.enterRawMode();
                    nbr = terminal.reader();
                    input = Character.toString((char) nbr.read());
                    pw.println(input);
                    pw.flush();
                    nbr.close();
                    // // terminal.
                    // // nbr.wait();

                    if (input.equals("q")) {
                        pw.println("hellow hello");
                    } else if (input.equals("r")) {
                        pw.println("pressed r, server restarting");
                        debug("Detected restart command");
                        info("Restarting server...");
                        info("The server has been restarted.");
                    } else if (input.equals("h")) {
                        info(formatAttentionBarrier());
                        info(formatAttentionMessage(
                                "🛑 To stop the server and quit dev mode, press Ctrl-C or type 'q' and press Enter."));
                        info(formatAttentionMessage("📖 To see the help menu type ‘h’ and press Enter."));
                        info(formatAttentionBarrier());
                    } else if (input.equals("\n")) {
                        debug("Detected Enter key. Running tests... ");
                    }

                } catch (Exception e) {
                    // TODO: handle exception
                } finally {
                    // TODO: close the terminal
                }
                // try {
                // LineDisciplineTerminal terminal = new LineDisciplineTerminal(System.in,
                // System.out);
                // LineReader reader = new LineReaderImpl(terminal);
                // String prompt = "To restart the server, type 'r' and press Enter.\nTo stop
                // the server and quit dev mode, press Ctrl-C or type 'q' and press
                // Enter.\ndevmode-demo> ";
                // String line = reader.readLine(prompt);
                // reader.printAbove(line);
                // } catch (Exception e) {
                // // TODO: handle exception
                // }
            }
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }

    public static void startupMessages() {
        info(formatAttentionBarrier());
        info(formatAttentionTitle("🛸 Liberty developer mode:"));
        info(formatAttentionBarrier());
        info(formatAttentionTitle("Liberty is running in dev mode."));
        String message = "📝 To run tests on demand, press Enter.";
        info(formatAttentionMessage(message));
        info(formatAttentionMessage("⚙️  To restart the server, type 'r'"));
        info(formatAttentionMessage("📖 To see the help menu type 'h'"));
        info(formatAttentionMessage("🛑 To stop the server and quit dev mode, press Ctrl-C or type 'q'"));
        info(formatAttentionMessage(""));
        info(formatAttentionTitle("Liberty server port information:"));
        info(formatAttentionMessage("🛥️  Liberty server HTTP port: [ " + 9080 + " ]"));
        info(formatAttentionMessage("🛡️  Liberty server HTTPS port: [ " + 9443 + " ]"));
        info(formatAttentionMessage("🐞 Liberty debug port: [ " + 7777 + " ]"));
        info(formatAttentionBarrier());

    }

    private static void info(String x) {
        System.out.println(x);
    }

    private static void debug(String x) {
        System.out.println(x);
    }

    private static String formatAttentionBarrier() {
        return "------------------------------------------------------------------------";
    }

    private static String formatAttentionTitle(String message) {
        return "-    " + message;
    }

    private static String formatAttentionMessage(String message) {
        return "-        " + message;
    }
}
