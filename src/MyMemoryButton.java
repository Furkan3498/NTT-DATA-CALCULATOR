import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyMemoryButton extends Button implements ActionListener
{
    MyCalculator hesapMakinası;

    MyMemoryButton(int x,int y, int width,int height,String cap, MyCalculator hesap)
    {
        super(cap);
        setBounds(x,y,width,height);
        this.hesapMakinası=hesap;
        this.hesapMakinası.add(this);
        addActionListener(this);
    }
    public void actionPerformed(ActionEvent ev)
    {
        char memop=((MyMemoryButton)ev.getSource()).getLabel().charAt(1);

        hesapMakinası.setClear=true;
        double temp=Double.parseDouble(hesapMakinası.displayLabel.getText());

        switch(memop)
        {
            case 'C':
                hesapMakinası.memLabel.setText(" ");hesapMakinası.memValue=0.0;break;
            case 'R':
                hesapMakinası.displayLabel.setText(MyCalculator.getFormattedText(hesapMakinası.memValue));break;
            case 'S':
                hesapMakinası.memValue=0.0;
            case '+':
                hesapMakinası.memValue+=Double.parseDouble(hesapMakinası.displayLabel.getText());
                if(hesapMakinası.displayLabel.getText().equals("0") || hesapMakinası.displayLabel.getText().equals("0.0")  )
                    hesapMakinası.memLabel.setText(" ");
                else
                    hesapMakinası.memLabel.setText("M");
                break;
        }
    }
}


