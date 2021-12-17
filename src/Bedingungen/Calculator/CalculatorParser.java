package Bedingungen.Calculator;

import java.util.ArrayList;

public class CalculatorParser
{
    enum EConstant
    {
        None,
        PI_CONSTANT,
        E_CONSTANT
    }

    public static ArrayList<MathOperator> Parse(String String)
    {
        ArrayList<MathOperator> operatorList = new ArrayList<>();
        MathOperator lastOperator = new NoneOperator();
        float lastNumber = 0.f;

        int stringLength = String.length();
        for(int i = 0; i < stringLength; i++)
        {
            String token = Tokenize(String, i);
            if(token == null || token.isEmpty())
                continue;

            int tokenLength = token.length();
            if(token.equals("PI") || token.equals("E"))
            {
                if(lastNumber != 0.f)
                {
                    System.out.println("Unerwartetes token: " + token + " Erwartet: Operator");
                    return null;
                }

                if(token.equals("PI"))
                    lastNumber = (float)Math.PI;
                else
                    lastNumber = (float) Math.E;
            }
            else if(tokenLength == 1 && IsOperator(token.charAt(0)))
            {
                char character = token.charAt(0);

                lastOperator.m_OperatorNumber = new FloatContainer(lastNumber);
                MathOperator newOperator = null;

                if(character == '+')
                {
                    newOperator = new AddOperator();

                    newOperator.m_ParentOperator = lastOperator;
                    lastNumber = 0.f;
                }
                else if(character == '-')
                {
                    newOperator = new SubOperator();

                    newOperator.m_ParentOperator = lastOperator;
                    lastNumber = 0.f;
                }
                else if(character == '*')
                {
                    newOperator = new MulOperator();

                    newOperator.m_ParentOperator = lastOperator;
                    lastNumber = 0.f;
                }
                else if(character == '/')
                {
                    newOperator = new DivOperator();

                    newOperator.m_ParentOperator = lastOperator;
                    lastNumber = 0.f;
                }

                operatorList.add(lastOperator);
                lastOperator = newOperator;
            }
            else if(token.charAt(0) == '(' && token.charAt(tokenLength - 1) == ')')
            {
                ArrayList<MathOperator> operators = Parse(token.substring(1, tokenLength - 1));

                assert operators != null;
                float value = 0.f;

                for (MathOperator operator : operators)
                    value = operator.Calculate();

                lastNumber = value;
            }
            else
            {
                if(lastNumber != 0.f)
                {
                    System.out.println("Unerwartetes token: " + token + " Erwartet: Operator");
                    return null;
                }

                lastNumber = Float.parseFloat(token);
            }

            i += tokenLength - 1;
        }

        lastOperator.m_OperatorNumber = new FloatContainer(lastNumber);
        operatorList.add(lastOperator);

        ArrayList<MathOperator> listSave = operatorList;
        operatorList = new ArrayList<>();

        for (MathOperator operator : listSave)
        {
            if (operator instanceof MulOperator || operator instanceof DivOperator)
                operatorList.add(operator);
        }
        for (MathOperator operator : listSave)
        {
            if (operator instanceof AddOperator || operator instanceof SubOperator)
                operatorList.add(operator);
        }
        for (MathOperator operator : listSave)
        {
            if (operator instanceof NoneOperator)
                operatorList.add(operator);
        }

        return operatorList;
    }

    private static String Tokenize(String String, int Index)
    {
        int stringLength = String.length();
        for(int i = Index; i < stringLength; i++)
        {
            EConstant constant = IsConstant(String, i);
            if(constant != EConstant.None)
            {
                if(constant == EConstant.PI_CONSTANT)
                    return String.substring(i, i + 2);
                else if(constant == EConstant.E_CONSTANT)
                    return String.substring(i, i + 1);
            }
            else if(IsSpace(String.charAt(i)) || i + 1 >= stringLength)
            {
                if(i + 1 >= stringLength)
                    return String.substring(Index, i + 1);
                return String.substring(Index, i);
            }
            else if(IsOperator(String.charAt(i)))
            {
                if(i == Index)
                    return String.substring(i, i + 1);
                else
                    return String.substring(Index, i);
            }
            else if(String.charAt(i) == '(')
            {
                if(i == Index)
                {
                    for(int x = i + 1; x < stringLength; x++)
                    {
                        if(String.charAt(x) == ')')
                            return String.substring(Index, x + 1);
                    }
                }
                else
                    return String.substring(Index, i);
            }
        }

        return null;
    }

    private static boolean IsOperator(char Character)
    {
        return Character == '+' || Character == '-' || Character == '*' || Character == '/';
    }
    private static boolean IsSpace(char Character)
    {
        return Character == ' ' || Character == '\t';
    }
    private static EConstant IsConstant(String String, int Index)
    {
        char firstCharacter = String.charAt(Index);
        if(firstCharacter == 'P' && String.charAt(Index + 1) == 'I')
            return EConstant.PI_CONSTANT;
        else if(firstCharacter == 'E')
            return EConstant.E_CONSTANT;

        return EConstant.None;
    }
}
