package com.telek.ghj.mail;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.StringTokenizer;
import sun.misc.BASE64Encoder;

public class SMTPClient {
	private static String USER = "";
	private static String PASSWORD = "";
	static {
		SMTPClient.USER = ConfigReader.getConfig("user");
		SMTPClient.PASSWORD = ConfigReader.getConfig("password");
	}
	
	private boolean debug=true;

	BASE64Encoder encode=new BASE64Encoder();//用于加密后发送用户名和密码
	
	public static void sendEMail(MailMessage message) throws UnknownHostException, IOException {
	
		String server="smtp.163.com";//邮件服务器
		SMTPClient smtp=new SMTPClient(server,25);
		boolean flag;
		flag=smtp.sendMail(message,server);
		if(flag){
			System.out.println("邮件发送成功！");
		} else {
			System.out.println("邮件发送失败！");
		}
	}

	private Socket socket;

	/** 
	 * 有参的构造方法
	 * @param server  邮件服务器
	 * @param port  服务器端口号
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	private SMTPClient(String server,int port) throws UnknownHostException, IOException{
		try {
			socket=new Socket(server,25);
		}catch(SocketException e){
			System.out.println(e.getMessage());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.out.println("已经建立连接!");
		}
	}
	
	//注册到邮件服务器
	private void helo(String server,BufferedReader in,BufferedWriter out) throws IOException{
		int result;
		result=getResult(in);
		//连接上邮件服务后,服务器给出220应答
		if(result!=220){
			throw new IOException("连接服务器失败");
		}
		result=sendServer("HELO "+server,in,out);
		//HELO命令成功后返回250
		if(result!=250) {
			throw new IOException("注册邮件服务器失败！");
		}
	}

	private int sendServer(String str,BufferedReader in,BufferedWriter out) throws IOException{
		out.write(str);
		out.newLine();
		out.flush();
		if(debug)
		{
			System.out.println("已发送命令:"+str);
		}
		return getResult(in);
	}

	private int getResult(BufferedReader in){
		String line="";
		try{
			line=in.readLine();
			if(debug){
				System.out.println("服务器返回状态:"+line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		//从服务器返回消息中读出状态码,将其转换成整数返回
		StringTokenizer st=new StringTokenizer(line," ");
		return Integer.parseInt(st.nextToken());
	}

	private void authLogin(MailMessage message,BufferedReader in,BufferedWriter out) throws IOException{
		int result;
		result=sendServer("AUTH LOGIN",in,out);
		if(result!=334){
			throw new IOException("用户验证失败！");
		}

		result=sendServer(encode.encode(SMTPClient.USER.getBytes()),in,out);
		if(result!=334){
			throw new IOException("用户名错误！");
		}
		result=sendServer(encode.encode(SMTPClient.PASSWORD.getBytes()),in,out);
		if(result!=235){
			throw new IOException("验证失败！");
		}
	}

	//开始发送消息，邮件源地址
	private void mailfrom(String source,BufferedReader in,BufferedWriter out) throws IOException{
		int result;
		result=sendServer("MAIL FROM:<"+source+">",in,out);
		if(result!=250){
			throw new IOException("指定源地址错误");
		}
	}
	
	// 设置邮件收件人
	private void rcpt(String touchman,BufferedReader in,BufferedWriter out) throws IOException{
		int result;
		result=sendServer("RCPT TO:<"+touchman+">",in,out);
		if(result!=250){
			throw new IOException("指定目的地址错误！");
		}
	}
	
	//邮件体
	private void data(String from,String to,String subject,String content,BufferedReader in,BufferedWriter out) throws IOException{
		int result;
		result=sendServer("DATA",in,out);
		//输入DATA回车后,若收到354应答后,继续输入邮件内容
		if(result!=354){
			throw new IOException("不能发送数据");
		}
//		out.write("From: "+from);
//		out.newLine();
//		out.write("To: "+to);
//		out.newLine();
		out.write("Subject: "+subject);
		out.newLine();
		out.newLine();
		out.write(content);
		
		out.newLine();
		//句号加回车结束邮件内容输入
		result=sendServer(".",in,out);
		System.out.println(result);
		if(result!=250)
		{
			throw new IOException("发送数据错误");
		}
	}
	
	//退出
	private void quit(BufferedReader in,BufferedWriter out) throws IOException{
		int result;
		result=sendServer("QUIT",in,out);
		if(result!=221){
			throw new IOException("未能正确退出");
		}
	}
	
	//发送邮件主程序
	private boolean sendMail(MailMessage message,String server) { 
		try{
			BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			helo(server,in,out);//HELO命令
			authLogin(message,in,out);//AUTH LOGIN命令
			mailfrom(USER,in,out);//MAIL FROM
			for (int i = 0; i < message.getTo().length; i++) {
				rcpt(message.getTo()[i],in,out);//RCPT
			}
			data(message.getDatafrom(),message.getDatato(),message.getSubject(),message.getContent(),in,out);//DATA
			quit(in,out);//QUIT
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
}


