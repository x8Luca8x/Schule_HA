package Bedingungen.Calculator;

public class SubOperator extends MathOperator
{
    @Override
    public float Calculate()
    {
        if(m_ParentOperator == null)
            return m_OperatorNumber.m_Number;

        m_ParentOperator.m_OperatorNumber.m_Number -= m_OperatorNumber.m_Number;
        m_OperatorNumber = m_ParentOperator.m_OperatorNumber;

        return m_ParentOperator.m_OperatorNumber.m_Number;
    }
}
