import java.util.*;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;

import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigInteger;
public class aesabc {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("textin.txt"));
		PrintWriter pw = new PrintWriter("something.ppm");
		StringBuilder sb2 = new StringBuilder();
		sc.useDelimiter("");
		System.out.println(sc.hasNext());
		StringBuilder sb = new StringBuilder();
		while(sc.hasNext()){
			int x = Integer.parseInt(sc.next()+sc.next(),16);
			sb.append((char)(x));
		}
		sc = new Scanner(sb.toString());
		String str = sb.toString();
		sc.useDelimiter("");
		pw.println(sc.nextLine());
		pw.println(sc.nextLine());
		pw.println(sc.nextLine());
		BigInteger max = new BigInteger("256").pow(16);
		String iv = scan16(sc);
		BigInteger x = dec(iv);
		for(int i=1;i<str.length()/16;i++){
			String n = scan16(sc);
			if(n.length()==0);
			else{
			BigInteger y = dec(n);
			BigInteger res = (y.subtract(x)).mod(max);
			if(res.compareTo(BigInteger.ZERO)<0)
				System.out.println(res);
			x=y;
			sb2.append(bytes(res));
			}
		}
		pw.println(sb2);
        pw.close();
		
	}
	public static String scan16(Scanner sc){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<16&&sc.hasNext();i++){
			sb.append(sc.next());
		}
		return sb.toString();
	}
	public static BigInteger dec(String a){
		BigInteger asd = new BigInteger("0");
		char[] x = a.toCharArray();
		for(char c : x){
			asd = asd.multiply(new BigInteger("256")).add(new BigInteger(Integer.toString(c)));
		}
		return asd;
	}

	public static String bytes(BigInteger a){
		String s = "";
		while(!a.equals(new BigInteger("0"))){
			char c = (char)Integer.parseInt(a.mod(new BigInteger("256")).toString());
			s=c+s;
			a=a.divide(new BigInteger("256"));
		}
		return s;
	}
}