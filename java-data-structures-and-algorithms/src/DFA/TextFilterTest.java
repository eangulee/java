package DFA;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class TextFilterTest {
	public static void main(String[] args) {
		new TextFilterTest().test1();
		
		
	}
	
	public void test1(){
		Set<String>  sensitiveWords=new HashSet<>();
		sensitiveWords.add("shit");
		sensitiveWords.add("傻逼");
		sensitiveWords.add("笨蛋");
		String text="你是傻逼啊";
		for(String sensitiveWord:sensitiveWords){
			if(text.contains(sensitiveWord)){
				System.out.println("输入的文本存在敏感词。——"+sensitiveWord);
				break;
			}
		}
	}


	public void test2(){

		char[] chars=new char[]{' ','*','!','@'};
		String text="  fgs  * ds ! fgd@gfdg";
		BitSet bitSet=new BitSet();
		for(char c:chars){
			bitSet.set(c);
		}
		char[] textChars = text.toCharArray();
		char[] newChars=new char[textChars.length];
		int i=0;
		for (char c:textChars){
			if(!bitSet.get(c)){
				newChars[i++]=c;
			}
		}
		System.out.println(new String(newChars));
		System.out.println((int)'&');
	}
}
