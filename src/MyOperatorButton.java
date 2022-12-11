import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyOperatorButton extends Button implements ActionListener
{
    MyCalculator hesapMakinası;

    MyOperatorButton(int x,int y, int width,int height,String cap, MyCalculator hesap)
    {
        super(cap);
        setBounds(x,y,width,height);
        this.hesapMakinası=hesap;
        this.hesapMakinası.add(this);
        addActionListener(this);
    }
    public void actionPerformed(ActionEvent ev)
    {
        String opText=((MyOperatorButton)ev.getSource()).getLabel();

        hesapMakinası.setClear=true;
        double temp=Double.parseDouble(hesapMakinası.displayLabel.getText());

        if(opText.equals("fact"))
        {try{
            int result = 1;
            for(int i = 1; i <= temp; i++){
                result = result * i;
                hesapMakinası.displayLabel.setText(MyCalculator.getFormattedText(result));
            }}catch (ArithmeticException excp)
        {hesapMakinası.displayLabel.setText("sıfıra bölünemez");}
            return;}
        if(opText.equals("sqrt"))
        {
            try
            {double tempd=Math.sqrt(temp);
                hesapMakinası.displayLabel.setText(MyCalculator.getFormattedText(tempd));}
            catch(ArithmeticException excp)
            {hesapMakinası.displayLabel.setText("Sıfıra bölünemez");}
            return;
        }
        if(!opText.equals("="))
        {
            hesapMakinası.number=temp;
            hesapMakinası.op=opText.charAt(0);
            return;
        }

        switch(hesapMakinası.op)
        {
            case '^':
                temp=  Math.pow(hesapMakinası.number,temp);
                break;
            case '+':
                temp+=hesapMakinası.number;break;
            case '-':
                temp=hesapMakinası.number-temp;break;
            case '*':
                temp*=hesapMakinası.number;break;
            case '%':
                try{temp=hesapMakinası.number%temp;}
                catch(ArithmeticException excp)
                {hesapMakinası.displayLabel.setText("Divide by 0."); return;}
                break;
            case '/':
                try{temp=hesapMakinası.number/temp;}
                catch(ArithmeticException excp)
                {hesapMakinası.displayLabel.setText("Divide by 0."); return;}
                break;
        }

        hesapMakinası.displayLabel.setText(MyCalculator.getFormattedText(temp));

    }
}


