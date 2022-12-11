import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MySpecialButton extends Button implements ActionListener
{
    MyCalculator hesapMakinası;

    MySpecialButton(int x,int y, int width,int height,String cap, MyCalculator hesap)
    {
        super(cap);
        setBounds(x,y,width,height);
        this.hesapMakinası=hesap;
        this.hesapMakinası.add(this);
        addActionListener(this);
    }
    static String backSpace(String s)
    {
        String Res="";
        for(int i=0; i<s.length()-1; i++) Res+=s.charAt(i);
        return Res;
    }
    public void actionPerformed(ActionEvent ev)
    {
        String opText=((MySpecialButton)ev.getSource()).getLabel();

        if(opText.equals("GERİ AL"))
        {
            String tempText=backSpace(hesapMakinası.displayLabel.getText());
            if(tempText.equals(""))
                hesapMakinası.displayLabel.setText("0");
            else
                hesapMakinası.displayLabel.setText(tempText);
            return;
        }
        if(opText.equals("TEMİZLE"))
        {
            hesapMakinası.number=0.0; hesapMakinası.op=' '; hesapMakinası.memValue=0.0;
            hesapMakinası.memLabel.setText(" ");
        }

        hesapMakinası.displayLabel.setText("0");hesapMakinası.setClear=true;
    }
}