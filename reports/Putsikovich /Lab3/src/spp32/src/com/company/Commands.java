package com.company;

import com.company.programexceptions.SqrtFromNegativeException;
import com.company.programexceptions.StackEmptyException;
import com.company.programexceptions.UnknownCommandException;
import com.company.programexceptions.ZeroDivisionException;

public class Commands {

    public ExecContext PopCommand(ExecContext context, String command) throws Exception
    {
        if(!command.equals("POP"))
            throw new UnknownCommandException();

        if(context.stackIsEmpty())
            throw new StackEmptyException();

        context.popFromStack();

        return context;
    }

    public ExecContext PushCommand(ExecContext context, String command) throws Exception
    {
        String[] args = command.split(" ");

        if(args.length!=2)
            throw new UnknownCommandException();

        if(!args[0].equals("PUSH"))
            throw new UnknownCommandException();

        Double value = null;
        try{
            value = Double.parseDouble(args[1]);
        }
        catch(NumberFormatException e)
        {
            value = context.getParam(args[1]);
        }

        if(value==null)
            throw new UnknownCommandException();

        context.pushInStack(value);

        return context;
    }

    public ExecContext PlusCommand(ExecContext context, String command) throws Exception
    {
        if(!command.equals("+"))
            throw new UnknownCommandException();

        double value1, value2;

        if(context.stackIsEmpty())
            throw new StackEmptyException();

        value2 = context.popFromStack();

        if(context.stackIsEmpty()) {
            context.pushInStack(value2);
            throw new StackEmptyException();
        }

        value1 = context.popFromStack();

        context.pushInStack(value1+value2);

        return context;
    }

    public ExecContext MinusCommand(ExecContext context, String command) throws Exception
    {
        if(!command.equals("-"))
            throw new UnknownCommandException();

        double value1, value2;

        if(context.stackIsEmpty())
            throw new StackEmptyException();

        value2 = context.popFromStack();

        if(context.stackIsEmpty()) {
            context.pushInStack(value2);
            throw new StackEmptyException();
        }

        value1 = context.popFromStack();

        context.pushInStack(value1-value2);

        return context;
    }

    public ExecContext MultiplyCommand(ExecContext context, String command) throws Exception
    {
        if(!command.equals("*"))
            throw new UnknownCommandException();

        double value1, value2;

        if(context.stackIsEmpty())
            throw new StackEmptyException();

        value2 = context.popFromStack();

        if(context.stackIsEmpty()) {
            context.pushInStack(value2);
            throw new StackEmptyException();
        }

        value1 = context.popFromStack();

        context.pushInStack(value1*value2);

        return context;
    }

    public ExecContext DivideCommand(ExecContext context, String command) throws Exception
    {
        if(!command.equals("/"))
            throw new UnknownCommandException();

        double value1, value2;

        if(context.stackIsEmpty())
            throw new StackEmptyException();

        value2 = context.popFromStack();

        if(value2==0) {
            context.pushInStack(value2);
            throw new ZeroDivisionException();
        }

        if(context.stackIsEmpty()) {
            context.pushInStack(value2);
            throw new StackEmptyException();
        }

        value1 = context.popFromStack();

        context.pushInStack(value1/value2);

        return context;
    }

    public ExecContext SqrtCommand(ExecContext context, String command) throws Exception
    {
        if(!command.equals("SQRT"))
            throw new UnknownCommandException();

        double value;

        if(context.stackIsEmpty())
            throw new StackEmptyException();

        value = context.popFromStack();

        if(value<0) {
            context.pushInStack(value);
            throw new SqrtFromNegativeException();
        }

        context.pushInStack(Math.sqrt(value));

        return context;
    }

    public void PrintCommand(ExecContext context, String command) throws Exception
    {
        if(!command.equals("PRINT"))
            throw new UnknownCommandException();

        if(context.stackIsEmpty())
            throw new StackEmptyException();

        System.out.println(context.peekFromStack());
    }

    public ExecContext DefineCommand(ExecContext context, String command) throws Exception
    {
        String[] args = command.split(" ");

        if(args.length!=3)
            throw new UnknownCommandException();

        if(!args[0].equals("DEFINE"))
            throw new UnknownCommandException();

        Double value = null;
        try{
            value = Double.parseDouble(args[2]);
        }
        catch(NumberFormatException e)
        {
            throw new UnknownCommandException();
        }

        context.setParam(args[1], value);

        return context;

    }
}
