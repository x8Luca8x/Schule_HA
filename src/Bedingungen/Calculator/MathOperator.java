package Bedingungen.Calculator;

public abstract class MathOperator
{
    public MathOperator m_ParentOperator = null;
    public FloatContainer m_OperatorNumber = null;

    public abstract float Calculate();
}
