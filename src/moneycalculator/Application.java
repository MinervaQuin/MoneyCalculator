package moneycalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import moneycalculator.control.ActionListenerFactory;
import moneycalculator.control.CalculateCommand;
import moneycalculator.control.Command;
import moneycalculator.control.CommandDictionary;
import moneycalculator.persistence.MockCurrencySetLoader;
import moneycalculator.ui.swing.ApplicationFrame;

public class Application {
    
    private ApplicationFrame frame;
    private CommandDictionary commandDictionary;
    
    public static void main(String[] args) {
        new Application().execute();
    }

    private void execute() {
        MockCurrencySetLoader.getInstance().load();

        frame = new ApplicationFrame(new ActionListenerFactory() {
            @Override
            public ActionListener getAction(final String action) {
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        commandDictionary.get(action).execute();
                    }
                };
            }
        });
        
        createCommands();
    }

    private void createCommands() {
        commandDictionary = new CommandDictionary();
        commandDictionary.register("Calculate", new CalculateCommand(frame.getMoneyDialog(), frame.getCurrencyDialog()));
        commandDictionary.register("Exit", new Command() {
            @Override
            public void execute() {
                frame.dispose();
            }
        });
    }
}
