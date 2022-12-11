import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyDigitButton extends Button implements ActionListener
{
    MyCalculator hesapMakinası;


    MyDigitButton(int x,int y, int width,int height,String cap, MyCalculator hesap)
    {
        super(cap);
        setBounds(x,y,width,height);
        this.hesapMakinası=hesap;
        this.hesapMakinası.add(this);
        addActionListener(this);
    }
    static boolean isInString(String s, char ch)
    {
        for(int i=0; i<s.length();i++) if(s.charAt(i)==ch) return true;
        return false;
    }
    public void actionPerformed(ActionEvent ev)
    {
        String tempText=((MyDigitButton)ev.getSource()).getLabel();

        if(tempText.equals("."))
        {
            if(hesapMakinası.setClear)
            {hesapMakinası.displayLabel.setText("0.");
                hesapMakinası.setClear=false;}
            else if(!isInString(hesapMakinası.displayLabel.getText(),'.'))
                hesapMakinası.displayLabel.setText(hesapMakinası.displayLabel.getText()+".");
            return;
        }

        int index=0;
        try{
            index=Integer.parseInt(tempText);
        }catch(NumberFormatException e){return;}

        if (index==0 && hesapMakinası.displayLabel.getText().equals("0")) return;

        if(hesapMakinası.setClear)
        {hesapMakinası.displayLabel.setText(""+index);hesapMakinası.setClear=false;}
        else
            hesapMakinası.displayLabel.setText(hesapMakinası.displayLabel.getText()+index);
    }
}

