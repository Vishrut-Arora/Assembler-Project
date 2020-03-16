
import java.util.Scanner;
import java.lang.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;

class cofinal1{
  public static String[] varused=new String[1000];
  public static int varu=0;
  public static String[] labelused=new String[1000];
  public static int labelu=0;
  public static String[] vardeclared=new String[1000];
  public static int vard=0;
  public static String[] labeldeclared=new String[1000];
  public static int labeld=0;
  public static void pass2(int labels,String counter_label[][]) throws FileNotFoundException, IOException //2nd pass
  {
    File assembly_file=new File("C:\\Users\\hp-pavilion\\Desktop\\Input.txt");
    FileWriter machine_file=new FileWriter("C:\\Users\\hp-pavilion\\Desktop\\Output.txt");
    Scanner sc=new Scanner(assembly_file);
    String oparray1[][]={{"CLA","0"},{"LAC","1"},{"SAC","1"},{"ADD","1"},{"SUB","1"},{"BRZ","1"},{"BRN","1"},{"BRP","1"},{"INP","1"},{"DSP","1"},{"MUL","1"},{"DIV","3"},{"STP","0"}};
    String oparray2[][]={{"CLA","0000"},{"LAC","0001"},{"SAC","0010"},{"ADD","0011"},{"SUB","0100"},{"BRZ","0101"},{"BRN","0110"},{"BRP","0111"},{"INP","1000"},{"DSP","1001"},{"MUL","1010"},{"DIV","1011"},{"STP","1100"}};
    int memoryadd=0;
    String s=sc.nextLine();
    while(sc.hasNextLine())  //reading file line by line for second pass
    {
         s=sc.nextLine();
        String[] c=s.split(" ");

        if(c[0].equals("CLA"))  //clear acc
        {
            machine_file.write(String.format("%4s", Integer.toBinaryString(memoryadd)).replace(' ', '0')+" 0000"+"\n");
        }
        else if(c[0].equals("LAC")) //load to acc
        {
                    try{
                        Integer.parseInt(c[1]);

                        machine_file.write(String.format("%4s", Integer.toBinaryString(memoryadd)).replace(' ', '0')+" 0001"+" "+Integer.toBinaryString(Integer.parseInt(c[1]))+"\n");
                    }
                    catch (NumberFormatException e)
                    {
                        machine_file.write(String.format("%4s", Integer.toBinaryString(memoryadd)).replace(' ', '0')+" 0001"+" "+c[1]+"\n");
                    }
        }
        else if(c[0].equals("SAC"))     //store to acc
        {
                    try{
                        Integer.parseInt(c[1]);

                        machine_file.write(String.format("%4s", Integer.toBinaryString(memoryadd)).replace(' ', '0')+" 0010"+" "+Integer.toBinaryString(Integer.parseInt(c[1]))+"\n");
                    }
                    catch (NumberFormatException e)
                    {
                        machine_file.write(String.format("%4s", Integer.toBinaryString(memoryadd)).replace(' ', '0')+" 0010"+" "+c[1]+"\n");
                    }
        }

        else if(c[0].equals("ADD"))    //add contents to acc
        {
                    try{
                        Integer.parseInt(c[1]);

                        machine_file.write(String.format("%4s", Integer.toBinaryString(memoryadd)).replace(' ', '0')+" 0011"+" "+Integer.toBinaryString(Integer.parseInt(c[1]))+"\n");
                    }
                    catch (NumberFormatException e)
                    {
                        machine_file.write(String.format("%4s", Integer.toBinaryString(memoryadd)).replace(' ', '0')+" 0011"+" "+c[1]+"\n");
                    }
        }

        else if(c[0].equals("SUB"))    //subtract contents from acc
        {
                    try{
                        Integer.parseInt(c[1]);

                        machine_file.write(String.format("%4s", Integer.toBinaryString(memoryadd)).replace(' ', '0')+" 0100"+" "+Integer.toBinaryString(Integer.parseInt(c[1]))+"\n");
                    }
                    catch (NumberFormatException e)
                    {
                        machine_file.write(String.format("%4s", Integer.toBinaryString(memoryadd)).replace(' ', '0')+" 0100"+" "+c[1]+"\n");
                    }
        }
        else if(c[0].equals("BRZ"))     //branch to address zero
        {
            for(int i=0;i<labels;i++)   //writing corresponding label address
            {

                if(c[1].equals(counter_label[i][0]))
                {
                    machine_file.write(String.format("%4s", Integer.toBinaryString(memoryadd)).replace(' ', '0')+" 0101"+" "+String.format("%4s", Integer.toBinaryString(Integer.parseInt(counter_label[i][1]))).replace(' ', '0')+"\n");
                    break;
                }
            }

        }
        else if(c[0].equals("BRN"))       //branch to address negative
        {
            for(int i=0;i<labels;i++)      //writing corresponding label address
            {
                if(c[1].equals(counter_label[i][0]))
                {
                    machine_file.write(String.format("%4s", Integer.toBinaryString(memoryadd)).replace(' ', '0')+" 0110"+" "+String.format("%4s", Integer.toBinaryString(Integer.parseInt(counter_label[i][1]))).replace(' ', '0')+"\n");
                }
            }

        }
        else if(c[0].equals("BRP"))         //branch to address positive
        {
            for(int i=0;i<labels;i++)         //writing corresponding label address
            {
                if(c[1].equals(counter_label[i][0]))
                {
                    machine_file.write(String.format("%4s", Integer.toBinaryString(memoryadd)).replace(' ', '0')+" 0111"+" "+String.format("%4s", Integer.toBinaryString(Integer.parseInt(counter_label[i][1]))).replace(' ', '0')+"\n");
                }
            }

        }
        else if(c[0].equals("INP"))             // input
        {
                    try{
                        Integer.parseInt(c[1]);

                        machine_file.write(String.format("%4s", Integer.toBinaryString(memoryadd)).replace(' ', '0')+" 1000"+" "+Integer.toBinaryString(Integer.parseInt(c[1]))+"\n");
                    }
                    catch (NumberFormatException e)
                    {
                        machine_file.write(String.format("%4s", Integer.toBinaryString(memoryadd)).replace(' ', '0')+" 1000"+" "+c[1]+"\n");
                    }
        }
        else if(c[0].equals("DSP"))               //display
        {
                    try{
                        Integer.parseInt(c[1]);

                        machine_file.write(String.format("%4s", Integer.toBinaryString(memoryadd)).replace(' ', '0')+" 1001"+" "+Integer.toBinaryString(Integer.parseInt(c[1]))+"\n");
                    }
                    catch (NumberFormatException e)
                    {
                        machine_file.write(String.format("%4s", Integer.toBinaryString(memoryadd)).replace(' ', '0')+" 1001"+" "+c[1]+"\n");
                    }
        }
        else if(c[0].equals("MUL"))                 //multiply acc contents
        {
                    try{
                        Integer.parseInt(c[1]);

                        machine_file.write(String.format("%4s", Integer.toBinaryString(memoryadd)).replace(' ', '0')+" 1010"+" "+Integer.toBinaryString(Integer.parseInt(c[1]))+"\n");
                    }
                    catch (NumberFormatException e)
                    {
                        machine_file.write(String.format("%4s", Integer.toBinaryString(memoryadd)).replace(' ', '0')+" 1010"+" "+c[1]+"\n");
                    }
        }
        else if(c[0].equals("DIV"))               //divide acc contents get quotient and remainder
        {
            machine_file.write(String.format("%4s", Integer.toBinaryString(memoryadd)).replace(' ', '0')+" 1011 ");
            for(int i=1;i<c.length;i++)
            {
                    try{
                        Integer.parseInt(c[i]);

                        machine_file.write(Integer.toBinaryString(Integer.parseInt(c[i]))+" ");
                    }
                    catch (NumberFormatException e)
                    {
                        machine_file.write(c[i]+" ");
                    }
            }
            machine_file.write("\n");
        }

        else if(c[0].equals("STP"))           //end statement
        {
           machine_file.write(String.format("%4s", Integer.toBinaryString(memoryadd)).replace(' ', '0')+" 1100"+"\n");
        }

        else{                                         //check for labels if any
            for(int i=0;i<13;i++)
            {
                if(c[1].equals(oparray1[i][0]))
                {
                    if(Integer.parseInt(oparray1[i][1])==0)
                    {
                        machine_file.write(String.format("%4s", Integer.toBinaryString(memoryadd)).replace(' ', '0')+" "+oparray2[i][1]+"\n");
                    }
                    else if(Integer.parseInt(oparray1[i][1])==1)
                    {
                    try{
                        Integer.parseInt(c[2]);
                        machine_file.write(String.format("%4s", Integer.toBinaryString(memoryadd)).replace(' ', '0')+" "+oparray2[i][1]+" "+Integer.toBinaryString(Integer.parseInt(c[2]))+"\n");
                    }
                    catch (NumberFormatException e)
                    {
                        machine_file.write(String.format("%4s", Integer.toBinaryString(memoryadd)).replace(' ', '0')+" "+oparray2[i][1]+" "+c[2]+"\n");
                    }

                    }
                    else
                    {
                        machine_file.write(String.format("%4s", Integer.toBinaryString(memoryadd)).replace(' ', '0')+" "+oparray2[i][1]+" ");
                        for(int j=0;j<Integer.parseInt(oparray1[i][1]);j++)
                        {
                    try{
                        Integer.parseInt(c[j+2]);
                        machine_file.write(Integer.toBinaryString(Integer.parseInt(c[j+2]))+" ");
                    }
                    catch (NumberFormatException e)
                    {
                        machine_file.write(c[j+2]+" ");
                    }
                        }
                     machine_file.write("\n");
                    }
                }
            }
        }
            ++memoryadd;




        }
        machine_file.close();

  }
  public static void definevar(String[] file,int l)
  {  int flagc=0;
    for(int j=0;j<vardeclared.length;j++)
    {
        if(file[l+1].equals(vardeclared[j]))
        {
            System.out.print(file[l+1]+" symbol has been defined more than once");
            flagc=1;
            System.exit(0);

        }
    }
    if(flagc!=1)
    {
    vardeclared[vard]=file[l+1];
    vard++;
  }
}
  public static void usedlabel(String[] file,int l)
  {
    int flagc=0;
      for(int j=0;j<labelu;j++)
      {
          if((file[l+1]+":").equals(labelused[j]))
          {
            flagc=1;
            break;
  }
}    if(flagc==0)
    {
      labelused[labelu]=file[l+1] +":";
      labelu++;
    }
}
public static void usedvar(String[] file,int l)
{
  for(int i=l+1;i<file.length;i++)
  { int flagc=0;

      for(int j=0;j<varused.length;j++)
      {
          if(file[i].equals(varused[j]))
          {
            flagc=1;
            break;
  }
}

if(flagc==0)
{
  varused[varu]=file[i];
  varu++;
}
}
}
public static void declaredlabel(String[] file,int l){
  int flagc=0;
    for(int j=0;j<labeldeclared.length;j++)
    {
        if(file[l].equals(labeldeclared[j]))
        {
            System.out.print(file[l]+" label has been defined more than once");
            flagc=1;
            System.exit(0);

        }
    }
    if(flagc!=1)
    {
    labeldeclared[labeld]=file[l];
    labeld++;
  }
}

public static void  checkop(String[] file,String[][] arr)
{
  int k=0;
  int r=0;
int l=0;

   if(file[0].charAt(file[0].length()-1)==':')
   { l=1; }
     for(int j=0;j<arr.length;j++)
     {
       if (file[l].equals(arr[j][0]))
       {
         k=1; r=Integer.parseInt(arr[j][1]);}
     }
     if(k==0)
     { System.out.println(file[l]);
       System.out.println("INVALID OP CODE");
        System.exit(0);
       }

     else
     {
       if (r<file.length-1-l)
       {  System.out.println(file[l]);
         System.out.println("TOO MANY OPERAND");
        System.exit(0);
       }
       else if (r>file.length-1-l)
       { System.out.println(file[l]);
         System.out.println("LESS NUMBER OF OPERAND");
       System.exit(0);}
     }


   if (file[l].equals("INP"))
   {
     definevar(file,l);
   }
   else if (file[l].charAt(0)=='B')
   {
     usedlabel(file,l);
   }
else{
  usedvar(file,l);
}
if (l==1)
{
  declaredlabel(file,0);
}
 }

  public static void main (String[] args)throws FileNotFoundException, IOException
  {
        File assembly_file=new File("C:\\Users\\hp-pavilion\\Desktop\\Input.txt");
        FileWriter symbol_table=new FileWriter("C:\\Users\\hp-pavilion\\Desktop\\Symbol.txt");
        FileWriter label_table=new FileWriter("C:\\Users\\hp-pavilion\\Desktop\\Label.txt");
        Scanner sc=new Scanner(assembly_file);
        String oparray[][]={{"CLA","0"},{"LAC","1"},{"SAC","1"},{"ADD","1"},{"SUB","1"},{"BRZ","1"},{"BRN","1"},{"BRP","1"},{"INP","1"},{"DSP","1"},{"MUL","1"},{"DIV","3"},{"STP","0"}};
        String str=null;
        String[] c=new String[500];
        int labels=0;
        String counter_label[][]=new String[100][2];
        int counter=0;
        str=sc.nextLine();
        c=str.split(" ");
        if (c[0].equals("START"))
        System.out.print("");
        else
        { System.out.println("START MISSING");System.exit(0);}
        while(sc.hasNextLine()) 
        {
            str=sc.nextLine(); 
            c=str.split(" ");
            if (c[0].equals("com"))
            {
              System.out.print("");
            }
            else
            {
            checkop(c,oparray);                                 //error reporting function
            if(c[0].equals("INP"))                                
            {
              symbol_table.write(c[1]+"  "+counter+"\n");        //symbol table creation
            }
            else if(c[0].charAt(c[0].length()-1)==':')
            {
              label_table.write(c[0].substring(0,c[0].length()-1)+"  "+counter+"\n"); //label table creation
              counter_label[labels][0]=c[0].substring(0,c[0].length()-1);
              counter_label[labels][1]=counter+"";
              ++labels;

            }
            ++counter;

        }
      }
        symbol_table.close();
        label_table.close();
        int l=0;
        if(c[0].charAt(c[0].length()-1)==':')
        { l=1; }
      if (c[l].equals("STP")==false)                     //end statement
      {
        System.out.println("MISSING STP STATEMENT");

        System.exit(0);
      }


      for(int i=0;i<varu;i++)                              //some other possible errors
      { int flag=0;
        for(int j=0;j<vard;j++)
        {
          if (varused[i].equals(vardeclared[j]))
           {flag=1;break;}
        }
        if (flag==0)
        {System.out.println(varused[i] +" NOT DECLARED");
          System.exit(0);
      }
  }

  for(int j=0;j<vard;j++)
  { int flag=0;
      for(int i=0;i<varu;i++)
    {
      if (varused[i].equals(vardeclared[j]))
       {flag=1;break;}
    }
    if (flag==0)
    {System.out.println(vardeclared[j] +" NOT Used");
System.exit(0);
  }
 }


 for(int i=0;i<labelu;i++)
 { int flag=0;
   for(int j=0;j<labeld;j++)
   {
     if (labelused[i].equals(labeldeclared[j]))
      {flag=1;break;}
   }
   if (flag==0)
   {System.out.println(labelused[i] +" NOT DECLARED");
System.exit(0);
 }
 }

 for(int j=0;j<labeld;j++)
 {  int flag=0;
   for(int i=0;i<labelu;i++)
  {
  if (labelused[i].equals(labeldeclared[j]))
  {
    flag=1;break;}
   }
  if (flag==0)
  {System.out.println(labeldeclared[j] +" NOT Used");
System.exit(0);
  }
}
pass2(labels,counter_label);//2nd pass call
}



}
