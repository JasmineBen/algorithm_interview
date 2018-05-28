package com.datastructure.exercise;

import java.util.HashMap;

public class StringExercise {
	
	public static void main(String[] args) {
//		System.out.println(isDeformation("123", "231"));
//		System.out.println(isDeformation("123", "2331"));
//		System.out.println(numSum("A-1cd-2e--33"));
//		System.out.println(removeKZeros("A0000B000",4));
//		System.out.println(isRotation("1234", "3412"));
//		System.out.println(replace("123abcabca4", "abc", "x"));
		System.out.println(replaceSpace("I am a student.      ".toCharArray())+";");
	}

	/**
	 * �ַ���a b���ַ�һ��˵������֮�以Ϊ���δʣ����ֵ���ĸһ������ÿ����ĸ������һ��
	 * ���磺��123�� ��231����Ϊ���δ�, ��123�� "2331"���Ǳ��δ�
	 * ��һ��HashMap�����㣬keyΪ�ַ������ַ���valueΪ�ַ����ֵĴ�����
	 * ���ȱ���a,��a�е��ַ�����HashMap�У�������ÿ���ַ�����������ͬ�ַ���������1.
	 * Ȼ�����b����b�е��ַ������HashMap�в����ڣ�ֱ�ӷ���false,
	 * ������ڣ����HashMap�ж�Ӧ�ַ�������������������������ּ�������������С��0������false
	 */
	public static boolean isDeformation(String a,String b){
		if(a == null || b == null || (a.length() != b.length())){
			return false;
		}
		//keyΪchar�ַ���valueΪcount
		HashMap<Integer,Integer> map = new HashMap<>();
		char[] aChar = a.toCharArray();
		char[] bChar = b.toCharArray();
		for(char c : aChar){
			Integer key = c-'0';
			Integer count = map.get(key);
			if(count != null){
				map.put(key, map.get(key)+1);
			}else{
				map.put(key,1);
			}
		}
		for(char c : bChar){
			Integer key = c-'0';
			Integer count = map.get(key);
			if(count != null){
				map.put(key, count-1);
				if(count < 0){
					return false;
				}
			}else{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * �����ַ��������е������Ӵ��ĺͣ����������߳��ֵġ�-��Ϊ����ʱ��ʾ��������֮��ʾ����
	 * ��A1cd2e33��  == 1+2+33 = 36
	 */
	public static int numSum(String s) {
		char[] chars = s.toCharArray();
		int res = 0;// ������
		int num = 0;// ��ǰʶ��������Ӵ�
		boolean flag = true;// �������
		for (int i = 0;i<chars.length;i++) {
			int code = chars[i] - '0';
			if (code < 0 || code > 9) {// ������
				res += num;
				num = 0;
				if (i-1>=0 && chars[i] == '-' && chars[i-1] == '-') {
					flag = !flag;
				}else{
					flag = false;
				}
			} else {// ����
				num = num * 10 + (flag ? code : -code);
			}
		}
		res += num;
		return res;
	}
	
	/**
	 * ȥ���ַ�����������k��0
	 * ���磺��A00B����k=2ʱ����AB
	 * ��A0000B000����k=3ʱ����A0000B
	 */
	public static String removeKZeros(String s, int k) {
		if (s == null || s.length() < k) {
			return s;
		}
		char[] chars = s.toCharArray();
		int count = 0;
		int start = -1;
		for(int i=0;i<chars.length;i++){
			int code = chars[i]-'0';
			if(code == 0){
				count ++;
				start = (start ==-1?i:start);
			}else{
				if(count == k){
					for(int j = start;j<start+k;j++){
						chars[j]=0;//�滻�ɿո�
					}
				}
				count = 0;
				start = -1;
			}
			
		}
		if(count == k){
			for(int j = start;j<start+k;j++){
				chars[j]=0;//�滻�ɿո�
			}
		}
		StringBuffer sb = new StringBuffer();
		for(char c : chars){
			if(c != 0){
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	/**
	 * �ж�a b�Ƿ�Ϊ��ת��,��1234���͡�3412����Ϊ��ת��
	 * ����aΪx��y�����Ӵ���ɣ����a b��Ϊ��ת�ʣ���ôbһ����y��x�����Ӵ���ɡ�
	 * ����a+a=xyxyһ������b
	 */
	public static boolean isRotation(String a,String b){
		if(a.length() != b.length()){
			return false;
		}
		return (a+a).contains(b);
	} 
	
	/**
	 * ���ַ���str���������ֵ��ַ���from�滻���ַ���to.
	 * ����str=��123abcabca4��,from="abc",to="x",�滻��ɺ�str=123xa4
	 * ˼�룺��strתΪ�ַ����飬��������from��0��ʾ��ת����Ϊ['1','2','3',0,0,0,0,0,0,'a','4'],
	 * Ȼ���ٽ��ַ����������еķ�0������װ
	 */
	public static String replace(String str,String from,String to){
		char[] strChars = str.toCharArray();
		char[] fromChars = from.toCharArray();
		int match = 0;
		for(int i = 0;i<strChars.length;i++){
			if(strChars[i] == fromChars[match]){
				match++;
				if(match == fromChars.length){//ƥ��һ���ɹ�
					while(match != 0){
						strChars[i-match+1] = 0;
						match--;
					}
					match = 0;
				}
			}else{
				if(strChars[i]==fromChars[0]){
					i--;
				}
				match = 0;
			}
			
		}
	
		StringBuffer sb = new StringBuffer();
		String cur = "";
		for(int i = 0;i<strChars.length;i++){
			if(strChars[i] != 0){
				cur = cur+String.valueOf(strChars[i]);
			}
			if(strChars[i] == 0 && (i ==0||strChars[i-1] != 0)){//��ǰ�ַ�Ϊ0����ǰһ���ַ���Ϊ0�����Խ����滻
				sb.append(cur).append(to);
				cur = "";
			}
		}
		if(!cur.equals("")){
			sb.append(cur);
		}
		return sb.toString();
	}
	
	/**
	 * һ���ַ�����.��β�����ַ������еĿո��滻�� %20
	 * ���������ַ���������д�������λ��(important)
	 * 1���ȼ���ԭ�������ж��ٿո��ַ�
	 * 2������ԭ�ַ������е��ַ�����Ϊx����y���ո������ô���滻��ɺ��ַ�����Ϊx+2*y
	 */
	public static String replaceSpace(char[] strs){
		int spaceCount = 0;//�ո�����
		int beforeLen = 0;//�滻ǰ����Ч�ַ�����
		int afterLen = 0;//�滻�����Ч�ַ�����
		for(int i = 0;i<strs.length;i++){
			if(strs[i] == ' '){
				spaceCount++;
			}
			beforeLen ++;
			if(strs[i] == '.'){
				break;
			}	
		}
		if(spaceCount > 0){
			afterLen = beforeLen + 2 * spaceCount;
			afterLen--;
			for(int i=beforeLen-1;i>=0;i--){
				if(strs[i] != ' '){
					strs[afterLen--] = strs[i];
				}else{
					strs[afterLen--] = '0';
					strs[afterLen--] = '2';
					strs[afterLen--] = '%';
				}
			}
		}
		
		return new String(strs);
	}
}
