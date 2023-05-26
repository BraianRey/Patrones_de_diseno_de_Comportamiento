package co.edu.unicauca.openmarket.presentation.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class OMInvoker {

    private List<OMCommand> myCommands;
    private List<OMCommand> undoneCommands;
    private OMCommand currentCommand;

    public OMInvoker() {
        myCommands = new ArrayList<>();
        undoneCommands = new Stack<>();
        currentCommand = null;
    }

    public void addCommand(OMCommand actualCommand) {
        currentCommand = actualCommand;
    }

    public void execute() {
        this.addCommand(currentCommand);
        currentCommand.make();
        myCommands.add(currentCommand);
        undoneCommands.clear();
    }

    public void unexecute() {
        if (!myCommands.isEmpty()) {
            int index = myCommands.size() - 1;
            OMCommand command = myCommands.get(index);
            command.unmake();
            undoneCommands.add(command);
            myCommands.remove(index);
        }
    }

    public void reexecute() {
        while (!undoneCommands.isEmpty()) {
            int index = undoneCommands.size() - 1;
            OMCommand command = undoneCommands.get(index);
            command.remake();
            undoneCommands.remove(index);
            myCommands.add(command);
        }
    }

    public boolean hasMoreCommands() {
        return !myCommands.isEmpty();
    }
    
    public boolean hasMoreRecuperableCommands() {
        return !undoneCommands.isEmpty();
    }
}
