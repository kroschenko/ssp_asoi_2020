package com.company;

import com.company.programexceptions.SqrtFromNegativeException;
import com.company.programexceptions.StackEmptyException;
import com.company.programexceptions.UnknownCommandException;
import com.company.programexceptions.ZeroDivisionException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {


        ExecContext context = new ExecContext();
        Commands commands = new Commands();

        File file;
        Scanner scanner;

        if(args.length==0)
            scanner = new Scanner(System.in);
        else if(args.length==1) {
            try {
                file = new File(args[0]);
                scanner = new Scanner(file, "utf-8");
            }
            catch(FileNotFoundException e){
                System.out.println("Error: file not found");
                return;
            }
        }
        else{
            System.out.println("Error: unexpected params");
            return;
        }

        while(scanner.hasNextLine())
        {
            String command = scanner.nextLine();

            if(command.indexOf("#")==0)
                continue;
            else if(command.indexOf("POP")==0)
            {
                try
                {
                    context = commands.PopCommand(context, command);
                }
                catch(StackEmptyException e)
                {
                    System.out.println("Error: stack is empty or too few values in stack");
                }
                catch(UnknownCommandException e)
                {
                    System.out.println("Error: unknown command");
                }
                catch(Exception e)
                {
                    System.out.println("Error: sorry, unexpected error");
                }
            }
            else if(command.indexOf("PUSH")==0)
            {
                try
                {
                    context = commands.PushCommand(context, command);
                }
                catch(UnknownCommandException e)
                {
                    System.out.println("Error: unknown command");
                }
                catch(Exception e)
                {
                    System.out.println("Error: sorry, unexpected error");
                    e.printStackTrace();
                }
            }
            else if(command.indexOf("+")==0)
            {
                try
                {
                    context = commands.PlusCommand(context, command);
                }
                catch(StackEmptyException e)
                {
                    System.out.println("Error: stack is empty or too few values in stack");
                }
                catch(UnknownCommandException e)
                {
                    System.out.println("Error: unknown command");
                }
                catch(Exception e)
                {
                    System.out.println("Error: sorry, unexpected error");
                }
            }
            else if(command.indexOf("-")==0)
            {
                try
                {
                    context = commands.MinusCommand(context, command);
                }
                catch(StackEmptyException e)
                {
                    System.out.println("Error: stack is empty or too few values in stack");
                }
                catch(UnknownCommandException e)
                {
                    System.out.println("Error: unknown command");
                }
                catch(Exception e)
                {
                    System.out.println("Error: sorry, unexpected error");
                }
            }
            else if(command.indexOf("*")==0)
            {
                try
                {
                    context = commands.MultiplyCommand(context, command);
                }
                catch(StackEmptyException e)
                {
                    System.out.println("Error: stack is empty or too few values in stack");
                }
                catch(UnknownCommandException e)
                {
                    System.out.println("Error: unknown command");
                }
                catch(Exception e)
                {
                    System.out.println("Error: sorry, unexpected error");
                }
            }
            else if(command.indexOf("/")==0)
            {
                try
                {
                    context = commands.DivideCommand(context, command);
                }
                catch(StackEmptyException e)
                {
                    System.out.println("Error: stack is empty or too few values in stack");
                }
                catch(UnknownCommandException e)
                {
                    System.out.println("Error: unknown command");
                }
                catch(ZeroDivisionException e)
                {
                    System.out.println("Error: zero division");
                }
                catch(Exception e)
                {
                    System.out.println("Error: sorry, unexpected error");
                }
            }
            else if(command.indexOf("SQRT")==0)
            {
                try
                {
                    context = commands.SqrtCommand(context, command);
                }
                catch(StackEmptyException e)
                {
                    System.out.println("Error: stack is empty or too few values in stack");
                }
                catch(UnknownCommandException e)
                {
                    System.out.println("Error: unknown command");
                }
                catch(SqrtFromNegativeException e)
                {
                    System.out.println("Error: sqrt from negative");
                }
                catch(Exception e)
                {
                    System.out.println("Error: sorry, unexpected error");
                }
            }
            else if(command.indexOf("PRINT")==0)
            {
                try
                {
                    commands.PrintCommand(context, command);
                }
                catch(StackEmptyException e)
                {
                    System.out.println("Error: stack is empty or too few values in stack");
                }
                catch(UnknownCommandException e)
                {
                    System.out.println("Error: unknown command");
                }
                catch(Exception e)
                {
                    System.out.println("Error: sorry, unexpected error");
                }
            }
            else if(command.indexOf("DEFINE")==0)
            {
                try
                {
                    commands.DefineCommand(context, command);
                }
                catch(UnknownCommandException e)
                {
                    System.out.println("Error: unknown command");
                }
                catch(Exception e)
                {
                    System.out.println("Error: sorry, unexpected error");
                }
            }
            else if(command.indexOf("EXIT")==0)
                break;
            else
            {
                System.out.println("Error: unknown command");
            }
        }
    }
}
