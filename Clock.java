import java.awt.*;
import java.applet.*;
import java.util.*;
/*<applet code="Clock" width="800" height="600"></applet>*/

public class Clock extends Applet {
int x1=400,y1=250,x2,y2,theta=30,hx,hy,mx,my,sx,sy;
float k=90;

public void paint(Graphics g){
Calendar calendar = Calendar.getInstance();
int hours = calendar.get(Calendar.HOUR_OF_DAY);
int minutes = calendar.get(Calendar.MINUTE);
int seconds = calendar.get(Calendar.SECOND);

if(hours>12)
hours -= 12;

mx=(int)(70*Math.cos((((minutes+45)%60))*6*Math.PI/180))+x1;
my=(int)(70*Math.sin((((minutes+45)%60))*6*Math.PI/180))+y1;
sx=(int)(90*Math.cos((((seconds+45)%60))*6*Math.PI/180))+x1;
sy=(int)(90*Math.sin((((seconds+45)%60))*6*Math.PI/180))+y1;

int cnt=minutes/12;
hx=(int)(45*Math.cos(((((hours+8)%12)+1)*30+cnt*6)*Math.PI/180))+x1;
hy=(int)(45*Math.sin(((((hours+8)%12)+1)*30+cnt*6)*Math.PI/180))+y1;


g.setColor(Color.cyan);
g.fillOval(225+5,75+5,350,350);
g.setColor(Color.black);
g.drawOval(225+5,75+5,350,350);
g.drawOval(225+3,75+3,354,354);

g.setColor(Color.red);
g.drawLine(x1,y1,mx,my);
g.drawLine(x1+1,y1+1,mx+1,my+1);


g.setColor(Color.blue);
g.drawLine(x1,y1,hx,hy);
g.drawLine(x1+1,y1+1,hx+1,hy+1);



//x2=sx;
//y2=sy;
g.setColor(Color.black);
for(int t=0;t<=360;t=t+6){
int x7=(int)((k+30)*Math.cos(t*Math.PI/180))+x1;
int y7=(int)((k+30)*Math.sin(t*Math.PI/180))+y1;
g.fillOval(x7,y7,5,5);
}

g.setFont(new Font("TimesRoman",Font.PLAIN,30));
g.drawString("12",390,120);
g.drawString("6",400,405);
g.drawString("3",535,260);
g.drawString("9",255,260);
g.drawString("1",465,145);
g.drawString("2",515,195);
g.drawString("4",515,325);
g.drawString("5",460,385);
g.drawString("7",340,390);
g.drawString("8",275,335);
g.drawString("11",310,145);
g.drawString("10",260,195);

g.drawLine(x1,y1,sx,sy);
g.drawLine(x1+1,y1+1,sx+1,sy+1);

g.setColor(Color.black);
g.setFont(new Font("TimesRoman",Font.PLAIN,30));
if(hours==0)
hours=12;
g.drawString(""+hours+" : "+minutes+" : "+seconds+"",350,480);

try{
Thread.sleep(1000);
}catch(InterruptedException e){}

repaint();
}
}